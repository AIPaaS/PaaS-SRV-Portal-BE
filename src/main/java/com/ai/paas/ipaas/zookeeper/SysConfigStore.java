package com.ai.paas.ipaas.zookeeper;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import net.sf.json.JSONArray;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.paas.ipaas.PaaSConstant;
import com.ai.paas.ipaas.ccs.constants.AddMode;
import com.ai.paas.ipaas.ccs.constants.BundleKeyConstant;
import com.ai.paas.ipaas.ccs.constants.ConfigException;
import com.ai.paas.ipaas.ccs.zookeeper.ZKClient;
import com.ai.paas.ipaas.util.ResourceUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.google.gson.Gson;

public class SysConfigStore {
	private static transient final Logger logger = 
			LoggerFactory.getLogger(SysConfigStore.class);
	
	private static final String selectSysConfig = 
			"SELECT distinct concat(type_code,'.',param_code,'.',service_value), service_option "
			+ "FROM sys_config where state='1'";

	private DataSource dataSource;
	
	private String zkAddress;
	private String zkUser;
	private String zkPasswd;
	private int timeOut;
	private String storePath;
	
	public SysConfigStore() throws Exception{
	}
	
    public String getSysConfig() throws Exception {
    	Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<SysConfig> configList = new ArrayList<SysConfig>();
        try{
	        conn = dataSource.getConnection();
	        pst = conn.prepareStatement(selectSysConfig);
	        rs = pst.executeQuery();
	        while (rs.next()) {
	        	SysConfig value = new SysConfig();
	        	value.setKey(rs.getString(1));
	        	value.setValue(rs.getString(2));
	        	configList.add(value);
	        }
        } catch(Exception ex) {
        	logger.error("==== getSysConfig error:" + ex.getMessage());
        	throw ex;
        } finally {
        	if (rs != null) {
    			rs.close();
    			rs = null;
    		}
        	if (pst != null) {
    			pst.close();
    			pst = null;
    		}
        	if (conn != null && !conn.isClosed()) {
        		conn.close();
    			conn = null;
    		}
        }
        
        Gson gson = new Gson();
    	return gson.toJson(configList);
    }
    
    public String getConfig() {
    	String confJson = "";
		try{
			ZKClient client = getZKClient();
			confJson = client.getNodeData(storePath);
		} catch(Exception ex) {
			logger.error("get config from zookeeper error." + ex.getMessage());
		}
		return confJson;
	}
    
    public static HashMap<String, String> getConfigMap(String config) {
    	HashMap<String, String> map = new HashMap<String, String>();
		try{
			if(!StringUtil.isBlank(config)){
				JSONArray jsonArray = JSONArray.fromObject(config);  
				List<Map<String,String>> mapListJson = (List)jsonArray;
		        for (int i = 0; i < mapListJson.size(); i++) { 
		            Map<String,String> obj = mapListJson.get(i);  
		            
		            String mapKey = "", mapValue = "";
		            for(Entry<String,String> entry : obj.entrySet()){
		                if("key".equals(entry.getKey())){
		                	mapKey = entry.getValue();
		                }
		                if("value".equals(entry.getKey())){
		                	mapValue = entry.getValue();
		                }
		            }
		            System.out.println("KEY:"+mapKey+"  -->  Value:"+mapValue+"\n");
		            map.put(mapKey, mapValue);
		        }
			}
		} catch(Exception ex) {
			logger.error("convert config to HashMap error." + ex.getMessage());
		}
		
		return map;
	}
    
    public void storeConfig() {
		try{
			ZKClient client = getZKClient();
			String configJson = getSysConfig();
			add(client, storePath, configJson);
		} catch(Exception ex) {
			logger.error("store config into zookeeper error." + ex.getMessage());
		}
	}
    
    private ZKClient getZKClient() throws Exception {
        ZKClient client = null;
        try {
            client = new ZKClient(zkAddress, timeOut, new String[] { "digest", zkUser + ":" + zkPasswd });
            client.addAuth("digest", zkUser + ":" + zkPasswd);
        } catch(Exception e) {
            throw new ConfigException(ResourceUtil.getMessage(BundleKeyConstant.GET_CONFIG_CLIENT_FAILED));
        }
        return client;
    }
    
    private void add(ZKClient client, String configPath, String value) throws Exception {
        if (!StringUtil.isBlank(value)) {
        	if(userNodeIsExist(client, configPath)) {
        		client.setNodeData(configPath, value);
        	} else {
        		byte[] data = value.getBytes(PaaSConstant.CHARSET_UTF8);
        		add(client, configPath, data, AddMode.PERSISTENT);
        	}
        }
    }
    
    private void add(ZKClient client, String configPath, byte[] bytes, AddMode mode) throws Exception {
    	/** 校验用户传入Path，必须以'/'开头,否则抛出异常 **/
    	if (!configPath.startsWith(PaaSConstant.UNIX_SEPERATOR) 
    			&& configPath.endsWith(PaaSConstant.UNIX_SEPERATOR)) {
            throw new ConfigException(ResourceUtil.getMessage(BundleKeyConstant.PATH_ILL));
    	}
    	
        try {
            client.createNode(configPath, createWritableACL(), bytes, AddMode.convertMode(mode.getFlag()));
        } catch (Exception e) {
            if (e instanceof KeeperException.NoAuthException) {
                throw new Exception(ResourceUtil.getMessage(BundleKeyConstant.USER_AUTH_FAILED, configPath));
            }
            throw new Exception(ResourceUtil.getMessage(BundleKeyConstant.ADD_CONFIG_FAILED), e);
        }
    }
    
    private boolean userNodeIsExist(ZKClient client, String nodePath) throws ConfigException {
        boolean result = true;
        try {
        	result = client.exists(nodePath);
        } catch (Exception e) {
            if (e instanceof KeeperException.NoAuthException) {
                throw new ConfigException(ResourceUtil.getMessage(BundleKeyConstant.USER_AUTH_FAILED));
            }
            throw new ConfigException(ResourceUtil.getMessage(BundleKeyConstant.USER_NODE_NOT_EXISTS), e);
        }
        
        return result;
    }
    
    private List<ACL> createWritableACL() throws NoSuchAlgorithmException {
        List<ACL> acls = new ArrayList<ACL>();
        Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest(zkUser + ":" + zkPasswd));
        ACL userACL = new ACL(ZooDefs.Perms.ALL, id1);
        acls.add(userACL);
        return acls;
    }
    
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setZkAddress(String zkAddress) {
		this.zkAddress = zkAddress;
	}

	public void setZkUser(String zkUser) {
		this.zkUser = zkUser;
	}

	public void setZkPasswd(String zkPasswd) {
		this.zkPasswd = zkPasswd;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}
}

package com.ai.paas.ipaas.user.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.RestfullReq;
import com.ai.paas.ipaas.user.dto.RestfullReturn;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISesConsoleSv;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.paas.ipaas.zookeeper.SystemConfigHandler;
 
@Service
@Transactional
public class SesConsoleSvImpl implements ISesConsoleSv{
	@Autowired
	private SqlSessionTemplate template;
	 
	@Autowired
	private IProdProductSv prodProductSv;
	@Autowired
	private IUserMgrOperateSv userMgrOperateSv;
	
	@Override
	public String startService(UserProdInstVo vo) throws PaasException, IOException, URISyntaxException {
		long userServId=vo.getUserServId();
		UserProdInstMapper userProdInstMapper=template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst=userProdInstMapper.selectByPrimaryKey(userServId);
		if(userProdInst	== null){
			throw new PaasException("产品实例为空！");
		}
		String prodId=userProdInst.getUserServiceId();
		if(prodId == null){
			throw new PaasException("用户产品实例产品编码为空");
		}
		Short priKey=Short.parseShort(prodId);
		ProdProduct prodProduct=prodProductSv.selectProductByPrimaryKey(priKey);
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdStartRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdStartRestfull();
		
		if(StringUtil.isBlank(address)){
			throw new PaasException("产品的服务地址为空");
		}
		RestfullReq req=new RestfullReq();
		req.setUserId(vo.getUserId());
		req.setApplyType("start");
		req.setServiceId(userProdInst.getUserServIpaasId());
		String param=JSonUtil.toJSon(req);
		String data=HttpClientUtil.sendPostRequest(address, param);
		if(data==null){
			throw new PaasException("Ses启动服务异常");
		}
		RestfullReturn restfullReturn=JSonUtil.fromJSon(data, RestfullReturn.class);
		String resultCode=restfullReturn.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.OPEN);
			userProdInstMapper.updateByPrimaryKey(userProdInst);
			
		}
		UserMgrOperate userMgrOperate=new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.START);
		this.saveUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		return resultCode;
	}

	@Override
	public String stopService(UserProdInstVo vo) throws PaasException, IOException, URISyntaxException {
		long userServId=vo.getUserServId();
		UserProdInstMapper userProdInstMapper=template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst=userProdInstMapper.selectByPrimaryKey(userServId);
		if(userProdInst	== null){
			throw new PaasException("产品实例为空！");
		}
		String prodId=userProdInst.getUserServiceId();
		if(prodId == null){
			throw new PaasException("用户产品实例产品编码为空");
		}
		Short priKey=Short.parseShort(prodId);
		ProdProduct prodProduct=prodProductSv.selectProductByPrimaryKey(priKey);
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdStopRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE") +prodProduct.getProdStopRestfull();
		if(StringUtil.isBlank(address)){
			throw new PaasException("产品的服务地址为空");
		}
		RestfullReq req=new RestfullReq();
		req.setUserId(vo.getUserId());
		req.setApplyType("stop");
		req.setServiceId(userProdInst.getUserServIpaasId());
		String param=JSonUtil.toJSon(req);
		String data=HttpClientUtil.sendPostRequest(address, param);
		if(data==null){
			throw new PaasException("Ses停止服务异常");
		}
		RestfullReturn restfullReturn=JSonUtil.fromJSon(data, RestfullReturn.class);
		String resultCode=restfullReturn.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CLOSE);
			userProdInstMapper.updateByPrimaryKey(userProdInst);
			
		}
		UserMgrOperate userMgrOperate=new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.STOP);
		this.saveUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		return resultCode;
	}

	@Override
	public String cancleService(UserProdInstVo vo) throws PaasException, IOException, URISyntaxException {
		long userServId=vo.getUserServId();
		UserProdInstMapper userProdInstMapper=template.getMapper(UserProdInstMapper.class);
		UserProdInst userProdInst=userProdInstMapper.selectByPrimaryKey(userServId);
		if(userProdInst	== null){
			throw new PaasException("产品实例为空！");
		}
		String prodId=userProdInst.getUserServiceId();
		if(prodId == null){
			throw new PaasException("用户产品实例产品编码为空");
		}
		Short priKey=Short.parseShort(prodId);
		ProdProduct prodProduct=prodProductSv.selectProductByPrimaryKey(priKey);
//		String address=CacheUtils.getValueByKey("PASS.SERVICE")+prodProduct.getProdCancleRestfull();
		String address = SystemConfigHandler.configMap.get("PASS.SERVICE.IP_PORT_SERVICE")+prodProduct.getProdCancleRestfull();
		if(StringUtil.isBlank(address)){
			throw new PaasException("产品的服务地址为空");
		}
		RestfullReq req=new RestfullReq();
		req.setUserId(vo.getUserId());
		req.setApplyType("recycle");
		req.setServiceId(userProdInst.getUserServIpaasId());
		String param=JSonUtil.toJSon(req);
		String data=HttpClientUtil.sendPostRequest(address, param);
		if(data==null){
			throw new PaasException("Ses注销服务异常");
		}
		RestfullReturn restfullReturn=JSonUtil.fromJSon(data, RestfullReturn.class);
		String resultCode=restfullReturn.getResultCode();
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CANCEL);
			userProdInstMapper.updateByPrimaryKey(userProdInst);
			
		}
		UserMgrOperate userMgrOperate=new UserMgrOperate();
		userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.CANCLE);
		this.saveUserMgrOperate(userProdInst, resultCode, userMgrOperate);
		return resultCode;
	}
	
	private void saveUserMgrOperate(UserProdInst userProdInst,String resultCode,UserMgrOperate userMgrOperate) throws PaasException{
		userMgrOperate.setUserId(userProdInst.getUserId());
		userMgrOperate.setUserProdType(userProdInst.getUserServType());
		userMgrOperate.setUserProdId(userProdInst.getUserServiceId());
		userMgrOperate.setUserServIpaasId(userProdInst.getUserServIpaasId());
		userMgrOperate.setUserServId(StringUtil.toString(userProdInst.getUserServId()));
		userMgrOperate.setUserProdParam(userProdInst.getUserServParam());
		userMgrOperate.setUserProdByname(userProdInst.getUserProdByname());
		userMgrOperate.setUserOperateDate(DateUtil.getSysDate());
		if(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)){
			userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.SUCCESS);
		}else{
			userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.FAIL);
		}
		userMgrOperateSv.saveUserMgrOperate(userMgrOperate);
	}

}

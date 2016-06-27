package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public class UserProdInstVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userServId;

    private String userId;

    private String userServType;

    private String userServiceId;

    private String userServIpaasId;

    private String userServParam;

    private String userProdByname;

    private String userServState;

    private Timestamp userServOpenTime;

    private String userServBackParam;

    private Timestamp userServCloseTime;

    private String userServRunState;

    private Timestamp userServStartTime;

    private Timestamp userServStopTime;

    private String totalAmount; // 总容量

    private String singleFileSize;// 单文件大小

    private String usedAmount; // 已使用量

    private String key; // DSS服务下文档key值

    private String newPwd; // DSS新服务密码

    private String oldPwd; // DSS旧服务密码

    private String prodName; // 产品名称

    private String serviceName; // 服务名称

    private String capacity; // 缓存容量

    private String haMode;

    private String applyType;

    private Map<String, String> userServParamMap;

    private Map<String, String> userServBackParamMap;

    private MdsUserPageVo mdsUserPageVo;
    
    private AtsUserPageVo atsUserPageVo;
   
	private String signatureId;
	
	private String selectType;	
	
	private String field;	
	
	private String subscribeName;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

	public AtsUserPageVo getAtsUserPageVo() {
		return atsUserPageVo;
	}

	public void setAtsUserPageVo(AtsUserPageVo atsUserPageVo) {
		this.atsUserPageVo = atsUserPageVo;
	}

    public String getHaMode() {
        return haMode;
    }

    public void setHaMode(String haMode) {
        this.haMode = haMode;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Long getUserServId() {
        return userServId;
    }

    public void setUserServId(Long userServId) {
        this.userServId = userServId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserServType() {
        return userServType;
    }

    public void setUserServType(String userServType) {
        this.userServType = userServType == null ? null : userServType.trim();
    }

    public String getUserServiceId() {
        return userServiceId;
    }

    public void setUserServiceId(String userServiceId) {
        this.userServiceId = userServiceId == null ? null : userServiceId.trim();
    }

    public String getUserServIpaasId() {
        return userServIpaasId;
    }

    public void setUserServIpaasId(String userServIpaasId) {
        this.userServIpaasId = userServIpaasId == null ? null : userServIpaasId.trim();
    }

    public String getUserServParam() {
        return userServParam;
    }

    public void setUserServParam(String userServParam) {
        this.userServParam = userServParam == null ? null : userServParam.trim();
    }

    public String getUserProdByname() {
        return userProdByname;
    }

    public void setUserProdByname(String userProdByname) {
        this.userProdByname = userProdByname == null ? null : userProdByname.trim();
    }

    public String getUserServState() {
        return userServState;
    }

    public void setUserServState(String userServState) {
        this.userServState = userServState == null ? null : userServState.trim();
    }

    public Timestamp getUserServOpenTime() {
        return userServOpenTime;
    }

    public void setUserServOpenTime(Timestamp userServOpenTime) {
        this.userServOpenTime = userServOpenTime;
    }

    public String getUserServBackParam() {
        return userServBackParam;
    }

    public void setUserServBackParam(String userServBackParam) {
        this.userServBackParam = userServBackParam == null ? null : userServBackParam.trim();
    }

    public Timestamp getUserServCloseTime() {
        return userServCloseTime;
    }

    public void setUserServCloseTime(Timestamp userServCloseTime) {
        this.userServCloseTime = userServCloseTime;
    }

    public String getUserServRunState() {
        return userServRunState;
    }

    public void setUserServRunState(String userServRunState) {
        this.userServRunState = userServRunState == null ? null : userServRunState.trim();
    }

    public Timestamp getUserServStartTime() {
        return userServStartTime;
    }

    public void setUserServStartTime(Timestamp userServStartTime) {
        this.userServStartTime = userServStartTime;
    }

    public Timestamp getUserServStopTime() {
        return userServStopTime;
    }

    public void setUserServStopTime(Timestamp userServStopTime) {
        this.userServStopTime = userServStopTime;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getSingleFileSize() {
        return singleFileSize;
    }

    public void setSingleFileSize(String singleFileSize) {
        this.singleFileSize = singleFileSize;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Map<String, String> getUserServParamMap() {
        return userServParamMap;
    }

    public void setUserServParamMap(Map<String, String> userServParamMap) {
        this.userServParamMap = userServParamMap;
    }

    public Map<String, String> getUserServBackParamMap() {
        return userServBackParamMap;
    }

    public void setUserServBackParamMap(Map<String, String> userServBackParamMap) {
        this.userServBackParamMap = userServBackParamMap;
    }

    public MdsUserPageVo getMdsUserPageVo() {
        return mdsUserPageVo;
    }

    public void setMdsUserPageVo(MdsUserPageVo mdsUserPageVo) {
        this.mdsUserPageVo = mdsUserPageVo;
    }

	public String getSignatureId() {
		return signatureId;
	}

	public void setSignatureId(String signatureId) {
		this.signatureId = signatureId;
	}

	public String getSubscribeName() {
		return subscribeName;
	}

	public void setSubscribeName(String subscribeName) {
		this.subscribeName = subscribeName;
	}
	
	
}
package com.ai.paas.ipaas.user.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.cache.CacheUtils;
import com.ai.paas.ipaas.user.constants.Constants;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dto.RestfullReturn;
import com.ai.paas.ipaas.user.dto.UserMgrOperate;
import com.ai.paas.ipaas.user.dto.UserProdInst;
import com.ai.paas.ipaas.user.dto.UserProdInstCriteria;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SysParamVo;
import com.ai.paas.ipaas.user.dubbo.vo.SysParmRequest;
import com.ai.paas.ipaas.user.dubbo.vo.UserProdInstVo;
import com.ai.paas.ipaas.user.service.IMcsConsoleSv;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.ai.paas.ipaas.user.service.ISysParamSv;
import com.ai.paas.ipaas.user.service.IUserMgrOperateSv;
import com.ai.paas.ipaas.user.service.dao.UserProdInstMapper;
import com.ai.paas.ipaas.user.utils.DateUtil;
import com.ai.paas.ipaas.user.utils.HttpClientUtil;
import com.ai.paas.ipaas.user.utils.JsonUtils;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;

@Service
@Transactional
public class McsConsoleSvImpl implements IMcsConsoleSv {

    private final Log logger = LogFactory.getLog(McsConsoleSvImpl.class);

    @Autowired
    private SqlSessionTemplate template;

    @Autowired
    private IProdProductSv iProdProductSv;

    @Autowired
    private ISysParamSv iSysParamSv;

    @Autowired
    private IUserMgrOperateSv iUserMgrOperateSv;

    public List<UserProdInstVo> selectUserProdInsts(UserProdInstVo vo) throws PaasException {
        UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
        UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();
        criteria.andUserIdEqualTo(vo.getUserId());
        criteria.andUserServiceIdEqualTo(vo.getUserServiceId());
        criteria.andUserServRunStateNotEqualTo(Constants.UserProdInst.UserServRunState.CANCEL);
        criteria.andUserServStateEqualTo(Constants.UserProdInst.UserServState.OPEN);
        UserProdInstCriteria.Criteria criteria2 = userProdInstCriteria.createCriteria();
        criteria2.andUserIdEqualTo(vo.getUserId());
        criteria2.andUserServiceIdEqualTo(vo.getUserServiceId());
        criteria2.andUserServRunStateIsNull();
        criteria2.andUserServStateEqualTo(Constants.UserProdInst.UserServState.OPEN);
        userProdInstCriteria.or(criteria2);
        userProdInstCriteria.setOrderByClause(" USER_SERV_OPEN_TIME desc");
        UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
        List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
        List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
        if (userProdInsts != null && userProdInsts.size() > 0) {
            for (int i = 0; i < userProdInsts.size(); i++) {
                UserProdInstVo userProdInstVo = new UserProdInstVo();
                BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
                // 获取容量
                getCapacity(userProdInsts.get(i), userProdInstVo);
                userProdInstVoist.add(userProdInstVo);
            }
        }
        return userProdInstVoist;
    }

    private void getCapacity(UserProdInst userProdInst, UserProdInstVo userProdInstVo)
            throws PaasException {
        logger.info("查询缓存容量");
        if (userProdInst == null) {
            throw new PaasException("用户产品实例产品为空");
        }
        String prodId = userProdInstVo.getUserServiceId();
        if (StringUtil.isBlank(prodId)) {
            throw new PaasException("用户产品实例产品编码为空");
        }
        String userServParam = userProdInst.getUserServParam();
        UserProdInstVo vo = JSonUtil.fromJSon(userServParam, UserProdInstVo.class);
        userProdInstVo.setCapacity(vo.getCapacity());
    }

    /**
     * @description 对MCS的操作
     * @param vo
     * @return
     * @throws Exception
     * @author caiyt
     */
    public ResponseHeader operatMcsServer(UserProdInstVo vo) throws Exception {
        Long userServId = vo.getUserServId();
        if (userServId == null) {
            throw new PaasException("userServId为空");
        }
        UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
        UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
       
        String applyType = vo.getApplyType();
        String address = CacheUtils.getValueByKey("PASS.SERVICE") + applyType;
        if (StringUtil.isBlank(address)) {
            throw new PaasException("产品的已使用量查询地址为空");
        }
        if (applyType.endsWith("cancel")) {
            vo.setApplyType("remove");
        } else {
            vo.setApplyType(applyType.substring(applyType.lastIndexOf("/") + 1));
        }
        String param = JSonUtil.toJSon(vo).replaceAll("userServIpaasId", "serviceId");
        logger.info("调用服务接口url：" + address);
        logger.info("调用服务接口入参：" + param);
        String result = HttpClientUtil.send(address, param);
        if (StringUtil.isBlank(result)) {
            throw new PaasException("服务异常");
        }
        JSONObject createJson = JsonUtils.parse(result);
        ResponseHeader header = new ResponseHeader();
        header.setResultCode(createJson.getString("resultCode"));
        if (createJson.has("resultMsg"))
            header.setResultMessage(createJson.getString("resultMsg"));
        // 写用户管理操作
        UserMgrOperate userMgrOperate = new UserMgrOperate();
        String userOperaAction = this.getUserOperaAction(applyType);
        userMgrOperate.setUserOperateAction(userOperaAction);
        this.saveUserMgrOperate(userProdInst, header.getResultCode(), userMgrOperate);
        return header;
    }

    private String getUserOperaAction(String applyType) {
        String action = applyType.substring(applyType.lastIndexOf("/") + 1);
        String actionCode = "";
        switch (action) {
        case "cancel":
            actionCode = Constants.UserMgrOperate.UserOperateAction.CANCLE;
            break;
        case "start":
            actionCode = Constants.UserMgrOperate.UserOperateAction.START;
            break;
        case "stop":
            actionCode = Constants.UserMgrOperate.UserOperateAction.STOP;
            break;
        case "clean":
            actionCode = Constants.UserMgrOperate.UserOperateAction.FULLCLEAR;
            break;
        case "del":
            actionCode = Constants.UserMgrOperate.UserOperateAction.KEYCLEAR;
            break;
        case "restart":
            actionCode = Constants.UserMgrOperate.UserOperateAction.RESTART;
            break;
        }
        return actionCode;
    }

    public void saveUserMgrOperate(UserProdInst userProdInst, String resultCode,
            UserMgrOperate userMgrOperate) throws PaasException {
        userMgrOperate.setUserId(userProdInst.getUserId());
        userMgrOperate.setUserProdType(userProdInst.getUserServType());
        userMgrOperate.setUserProdId(userProdInst.getUserServiceId());
        userMgrOperate.setUserServId(userProdInst.getUserServId().toString());
        userMgrOperate.setUserServIpaasId(userProdInst.getUserServIpaasId());
        userMgrOperate.setUserProdParam(userProdInst.getUserServParam());
        userMgrOperate.setUserProdByname(userProdInst.getUserProdByname());
        userMgrOperate.setUserOperateDate(DateUtil.getSysDate());
        if (PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS.equals(resultCode)) {
            userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.SUCCESS);
            // 更新数据库订单相关状态
            this.updateUserProdInst(userProdInst, userMgrOperate);
        } else {
            userMgrOperate.setUserOperateResult(Constants.UserMgrOperate.UserOperateResult.FAIL);
        }
        iUserMgrOperateSv.saveUserMgrOperate(userMgrOperate);
    }

    // 根据用户操作类型更新对应订单的相关状态
    private void updateUserProdInst(UserProdInst userProdInst, UserMgrOperate userMgrOperate) {
        switch (userMgrOperate.getUserOperateAction()) {
        // 启动或重启，将用户服务运行状态改为“启动”
        case Constants.UserMgrOperate.UserOperateAction.START:
        case Constants.UserMgrOperate.UserOperateAction.RESTART:
            userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.OPEN);
            userProdInst.setUserServStartTime(new Timestamp(new Date().getTime()));
            break;
        // 启动或重启，将用户服务运行状态改为“停用”
        case Constants.UserMgrOperate.UserOperateAction.STOP:
            userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CLOSE);
            userProdInst.setUserServStopTime(new Timestamp(new Date().getTime()));
            break;
        // 启动或重启，将用户服务运行状态改为“注销”
        case Constants.UserMgrOperate.UserOperateAction.CANCLE:
            userProdInst.setUserServRunState(Constants.UserProdInst.UserServRunState.CANCEL);
            userProdInst.setUserServCloseTime(new Timestamp(new Date().getTime()));
        }
        UserProdInstMapper mapper = template.getMapper(UserProdInstMapper.class);
        int updateCount = mapper.updateByPrimaryKey(userProdInst);
        if (updateCount == 1) {
            logger.info("update one instance successfully!");
        } else {
            logger.info("update none record!");
        }
    }

    public List<UserProdInstVo> selectMcsById(UserProdInstVo selectRequestVo) throws PaasException {
        UserProdInstCriteria userProdInstCriteria = new UserProdInstCriteria();
        UserProdInstCriteria.Criteria criteria = userProdInstCriteria.createCriteria();
        long userServId = selectRequestVo.getUserServId();
        criteria.andUserServIdEqualTo(userServId);
        UserProdInstMapper UserProdInstMapper = template.getMapper(UserProdInstMapper.class);
        List<UserProdInst> userProdInsts = UserProdInstMapper.selectByExample(userProdInstCriteria);
        List<UserProdInstVo> userProdInstVoist = new ArrayList<UserProdInstVo>();
        if (userProdInsts != null && userProdInsts.size() > 0) {
            for (int i = 0; i < userProdInsts.size(); i++) {
                UserProdInstVo userProdInstVo = new UserProdInstVo();
                BeanUtils.copyProperties(userProdInsts.get(i), userProdInstVo);
                String prodId = userProdInstVo.getUserServiceId();
                if (StringUtil.isBlank(prodId)) {
                    throw new PaasException("用户产品实例产品编码为空");
                }
                short priKey = Short.parseShort(prodId);
                ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);
                userProdInstVo.setProdName(prodProduct.getProdName());
                String prodParam = userProdInstVo.getUserServParam();
                if (StringUtil.isBlank(prodParam)) {
                    throw new PaasException("产品参数为空");
                }
                JSONObject json = JsonUtils.parse(prodParam);
                userProdInstVo.setServiceName(json.getString("serviceName"));
                userProdInstVoist.add(userProdInstVo);
            }
        }
        return userProdInstVoist;
    }

    public ResponseHeader mdyServPwd(UserProdInstVo vo) throws PaasException {
        long userServId = vo.getUserServId();
        UserProdInstMapper userProdInstMapper = template.getMapper(UserProdInstMapper.class);
        UserProdInst userProdInst = userProdInstMapper.selectByPrimaryKey(userServId);
        if (null == userProdInst) {
            throw new PaasException("用户产品实例不存在");
        }
        String prodId = userProdInst.getUserServiceId();
        if (StringUtil.isBlank(prodId)) {
            throw new PaasException("用户产品实例产品编码为空");
        }
        short priKey = Short.parseShort(prodId);
        ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(priKey);     
      
        String address = CacheUtils.getValueByKey("IPAAS-UAC.SERVICE") + prodProduct.getProdMdypwdRestfull();
        if (StringUtil.isBlank(address)) {
            throw new PaasException("产品的的服务地址为空");
        }
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("userId", vo.getUserId());
        paramMap.put("serviceId", userProdInst.getUserServIpaasId());
        paramMap.put("newPwd", vo.getNewPwd());
        paramMap.put("oldPwd", vo.getOldPwd());
        logger.info("调用服务接口url：" + address);
        logger.info("调用服务接口入参：" + paramMap);
        String result = HttpClientUtil.sendGet(address, paramMap);
        if (StringUtil.isBlank(result)) {
            throw new PaasException("服务异常");
        }
        RestfullReturn restfullReturn = JSonUtil.fromJSon(result, RestfullReturn.class);
        String resultCode = restfullReturn.getResultCode();
        ResponseHeader header = new ResponseHeader();
        header.setResultCode(resultCode);
        header.setResultMessage(restfullReturn.getResultMessage());
        // 写用户管理操作
        UserMgrOperate userMgrOperate = new UserMgrOperate();
        userMgrOperate.setUserOperateAction(Constants.UserMgrOperate.UserOperateAction.MDYPWD);
        this.saveUserMgrOperate(userProdInst, resultCode, userMgrOperate);
        return header;
    }
}
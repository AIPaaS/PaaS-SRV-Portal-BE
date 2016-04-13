package com.ai.paas.ipaas.user.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.ipaas.PaaSMgmtConstant;
import com.ai.paas.ipaas.PaasException;
import com.ai.paas.ipaas.user.dto.ProdProduct;
import com.ai.paas.ipaas.user.dubbo.interfaces.IProdProductDubboSv;
import com.ai.paas.ipaas.user.dubbo.vo.ProdProductVo;
import com.ai.paas.ipaas.user.dubbo.vo.ResponseHeader;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageRequest;
import com.ai.paas.ipaas.user.dubbo.vo.SelectWithNoPageResponse;
import com.ai.paas.ipaas.user.service.IProdProductSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class ProdProductDubboSvImpl implements IProdProductDubboSv {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private IProdProductSv iProdProductSv;

	@Override
	public SelectWithNoPageResponse<ProdProductVo> selectProduct(
			SelectWithNoPageRequest<ProdProductVo> request) throws PaasException {
		ResponseHeader responseHeader = new ResponseHeader();	
		List<ProdProductVo>   resultList  = new ArrayList<ProdProductVo>();
		ProdProductVo prodProductVo = new ProdProductVo();
		try{
			ProdProduct prodProduct = iProdProductSv.selectProductByPrimaryKey(request.getSelectRequestVo().getProdId());
			BeanUtils.copyProperties(prodProduct, prodProductVo);
			resultList.add(prodProductVo);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_SUCCESS);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			responseHeader.setResultCode(PaaSMgmtConstant.REST_SERVICE_RESULT_FAIL);
			responseHeader.setResultMessage(e.getMessage());
		}		
		SelectWithNoPageResponse<ProdProductVo> response = new SelectWithNoPageResponse<ProdProductVo>();
		response.setResultList(resultList);
		response.setResponseHeader(responseHeader);		
		return response;
	}

	
	@Override
	public String selectProductByProdEnSimp(String prodEnSimp) {
		try {
			ProdProduct prodProduct =iProdProductSv.selectProductByProdEnSimp(prodEnSimp);
			 JSONObject jsonww = new JSONObject(prodProduct);
			 return jsonww.toString();
		} catch (PaasException e) {
			e.printStackTrace();
		}
		return "";
	}
	

}

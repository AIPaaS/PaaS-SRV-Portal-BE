package com.ai.paas.ipaas.user.dto;

public class OrderSchemeWithBLOBs extends OrderScheme {
    private String prodParamZh;

    private String prodParam;

    public String getProdParamZh() {
        return prodParamZh;
    }

    public void setProdParamZh(String prodParamZh) {
        this.prodParamZh = prodParamZh == null ? null : prodParamZh.trim();
    }

    public String getProdParam() {
        return prodParam;
    }

    public void setProdParam(String prodParam) {
        this.prodParam = prodParam == null ? null : prodParam.trim();
    }
}
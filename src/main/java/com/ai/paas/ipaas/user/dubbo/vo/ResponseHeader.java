package com.ai.paas.ipaas.user.dubbo.vo;

import java.io.Serializable;

public class ResponseHeader  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String resultCode;
    
    private String resultMessage;    

    
    public ResponseHeader(){
        
    }
    
    public ResponseHeader(String resultCode,String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    
}

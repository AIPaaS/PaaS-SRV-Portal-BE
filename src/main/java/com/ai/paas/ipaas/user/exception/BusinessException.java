package com.ai.paas.ipaas.user.exception;

/**
 * 业务异常
 * @author mapl
 */

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    /** 错误码 */
    protected String errcode;
    
    public BusinessException(String errmsg){
        super(errmsg);
    }
    
    public BusinessException(String errcode, String errmsg){ 
        super(errmsg);
        this.errcode = errcode;
    }
    
    public BusinessException(String errcode, String errmsg, Throwable cause){ 
        super(errmsg, cause);
        this.errcode = errcode;
    }

    public String getErrcode() {
        return errcode;
    }
}

/**
 * Project Name:mk-dubbo <br>
 * Package Name:com.suns.service.imp.exception <br>
 *
 * @author mk <br>
 * Date:2018-11-21 15:01 <br>
 */

package com.suns.service.exception;

/**
 * ClassName: BusinessException <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-21 15:01 <br>
 * @version
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2197518832775586974L;
    private String errorCode;

    public BusinessException() {
        super();
    }

    /**
     * 通过错误信息创建业务异常对象
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * 通过错误信息，错误码创建业务异常对象
     *
     * @param message
     * @param errorCode
     */
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 通过错误信息，异常对象，错误码创建业务异常对象
     *
     * @param message
     * @param cause
     * @param errorCode
     */
    public BusinessException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * 通过异常对象，错误码创建业务异常对象
     *
     * @param cause
     * @param errorCode
     */
    public BusinessException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }
}

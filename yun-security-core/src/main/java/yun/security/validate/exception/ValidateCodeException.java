package yun.security.validate.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 13:59
 * @desc 验证码异常处理
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg) {
        super(msg);
    }
}

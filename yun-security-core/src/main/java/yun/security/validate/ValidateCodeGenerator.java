package yun.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: yzhang
 * @Date: 2018/3/7 15:14
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}

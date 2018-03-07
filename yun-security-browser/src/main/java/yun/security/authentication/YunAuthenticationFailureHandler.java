package yun.security.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import yun.security.properties.LoginResponseType;
import yun.security.properties.SecurityProperties;
import yun.security.support.SimpleResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 17:58
 */
@Component("yunAuthenticationFailureHandler")
public class YunAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(YunAuthenticationFailureHandler.class);


    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        logger.info("认证失败!");
        //如果配置了返回时JSON格式
        if(securityProperties.getBrowser().getLoginType().equals(LoginResponseType.JSON)){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
        }else {
            //否则返回spring Security默认的配置 返回html页面
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}

package yun.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
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
 * @Date: 2018/3/6 17:11
 */
@Component("yunAuthenticationSuccessHandler")
public class YunAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(YunAuthenticationSuccessHandler.class);


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("验证成功");
        if(securityProperties.getBrowser().getLoginType().equals(LoginResponseType.JSON)){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(authentication)));
        }else {
            //否则返回spring Security默认的配置 返回html页面
            super.onAuthenticationSuccess(request,response,authentication);
        }



    }
}

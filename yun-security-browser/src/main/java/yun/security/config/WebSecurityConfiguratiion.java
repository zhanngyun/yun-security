package yun.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import yun.security.properties.SecurityProperties;

/**
 * @Author: yzhang
 * @Date: 2018/3/6 14:01
 */
@Configuration
public class WebSecurityConfiguratiion extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private AuthenticationSuccessHandler  yunAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler yunAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
//                .loginPage("/signIn.html")  //登录页面
                .loginPage("/authentication/require")  //跳转到controller路径
                .loginProcessingUrl("/authentication/form") //登录请求地址
                .successHandler(yunAuthenticationSuccessHandler)  //登录成功处理的handler
                .failureHandler(yunAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),"/me").permitAll()//禁止该页面校验
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        //密码验证
        return new BCryptPasswordEncoder();
    }
}

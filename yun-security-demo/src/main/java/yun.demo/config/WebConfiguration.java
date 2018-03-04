package yun.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import yun.demo.filter.MyFilter;
import yun.demo.interceptor.MyInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzhang
 * @date 2018/3/4 15:09
 * @desc
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{




    /**
     * 自定义配置Filter 并且在这里可以设置过滤的路径，在@Component中只能默认/*
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        MyFilter myFilter = new MyFilter();
        filterRegistrationBean.setFilter(myFilter);

        List<String> url = new ArrayList<>();
        url.add("/*");
        filterRegistrationBean.setUrlPatterns(url);
        return filterRegistrationBean;
    }

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
    }
}

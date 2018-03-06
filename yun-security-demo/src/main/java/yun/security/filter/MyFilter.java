package yun.security.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author yzhang
 * @date 2018/3/4 15:03
 * @desc
 */
//@Component  如果不使用@Component，那么需要配置
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("myfilter start");
        long start = new Date().getTime();
        chain.doFilter(request,response);
        System.out.println("myfilter filter :"+(new Date().getTime()-start));
        System.out.println("myfilter finished");

    }

    @Override
    public void destroy() {
        System.out.println("myfilter destroy");
    }
}

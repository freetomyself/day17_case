package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: day17_case--${PACKAGE_NAME}
 * @author: WaHotDog 2019-06-27 14:58
 **/

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //将req强制转换成HttpServlet
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源是否包含登录相关资源路径，要注意排除掉 css/js/图片/验证码等资源
        String uri = request.getRequestURI();
        System.out.println(uri);
        Object user = request.getSession().getAttribute("user");
        //
        if(uri.contains("login.jsp")||uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/img/")){
            //如果包含说明用户是要登录进行放行
            chain.doFilter(req, resp);
        }else {
            if (user == null || "".equals(user)) {
                request.setAttribute("msg","请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

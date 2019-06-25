package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.imp.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: day15_response--${PACKAGE_NAME}
 * @author: WaHotDog 2019-06-21 08:54
 **/


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1设置编码
        request.setCharacterEncoding("utf-8");
//        2获取数据
        String verifycode = request.getParameter("verifycode");
//        3验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
//        确保验证码一次性
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server==null || !checkcode_server.equalsIgnoreCase(verifycode)){
//            如果不正确
            request.setAttribute("msg","验证码错误！");
//            提示信息跳转
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return ;
        }
//        使用map接收所前端传的数据
            Map<String, String[]> map = request.getParameterMap();
//        4封装User对象
//        创建一个User对象用于做关联
            User user = new User();
            try {
//            将map与user关联
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//        5调用Service查询
        UserService userService = new UserServiceImp();
        User loginuser = userService.login(user);
        System.out.println(loginuser);
//        6判断是否登录成功
        if(loginuser!=null){
//            登录成功
//            将用户存入session
            session.setAttribute("user",loginuser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
//            登录失败
            request.setAttribute("msg","账号或密码不正确！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

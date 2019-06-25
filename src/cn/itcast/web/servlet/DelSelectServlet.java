package cn.itcast.web.servlet;

import cn.itcast.service.UserService;
import cn.itcast.service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: day15_response--${PACKAGE_NAME}
 * @author: WaHotDog 2019-06-24 21:04
 **/


@WebServlet("/delSelectServlet")
public class DelSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        try {
//        获取前端页面传值
            String[] uids = request.getParameterValues("uid");
//        调用service
            UserService userService = new UserServiceImp();
            userService.delSelectUser(uids);
//        } catch (Exception e) {
//            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
//            //response重定向后没有return，后续程序继续运行，遇到了后续的再次重定向代码报错。
//            return;
//        }

//        跳转回页面
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

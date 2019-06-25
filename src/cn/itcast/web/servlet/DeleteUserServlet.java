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
 * @author: WaHotDog 2019-06-21 15:41
 **/


@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1获取需要删除的id
        String id = request.getParameter("id");
        UserService userService = new UserServiceImp();
        userService.deleteUser(id);
//        request.getRequestDispatcher(request.getContextPath()+"/findUserByPageServlet").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

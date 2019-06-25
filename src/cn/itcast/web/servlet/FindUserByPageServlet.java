package cn.itcast.web.servlet;

import cn.itcast.domain.PageBeen;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.imp.UserServiceImp;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: day15_response--${PACKAGE_NAME}
 * @author: WaHotDog 2019-06-23 19:11
 **/


@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        pos传值所以要设置字符集
        request.setCharacterEncoding("utf-8");

//        获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数

//        当直接访问servlet不加两个参数时做处理||当输入为负数是做处理
        if (currentPage == null || "".equals(currentPage) || Integer.parseInt(currentPage) < 1) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
//        获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();



//        调用service查询
        UserService service = new UserServiceImp();
        PageBeen<User> pb = service.findUserByPage(currentPage, rows,condition);

//        在此处做判断当选的页面大于最大值时设置成最大值(解决:limit范围如果超出数据范围会显示空)
        if (pb.getCurrentPage()>pb.getTotalPage()){
            pb.setCurrentPage (pb.getTotalPage());
        }

//        3.将Page存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
//        4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: day17_case--cn.itcast.web.servlet
 * @author: WaHotDog 2019-06-28 13:51
 **/

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        用于测试getParameter拦截
//        String name = req.getParameter("name");
//        String msg = req.getParameter("msg");
//        String value = name+":"+msg;
//        req.setAttribute("ccc",value);
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
//        用于测试getParameterValues拦截
//        String[] names = req.getParameterValues("name");
//        System.out.println(names);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}

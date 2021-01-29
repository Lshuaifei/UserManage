package com.liushuaifei.servlet; /**
 * @Description
 * @author shkstart
 * @create 2021-01-29 19:25
 */

import com.liushuaifei.dao.UserDao;
import com.liushuaifei.dao.UserDaoImpl;
import com.liushuaifei.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String home = request.getParameter("home");
        String info = request.getParameter("info");

        User user = new User(); //实例化一个对象，组装属性
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
            request.setAttribute("username", name);  //向request域中放置参数
            request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
        }else{

            response.sendRedirect("login.jsp");//重定向到首页
        }

    }
}

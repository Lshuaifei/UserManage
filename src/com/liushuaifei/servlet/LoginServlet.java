package com.liushuaifei.servlet; /**
 * @Description
 * @author shkstart
 * @create 2021-01-29 19:17
 */

import com.liushuaifei.dao.UserDao;
import com.liushuaifei.dao.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("pwd");

        UserDao ud = new UserDaoImpl();
        System.out.println(name+"    "+ pwd  );
        if(ud.login(name, pwd)){
            request.setAttribute("name", "欢迎用户"+name); //向request域中放置信息
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
        }else{
            response.sendRedirect("login.jsp"); //重定向到首页
        }

    }
}

package com.liushuaifei.servlet; /**
 * @Description
 * @author shkstart
 * @create 2021-01-29 19:29
 */

import com.liushuaifei.dao.UserDao;
import com.liushuaifei.dao.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String home = request.getParameter("home");
        String info = request.getParameter("info");

        System.out.println("------------------------------------"+userId);

        UserDao ud = new UserDaoImpl();

        if(ud.update(userId, name, pwd, sex, home, info)){
            request.setAttribute("name", "更新成功");
            request.getRequestDispatcher("/FindUserList").forward(request, response);
        }else{
            response.sendRedirect("login.jsp");
        }

    }
}

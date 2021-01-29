package com.liushuaifei.servlet; /**
 * @Description
 * @author shkstart
 * @create 2021-01-29 19:27
 */

import com.liushuaifei.dao.UserDao;
import com.liushuaifei.dao.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        UserDao ud = new UserDaoImpl();

        if(ud.delete(userId)){
            request.setAttribute("name", "删除成功");
            request.getRequestDispatcher("/FindUserList").forward(request, response);
        }else{
            response.sendRedirect("login.jsp");
        }

    }
}

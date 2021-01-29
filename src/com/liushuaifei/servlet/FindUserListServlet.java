package com.liushuaifei.servlet; /**
 * @Description
 * @author shkstart
 * @create 2021-01-29 19:27
 */

import com.liushuaifei.dao.UserDao;
import com.liushuaifei.dao.UserDaoImpl;
import com.liushuaifei.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class FindUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }
}

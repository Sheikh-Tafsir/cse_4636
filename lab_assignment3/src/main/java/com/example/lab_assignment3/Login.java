package com.example.lab_assignment3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean loginBean =new LoginBean();

        loginBean.setUsername(request.getParameter("username"));
        loginBean.setPassword(request.getParameter("password"));

        int valid=loginBean.getValid();

        if(valid==1){
            HttpSession session=request.getSession(true);

            session.setAttribute("username",loginBean.getUsername());
            session.setAttribute("password",loginBean.getPassword());
            request.getRequestDispatcher("home.jsp").include(request,response);
        }
        else{
            request.getRequestDispatcher("login.jsp").include(request,response);
        }

    }
}

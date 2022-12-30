package com.codegym.casem2.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess = req.getParameter("mess");
        if(mess != null){
            mess ="wrong information account";
            req.setAttribute("mess",mess);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/login.jsp");
        dispatcher.forward(req,resp);
    }
}

package com.codegym.casem2.view;

import com.codegym.casem2.clientService.ClientServiceliml;
import com.codegym.casem2.modal.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/searchUser")
public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name1");
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        List<Client> clients = clientServiceliml.searchUser(name);
        req.setAttribute("User", clients);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/showClient.jsp");
        dispatcher.forward(req,resp);
    }
}

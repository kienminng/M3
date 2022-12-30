package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.ClientServiceliml;
import com.codegym.casem2.modal.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editUser")
public class EditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        String email =req.getParameter("email");
        Client client = clientServiceliml.findIndexByEmail(email);
        req.setAttribute("client", client);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/editUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        String name = req.getParameter("name");
        String gender = req.getParameter("inlineRadioOptions");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        int role = 1;
        String password = req.getParameter("password");

        clientServiceliml.edit(new Client(name,email,password,role,gender,address,phoneNumber));
    }
}

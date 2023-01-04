package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.ClientServiceliml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConfirmDeleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        clientServiceliml.delete(email);
        resp.sendRedirect("/ListUser");

    }
}

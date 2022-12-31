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

@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        String email = request.getParameter("email");

        Client clients = clientServiceliml.findIndexByEmail(email);
        request.setAttribute("User", clients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html5/deleteUserForm.jsp");
        dispatcher.forward(request,response);
    }
}

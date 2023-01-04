package com.codegym.casem2.view;

import com.codegym.casem2.clientService.ClientServiceliml;
import com.codegym.casem2.clientService.DanhGiaService;
import com.codegym.casem2.modal.Client;
import com.codegym.casem2.modal.DanhGia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cartUser")
public class viewCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        Client client = clientServiceliml.findIndexByEmail(email);
        req.setAttribute("client",client);
        DanhGiaService danhGiaService = new DanhGiaService();
        List<DanhGia> list = danhGiaService.ShowNotification(email);
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/cartUser.jsp");
        dispatcher.forward(req,resp);


    }
}

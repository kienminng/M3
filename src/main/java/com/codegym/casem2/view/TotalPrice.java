package com.codegym.casem2.view;

import com.codegym.casem2.clientService.DanhGiaService;
import com.codegym.casem2.modal.DanhGia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/total")
public class TotalPrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhGiaService danhGiaService= new DanhGiaService();
        double total= danhGiaService.totalPrice();
        req.setAttribute("totals",total);

        List<DanhGia> danhGias =danhGiaService.totaldanhgia();
        req.setAttribute("danhgia",danhGias);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/Total.jsp");
        dispatcher.forward(req,resp);
    }
}

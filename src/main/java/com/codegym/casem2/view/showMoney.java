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

@WebServlet(urlPatterns = "/showMoney")
public class showMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DanhGiaService danhGiaService = new DanhGiaService();
        List<DanhGia> list = danhGiaService.doneDear();
        req.setAttribute("list",list);
        double sumPrice = danhGiaService.sumPrice();
        req.setAttribute("sumPrice",sumPrice);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/showMoney.jsp");
        dispatcher.forward(req,resp);
    }
}

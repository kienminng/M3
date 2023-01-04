package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.DanhGiaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateContent")
public class UpdateContent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        String content = req.getParameter("content");
        DanhGiaService danhGiaService = new DanhGiaService();
        danhGiaService.updateContent(carID,content);
        resp.sendRedirect("/viewEmailUser");

    }
}

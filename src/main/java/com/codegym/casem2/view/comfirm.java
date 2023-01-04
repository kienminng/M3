package com.codegym.casem2.view;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.clientService.DanhGiaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comfirmCarFormCart")
public class comfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        CarService carService = new CarService();
        carService.updateStatus(3,carID);
        resp.sendRedirect("/adminHoaDon");
    }
}

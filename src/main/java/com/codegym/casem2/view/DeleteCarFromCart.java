package com.codegym.casem2.view;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.clientService.DanhGiaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCarFromCart")
public class DeleteCarFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        CarService carService = new CarService();
        carService.updateStatus(1,carID);
        DanhGiaService danhGiaService = new DanhGiaService();
        danhGiaService.delete(carID);
        resp.sendRedirect("/carModal");

    }
}

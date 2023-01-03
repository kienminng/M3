package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteCar")
public class deleteCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        CarService carService = new CarService();
        carService.delete(carID);
        resp.sendRedirect("/carModal");

    }
}

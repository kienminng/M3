package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.modal.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateCar")
public class UpdateCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        String carName = req.getParameter("carName");
        double price = Double.parseDouble(req.getParameter("price"));
        String color = req.getParameter("color");
        String img = req.getParameter("img");
        String branch = req.getParameter("branch");
        CarService carService = new CarService();
        carService.edit(new Car(carID,carName,price,color,img,branch,1));
        resp.sendRedirect("/carModal");

    }
}

package com.codegym.casem2.controller;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.clientService.ClientServiceliml;
import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/searchCar")
public class SearchCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name1");
        CarService carService = new CarService();
        List<Car> cars = carService.searchCar(name);
        req.setAttribute("carList", cars);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/product.jsp");
        dispatcher.forward(req,resp);
    }
}

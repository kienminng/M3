package com.codegym.casem2.view;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.modal.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/priceNormal")
public class PriceNormal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarService carService = new CarService();
        List<Car> cars = carService.priceNormal();
        req.setAttribute("carList", cars);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/product.jsp");
        dispatcher.forward(req,resp);
    }
}

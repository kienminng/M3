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

@WebServlet(urlPatterns = "/carEdit")
public class viewCarEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        CarService carService = new CarService();
        Car cars = carService.findByCarID(carID);
        req.setAttribute("cars",cars);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/editCar.jsp");
        dispatcher.forward(req,resp);
    }
}

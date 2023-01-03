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

@WebServlet(urlPatterns = "/viewCarByID")
public class viewCarByID extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.parseInt(req.getParameter("carID"));
        CarService carService = new CarService();

        Car car = carService.findByCarID(ID);
        req.setAttribute("car",car);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/carInfomation.jsp");
        dispatcher.forward(req,resp);
    }
}

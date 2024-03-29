package com.codegym.casem2.view;

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

@WebServlet(urlPatterns = "/carModal")
public class CarModal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        CarService carService = new CarService();
        List<Car> carList = carService.getAllCar();

        String email = req.getParameter("email");

        Client client = clientServiceliml.findIndexByEmail(email);

        req.setAttribute("client",client);
        req.setAttribute("carList",carList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/html5/product.jsp");

        dispatcher.forward(req,resp);
    }
}

package com.codegym.casem2.view;

import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.clientService.Cart;
import com.codegym.casem2.modal.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addToCart")
public class addToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carID = Integer.parseInt(req.getParameter("carID"));
        Cart cart = new Cart();
        CarService carService =new CarService();
        Car car = carService.findByCarID(carID);
        if (car!=null) {
            cart.addCarToCart(car);
            RequestDispatcher dispatcher =req.getRequestDispatcher("/html5/modalCheck.jsp");
        }
    }
}

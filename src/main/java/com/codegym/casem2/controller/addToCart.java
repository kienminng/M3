package com.codegym.casem2.controller;

import com.codegym.casem2.DAO.DanhGiaDAO;
import com.codegym.casem2.clientService.CarService;
import com.codegym.casem2.clientService.Cart;
import com.codegym.casem2.clientService.ClientServiceliml;
import com.codegym.casem2.clientService.DanhGiaService;
import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;

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
        String email = req.getParameter("email");
        ClientServiceliml clientServiceliml = new ClientServiceliml();
        Client client = clientServiceliml.findIndexByEmail(email);
        req.setAttribute("client",client);



        int carID = Integer.parseInt(req.getParameter("carID"));
        Cart cart = new Cart();
        CarService carService =new CarService();
        Car car = carService.findByCarID(carID);
        carService.updateStatus(2,car.getCarID());

        req.setAttribute("car",car);


        DanhGiaService danhGiaService = new DanhGiaService();
        danhGiaService.addToCart(car.getCarID(),client.getId());


        resp.sendRedirect("/carModal");


    }
}

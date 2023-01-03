package com.codegym.casem2.clientService;

import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Car> cart = new ArrayList<>();

    public boolean addCarToCart(Car car){
        return cart.add(car);
    }

    public void deleteCarFromCart(Car car){
        cart.remove(car);
    }

}

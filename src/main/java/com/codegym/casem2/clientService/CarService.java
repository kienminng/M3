package com.codegym.casem2.clientService;

import com.codegym.casem2.DAO.CarDAO;
import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;

import java.util.List;

public class CarService {

    CarDAO carDAO = new CarDAO();
    public  List<Car> getAllCar() {
        return carDAO.getAllCar();
    }

    public  Car findByCarID(int ID) {
        return carDAO.findByCarID(ID) ;
    }

    public boolean saveCar(Car car) {
        return carDAO.saveCar(car);
    }

    public void edit(Car car) {
        carDAO.editCar(car);
    }

    public void delete(int Id){
        carDAO.deleteCar(Id);
    }

    public List<Car> priceNormal() {
        return carDAO.priceNormal();
    }

    public List<Car> priceMedium() {
        return carDAO.priceMedium();
    }

    public List<Car> priceHigh() {
        return carDAO.priceHigh();
    }

    public List<Car> searchCar(String name) {
        return carDAO.searchCar(name);
    }
}

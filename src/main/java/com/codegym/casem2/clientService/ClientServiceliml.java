package com.codegym.casem2.clientService;

import com.codegym.casem2.DAO.ProductDAO;
import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceliml {

    ProductDAO productDAO = new ProductDAO();


    public List<Client> getAll() {
        return productDAO.getAll();
    }

    public boolean save(Client client){
        return productDAO.Save(client);
    }

    public void edit(Client client) {
        productDAO.edit(client);
    }

    public void delete(String email){
        productDAO.delete(email);
    }

    public  Client findIndexByEmail(String email ){
        return productDAO.checkEmail(email);
    }

    public Client checkLogin(String email,String pass) {
        return productDAO.checkLogin(email,pass);
    }


}

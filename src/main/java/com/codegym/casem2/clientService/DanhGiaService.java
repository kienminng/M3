package com.codegym.casem2.clientService;

import com.codegym.casem2.DAO.DanhGiaDAO;
import com.codegym.casem2.modal.DanhGia;

import java.util.List;

public class DanhGiaService {
    DanhGiaDAO danhGiaDAO = new DanhGiaDAO();

    public List<DanhGia> getAllDAnhGia() {
        return danhGiaDAO.getAllDanhGia();
    }

    public void updateStatus(int status,int xeID){
        danhGiaDAO.updateStatus(status,xeID);
    }

    public boolean addToCart(int status,int xeID,int IDKH){
        return danhGiaDAO.addToCart(status,xeID,IDKH);
    }

     public List<DanhGia> ShowNotification(String email) {
        return danhGiaDAO.ShowNotification(email);
    }
}

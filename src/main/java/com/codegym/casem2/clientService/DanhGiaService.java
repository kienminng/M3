package com.codegym.casem2.clientService;

import com.codegym.casem2.DAO.DanhGiaDAO;
import com.codegym.casem2.modal.DanhGia;


import java.util.List;

public class DanhGiaService {
    DanhGiaDAO danhGiaDAO = new DanhGiaDAO();

    public List<DanhGia> getAllDAnhGia() {
        return danhGiaDAO.getAllDanhGia();
    }

//    public void updateStatus(int status,int xeID){
//        danhGiaDAO.updateStatus(status,xeID);
//    }

    public boolean addToCart(int xeID,int IDKH){
        return danhGiaDAO.addToCart(xeID,IDKH);
    }

    public List<DanhGia> getAllDanhGiaFormIDKH(int IDKH){
        return danhGiaDAO.getAllDanhGiaFromIDKH(IDKH);
    }

    public void delete(int ID) {
        danhGiaDAO.delete(ID);
    }

    public List<DanhGia> ShowNotification(String email) {
        return danhGiaDAO.ShowNotification(email);
    }

    public void updateContent(int IDxe,String content){
        danhGiaDAO.updateContent(IDxe,content);
    }

    public List<DanhGia> showAdminHD(){
        return danhGiaDAO.adminShowHD();
    }
}

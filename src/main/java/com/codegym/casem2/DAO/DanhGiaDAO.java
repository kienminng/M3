package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.Car;
import com.codegym.casem2.modal.Client;
import com.codegym.casem2.modal.DanhGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DanhGiaDAO {

    List<DanhGia> danhGias = new ArrayList<>();

    public List<DanhGia> getAllDanhGia(){
        String sql = "select * from danhgia";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int IDKH = resultSet.getInt("IDKD");
                int IDxe = resultSet.getInt("IDxe");
                String content = resultSet.getString("content");
                int status = resultSet.getInt("status");
                danhGias.add(new DanhGia(IDKH,IDxe,content,status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhGias;
    }

    public void updateStatus(int status,int xeID){
        String sql = "update danhgia set status=? where IDxe=?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,status);
            preparedStatement.setInt(2,xeID);
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    CarDAO carDAO = new CarDAO();

//    public List<Car> showCar(String email) {
//
//    }

    public boolean addToCart(int status,int xeID,int IDKH) {
        String sql = "insert into danhgia value(?,?,null,?)";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,xeID);
            preparedStatement.setInt(2,IDKH);
            preparedStatement.setInt(3,status);
            return preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}

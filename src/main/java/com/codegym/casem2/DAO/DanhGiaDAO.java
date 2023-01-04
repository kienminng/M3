package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.DanhGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DanhGiaDAO {



    public List<DanhGia> getAllDanhGia(){
        List<DanhGia> danhGias = new ArrayList<>();

        String sql = "select * from danhgia";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int IDKH = resultSet.getInt("IDKH");
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

    public List<DanhGia> getAllDanhGiaFromIDKH(int IDKH){
        List<DanhGia> danhGias = new ArrayList<>();
        String sql = "select * from danhgia where IDKH=?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,IDKH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
    public void updateContent(int IDxe,String content){
        String sql = "update danhgia set content=? wherer IDxe=?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,content);
            preparedStatement.setInt(2,IDxe);
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    CarDAO carDAO = new CarDAO();


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




    public void delete(int IDxe){
        String sql = "delete from danhgia where IDxe =?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,IDxe);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DanhGia> ShowNotification(String email) {
        List<DanhGia> danhGias = new ArrayList<>();
        String sql = "select * from khachhang join danhgia on danhgia.IDKH=khachhang.IDKH join xe on danhgia.IDxe=xe.IDxe where email= ?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int IDxe = resultSet.getInt("IDxe");
                String NameXe = resultSet.getString("NameXe");
                double price = resultSet.getDouble("Price");
                String color = resultSet.getString("Color");
                String img = resultSet.getString("Img");
                String branch = resultSet.getString("branch");
                int status = resultSet.getInt("status");
                int IDKH = resultSet.getInt("IDKH");
                String content = resultSet.getString("content");

                danhGias.add(new DanhGia(IDxe,NameXe,price,color,img,branch,status,IDKH,content));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhGias;
    }


    public List<DanhGia> adminShowHD() {
        List<DanhGia> danhGias = new ArrayList<>();

        String sql = "select * from khachhang join danhgia on danhgia.IDKH=khachhang.IDKH join xe on danhgia.IDxe=xe.IDxe";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int status = resultSet.getInt("status");
                int IDxe = resultSet.getInt("IDxe");
                String NameXe = resultSet.getString("NameXe");
                double price = resultSet.getDouble("Price");
                String color = resultSet.getString("Color");
                String img = resultSet.getString("Img");
                String branch = resultSet.getString("branch");
                int IDKH = resultSet.getInt("IDKH");
                String content = resultSet.getString("content");

                danhGias.add(new DanhGia(IDxe,NameXe,price,color,img,branch,status,IDKH,content));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhGias;
    }

    public double totalPrice(){
        String sql = "select sum(price) from khachhang join danhgia on danhgia.IDKH=khachhang.IDKH join xe on danhgia.IDxe=xe.IDxe where xe.status=3";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.next();
            return resultSet.getDouble("sum(price)");
        } catch (Exception e) {
            e.printStackTrace();
        }
       return 0;
    }

    public List<DanhGia> totaldanhgia() {
        List<DanhGia> danhGias = new ArrayList<>();

        String sql = "select * from khachhang join danhgia on danhgia.IDKH=khachhang.IDKH join xe on danhgia.IDxe=xe.IDxe where xe.status = 3";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int status = resultSet.getInt("status");
                int IDxe = resultSet.getInt("IDxe");
                String NameXe = resultSet.getString("NameXe");
                double price = resultSet.getDouble("Price");
                String color = resultSet.getString("Color");
                String img = resultSet.getString("Img");
                String branch = resultSet.getString("branch");
                int IDKH = resultSet.getInt("IDKH");
                String content = resultSet.getString("content");

                danhGias.add(new DanhGia(IDxe,NameXe,price,color,img,branch,status,IDKH,content));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhGias;
    }

}

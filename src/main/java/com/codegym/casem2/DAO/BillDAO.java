package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDAO {

    public List<HoaDon> getAllBill() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "select * from hoadon";

        Connection connection = ConnectionMySQL.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int IDHoaDon = resultSet.getInt("IDHoaDon");
                int IDKH = resultSet.getInt("IDKH");
                Date date = resultSet.getDate("NgayBan");

                hoaDonList.add(new HoaDon(IDHoaDon,IDKH,date));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return hoaDonList;
    }

    public boolean saveBill(HoaDon hoaDon) {
        String sql = "insert into hoadon value(null,?,?)";
        Connection connection = ConnectionMySQL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,hoaDon.getIDKH());
            preparedStatement.setDate(3, (java.sql.Date) hoaDon.getTime());

            return  preparedStatement.execute();

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HoaDon findBillByID(int IDKH) {
        List<HoaDon> hoaDonList = new ArrayList<>();

        String sql = "select * from hoadon where IDKH=?";
        Connection connection = ConnectionMySQL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,IDKH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int IDHoaDon = resultSet.getInt("IDHoaDon");
                Date time = resultSet.getTime("NgayBan");
                hoaDonList.add(new HoaDon(IDHoaDon,IDKH,time));

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return (HoaDon) hoaDonList;
    }
}

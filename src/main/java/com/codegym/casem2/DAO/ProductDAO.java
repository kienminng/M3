package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public  List<Client> getAll(){

        List<Client> clients = new ArrayList<>();
        String sql = "select * from khachhang";

        Connection connection = ConnectionMySQL.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                int role = resultSet.getInt("role");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("sdt");
                clients.add(new Client(name,email,pass,role,gender,address,phoneNumber));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    public boolean Save(Client client) {
        String spl = "insert into khachhang value(null,?,?,?,?,?,?,?)";

        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(spl);
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getEmail());
            preparedStatement.setString(3,client.getPassword());
            preparedStatement.setInt(4,client.getRole());
            preparedStatement.setString(5,client.getGender());
            preparedStatement.setString(6,client.getAddress());
            preparedStatement.setInt(7,client.getPhoneNumber());

            return preparedStatement.execute();

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean edit(Client client) {
        String spl = "update khachhang set name=?, password=?,gender= ?,address=?,sdt=? where email = ?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(spl);
            preparedStatement.setString(6,client.getEmail());
            preparedStatement.setString(1,client.getName());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.setString(3,client.getGender());
            preparedStatement.setString(4,client.getAddress());
            preparedStatement.setInt(5,client.getPhoneNumber());
            return preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  Client checkLogin(String email,String pass) {
        String sql = "select * from khachhang where (email =? and password = ?)";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();


            String Name= resultSet.getString("name");
            int role = resultSet.getInt("role");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            int phoneNumber = resultSet.getInt("sdt");

            return new Client(Name,email,pass,role,gender,address,phoneNumber);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void delete(String email) {
        String sql = "delete from khachhang where email= " +email;
        Connection connection = ConnectionMySQL.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client checkEmail(String email) {
        String sql = "select * from khachhang where email=" + email;
        Connection connection = ConnectionMySQL.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet =preparedStatement.executeQuery();

            String pass = resultSet.getString("password");

            String name= resultSet.getString("name");
            int role = resultSet.getInt("role");
            String gender = resultSet.getString("gender");
            String address = resultSet.getString("address");
            int phoneNumber = resultSet.getInt("sdt");

            return new Client(name,email,pass,role,gender,address,phoneNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




}

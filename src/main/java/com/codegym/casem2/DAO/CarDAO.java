package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {


    public List<Car> getAllCar() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from xe";

        Connection connection = ConnectionMySQL.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int carID = resultSet.getInt("IDxe");
                String carName = resultSet.getString("NameXe");
                double price = resultSet.getDouble("Price");
                String  color = resultSet.getString("color");
                String img = resultSet.getString("Img");
                String branch = resultSet.getString("branch");
                cars.add(new Car(carID,carName,price,color,img,branch));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    public boolean saveCar(Car car) {
        String spl = "insert into xe value(?,?,?,?,?,?)";
        Connection  connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(spl);
            preparedStatement.setInt(1,car.getCarID());
            preparedStatement.setString(2,car.getCarName());
            preparedStatement.setDouble(3,car.getPrice());
            preparedStatement.setString(4,car.getColor());
            preparedStatement.setString(5, car.getImg());
            preparedStatement.setString(6, car.getBranch());

            return  preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean editCar(Car car) {
        String sql = "update xe set NameXe=?,Price=?,Color =?,Img=?,branch=?  where IDxe=?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,car.getCarName());
            preparedStatement.setDouble(2,car.getPrice());
            preparedStatement.setString(3,car.getColor());
            preparedStatement.setString(4,car.getImg());
            preparedStatement.setString(5,car.getBranch());
            preparedStatement.setInt(6,car.getCarID());
            return preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Car findByCarID(int id) {
        String sql = "select * from xe where IDxe = ?";
        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String nameCar = resultSet.getString("nameXe");
            double price = resultSet.getDouble("Price");
            String color = resultSet.getString("Color");
            String img = resultSet.getString("Img");
            String branch = resultSet.getString("branch");
            return new Car(id,nameCar,price,color,img,branch);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteCar(int carID) {
        String sql = "delete from xe where IDxe=?";

        Connection connection = ConnectionMySQL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,carID);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Car> getAllCarByName(String carName) {
        List<Car> cars = new ArrayList<>();
        String sql = "call find_car_name(?)";
        Connection connection = ConnectionMySQL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,carName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int carID = resultSet.getInt("IDxe");
                double price = resultSet.getDouble("Price");
                String  color = resultSet.getString("color");
                String img = resultSet.getString("Img");
                String branch = resultSet.getString("branch");
                cars.add(new Car(carID,carName,price,color,img,branch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;

    }


}

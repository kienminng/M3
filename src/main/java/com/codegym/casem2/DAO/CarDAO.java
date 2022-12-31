package com.codegym.casem2.DAO;

import com.codegym.casem2.modal.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public List<Car> cars = new ArrayList<>();

    public List<Car> getAllCar() {
        String sql = "select * from xe";

        Connection connection = ConnectionMySQL.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int carID = resultSet.getInt("IDxe");
                String carName = resultSet.getString("Namexe");
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
        String sql = "update xe set Namexe=?,Price=?,Color =?,Img=?,branch=?  where carID=?";
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
        String sql = "select * from xe where carID =" +id;
        Connection connection = ConnectionMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            int carId = resultSet.getInt("IDxe");
            String nameCar = resultSet.getString("nameCar");
            double price = resultSet.getDouble("Price");
            String color = resultSet.getString("Color");
            String img = resultSet.getString("Img");
            String branch = resultSet.getString("branch");

            return new Car(carId,nameCar,price,color,img,branch);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteCar(int carID) {
        String sql = "delete from xe where carID="+carID;

        Connection connection = ConnectionMySQL.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

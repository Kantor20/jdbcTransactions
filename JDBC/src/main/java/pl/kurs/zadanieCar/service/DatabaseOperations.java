package pl.kurs.zadanieCar.service;

import pl.kurs.zadanieCar.model.Car;

import java.sql.*;

public class DatabaseOperations {


    public static boolean carExist(Car car, Connection connection) throws SQLException {
        String check = "SELECT count(*) FROM cars2 WHERE brand = ? AND model = ? AND price = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(check)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }
    }

    public static void addCarToDataBase(Car car, Connection connection) throws SQLException {
        String insert = "INSERT INTO cars2(brand, model, price) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setDouble(3, car.getPrice());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Samochód dodany.");
            }
        }
    }


    public static void insertCar(Car car, Connection connection) throws SQLException {
        if (!carExist(car, connection)) {
            addCarToDataBase(car, connection);
        } else {
            System.out.println("Samochod marki " + car.getBrand() + " znajduje się już w bazie danych!");
        }
    }

    public static void deleteCar(Car car, Connection connection) throws SQLException {
        String deleteQuery = "DELETE FROM cars2 WHERE brand = '"
                + car.getBrand() + "' AND model = '"
                + car.getModel() + "' AND price = "
                + car.getPrice() + ";";

        try (Statement statement = connection.createStatement()) {
            int affectedRows = statement.executeUpdate(deleteQuery);
            if (affectedRows > 0) {
                System.out.println("Samochod marki " + car.getBrand() + " zostal usuniety z bazy danych!");
            }
            else {
                System.out.println("Nie znaleziono samochodu marki " + car.getBrand() + " w bazie danych!");
            }
        }

    }

    public static void deleteAllDatabase(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        String deleteAll = "delete from cars2";
        statement.executeUpdate(deleteAll);
    }
}
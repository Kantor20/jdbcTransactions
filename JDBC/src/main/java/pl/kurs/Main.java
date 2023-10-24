package pl.kurs;

import org.apache.commons.dbcp2.BasicDataSource;
import pl.kurs.zadanieCarVol2.connection.Config;
import pl.kurs.zadanieCarVol2.model.Car;
import pl.kurs.zadanieCarVol2.service.SQLService;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        SQLService service = new SQLService();
//        Car car1 = new Car("Audi", "A5", 1500);
//        Car car2 = new Car("Audi", "A6", 15000);
//        Car car3 = new Car("BMW", "M3", 1000);
//        Car car3Update = new Car("BMW", "M4", 10020);
//
//        SQLService.insertToDB(car1);
//        SQLService.insertToDB(car2);
//
//        SQLService.deleteFromDB(1);

//        SQLService.updateToDB(car2);

//        SQLService.insertToDB(car1);
//        SQLService.deleteFromDB(2);
//        SQLService.updateToDB(car3Update);
//        Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksiegarnia?useSSL=false&serverTimezone=UTC",
//                "root",
//                "root");

        // Stwórz tabele user która ma haslo i tajne dane, dodaj kilka rekordow
        // https://www.w3schools.com/sql/sql_injection.asp

//        String select = "select * from user where pass = '1234' or 1 = 1";
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(select);
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(3));
//        }
//
//        String select = "select * from ksiazka where cena > ? and gatunek = ?";
//
//        PreparedStatement prepStm = connection.prepareStatement(select);
//
//        prepStm.setInt(1, 80);
//        prepStm.setString(2, "kryminal");
//
//        ResultSet resultSet = prepStm.executeQuery();
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(2));
//        }


        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ksiegarnia?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

//
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;

//        try {
//            connection = dataSource.getConnection();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select * from ksiazka");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (resultSet != null) resultSet.close();
//            if (statement != null) statement.close();
//            if (connection != null) connection.close();
//        }

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from ksiazka")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//
//        // SELECT
////        String select = "select * from klient";
////        ResultSet resultSet = statement.executeQuery(select);
////
////        while (resultSet.next()) {
//////            int id = resultSet.getInt("idklienta");
//////            String name = resultSet.getString("imie");
////
////            int id = resultSet.getInt(1);
////            String name = resultSet.getString(2);
////
////            System.out.println(id + " " + name);
////        }
//
//        // insert
//        String insert = "insert into klient values(null, 'Lukasz', 'Raczka');";
//        int insertedRows = statement.executeUpdate(insert);
//        System.out.println("Dodano: " + insertedRows);
//
//        // update
////        String update = "update klient set nazwisko = 'Nozka' where idklienta = 5";
////        int updatedRows = statement.executeUpdate(update);
////        System.out.println("Zaktulaziowano: " + updatedRows);
//
//        // delete
////        String delete = "delete from klient where idklienta = 5";
////        int deletedRows = statement.executeUpdate(delete);
////        System.out.println("Usunieto: " + deletedRows);
//    }

//}

package pl.kurs.zadanieCar;

import pl.kurs.zadanieCar.connection.Config;
import pl.kurs.zadanieCar.model.Car;


import java.sql.SQLException;

import static pl.kurs.zadanieCar.service.DatabaseOperations.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Car myCar = new Car("Audi", "A4", 103014);
        Car myCar2 = new Car("Bmw", "520", 75621);
        Car myCar3 = new Car("Mercedes", "Eklass", 98452);
        Car myCar4 = new Car("Mercedes", "Eklass", 52452);

        insertCar(myCar, Config.getConnection());
        insertCar(myCar2, Config.getConnection());
        insertCar(myCar3, Config.getConnection());
        insertCar(myCar4, Config.getConnection());
        deleteCar(myCar4, Config.getConnection());
        deleteAllDatabase(Config.getConnection());
    }
}

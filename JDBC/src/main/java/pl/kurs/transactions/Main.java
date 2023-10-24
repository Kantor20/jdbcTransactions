package pl.kurs.transactions;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    //  Zasady ACID (anagram) to zbiór zasad które opisują transakcję:
    //•	Atomowość – wykonanie wszystkich kroków wchodzących w skład transakcji decyduje o jej sukcesie;
    //•	Spójność – stan bazy danych zawsze przedstawia stan przed lub po transakcji;
    //•	Izolacja – transakcja jest odizolowana od innych transakcji, działa niezależnie od pozostałych;
    //•	Trwałość – w przypadku awarii systemu bazodanowego, transakcja albo wykonana jest w całości albo wcale;
    public static void main(String[] args) throws SQLException {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ksiegarnia?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            // DELETE
            PreparedStatement prepStm1 = null;

            try {
                prepStm1 = connection.prepareStatement("delete from klient where nazwisko = ?");
                prepStm1.setString(1, "Nowak");

                int deletedRows = prepStm1.executeUpdate();
                System.out.println("Usunieto: " + deletedRows);
            } finally {
                if (prepStm1 != null) prepStm1.close();
            }

            // INSERT
            PreparedStatement prepStm2 = null;
            try {
                prepStm2 = connection.prepareStatement("insert into klient values(null, ?,?);");
                prepStm2.setString(1, "Lukasz");
                //  prepStm2.setString(2, "dupa");

                int insertedRows = prepStm2.executeUpdate();
                System.out.println("Dodano: " + insertedRows);
            } finally {
                if (prepStm2 != null) prepStm2.close();
            }

            connection.commit();

        } catch (SQLException e) {
            System.out.println("ROLLBACK!!!!!");
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (connection != null) connection.close();
        }

    }
}

package kz.aitu.oop.practice.assignment5.data;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import java.sql.*;

public class DB implements IDB {

    // overriding method to connect with database
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/java";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "12345");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

package com.vantex.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/vantexsoft";
    private static String username = "root";
    private static String pass = "Suthesh123s";
    private static Connection con;

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,username, pass);
        return con;
    }
}

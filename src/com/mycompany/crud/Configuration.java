package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Configuration {

    private final static String URL = "jdbc:mysql://localhost:3306/foodiedb";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static Connection createConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
}

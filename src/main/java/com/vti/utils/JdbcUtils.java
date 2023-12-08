package com.vti.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    static Connection connection = null;
    public static Connection getConnection(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/db.properties"));
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if (connection == null){
                System.out.println("Kết nối thất bại");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection == null){
            try {
                connection.close();
            } catch (SQLException e){
                System.err.println("Có lỗi xảy ra");
            }
        }
    }
}

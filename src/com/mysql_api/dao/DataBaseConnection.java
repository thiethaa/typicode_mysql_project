package com.mysql_api.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnection {
    private static String db_baseUrl;
    private static String username;
    private static String password;
    private static String driver;

    public static Connection getDbConnection() {
        Properties properties = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("./src/db_property.properties");
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            System.out.println("File is not exist...");
            e.printStackTrace();
        }

        if (properties != null) {
            db_baseUrl = properties.getProperty("db_baseUrl");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        }

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(db_baseUrl, username, password);

        } catch (Exception e) {
            System.out.println("Failed Connect to DataBase....");
            e.printStackTrace();
        }

        return con;
    }
}

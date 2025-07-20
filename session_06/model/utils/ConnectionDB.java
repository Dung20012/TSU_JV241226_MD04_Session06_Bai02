package com.data.session_06.model.utils;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/login_demo";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection(){
        // mở kết nối
        // khai báo driver
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,PASS);
            return conn;

        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // đóng kết nối
    public void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.connection;

/**
 *
 * @author hainguyen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static DBConnection sSoleInstance;

    private DBConnection(){
        connection = getJDBCConnection();

    }  //private constructor.

    public static DBConnection getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new DBConnection();
        }

        return sSoleInstance;
    }
    private Connection getJDBCConnection() {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=Trung;encrypt=true;trustServerCertificate=true;";
        final String user = "hai1";
        final String password = "12345678";

        try {
//            Class.forName("");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            // TODO Auto-generated catch block

        }
        // TODO Auto-generated catch block
        return null;
    }

    public static void main(String[] args) {
        System.out.println("hello");
       Connection conn = DBConnection.getInstance().getConnection();
        if (conn != null) {
            System.out.println("Success");
        } else {
            System.err.println("error");
        }
//        DAO dao = new DAO();
//        System.err.println(dao.getAllGame());
//        System.err.println(dao.getAllAppVersion());
//        System.err.println(dao.getAllType());

    }


    public Connection getConnection() {
        return connection;
    }
}


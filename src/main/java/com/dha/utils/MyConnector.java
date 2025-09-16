/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class MyConnector {
    private static MyConnector instance;
    private Connection conn;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MyConnector() {
    }
    
    public static MyConnector getInstance(){
        if(instance == null){
            instance = new MyConnector();
        }
        return instance;
    }
    
    public Connection getConnect() throws SQLException{
        if(this.conn == null || this.conn.isClosed()){
            conn = DriverManager.getConnection("jdbc:mysql://localhost/translatedb", "root", "123456");
        }
        return conn;
    }
    
}

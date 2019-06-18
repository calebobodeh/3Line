/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caly.com;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DB_CONNECTION {
    
    public static void main(String[] args){
        DB_CONNECTION objconnect= new DB_CONNECTION();
        System.out.println(objconnect.get_connection());
    }
    
    public Connection get_connection(){
       Connection connection=null; 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:8084/test", "root", "root");
        }catch(Exception e){
            System.out.println(e);
        }
       return connection;
    }
}

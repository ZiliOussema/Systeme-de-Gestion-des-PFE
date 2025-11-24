/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.testmaven;  
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

   private  Connection  conDB ; 
private   Statement stmt ; 
public  ConnectionDB () throws SQLException 
{  try{
    Class.forName("oracle.jdbc.driver.OracleDriver"); 
     conDB  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ", "POO", "poo"); 
     stmt=(Statement) conDB.createStatement();
} catch  ( ClassNotFoundException e)
        { e.printStackTrace();
         }
 catch (SQLException e) {
       e.printStackTrace();       }

   
    
    
    
}

        public Connection getConDB() {
            return conDB;
        }  
          public void   close () throws SQLException  {
            conDB.close();  
          }

       

        public Statement getStmt() {
            return stmt;
        }

        
    }
      

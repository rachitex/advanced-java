package jframeexample;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class JFrameExample {
    
    protected Connection con = null;
    protected static final String url = "jdbc:mysql://localhost:3306/";
    protected static final String db = "login";
    protected static final String driver = "com.mysql.jdbc.Driver";
    
    public JFrameExample(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established..."); 
        }catch(ClassNotFoundException e){
        }catch(SQLException e){
        }catch(Exception e){
        }
    }
    
    public static void main(String[] args) {
    }   
    
}

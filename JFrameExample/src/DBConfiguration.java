
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moon
 */
public class DBConfiguration {
    public static Connection con = null;
    public static final String url = "jdbc:mysql://localhost:3306/";
    public static final String db = "prac3";
    public static final String driver = "com.mysql.jdbc.Driver";
    
    public static Connection gettingConnection(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established..."); 
        }catch(ClassNotFoundException e){
        }catch(SQLException e){
        }catch(Exception e){
        } 
        return con;
    }
}

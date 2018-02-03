package studentmanagement;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagement {
    
    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String db = "student";
    private static String driver = "com.mysql.jdbc.Driver";
    
    StudentManagement(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db, "root", "password123!");
            System.out.println("Connection Established...");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
            new StudentManagement();
            try{
                con.setAutoCommit(false);
                Statement stmt = con.createStatement();
                String createQuery = "drop table student";
                stmt.execute(createQuery);
                System.out.println("Table deleted successfully!!!");
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
    } 
}

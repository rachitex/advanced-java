
package studentmanagementcallable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentManagementCallable {
    static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String db = "studentcall";
    private static final String driver = "com.mysql.jdbc.Driver";
    
    StudentManagementCallable(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded..");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established..");
        }catch(SQLException e){
        }catch(ClassNotFoundException e){
        }
        
    }
    
    public static void main(String[] args) {
      
    }
    
}

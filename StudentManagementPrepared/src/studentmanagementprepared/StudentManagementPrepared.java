package studentmanagementprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class StudentManagementPrepared {

    static Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "student";
    String driver = "com.mysql.jdbc.Driver";
    
    StudentManagementPrepared(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db,"root","");
            System.out.println("Connection Established...");
        }catch(ClassNotFoundException e){
        }catch(SQLException e){
        }catch(Exception e){
        }
    }
    
    public static void main(String[] args) {
        new StudentManagementPrepared();
        PreparedStatement pstmt = null;
    }
    
}

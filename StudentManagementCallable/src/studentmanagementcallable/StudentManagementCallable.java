
package studentmanagementcallable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
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
            e.printStackTrace();
        }catch(ClassNotFoundException e){
        }
        
    }
    
    public static void main(String[] args) {
      new StudentManagementCallable();
       CallableStatement cstmt = null;
       Scanner scan = new Scanner(System.in);
       
       String callSQL = "{ call calculate_result(?,?,?,?,?) }";
       try{
            cstmt = con.prepareCall(callSQL);
            System.out.print("Enter the student ID: ");
            int rollNo = scan.nextInt();
            cstmt.setInt(1, rollNo); //Setting IN parameter
            cstmt.registerOutParameter(2, Types.VARCHAR); //Setting OUT parameter
            cstmt.registerOutParameter(3, Types.INTEGER); 
            cstmt.registerOutParameter(4, Types.DOUBLE);
            cstmt.registerOutParameter(5, Types.VARCHAR);
            cstmt.execute();
            
            String name = cstmt.getString(2);
            int total = cstmt.getInt(3);
            double percentage = cstmt.getDouble(4);
            String grade = cstmt.getString(5);
            System.out.println("Result:\n Name = "+name+", Total = "+total
                    + ", Percentage = "+percentage
                    +", Grade = "+grade);
       }catch(SQLException e){
           e.printStackTrace();
       }catch(Exception e){
       }
    }
    
}

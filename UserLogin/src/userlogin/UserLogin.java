package userlogin;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {
    
    static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String db = "login";
    private static final String driver = "com.mysql.jdbc.Driver";
    
    UserLogin(){
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
        new UserLogin();
        Statement stmt = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userid = scan.next();
        System.out.print("Enter Password: ");
        String password = scan.next();
        String selectQuery = "select * from login where id = '"+userid+"'AND "
                + "pass = '"+password+"';";
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            if(rs.next()){
                System.out.println("Successful Login!!!");
            }else{
                System.out.println("Invalid Username or Password!!!");
            }
            rs.close();
            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
        }
        
    }
    
}

package studentmanagement;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagement {
    
    Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String db = "student";
    private static final String driver = "com.mysql.jdbc.Driver";
    
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
            Connection con = null;
            Statement stmt = null;
            Scanner scan = new Scanner(System.in);
            int choice = 0;
            do{
                   try{
                //con.setAutoCommit(false);
                stmt = con.createStatement();
                System.out.println("Enter the choice to perform: ");
                System.out.println("Press 1 to perform Insert operation.");
                System.out.println("Press 2 to perform Read operation.");
                System.out.println("Press 3 to perform Update operation.");
                System.out.println("Press 4 to perform Delete operation.");
            
                try{
                    choice = scan.nextInt();
                }catch(Exception e){
                    scan.next();
                }
                
                switch(choice){
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    default:
                        System.out.println("Enter a valid choice!!!");
                }
                stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }while(choice != -9999);
            scan.close();
    } 
}

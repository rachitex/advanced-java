package insertupdatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUpdateDelete {
    
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String db = "prac2";
    private static final String driver = "com.mysql.jdbc.Driver";
    
    InsertUpdateDelete(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established...");
            
        }catch(SQLException e){
        }catch(ClassNotFoundException e){
        }catch(Exception e){
        }
    }
   
    public static void main(String[] args) {
           new InsertUpdateDelete();
           try{
                stmt = con.createStatement();
                Scanner scan = new Scanner(System.in);
                int choice = 0;
                do{
                    System.out.println("Press 1 for Insert operation.");
                    System.out.println("Press 2 for Update operation.");
                    System.out.println("Press 3 for Delete operation.");
                    System.out.println("Press 4 for Exit.");
                    int studentId = 0;
                    String studentName = "";
                    String course = "";
                    
                    choice = scan.nextInt();
                    switch(choice){
                        case 1:
                            System.out.print("Enter Student ID: ");
                            studentId = scan.nextInt();
                            System.out.print("Enter Student Name: ");
                            studentName = scan.next();
                            System.out.print("Enter Course: ");
                            course = scan.next();
                            String insertQuery = "insert into student_info"
                                    + " values"
                                    + "("+studentId+", '"+studentName+"', '"+course+"'"
                                    + ");";
                            //stmt = con.createStatement();
                            stmt.executeUpdate(insertQuery);
                            System.out.println("Rows inserted Successfully");
                            stmt.close();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Choice!!!");
                    }
                }while(choice != 4);
                scan.close();
           }catch(SQLException e){ 
               e.printStackTrace();
           }catch(Exception e){
               e.printStackTrace();
           }
    }
    
}

package databaseconnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "test";
    String drive = "com.mysql.jdbc.Driver";
    
    private DatabaseConnectivity(){
        try{
            Class.forName(drive);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established...");
        }catch(ClassNotFoundException e){
            System.out.println("Driver Not Loaded...");
            e.getMessage();
        }catch(SQLException e){
            System.out.println("Connection Not Established...");
            e.printStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    } 
    
    public static void main(String[] args) {
        new DatabaseConnectivity();
    }
}

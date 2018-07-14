package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
    Connection con = null;
    String url = "jdbc:mysql://localhost/";
    String db = "phonebook";
    String drive = "com.mysql.jdbc.Driver";
    
    public Connection gettingConnection(){
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
        return con;
    } 
    
    public static void main(String[] args) {
        /*DBConfiguration obj = new DBConfiguration();
        System.out.println(obj.gettingConnection());*/
    }
}

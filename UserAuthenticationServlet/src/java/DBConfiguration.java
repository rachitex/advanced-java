import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
    protected static Connection con = null;
    protected static String URL = "jdbc:mysql://localhost:3306/";
    protected static String DB = "login";
    protected static String DRIVER = "com.mysql.jdbc.Driver";
    
    public Connection gettingConnection(){
        try{
            Class.forName(DRIVER);
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection(URL+DB, "root", "");
            System.out.println("Connection established");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
    /*public static void main(String[] args){
          DBConfiguration obj = new DBConfiguration(); 
          obj.gettingConnection();      
    }*/
}

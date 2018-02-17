package metadataexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class MetaDataExample {
    static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String db = "studentcall";
    private static final String driver = "com.mysql.jdbc.Driver";
    static DatabaseMetaData metadata = null;
    
    MetaDataExample(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded..");
            con = DriverManager.getConnection(url+db, "root", "");
            System.out.println("Connection Established..");
            metadata = con.getMetaData();
            System.out.println("MetaData loaded in Program...");
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
        }
    }
    
    public static void printDatabaseMetaData(){
         try{
            System.out.println("\nDatabase Product Name: "+metadata.getDatabaseProductName());
            System.out.println("Database Major Version: "+metadata.getDatabaseMajorVersion());
            System.out.println("Database Minor Version: "+metadata.getDatabaseMinorVersion());
            System.out.println("Database Product Version: "+metadata.getDatabaseProductVersion());
            System.out.println("Driver Name: "+metadata.getDriverName());
            System.out.println("Database Driver Version: "+metadata.getDriverVersion());
            System.out.println("Database Numeric Functions: "+metadata.getNumericFunctions());
            System.out.println("Database SQL keywords: "+metadata.getSQLKeywords());
            System.out.println("Database String Functions: "+metadata.getStringFunctions());
            System.out.println("Database System Functions: "+metadata.getSystemFunctions());
            System.out.println("Database Time/Date Functions: "+metadata.getTimeDateFunctions());
            System.out.println("Database User Name: "+metadata.getUserName());
        }catch(SQLException e){
        }catch(Exception e){
        }
    }
    public static void main(String[] args) {
        new MetaDataExample();   
        printDatabaseMetaData();
    }  
}

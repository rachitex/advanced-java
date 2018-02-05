package studentmanagement;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentManagement {
    
    static Connection con = null;
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
            Statement stmt = null;
            Scanner scan = new Scanner(System.in);
            int choice = 0;
            do{
                   try{
                con.setAutoCommit(false);
                stmt = con.createStatement();
                System.out.println("Enter the choice to perform: ");
                System.out.println("Press 1 to perform Insert operation.");
                System.out.println("Press 2 to perform Read operation.");
                System.out.println("Press 3 to perform Update operation.");
                System.out.println("Press 4 to perform Delete operation.");
                System.out.println("Press 5 to exit.");
            
                try{
                    choice = scan.nextInt();
                }catch(Exception e){
                    scan.next();
                }
                
                switch(choice){
                    case 1:
                        System.out.print("Enter Roll No: ");
                        int rollNo = scan.nextInt();
                        System.out.print("Enter First Name: ");
                        String firstName = scan.next();
                        System.out.print("Enter Surname: ");
                        String surName = scan.next();
                        System.out.print("Enter Gender(m/f): ");
                        char gender = scan.next().charAt(0);
                        String gen = "";
                        if(gender == 'm' || gender == 'M'){
                            gen = "male";
                        }else if(gender == 'f' || gender == 'F'){
                            gen = "female";
                        }
                        System.out.println("Enter Date of Birth");
                        System.out.print("Enter Year: ");
                        String year = scan.next();
                        System.out.print("Enter Month: ");
                        String month = scan.next();
                        System.out.print("Enter Day: ");
                        String day = scan.next();
                        String dob = year+"-"+month+"-"+day;
                        System.out.print("Enter C Marks: ");
                        int cMarks = scan.nextInt();
                        System.out.print("Enter CPP Marks: ");
                        int cppMarks = scan.nextInt();
                        System.out.print("Enter Java Marks: ");
                        int javaMarks = scan.nextInt();
                        int total = cMarks + cppMarks + javaMarks;
                        float percentage = total/3;
                        String grade = "";
                        if(cMarks >= 40 && cppMarks >= 40 && javaMarks >= 40){
                            if(percentage >= 75){
                                grade = "Distinction";
                                percentage = total/3;
                            }else if(percentage >= 65 && percentage < 75){
                                grade = "First Class";
                                percentage = total/3;
                            }else if(percentage >= 50 && percentage < 65){
                                grade = "Second Class";
                                percentage = total/3;
                            }else if(percentage >=40 && percentage < 50){
                                grade = "Pass";
                                percentage = total/3;
                            }
                        }else{
                            grade = "Fail";
                            percentage = 0;
                        }
                        String insertQuery1 = "INSERT INTO student values"
                                + "("+rollNo+",'"+firstName+"', '"+surName+"',"
                                + "'"+gen+"', '"+dob+"');";
                        stmt.execute(insertQuery1);
                        con.commit();
                        System.out.println("Committing Data into student table");
                        String insertQuery2 = "INSERT INTO marks values"
                                + "("+rollNo+","+cMarks+","+cppMarks+","+javaMarks
                                +","+total+","+percentage+",'"+grade+"');";
                        stmt.execute(insertQuery2);
                        con.commit();
                        System.out.println("Values Inserted Successfully!!!\n\n");
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
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
            }while(choice != 5);
            try{
                stmt.close();
            }catch(SQLException e){
            }catch(Exception e){
            }
            scan.close();
    } 
}

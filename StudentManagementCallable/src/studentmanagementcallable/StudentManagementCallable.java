
package studentmanagementcallable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Scanner;
import java.sql.ResultSet;

public class StudentManagementCallable {
    static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "studentcall";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    StudentManagementCallable(){
        try{
            Class.forName(DRIVER);
            System.out.println("Driver Loaded..");
            con = DriverManager.getConnection(URL+DB, "root", "");
            System.out.println("Connection Established..");
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
        }
        
    }
    
    public static void main(String[] args) {
        new StudentManagementCallable();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String callSQL = "";
        int choice = 0;
        int rollNo = 0;
        String firstName = "";
        String surName = "";
        String gender = "";
        String dob = "";
        int cMarks = 0;
        int cppMarks = 0;
        int javaMarks = 0;
        
        Scanner scan = new Scanner(System.in);
        do{
           System.out.println("Press 1 to Calculate Result of a student");
            System.out.println("Press 2 to Fetch Distinction/Failure students");
            System.out.println("Press 3 to Print Merit List");
            System.out.println("Press 4 to print Gender Wise Merit List");
            System.out.println("Press 5 to search a Student by Roll No");
            System.out.println("Press 6 to search a Student by DOB");
            System.out.println("Press 7 to search a Student by Name");
            System.out.println("Press 8 to search a Student by Percentage");
            System.out.println("Press 9 to search a Student by Grade");
            System.out.println("Press 10 to count failures");
            System.out.println("Press 11 to show failing female students");
            System.out.println("Press 12 to show topper female students");
            System.out.println("Press 13 to exit");
            choice = scan.nextInt(); 
            
            switch(choice){
                case 1:
                    callSQL = "{ call calculate_result(?,?,?,?,?) }";
                    try{
                         cstmt = con.prepareCall(callSQL);
                         System.out.print("Enter the student ID: ");
                         rollNo = scan.nextInt();

                         //Setting IN parameter
                         cstmt.setInt(1, rollNo); 

                         //Setting OUT parameters
                         cstmt.registerOutParameter(2, Types.VARCHAR); 
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
                         cstmt.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch(Exception e){
                    }
                    break;
                case 2:
                    System.out.println("Press 1 for fetching distinction");
                    System.out.println("Press 2 for fetching failure");
                    int choice2 = scan.nextInt();
                    switch(choice2){
                        case 1:
                            callSQL = "{ call fetch_distinction }";
                            try{
                                cstmt = con.prepareCall(callSQL);
                                boolean hadResult = cstmt.execute(callSQL);
                                if(hadResult){
                                    rs = cstmt.getResultSet();
                                    while(rs.next()){
                                        System.out.println("\nName: "+rs.getString("name"));
                                        System.out.println("Percentage: "+rs.getDouble("percentage")+"\n");
                                    }
                                    rs.close();
                                    cstmt.close();
                                }
                            }catch(SQLException e){
                                e.printStackTrace();
                            }catch(Exception e){
                            }
                            break;
                        case 2:
                            callSQL = "{ call fetch_failure }";
                            try{
                                cstmt = con.prepareCall(callSQL);
                                boolean hadResult = cstmt.execute(callSQL);
                                if(hadResult){
                                    rs = cstmt.getResultSet();
                                    while(rs.next()){
                                        System.out.println("\nName: "+rs.getString("name"));
                                        System.out.println("Grade: Fail \n");
                                    }
                                    rs.close();
                                    cstmt.close();
                                }
                            }catch(SQLException e){
                                e.printStackTrace();
                            }catch(Exception e){
                            }
                            break;
                        default: 
                            System.out.println("Enter Valid Choice!!!");
                    }
                    break;
                case 3:
                    callSQL = "{ call fetch_merit_list }";
                    try{
                            cstmt = con.prepareCall(callSQL);
                            boolean hadResult = cstmt.execute(callSQL);
                            if(hadResult){
                                rs = cstmt.getResultSet();
                                System.out.println("Roll No\tName\t\tPercentage\tDate of Birth\tGender");
                                while(rs.next()){
                                    System.out.print("\n"+rs.getInt("rollno")+"\t");
                                    System.out.print(rs.getString("name")+"\t");
                                    System.out.print(Math.round(rs.getFloat("percentage")*100.0)/100.0+"\t");
                                    System.out.print(rs.getString("dob")+"\t");
                                    System.out.print(rs.getString("gender")+"\n");
                                }
                                rs.close();
                                cstmt.close();
                            }
                        }catch(SQLException e){
                                e.printStackTrace();
                        }catch(Exception e){
                        }
                    break;
                case 4:
                    callSQL = "{ call fetch_gender_merit_list }";
                    try{
                            cstmt = con.prepareCall(callSQL);
                            boolean hadResult = cstmt.execute(callSQL);
                            if(hadResult){
                                rs = cstmt.getResultSet();
                                System.out.println("Roll No\tName\t\tPercentage\tDate of Birth\tGender");
                                while(rs.next()){
                                    System.out.print("\n"+rs.getInt("rollno")+"\t");
                                    System.out.print(rs.getString("name")+"\t");
                                    System.out.print(Math.round(rs.getFloat("percentage")*100.0)/100.0+"\t");
                                    System.out.print(rs.getString("dob")+"\t");
                                    System.out.print(rs.getString("gender")+"\n");
                                }
                                rs.close();
                                cstmt.close();
                            }
                        }catch(SQLException e){
                                e.printStackTrace();
                        }catch(Exception e){
                        }
                    break;
                case 10:
                    callSQL = "{ call fetch_failure_count }";
                    try{
                        cstmt = con.prepareCall(callSQL);
                        boolean hadResult = cstmt.execute(callSQL);
                        if(hadResult){
                            rs = cstmt.getResultSet();
                            int count = 0;
                            while(rs.next()){
                                count = rs.getInt(1);
                            }
                            System.out.println("Number of Failures: "+count);
                            rs.close();
                            cstmt.close();
                        }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch(Exception e){
                    }
                    break;
                case 11:
                    callSQL = "{ call fetch_failure_female }";
                    try{
                        cstmt = con.prepareCall(callSQL);
                        boolean hadResult = cstmt.execute(callSQL);
                        if(hadResult){
                            rs = cstmt.getResultSet();
                            System.out.println("Name\t\tGrade");
                            while(rs.next()){
                                System.out.print("\n"+rs.getString("name")+"\t");
                                System.out.print("Fail\n");
                            }
                            rs.close();
                            cstmt.close();
                        }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch(Exception e){
                    }
                    break;
                
                case 12: 
                    callSQL = "{ call fetch_topper_female }";
                    try{
                        cstmt = con.prepareCall(callSQL);
                        boolean hadResult = cstmt.execute(callSQL);
                        if(hadResult){
                            rs = cstmt.getResultSet();
                            System.out.println("Name\t\tPercentage");
                            while(rs.next()){
                                System.out.print("\n"+rs.getString("name")+"\t");
                                System.out.print(Math.round(rs.getFloat("percentage")*100.0)/100.0+"\n");
                            }
                            rs.close();
                            cstmt.close();
                        }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch(Exception e){
                    }
                    break;
                default:
                    System.out.println("Enter Valid Choice!!!");
            }
        }while(choice != 13);
        scan.close();
    }
    
}

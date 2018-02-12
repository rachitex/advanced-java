package studentmanagementprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentManagementPrepared {

    static Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "student";
    String driver = "com.mysql.jdbc.Driver";
    
    StudentManagementPrepared(){
        try{
            Class.forName(driver);
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url+db,"root","");
            System.out.println("Connection Established...");
        }catch(ClassNotFoundException e){
        }catch(SQLException e){
        }catch(Exception e){
        }
    }
    
    public static void main(String[] args) {
        new StudentManagementPrepared();
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do{
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
                    int choice1 = 0;
                    do{
                            System.out.println("Press 1 to insert records.");
                            System.out.println("Press 2 to return to the main menu.");
                            try{
                                choice1 = scan.nextInt();
                            }catch(Exception e){
                                scan.next();
                            }
                            String insertQuery1 = "INSERT INTO student values"
                                    + "(?,?,?,?,?);";
                            try{
                                pstmt = con.prepareStatement(insertQuery1);
                            }catch(Exception e){
                            }
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
                            try{
                                pstmt.setInt(1, rollNo);
                                pstmt.setString(2, firstName);
                                pstmt.setString(3, surName);
                                pstmt.setString(4, gen);
                                pstmt.setString(5, dob);
                                int count = pstmt.executeUpdate();
                                pstmt.close();
                            }catch(Exception e){
                            }
                            
                    }while(choice1 != 2);
                    break;
                case 2:
                    int choice2 = 0;
                    do{
                        System.out.println("Press 1 to read all the records.");
                        System.out.println("Press 2 to read the specific records.");
                        System.out.println("Press 3 to read all failed students.");
                        System.out.println("Press 4 to return to the main menu.");
                        try{
                            choice2 = scan.nextInt();
                        }catch(Exception e){
                            scan.next();
                        }
                        switch(choice2){
                            case 1:
                                String selectQuery1 = "select distinct s.*,m.*"
                                            + " from student s, marks m "
                                            + "where s.rollno = m.rno;";
                                try{
                                    pstmt = con.prepareStatement(selectQuery1);
                                    
                                }catch(Exception e){
                                }
                                break;
                            case 2:
                                String selectQuery2 = "";
                                try{
                                    pstmt = con.prepareStatement(selectQuery2);
                                }catch(Exception e){
                                }
                                break;
                            default:
                                System.out.println("Enter a valid choice!!!");
                        }
                    }while(choice2 != 4);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Enter a valid choice!!!");
            }
        }while(choice != 5);
        try{
            scan.close();
        }catch(Exception e){
        }
    }
    
}

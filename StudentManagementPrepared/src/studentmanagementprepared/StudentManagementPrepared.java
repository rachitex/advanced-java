package studentmanagementprepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class StudentManagementPrepared {

    static Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "studentprep";
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
        ResultSet rs = null;
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
            int rollNo = 0;
            String firstName = "";
            String surName = "";
            char gender = ' ';
            String gen = "";
            String year = "";
            String month = "";
            String day = "";
            String dob = "";
            int cMarks = 0;
            int cppMarks = 0;
            int javaMarks = 0;
            int total = 0;
            float percentage = 0;
            String grade = "";
            
            switch(choice){
                case 1:
                    System.out.println("Press 1 to insert records.");
                    String insertQuery1 = "INSERT INTO student values"
                        + "(?,?,?,?,?);";
                    String insertQuery2 = "insert into marks values(?,?,?,?,?,?,?)";
                    try{
                        pstmt = con.prepareStatement(insertQuery1);
                        }catch(Exception e){
                        }
                            System.out.print("Enter Roll No: ");
                            rollNo = scan.nextInt();
                            System.out.print("Enter First Name: ");
                            firstName = scan.next();
                            System.out.print("Enter Surname: ");
                            surName = scan.next();
                            System.out.print("Enter Gender(m/f): ");
                            gender = scan.next().charAt(0);
                            gen = "";
                            if(gender == 'm' || gender == 'M'){
                                gen = "male";
                            }else if(gender == 'f' || gender == 'F'){
                                gen = "female";
                            }
                            System.out.println("Enter Date of Birth");
                            System.out.print("Enter Year: ");
                            year = scan.next();
                            System.out.print("Enter Month: ");
                            month = scan.next();
                            System.out.print("Enter Day: ");
                            day = scan.next();
                            dob = year+"-"+month+"-"+day;
                            System.out.print("Enter C Marks: ");
                            cMarks = scan.nextInt();
                            System.out.print("Enter CPP Marks: ");
                            cppMarks = scan.nextInt();
                            System.out.print("Enter Java Marks: ");
                            javaMarks = scan.nextInt();
                            total = cMarks + cppMarks + javaMarks;
                            percentage = total/3;
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
                                pstmt.executeUpdate();
                                pstmt.close();
                                pstmt = con.prepareStatement(insertQuery2);
                                pstmt.setInt(1, rollNo);
                                pstmt.setInt(2, cMarks);
                                pstmt.setInt(3, cppMarks);
                                pstmt.setInt(4, javaMarks);
                                pstmt.setInt(5, total);
                                pstmt.setFloat(6, percentage);
                                pstmt.setString(7, grade);
                                
                                int count = pstmt.executeUpdate();
                                System.out.println(count+" record inserted.");
                                pstmt.close();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
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
                        String selectQuery = "";
                        switch(choice2){
                            case 1:
                                selectQuery = "select distinct s.*,m.*"
                                            + " from student s, marks m "
                                            + "where s.rollno = m.rno";
                                try{
                                    pstmt = con.prepareStatement(selectQuery);
                                    rs = pstmt.executeQuery(selectQuery);
                                    while(rs.next()){
                                       rollNo = rs.getInt("rollno");
                                       System.out.println("\nRoll No: "+rollNo);
                                       firstName = rs.getString("firstname");
                                       System.out.println("Firstname: "+firstName);
                                       surName = rs.getString("surname");
                                       System.out.println("Surname: "+surName);
                                       gen = rs.getString("gender");
                                       System.out.println("Gender: "+gen);
                                       dob = rs.getDate("dob").toString();
                                       System.out.println("Date of Birth: "+dob);
                                       cMarks = rs.getInt("cmarks");
                                       System.out.println("C Marks: "+cMarks);
                                       cppMarks = rs.getInt("cppmarks");
                                       System.out.println("CPP Marks: "+cppMarks);
                                       javaMarks = rs.getInt("javamarks");
                                       System.out.println("Java Marks: "+javaMarks);
                                       percentage = rs.getFloat("percentage");
                                       System.out.println("Percentage: "+percentage);
                                       grade = rs.getString("grade");
                                       System.out.println("Grade: "+grade+"\n");
                                    } 
                                    rs.close();
                                    pstmt.close();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                System.out.print("Enter the Student Id: ");
                                int specificId = scan.nextInt();
                                selectQuery = "select distinct s.*, m.* from "
                                            + "student s JOIN marks m ON "
                                            + "s.rollno = m.rno WHERE "
                                            + "s.rollno = ?";
                                try{
                                    pstmt = con.prepareStatement(selectQuery);
                                    pstmt.setInt(1, specificId);
                                    rs = pstmt.executeQuery();
                                    while(rs.next()){
                                       rollNo = rs.getInt("rollno");
                                       System.out.println("\nRoll No: "+rollNo);
                                       firstName = rs.getString("firstname");
                                       System.out.println("Firstname: "+firstName);
                                       surName = rs.getString("surname");
                                       System.out.println("Surname: "+surName);
                                       gen = rs.getString("gender");
                                       System.out.println("Gender: "+gen);
                                       dob = rs.getDate("dob").toString();
                                       System.out.println("Date of Birth: "+dob);
                                       cMarks = rs.getInt("cmarks");
                                       System.out.println("C Marks: "+cMarks);
                                       cppMarks = rs.getInt("cppmarks");
                                       System.out.println("CPP Marks: "+cppMarks);
                                       javaMarks = rs.getInt("javamarks");
                                       System.out.println("Java Marks: "+javaMarks);
                                       percentage = rs.getFloat("percentage");
                                       System.out.println("Percentage: "+percentage);
                                       grade = rs.getString("grade");
                                       System.out.println("Grade: "+grade+"\n");
                                    }
                                    rs.close();
                                    pstmt.close();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                String gradeValue = "fail";
                                String name = "";
                                selectQuery = "select CONCAT_WS(' ', s.firstname, s.surname) " +
                                    "AS name " +
                                    "FROM   student s " +
                                    "JOIN   marks m ON s.rollno = m.rno " +
                                    "WHERE  m.grade = ?";
                                try{
                                    pstmt = con.prepareStatement(selectQuery);
                                    pstmt.setString(1, gradeValue);
                                    rs = pstmt.executeQuery();
                                    int count = 0;
                                    //con.commit();
                                    while(rs.next()){
                                        name = rs.getString("name");
                                        System.out.println(++count+". "+name);
                                    }
                                    rs.close();
                                    pstmt.close();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            default:
                                System.out.println("Enter a valid choice!!!");
                        }
                    }while(choice2 != 4);
                    break;
                case 3:
                    String selectQuery = "";
                    System.out.print("Enter the Student ID you want to update: ");
                    int updateId = scan.nextInt();
                    selectQuery = "select distinct s.*, m.* from "
                                            + "student s JOIN marks m ON "
                                            + "s.rollno = m.rno WHERE "
                                            + "s.rollno = ?";
                    try{
                        pstmt = con.prepareStatement(selectQuery);
                        pstmt.setInt(1, updateId);
                        rs = pstmt.executeQuery();
                        while(rs.next()){
                            System.out.println("Existing Record: ");
                                       rollNo = rs.getInt("rollno");
                                       System.out.println("\nRoll No: "+rollNo);
                                       firstName = rs.getString("firstname");
                                       System.out.println("Firstname: "+firstName);
                                       surName = rs.getString("surname");
                                       System.out.println("Surname: "+surName);
                                       gen = rs.getString("gender");
                                       System.out.println("Gender: "+gen);
                                       dob = rs.getDate("dob").toString();
                                       System.out.println("Date of Birth: "+dob);
                                       cMarks = rs.getInt("cmarks");
                                       System.out.println("C Marks: "+cMarks);
                                       cppMarks = rs.getInt("cppmarks");
                                       System.out.println("CPP Marks: "+cppMarks);
                                       javaMarks = rs.getInt("javamarks");
                                       System.out.println("Java Marks: "+javaMarks);
                                       percentage = rs.getFloat("percentage");
                                       System.out.println("Percentage: "+percentage);
                                       grade = rs.getString("grade");
                                       System.out.println("Grade: "+grade+"\n");
                                    }
                                    rs.close();
                                    pstmt.close();
                                    
                           String updateQuery1 = "UPDATE student SET"
                                    + " firstname = ?,"
                                    + " surname = ?,"
                                    + " gender = ?,"
                                    + " dob = ?"
                                    + " WHERE rollno = ?"; 
                           
                           String updateQuery2 = "UPDATE marks SET"
                                    + " cmarks = ?,"
                                    + " cppmarks = ?,"
                                    + " javamarks = ?,"
                                    + " totalmarks = ?,"
                                    + " percentage = ?,"
                                    + " grade = ?"
                                    + " WHERE rno = ?";
                           
                                    System.out.print("Enter the new First Name: ");
                                    String newFirstName = scan.next();
                                    System.out.print("Enter the new Surname: ");
                                    String newSurName = scan.next();
                                    System.out.print("Enter the new Gender(m/f): ");
                                    char newGender = scan.next().charAt(0);
                                    String newGen = "";
                                    if(newGender == 'm' || newGender == 'M'){
                                        newGen = "male";
                                    }else if(newGender == 'f' || newGender == 'F'){
                                        newGen = "female";
                                    }
                                    System.out.println("Enter the new Date of Birth");
                                    System.out.print("Enter Year: ");
                                    String newYear = scan.next();
                                    System.out.print("Enter Month: ");
                                    String newMonth = scan.next();
                                    System.out.print("Enter Day: ");
                                    String newDay = scan.next();
                                    String newDob = newYear+"-"+newMonth+"-"+newDay;
                                    System.out.print("Enter the new C Marks: ");
                                    int newCMarks = scan.nextInt();
                                    System.out.print("Enter the new CPP Marks: ");
                                    int newCppMarks = scan.nextInt();
                                    System.out.print("Enter the new Java Marks: ");
                                    int newJavaMarks = scan.nextInt();
                                    int newTotal = newCMarks + newCppMarks + newJavaMarks;
                                    float newPercentage = newTotal/3;
                                    String newGrade = "";
                                    if(newCMarks >= 40 && newCppMarks >= 40 && newJavaMarks >= 40){
                                        if(newPercentage >= 75){
                                            newGrade = "Distinction";
                                            percentage = newTotal/3;
                                        }else if(newPercentage >= 65 && newPercentage < 75){
                                            newGrade = "First Class";
                                            newPercentage = newTotal/3;
                                        }else if(newPercentage >= 50 && newPercentage < 65){
                                            newGrade = "Second Class";
                                            newPercentage = newTotal/3;
                                        }else if(newPercentage >=40 && newPercentage < 50){
                                            newGrade = "Pass";
                                            newPercentage = newTotal/3;
                                        }
                                    }else{
                                        newGrade = "Fail";
                                        newPercentage = 0;
                                    }
                             //con.setAutoCommit(false);
                             pstmt = con.prepareStatement(updateQuery1);
                             pstmt.setString(1, newFirstName);
                             pstmt.setString(2, newSurName);
                             pstmt.setString(3, newGen);
                             pstmt.setString(4, newDob);
                             pstmt.setInt(5, updateId);
                             pstmt.executeUpdate();
                             System.out.println("Table student updated...");
                             //con.commit();
                             pstmt.close();
                             
                             pstmt = con.prepareStatement(updateQuery2);
                             pstmt.setInt(1, newCMarks);
                             pstmt.setInt(2, newCppMarks);
                             pstmt.setInt(3, newJavaMarks);
                             pstmt.setInt(4, newTotal);
                             pstmt.setFloat(5, newPercentage);
                             pstmt.setString(6, newGrade);
                             pstmt.setInt(7, updateId);
                             pstmt.executeUpdate();
                             System.out.println("Table marks updated...");
                             //con.commit();
                             pstmt.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }catch(Exception e){
                    }
                    
                    break;
                case 4:
                    System.out.print("Enter the Student ID you want to delete: ");
                    int deleteId = scan.nextInt();
                    String deleteQuery = "delete m.*,s.* from marks m, student s";
                    try{
                        pstmt = con.prepareStatement(deleteQuery);
                        pstmt.executeUpdate();
                    }catch(Exception e){
                    }
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

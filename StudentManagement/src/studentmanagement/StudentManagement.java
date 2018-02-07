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
            con = DriverManager.getConnection(url+db, "root", "");
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
                    ResultSet rs = null;
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
                            int choice2 = 0;
                            System.out.println("Press 1 to display all the Records");
                            System.out.println("Press 2 to display specific Record");
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
                                    rs = stmt.executeQuery(selectQuery1);
                                    
                                    while(rs.next()){
                                        int rollno = rs.getInt("rollno");
                                        String firstname = rs.getString("firstname");
                                        String surname = rs.getString("surname");
                                        String gend = rs.getString("gender");
                                        String dateOfBirth = rs.getString("dob");
                                        int c = rs.getInt("cmarks");
                                        int cpp = rs.getInt("cppmarks");
                                        int java = rs.getInt("javamarks");
                                        int totalmarks = rs.getInt("totalmarks");
                                        float per = rs.getFloat("percentage");
                                        String grad = rs.getString("grade");
                                        System.out.println(rollno+"\n"
                                            +firstname+"\n"
                                            +surname+"\n"
                                            +gend+"\n"
                                            +dateOfBirth+"\n"
                                            +c+"\n"
                                            +cpp+"\n"
                                            +java+"\n"
                                            +totalmarks+"\n"
                                            +per+"\n"
                                            +grad+"\n\n");
                                    }
                                    rs.close();
                                    break;
                                case 2:
                                    System.out.print("Enter the roll no of a student: ");
                                    int value = scan.nextInt();
                                    String selectQuery2 = "select distinct s.*, m.* from "
                                            + "student s, marks m where "
                                            + "s.rollno = "+value+" AND "
                                            + "m.rno = "+value+";";
                                    rs = stmt.executeQuery(selectQuery2);
                                    while(rs.next()){
                                        int rollno = rs.getInt("rollno");
                                        String firstname = rs.getString("firstname");
                                        String surname = rs.getString("surname");
                                        String gend = rs.getString("gender");
                                        String dateOfBirth = rs.getString("dob");
                                        int c = rs.getInt("cmarks");
                                        int cpp = rs.getInt("cppmarks");
                                        int java = rs.getInt("javamarks");
                                        int totalmarks = rs.getInt("totalmarks");
                                        float per = rs.getFloat("percentage");
                                        String grad = rs.getString("grade");
                                        System.out.println(rollno+"\n"
                                            +firstname+"\n"
                                            +surname+"\n"
                                            +gend+"\n"
                                            +dateOfBirth+"\n"
                                            +c+"\n"
                                            +cpp+"\n"
                                            +java+"\n"
                                            +totalmarks+"\n"
                                            +per+"\n"
                                            +grad+"\n\n");
                                    }
                                    rs.close();
                                    break;
                                default:
                                    System.out.println("Invalid Choice!!!");
                            }
                            break;
                        case 3:
                            System.out.print("Enter the roll no of a Student to Update: ");
                            int updateValue = scan.nextInt();    
                            String selectQueryOld = "select distinct s.*, m.* from "
                                            + "student s, marks m where "
                                            + "s.rollno = "+updateValue+" AND "
                                            + "m.rno = "+updateValue+";";
                                    rs = stmt.executeQuery(selectQueryOld);
                                    while(rs.next()){
                                        int rollno = rs.getInt("rollno");
                                        String firstname = rs.getString("firstname");
                                        String surname = rs.getString("surname");
                                        String gend = rs.getString("gender");
                                        String dateOfBirth = rs.getString("dob");
                                        int c = rs.getInt("cmarks");
                                        int cpp = rs.getInt("cppmarks");
                                        int java = rs.getInt("javamarks");
                                        int totalmarks = rs.getInt("totalmarks");
                                        float per = rs.getFloat("percentage");
                                        String grad = rs.getString("grade");
                                        System.out.println(rollno+"\n"
                                            +firstname+"\n"
                                            +surname+"\n"
                                            +gend+"\n"
                                            +dateOfBirth+"\n"
                                            +c+"\n"
                                            +cpp+"\n"
                                            +java+"\n"
                                            +totalmarks+"\n"
                                            +per+"\n"
                                            +grad+"\n\n");
                                    }
                                    rs.close();
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
                            
                            String updateQuery1 = "UPDATE student SET"
                                    + " firstname = '"+newFirstName+"',"
                                    + "surname = '"+newSurName+"',"
                                    + "gender = '"+newGen+"',"
                                    + "dob = '"+newDob+"'"
                                    + " WHERE rollno = "+updateValue+";";
                            stmt.executeUpdate(updateQuery1);
                            System.out.println("Table Student Updated!");
                            con.commit();
                            
                            String updateQuery2 = "UPDATE marks SET"
                                    + " cmarks = "+newCMarks+","
                                    + "cppmarks = "+newCppMarks+","
                                    + "javamarks = "+newJavaMarks+","
                                    + "totalmarks = "+newTotal+","
                                    + "percentage = "+newPercentage+","
                                    + "grade = '"+newGrade+"'"
                                    + " WHERE rno = "+updateValue+";";
                            stmt.executeUpdate(updateQuery2);
                            System.out.println("Table Marks Updated!\n\n");
                            con.commit();
                            System.out.println("Updated Values: ");
                            String selectQueryNew = "select distinct s.*, m.* from "
                                            + "student s, marks m where "
                                            + "s.rollno = "+updateValue+" AND "
                                            + "m.rno = "+updateValue+";";
                                    rs = stmt.executeQuery(selectQueryNew);
                                    while(rs.next()){
                                        int rollno = rs.getInt("rollno");
                                        String firstname = rs.getString("firstname");
                                        String surname = rs.getString("surname");
                                        String gend = rs.getString("gender");
                                        String dateOfBirth = rs.getString("dob");
                                        int c = rs.getInt("cmarks");
                                        int cpp = rs.getInt("cppmarks");
                                        int java = rs.getInt("javamarks");
                                        int totalmarks = rs.getInt("totalmarks");
                                        float per = rs.getFloat("percentage");
                                        String grad = rs.getString("grade");
                                        System.out.println(rollno+"\n"
                                            +firstname+"\n"
                                            +surname+"\n"
                                            +gend+"\n"
                                            +dateOfBirth+"\n"
                                            +c+"\n"
                                            +cpp+"\n"
                                            +java+"\n"
                                            +totalmarks+"\n"
                                            +per+"\n"
                                            +grad+"\n\n");
                                    }
                                    rs.close();
                            break;
                        case 4:
                            System.out.println("Press 1 for Deleting specific record.");
                            System.out.println("Press 2 for Deleting all the records.");
                            int choice4 = scan.nextInt();
                            switch(choice4){
                                case 1:
                                    System.out.print("Enter the roll no of a Student to delete: ");
                                    int deleteValue = scan.nextInt();
                                    String deleteQuery1 = "delete m.*,s.* from marks m, student s "
                                            + "where m.rno = s.rollno AND m.rno = "+deleteValue+";";
                                    stmt.execute(deleteQuery1);
                                    con.commit();
                                    String selectQuery1 = "select distinct s.*,m.*"
                                            + " from student s, marks m "
                                            + "where s.rollno = m.rno;";
                                    rs = stmt.executeQuery(selectQuery1);
                                    
                                    while(rs.next()){
                                        int rollno = rs.getInt("rollno");
                                        String firstname = rs.getString("firstname");
                                        String surname = rs.getString("surname");
                                        String gend = rs.getString("gender");
                                        String dateOfBirth = rs.getString("dob");
                                        int c = rs.getInt("cmarks");
                                        int cpp = rs.getInt("cppmarks");
                                        int java = rs.getInt("javamarks");
                                        int totalmarks = rs.getInt("totalmarks");
                                        float per = rs.getFloat("percentage");
                                        String grad = rs.getString("grade");
                                        System.out.println(rollno+"\n"
                                            +firstname+"\n"
                                            +surname+"\n"
                                            +gend+"\n"
                                            +dateOfBirth+"\n"
                                            +c+"\n"
                                            +cpp+"\n"
                                            +java+"\n"
                                            +totalmarks+"\n"
                                            +per+"\n"
                                            +grad+"\n\n");
                                    }
                                    rs.close();
                                    break;
                                case 2:
                                    String deleteQuery2 = "delete m.*,s.* from marks m, student s;";
                                    stmt.execute(deleteQuery2);
                                    System.out.println("Records Deleted Successfully!!!");
                                    break;
                                default:
                                     System.out.println("Enter a valid choice!!!");
                            }
                            break;
                        default:
                            System.out.println("Enter a valid choice!!!");
                    }
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

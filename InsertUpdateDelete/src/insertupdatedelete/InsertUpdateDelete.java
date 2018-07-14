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
            e.getMessage();
        }
    }
   
    public static void main(String[] args) {
           new InsertUpdateDelete();
           try{
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
                            stmt = con.createStatement();
                            stmt.executeUpdate(insertQuery);
                            System.out.println("Rows inserted Successfully\n\n");
                            stmt.close();
                            break;
                        case 2:
                            System.out.print("Enter ID of the student: ");
                            int updateId = scan.nextInt();
                            String oldSelectQuery = "select * from student_info where student_id = "+updateId;
                            stmt = con.createStatement();
                            rs = stmt.executeQuery(oldSelectQuery);
                            System.out.println("\nExisting Records: ");
                            while(rs.next()){
                                studentId = rs.getInt("student_id");
                                studentName = rs.getString("student_name");
                                course = rs.getString("course");
                                System.out.println("Student ID: "+studentId);
                                System.out.println("Student Name: "+studentName);
                                System.out.println("Course: "+course);
                            }
                            rs.close();
                            //stmt.close();
                            
                            System.out.println("\nWhat do you want to Update?");
                            System.out.println("Press 1 for Name.");
                            System.out.println("Press 2 for Course.");
                            System.out.println("Press 3 for exit.");
                            int choice2 = scan.nextInt();
                            String updateQuery = "";
                            switch(choice2){
                                case 1:
                                    System.out.print("Enter new Name: ");
                                    studentName = scan.next();
                                    updateQuery = "Update student_info "
                                            + "set student_name = '"+studentName+"'"
                                            + " where student_id = "+updateId;
                                    stmt.executeUpdate(updateQuery);
                                    System.out.println("\nName updated successfully! \n");
                                    //stmt.close();
                                    break;
                                case 2:
                                    System.out.print("Enter new Course: ");
                                    course = scan.next();
                                    updateQuery = "Update student_info "
                                            + "set course = '"+course+"'"
                                            + " where student_id = "+updateId;
                                    stmt.executeUpdate(updateQuery);
                                    System.out.println("\nCourse updated successfully! \n");
                                    //stmt.close();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Enter valid choice!");
                            }
                            String newSelectQuery = "select * from student_info"
                                    + "where student_id = "+updateId;
                            rs = stmt.executeQuery(newSelectQuery);
                            System.out.println("\nNew Records: ");
                            while(rs.next()){
                                studentId = rs.getInt("student_id");
                                studentName = rs.getString("student_name");
                                course = rs.getString("course");
                                System.out.println("Student ID: "+studentId);
                                System.out.println("Student Name: "+studentName);
                                System.out.println("Course: "+course);
                            }
                            rs.close();
                            stmt.close();
                            break;
                        case 3:
                            System.out.print("Enter ID of the student: ");
                            int deleteId = scan.nextInt();
                            String oldDeleteSelectQuery = "select * from student_info where student_id = "+deleteId;
                            stmt = con.createStatement();
                            rs = stmt.executeQuery(oldDeleteSelectQuery);
                            System.out.println("\nExisting Records: ");
                            while(rs.next()){
                                studentId = rs.getInt("student_id");
                                studentName = rs.getString("student_name");
                                course = rs.getString("course");
                                System.out.println("Student ID: "+studentId);
                                System.out.println("Student Name: "+studentName);
                                System.out.println("Course: "+course);
                            }
                            rs.close();
                            //stmt.close();
                            
                            String deleteQuery = "delete from student_info "
                                    + "where student_id = "+deleteId;
                            stmt.executeUpdate(deleteQuery);
                            System.out.println("\nRow Deleted Successfully");
                            //stmt.close();
                            
                            String newDeleteSelectQuery = "select * from student_info;";
                            rs = stmt.executeQuery(newDeleteSelectQuery);
                            System.out.println("\nNew Records: ");
                            while(rs.next()){
                                studentId = rs.getInt("student_id");
                                studentName = rs.getString("student_name");
                                course = rs.getString("course");
                                System.out.println("Student ID: "+studentId);
                                System.out.println("Student Name: "+studentName);
                                System.out.println("Course: "+course);
                            }
                            rs.close();
                            stmt.close();
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

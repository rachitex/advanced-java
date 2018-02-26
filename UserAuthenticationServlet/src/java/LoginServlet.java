
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBConfiguration obj = new DBConfiguration();
        Connection con = obj.gettingConnection();
        PreparedStatement pstmt = null;
        PrintWriter out = null;
        //response.setContentType("text/html;charset=UTF-8");
        try{
           out = response.getWriter();
           String selectQuery = "SELECT id, pass FROM login WHERE id = ? AND pass = ?";
           pstmt = con.prepareStatement(selectQuery);
           String username = "";
           //String password = "";
           pstmt.setString(1, request.getParameter("txtUser"));
           pstmt.setString(2, request.getParameter("txtPassword"));
           pstmt.execute();
           ResultSet rs = pstmt.getResultSet();
           int count = 0;
           while(rs.next()){
               username = rs.getString("id");
               //password = rs.getString("password");
               count++;
           }
           if(count == 1){
               out.println("<h1>You are successfully Logged In, "+username+"!!!</h1>");
           }else{
               out.print("<h1>Failed</h1>");
           }
           rs.close();
           pstmt.close();
        }catch(Exception e){
            out.print(e.getMessage());
        }
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StudentMarks extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();  
            String name = (String)session.getAttribute("username");
            out.println();
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Enter Your Details</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form method = \"POST\" action = \"/GenerateResult/StudentMarks\">\n" +"<h1>Hello, "+name+"!!!</h1>"+
"            <table>\n" +
"                <tr>\n" +
"                    <td>Marks of C: </td>\n" +
"                    <td><input type=\"text\" name=\"txtCMarks\" placeholder=\"Enter your C Marks\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Marks of C++: </td>\n" +
"                    <td><input type=\"text\" name=\"txtCppMarks\" placeholder=\"Enter your C++ Marks\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>Marks of Java: </td>\n" +
"                    <td><input type=\"text\" name=\"txtJavaMarks\" placeholder=\"Enter your Java Marks\" /></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><input type=\"submit\" name=\"btnNext\" value=\"Next\"/></td>\n" +
"                    <td><input type=\"reset\" name=\"btnReset\" value=\"Reset\"/></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"        </form>\n" +
"    </body>\n" +
"</html>");
            int cmarks = Integer.parseInt(request.getParameter("txtCMarks"));
            int cppmarks = Integer.parseInt(request.getParameter("txtCppMarks"));
            int javamarks = Integer.parseInt(request.getParameter("txtJavaMarks"));
            int total = cmarks + cppmarks + javamarks;
            float percentage = total/3;
            String grade = "";
            if(cmarks > 40 && cppmarks > 40 && javamarks > 40){
                grade = "Pass";
            } else{
                grade = "Fail";
            }
            session.setAttribute("cmarks", cmarks);
            session.setAttribute("cppmarks", cppmarks);
            session.setAttribute("javamarks", javamarks);
            session.setAttribute("total", total);
            session.setAttribute("percentage", percentage);
            session.setAttribute("grade", grade);
            response.sendRedirect("DisplayResult");
            //return doGet(request, response);
        }
    }
}

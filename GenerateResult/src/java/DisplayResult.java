import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisplayResult extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();  
            int id = (Integer)session.getAttribute("userid");
            String name = (String)session.getAttribute("username");
            String department = (String)session.getAttribute("department");
            int cmarks = (Integer)session.getAttribute("cmarks");
            int cppmarks = (Integer)session.getAttribute("cppmarks");
            int javamarks = (Integer)session.getAttribute("javamarks");
            int total = (Integer)session.getAttribute("total");
            float percentage = (Float)session.getAttribute("percentage");
            String grade = (String)session.getAttribute("grade");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayResult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result of "+name+"</h1><br/>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>ID:</td><td>"+id+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Name:</td><td>"+name+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Department:</td><td>"+department+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>C Marks:</td><td>"+cmarks+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>C++ Marks:</td><td>"+cppmarks+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Java Marks:</td><td>"+javamarks+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Total:</td><td>"+total+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Percentage:</td><td>"+percentage+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            if(grade.equals("Pass")){
                out.println("<td>Grade:</td><td><font color='green'>"+grade+"</font></td>");
            }else{
                out.println("<td>Grade:</td><td><font color='red'>"+grade+"</font></td>");
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

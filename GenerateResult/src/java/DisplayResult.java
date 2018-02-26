import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisplayResult extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);  
            String id = (String)session.getAttribute("userid");
            String name = (String)session.getAttribute("username");
            String department = (String)session.getAttribute("department");
            String cmarks = (String)session.getAttribute("cmarks");
            String cppmarks = (String)session.getAttribute("cppmarks");
            String javamarks = (String)session.getAttribute("javamarks");
            String total = (String)session.getAttribute("total");
            String percentage = (String)session.getAttribute("percentage");
            String grade = (String)session.getAttribute("grade");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayResult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result of "+name+"</h1><br/>");
            out.println(name+ department+ cmarks+ cppmarks+ javamarks+ total+ percentage+ grade);
            out.println("</body>");
            out.println("</html>");
        }
    }
}

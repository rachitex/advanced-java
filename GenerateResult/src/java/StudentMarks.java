import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StudentMarks extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);  
            String name = (String)session.getAttribute("username");  
            out.println("Hello "+name);
            int cmarks = Integer.parseInt(request.getParameter("txtCMarks"));
            int cppmarks = Integer.parseInt(request.getParameter("txtCppMarks"));
            int javamarks = Integer.parseInt(request.getParameter("txtJavaMarks"));
            int total = cmarks + cppmarks + javamarks;
            float percentage = total/3;
            String grade = "";
            if(cmarks > 40 && cppmarks > 40 && javamarks > 40){
                grade = "pass";
            } else{
                grade = "fail";
            }
            session.setAttribute("cmarks", cmarks);
            session.setAttribute("cppmarks", cppmarks);
            session.setAttribute("javamarks", javamarks);
            session.setAttribute("total", total);
            session.setAttribute("percentage", percentage);
            session.setAttribute("grade", grade);
            RequestDispatcher rd = request.getRequestDispatcher("DisplayResult");  
            rd.forward(request, response);
        }
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

public class StudentData extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String name = request.getParameter("txtName");
            String department = request.getParameter("department");
            HttpSession session = request.getSession();
            session.setAttribute("userid", id);
            session.setAttribute("username", name);
            session.setAttribute("department", department);
            response.sendRedirect("StudentMarks");
        }catch(Exception e){
            e.printStackTrace();        
        }
    }
}

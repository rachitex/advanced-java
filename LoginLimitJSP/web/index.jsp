<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Limit using JSP</title>
</head>
<body>
	<form action="" method="post">
	
	UN<input type="text" name="UN">
	PW<input type="password" name="PW">
	<input type="submit" value="Login">
	
	</form>
	<%
		int count =1;
		String UN = request.getParameter("UN");
	if(UN != null){
		if(getServletContext().getAttribute("users")!=null){
			int cnt =(int) getServletContext().getAttribute("users");
			if (cnt>=2) {
				response.sendRedirect("err.jsp");
			}
			else {
				getServletContext().setAttribute("users", ++count);
				request.getSession().setAttribute("ses", UN);
				response.sendRedirect("home.jsp");
			}
			
		}
		else
		{
			ServletContext appl = getServletContext();
			appl.setAttribute("users", count);
			request.getSession().setAttribute("ses", UN);
			response.sendRedirect("home.jsp");
		}
		
	}
	%>
</body>
</html>
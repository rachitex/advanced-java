<%-- 
    Document   : index
    Created on : 15 Mar, 2018, 8:05:17 AM
    Author     : moon
--%>

<%@page import="service.CustomerFacadeREST, java.util.*, entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method = 'GET' action = '/service/CustomerFacadeREST'>
            <%
                CustomerFacadeREST cf = new CustomerFacadeREST();
                List<Customer> list = cf.findAll(); 
            %>
            <%= list %>
        </form>
    </body>
</html>

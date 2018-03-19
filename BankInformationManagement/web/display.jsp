<%-- 
    Document   : display
    Created on : 19 Mar, 2018, 1:40:27 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Information</title>
    </head>
    <body>
       <jsp:useBean id = 'bank' class = 'bankinfo.BankBean' scope="application">
           <jsp:setProperty name = 'bank' property = '*' />
       </jsp:useBean>
        <%
            HashMap hm = bank.displayInfo();
            out.println("Name of Account Holder: "+hm.get("Name"));
            out.println("<br/>Phone Number: "+hm.get("Phone"));
            out.println("<br/>Account Number: "+hm.get("AccountNumber"));
            out.println("<br/>Available Balance: "+hm.get("Balance"));
        %>
    </body>
</html>

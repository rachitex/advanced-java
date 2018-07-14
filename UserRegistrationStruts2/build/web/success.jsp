<%-- 
    Document   : success
    Created on : 27 Apr, 2018, 10:11:30 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Congratulations!</h1>
        <jsp:useBean id= "u" class="model.User"/>
        <p>You have successfully logged in  <jsp:getProperty name = "u" property= "name"/>.</p>
        <p>Your Contact No.: <jsp:getProperty name = "u" property= "contact"/>.</p>
        <p>Your Address: <jsp:getProperty name = "u" property= "address"/>.</p>
        <p>Your User ID: <jsp:getProperty name = "u" property= "user"/>.</p>
    </body>
</html>

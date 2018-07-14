<%-- 
    Document   : login
    Created on : 28 Apr, 2018, 9:54:55 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <s:form action="checklogin">  
            <table>
                <tbody>
                    <tr>
                        <td><s:textfield name="user" label="Username"></s:textfield></td>
                    </tr>
                    <tr>
                        <td><s:password name="password" label="Password"></s:password>  </td>
                    </tr>
                    <tr>
                        <td><s:submit value="Login"></s:submit></td>
                    </tr>
                </tbody>
            </table> 
        </s:form>
        <jsp:useBean id= "u" class="model.User" scope="session"/>
        <p>You have successfully logged in  <jsp:getProperty name = "u" property= "name"/>.</p>
        <p>Your Contact No.: <jsp:getProperty name = "u" property= "contact"/>.</p>
        <p>Your Address: <jsp:getProperty name = "u" property= "address"/>.</p>
        <p>Your User ID: <jsp:getProperty name = "u" property= "user"/>.</p>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 27 Apr, 2018, 10:02:14 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <s:form action="checklogin">  
            <table border="1">
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
    </body>
</html>

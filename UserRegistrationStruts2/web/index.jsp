<%-- 
    Document   : index
    Created on : 28 Apr, 2018, 9:36:02 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <s:form action="login">  
            <table>
                <tbody>
                    <tr>
                        <td><s:textfield name="name" label="Name"></s:textfield></td>
                    </tr>
                    <tr>
                        <td><s:textfield name="contact" label="Contact No"></s:textfield></td>
                    </tr>
                    <tr>
                        <td><s:textfield name="address" label="Address"></s:textfield></td>
                    </tr>
                    <tr>
                        <td><s:textfield name="user" label="Username"></s:textfield></td>
                    </tr>
                    <tr>
                        <td><s:password name="password" label="Password"></s:password>  </td>
                    </tr>
                    <tr>
                        <td><s:submit value="Register"></s:submit></td>
                    </tr>
                </tbody>
            </table> 
        </s:form>
    </body>
</html>

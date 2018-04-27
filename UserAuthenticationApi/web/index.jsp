<%-- 
    Document   : index
    Created on : 27 Apr, 2018, 9:44:12 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>
        <form action = "UserAuthenticationServlet" method = "GET">
            <table>
                <tr>
                    <td>
                        <input type = "text" name = "txtUser" placeholder = "Enter Username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = "password" name = "txtPass" placeholder = "Enter Password" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = "submit" name = "btnSubmit" value = "Login" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

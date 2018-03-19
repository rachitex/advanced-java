<%-- 
    Document   : index
    Created on : 12 Mar, 2018, 2:00:22 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Information Management</title>
    </head>
    <body>
        <form action = "result.jsp" method = "get">
            <table>
                <tr>
                    <td>
                        <input type = 'text' name = 'txtName' placeholder = 'Enter Name' />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = 'text' name = 'txtPhone' placeholder = 'Enter Phone Number' />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = 'text' name = 'txtAccountNumber' placeholder = 'Enter Account Number' />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = 'submit' name = 'btnSubmit' value = 'Submit' />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

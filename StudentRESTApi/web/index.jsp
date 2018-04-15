<%-- 
    Document   : index
    Created on : 15 Apr, 2018, 9:26:58 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Registration</title>
    </head>
    <body>
        <form action = "http://localhost:8080/StudentRESTApi/webresources/StudentRESTApi/studentDetail" method = "POST">
            <table>
                <tr>
                    <td><input type = "text" name = "txtName" placeholder="Enter Full Name" /></td>
                </tr>
                <tr>
                    <td><input type = "text" name = "txtFather" placeholder="Enter Father's Name" /></td>
                </tr>
                <tr>
                    <td><input type = "text" name = "txtEducation" placeholder="Enter Highest Education" /></td>
                </tr>
                <tr>
                    <td>
                        <select name = "course">
                            <option value = "MCA">MCA</option>
                            <option value = "MBA">MBA</option>
                            <option value = "MCom">MCom</option>
                            <option value = "MSc">MSc</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type = "submit" name = "btnSubmit" value="Register" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

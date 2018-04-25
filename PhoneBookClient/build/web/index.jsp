<%-- 
    Document   : index
    Created on : 25 Apr, 2018, 9:20:30 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PhoneBook</title>
    </head>
    <body>
        <form action = "http://localhost:8080/PhoneBookApi/webresources/phonebook/insertData" method = "POST">
            <table>
                <tr><td><input type = "text" name = "txtName" placeholder="Enter Your Name"></td></tr>
                <tr><td><input type = "text" name = "txtMobile" placeholder="Enter Your Mobile No."></td></tr>
                <tr><td><input type = "text" name = "txtEmail" placeholder="Enter Your Email"></td></tr>
                <tr><td><input type = "submit" name = "btnSubmit" value="Submit"></td></tr>
                <tr><td><a href = "http://localhost:8080/PhoneBookApi/webresources/phonebook/viewAllData">View All Data</a></td></tr>
                <tr><td><a href = "view.jsp">View Data</a></td></tr>
                <tr><td><a href = "update.jsp">Update Data</a></td></tr>
                <tr><td><a href = "delete.jsp">Delete Data</a></td></tr>
            </table>
        </form>
    </body>
</html>

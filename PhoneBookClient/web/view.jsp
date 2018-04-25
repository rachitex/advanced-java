<%-- 
    Document   : view
    Created on : Apr 25, 2018, 10:20:29 PM
    Author     : Aman Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PhoneBook</title>
    </head>
    <body>
        <form action = "http://localhost:8080/PhoneBookApi/webresources/phonebook/viewData" method = "POST">
            <input type = "text" name = "txtId" placeholder = "Enter ID">
            <input type = "submit" name = "btnView" value = "Go">
        </form>
    </body>
</html>

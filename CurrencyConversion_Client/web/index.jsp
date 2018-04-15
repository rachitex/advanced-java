<%-- 
    Document   : index
    Created on : 15 Apr, 2018, 9:17:47 AM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Currency Convertor</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action = "CurrencyConversionServlet" method = "POST">
            <table>
                <tr>
                    <td><input type = "text" name = "inr" placeholder = "Enter amount in Rupees"/></td>
                    <td><input type = "submit" name = "btnSubmit" value = "Go" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

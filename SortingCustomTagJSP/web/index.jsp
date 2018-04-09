<%-- 
    Document   : index
    Created on : 22 Mar, 2018, 12:47:55 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "m" uri = "WEB-INF/tlds/mytag.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorting</title>
    </head>
    <body>
        <form method="POST" action="ArrayServlet">
            Enter Space separated numbers:
            <input type="text" name="txtNum" />
            <input type="submit" name="btnSort" value="Sort" />
        </form>
        <m:sort/>
    </body>
</html>

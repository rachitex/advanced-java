<%-- 
    Document   : deposit
    Created on : 19 Mar, 2018, 2:05:33 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Money</title>
    </head>
    <body>
        <jsp:useBean id = 'bank' class = 'bankinfo.BankBean' scope="application">
           <jsp:setProperty name = 'bank' property = '*' />
       </jsp:useBean>
        <form action="deposit.jsp">
            <input type="text" name="txtAmount" placeholder="Enter Amount to Deposit">
            <input type="submit" name = "btnSubmit" value="Go">
        </form>
       <%
           try{
               long depositAmount = Long.parseLong(request.getParameter("txtAmount"));
               long newAmount = bank.deposit(depositAmount);
               out.println("New Balance: "+newAmount);
           }catch(Exception e){
               e.getMessage();
           }
       %>
       <br/>
       <a href="result.jsp">Go back</a>
    </body>
</html>

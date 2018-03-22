<%-- 
    Document   : withdraw
    Created on : 22 Mar, 2018, 12:25:20 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Money</title>
    </head>
    <body>
        <jsp:useBean id = 'bank' class = 'bankinfo.BankBean' scope="application">
           <jsp:setProperty name = 'bank' property = '*' />
       </jsp:useBean>
        <form action="withdraw.jsp">
            <input type="text" name="txtAmount" placeholder="Enter Amount to Deposit">
            <input type="submit" name = "btnSubmit" value="Go">
        </form>
       <%
           try{
               long withdrawAmount = Long.parseLong(request.getParameter("txtAmount"));
               long newAmount = bank.withdraw(withdrawAmount);
               out.println("New Balance: "+newAmount);
           }catch(Exception e){
               e.getMessage();
           }
       %>
       <br/>
       <a href="result.jsp">Go back</a>
    </body>
</html>

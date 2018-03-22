<%-- 
    Document   : result
    Created on : 19 Mar, 2018, 12:48:02 PM
    Author     : moon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Details</title>
    </head>
    <body>    
        <%
            String name = request.getParameter("txtName");
            String phone = request.getParameter("txtPhone");
            String accountNumber = request.getParameter("txtAccountNumber");
            long balance = 0;
        %>
        <jsp:useBean id = 'bank' class = 'bankinfo.BankBean' scope="application">
            <jsp:setProperty name = 'bank' property = 'name' value = '<%= name %>' />
            <jsp:setProperty name = 'bank' property = 'phone' value = '<%= phone %>' />
            <jsp:setProperty name = 'bank' property = 'accountNumber' value = '<%= accountNumber %>' />
            <jsp:setProperty name = 'bank' property = 'balance' value = '<%= balance %>' />
        </jsp:useBean>
        Name of Account Holder: <jsp:getProperty name = 'bank' property="name" /><br/>
        Phone: <jsp:getProperty name = 'bank' property="phone" /><br/>
        Account Number: <jsp:getProperty name = 'bank' property="accountNumber" /><br/>
        Available Balance: <jsp:getProperty name = 'bank' property="balance" /><br/><br/>
        Select operation you want to perform: 
        <ul>
            <li><a href="deposit.jsp">Deposit</a></li>
            <li><a href="withdraw.jsp">Withdraw</a></li>
            <li><a href="display.jsp">Display Info</a></li>
        </ul>
    </body>
</html>

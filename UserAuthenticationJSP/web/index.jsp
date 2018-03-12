<%-- 
    Document   : index
    Created on : 12 Mar, 2018, 12:50:37 PM
    Author     : moon
--%>
<%@page import = "userauthentication.DBConfiguration, java.sql.*, javax.servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Authentication</title>
    </head>
    <body>
        <form>
            <table>
                <tr>
                    <td><input type = 'text' name = 'txtUser' placeholder = 'Enter Username' /></td>
                </tr>
                <tr>
                    <td><input type = 'password' name = 'txtPass' placeholder = 'Enter Password' /></td>
                </tr>
                <tr>
                    <td><input type = 'submit' name = 'btnSubmit' value = 'Login' /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
<%
           DBConfiguration db = new DBConfiguration();
           Connection con = db.gettingConnection();
           Statement stmt = null;
           try{
                String userid = request.getParameter("txtUser");
                String password = request.getParameter("txtPass");
                String selectQuery = "select * from login where id = '"+userid+"'AND pass = '"+password+"'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);
                if(rs.next()){
                %>Login Successful!!! <br> Welcome, <%= userid %>
<%            }else{
                %>Login Failed!!!
<%            }
            rs.close();
            stmt.close();
           }catch(SQLException e){
               e.printStackTrace();
           }
%> 
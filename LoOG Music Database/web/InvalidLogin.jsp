<%-- 
    Document   : InvalidLogin
    Created on : Nov 10, 2014, 2:11:26 PM
    Author     : Busairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Login</title>
    </head>
    <body>
            <%
                String name = session.getAttribute("username").toString();
                out.println("Sorry we don't have the username '" + name + "' registered in our database.");
                out.println("Please re-enter the username and password.");
            %>
            <form action="LoginCheck.jsp" method="post">
            <br/> <font color ="black"> Username: </font> <input type = "text" name = "username">
            <br/> <font color ="black"> Password: </font> <input type = "password" name = "password">
            <br/> <input type = "submit" value = "Submit"> </form>
            <a href="Register.html">Click here to register.</a>
    </body>
</html>

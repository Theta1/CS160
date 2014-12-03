<%-- 
    Document   : InvalidLogin
    Created on : Nov 10, 2014, 2:11:26 PM
    Author     : Busairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="InvalidLogin.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Login</title>
    </head>
    <body>
        <%@ page import="servlets.LoginCheck" %>
        <%
            //String name = session.getAttribute("username").toString();
            String name = LoginCheck.getUserName();
            out.println("Sorry we don't have the username '" + name + "' registered in our database.");
            out.println("Please re-enter the username and password.");
        %>
    <center>
        <div id="submitbutton">
            <form action="LoginCheck">
                <br/> <font color ="white"> Username: </font> <input type = "text" name = "username">
                <br/> <font color ="white"> Password: </font> <input type = "password" name = "password">
                </center>
                <br/> <input type = "submit" value = "Submit"> </form>
        </div>

        <br>
        <a href="Register.html">Click here to register.</a>
        <p></p>
        <a href="index.html">Click here to go back to front page.</a>
    </body>
</html>

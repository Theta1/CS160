<%-- 
    Document   : LandingPage.jsp
    Created on : Nov 10, 2014, 8:42:25 AM
    Author     : Busairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cantus Home Page</title>
    </head>
    <body>
    <center> 
        <h2> 
            <%@ page import="servlets.LoginCheck" %>
            <%
                String name = LoginCheck.getUserName();
                out.println("Hello " + name + ", you have successfully logged into Cantus.");
            %> 
        </h2> 
        <canvas id="myCanvas" width="200" height="100"
        style="border:1px solid #d3d3d3;">
        Your browser does not support the HTML5 canvas tag.</canvas>
        
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            ctx.font = "30px Arial";
            ctx.fillText("Hello World",10,50);
        </script>
        
        <form action="search.java" method="post">
            <font color="black"> Search: </font> <input type="text" name="search"> </form>
        
        <form action="AddASong.html" method="post">
            <br/> <input type = "submit" value = "Add A Song To Library"> </form> 
            <input type = "submit" value = "Delete Song From Library">
            

            <br/><a href="LoggedOut.jsp">Logout</a>
    </center>
</body>
</html>

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
            <link rel="stylesheet" type="text/css" href="LandingPage.css">
            <%@ page import="servlets.LoginCheck, java.util.ArrayList" %>
            <%
                String name = LoginCheck.getUserName();
                //out.println("Hello " + name + ", you have successfully logged into Cantus.");
                ArrayList testListOfSongs = new ArrayList();
                for(int i = 0; i < 5000; i++)
                    testListOfSongs.add(i);
            %> 
            Hello <span class="aquaText"><%= name %></span>, you have successfully logged into Cantus.
        </h2> 
        
       <div class="songarea">
           <% 
             for(int i = 0; i < testListOfSongs.size(); i++)
             {  out.println(testListOfSongs.get(i) + "<BR>"); }
           %>
       </div>
       
       <div id="searchbar"
        <form action="search.java" method="post">
            <font color="white"> Search: </font> <input type="text" name="search"> </form>
       </div>
        
       <div id ="addsongbutton">
        <form action="AddASong.html" method="post">
            <br/> <input type = "submit" value = "Add A Song To Library"> </form> 
       </div>
       
       <div id ="deletesongbutton">
            <input type = "submit" value = "Delete Song From Library">
       </div>

       <br/><a href="LoggedOut.jsp">Logout of Cantus</a>
    </center>
</body>
</html>

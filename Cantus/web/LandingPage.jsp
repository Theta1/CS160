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
                testListOfSongs.add("Go Crazy");
                testListOfSongs.add("Holler");
                testListOfSongs.add("Mr Mr");
                testListOfSongs.add("Fur Elise");
                testListOfSongs.add("Immortals");
                testListOfSongs.add("Let It Go");
                testListOfSongs.add("Friend In Me");
                testListOfSongs.add("Big Booty Bitches");
                testListOfSongs.add("MapleStory Login Theme");
                testListOfSongs.add("Grenade");
                testListOfSongs.add("Nintendo Mii Theme");
                testListOfSongs.add("SSB Theme");
                testListOfSongs.add("Yu-Gi-Oh Theme");
                testListOfSongs.add("I Got A Boy");
                testListOfSongs.add("Give It To Me");
                testListOfSongs.add("Touch My Body");
                testListOfSongs.add("Upgrades");
                testListOfSongs.add("Avengers Theme Song");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                testListOfSongs.add("Twinkle");
                
            %> 
            Hello <span class="aquaText"><%= name %></span>, you have successfully logged into Cantus.
        </h2> 
        
       <!-- <canvas id="myCanvas" width="800" height="400">
        Your browser does not support the HTML5 canvas tag.</canvas>
        
        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            ctx.fillStyle="#FFFFFF";
            ctx.fillRect(20,0,800,400);
            ctx.fillStyle="#000000";
            ctx.fillText("List of songs from user goes here.",30,40);
        </script>-->
       <div class="songarea">
           <% 
             for(int i = 0; i < testListOfSongs.size(); i++)
             {  out.println(testListOfSongs.get(i) + "<BR>"); }
           %>
       </div>
       
        <form action="search.java" method="post">
            <font color="white"> Search: </font> <input type="text" name="search"> </form>
        
        <form action="AddASong.html" method="post">
            <br/> <input type = "submit" value = "Add A Song To Library"> </form> 
            <input type = "submit" value = "Delete Song From Library">
            

            <br/><a href="LoggedOut.jsp">Logout</a>
    </center>
</body>
</html>

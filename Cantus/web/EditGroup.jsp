<%-- 
    Document   : EditGroup
    Created on : Dec 9, 2014, 8:15:52 PM
    Author     : Busairo
--%>

<%@page import="tagging.SongGroup"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="EditGroup.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit a group</title>
    </head>
    <body>
          <%@ page import="servlets.LoginCheck, java.util.ArrayList, library_handling.MusicLibraryDatabase,
                     java.util.List, library_handling.Song" %>
        <form action="EditGroup">
        <br/> <font color="white">Please choose a group: </font>
        <%
            MusicLibraryDatabase mld = new MusicLibraryDatabase();
            List<SongGroup> groupList = mld.getAllGroups();
            
            out.println("<select>");
            for(int i = 0; i < groupList.size(); i++)
            {
                out.println("<option value=" + ""+ groupList.get(i).toString() + ">" + groupList.get(i).toString() + "</option>");
            }
            out.println("</select>");
        %>
         <br/> <font color="white"> Artist: </font> <input type ="text" name="Artist" required>
        </form>
        <a href="LandingPage.jsp"> Don't want to edit a group anymore?</a>
    </body>
</html>

<%-- 
Document   : LandingPage.jsp
Created on : Nov 10, 2014, 8:42:25 AM
Author     : Busairo
--%>

<%@page import="servlets.Search"%>
<%@page import="tagging.Artist"%>
<%@page import="tagging.SongGroup"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cantus Home Page</title>
    </head>
    <body>
      <%@ page import="servlets.LoginCheck,java.util.ArrayList, library_handling.MusicLibraryDatabase,
                     java.util.List, library_handling.Song" %>
        <h2> 
            <link rel="stylesheet" type="text/css" href="LandingPage.css">
            <%
                String name = LoginCheck.getUserName();
                MusicLibraryDatabase mld = new MusicLibraryDatabase();
                List<Song> songList = mld.getAllSongs();
                List<SongGroup> groupList = mld.getAllGroups();
                List<Artist> artistList = mld.getAllArtists();
                int biggest = songList.size() + groupList.size() + artistList.size();
            %> 
            
            <%!
                public int getIndexOfElement(List<Song> list, String name)
                {
                    int index = 0;
                    for(int i = 0; i < list.size(); i++)
                    {
                        String element = list.get(i).getTitle();
                        if(element.equalsIgnoreCase(name))
                        { index = i; }
                    }
                    return index;
                }
            %>
            Hello <span class="aquaText"><%= name %></span>, you have successfully logged into Cantus.
        </h2> 

        <div class="songarea">
            <center>
            <form action= "deleteFunction()" method="post">
            <select id ="name_of_song" name ="songtitles" size="50">
            <% 
              for(int i = 0; i < songList.size(); i++)
              {  out.println("<option>" + ""+ songList.get(i).getTitle() + "</option>"); }
            %>
            </select>
            </form>
            </center>
        </div>

        <div id="searchbar">
           <form action="javascript:searchFunction(number);">
             <font color="white">  Search: </font> <input type="text" id="searchinput" name="search"> 
             <%
                String toLookFor = "dvno" /* place holder for now to test search */;
                int indexOf = getIndexOfElement(songList, toLookFor);
             %>
            </form>
        </div>

        <div id ="addsongbutton">
            <form action="AddASong.html" method="post">
                <br/> <input type = "submit" value = "Add A Song To Library"> </form> 
        </div>

        <div id ="creategroupbutton">
            <form action="AddAGroup.html" method="post">
                <br/> <input type = "submit" value = "Create group"> </form> 
        </div>

        <div id ="editgroupbutton">
            <form action="EditGroup.jsp" method="post">
                <br/> <input type = "submit" value = "Edit group"> </form> 
        </div>

        <div id ="deletesongbutton">
            <form action="DeleteSong">
                <input type = "submit" value = "Delete Song From Library"> </form>
        </div>
            
        <br/><a href="LoggedOut.jsp">Logout of Cantus</a>
        
        <script>
           var number = '<%= indexOf %>';
           var searchfor = document.getElementById("searchinput").value;
           //var nos = document.getElementByName("search");
           
           function searchFunction(index) {
              document.getElementById("name_of_song").selectedIndex = index;
            }
        </script>

    
</body>
</html>

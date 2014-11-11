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
            <%
                String name = session.getAttribute("username").toString();
                out.println("Hello " + name + ", you have successfully logged into Cantus.");
            %> 
        </h2> 

        <form action="AddASong.html" method="post">
            <br/> <input type = "submit" value = "Add A Song To Library"> </form> 

        <a href="LoggedOut.jsp">Logout</a>
    </center>
</body>
</html>

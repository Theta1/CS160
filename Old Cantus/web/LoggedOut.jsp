<%-- 
    Document   : LoggedOut
    Created on : Nov 10, 2014, 2:18:27 PM
    Author     : Busairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% 
            session.removeAttribute("username"); 
            session.removeAttribute("password"); 
            session.invalidate(); 
        %> 
        <h1>Logout was done successfully.</h1>
        <a href="index.html">Click here to return to the Login page</a>
    </body>
</html>

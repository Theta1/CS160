<%-- 
    Document   : RegisterCheck
    Created on : Nov 20, 2014, 3:27:26 AM
    Author     : Christopher Raleigh
--%>

<%@page import="login_handling.User"%>
<%@page import="login_handling.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Check</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDatabase ud = new UserDatabase();
            ud.signUp(username, password);
            response.sendRedirect("index.html");
        %>
    </body>
</html>

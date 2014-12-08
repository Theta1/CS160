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
        <link rel="stylesheet" type="text/css" href="RegistrationCheck.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Check</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDatabase ud = new UserDatabase();
            boolean check = ud.signUp(username, password);
            if(check) { out.println("<p> Registration <b>SUCCESSFUL</b>");    }
            else {  out.println("<p> Registration <b>UNSUCCESSFUL</b> "
                    + "<p> Username & password already registered."
                    + "<p> Or (For developers) MYSQL server is not on.<p>");    }
            //response.sendRedirect("index.html");
        %>
        <br/> <a href="index.html">Click here to return to login page</a>
    </body>
</html>

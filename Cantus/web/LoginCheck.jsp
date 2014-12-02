<%--
    Document   : LoginCheck
    Created on : Nov 10, 2014, 8:36:28 AM
    Author     : Busairo
--%>

<%@page import="login_handling.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Check</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDatabase ud = new UserDatabase();

            try {
                User getuser = ud.logIn(username, password);
                session.setAttribute("username", username);
                response.sendRedirect("LandingPage.jsp");
            } catch (IllegalArgumentException e) {
                session.setAttribute("username", username);
                response.sendRedirect("InvalidLogin.jsp");
            }
        %>
    </body>
</html>

package login_handling;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author standard
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    private Connection connection;
    private PreparedStatement statement;

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is the login validation servlet called"
                + " via POST from the main page. It redirects to"
                + "registration or to a user page and creates a"
                + "user session token.";
    }

    public Login() throws IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cantus",
                    "root", "");
            statement = connection.prepareStatement("SELECT user_id, username, email, librarynumber "
                    + "FROM users WHERE username = ? AND password = ?");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        try {
            user = isValid(request.getParameter("username"), request.getParameter("password"));
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user == null) {
            response.sendRedirect("Regester.html");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("currentSessionUser", user);
            response.sendRedirect("LandingPage.jsp");
        }
    }
    /**
     * Provides login validation for login against DB records
     *
     * @param request servlet request
     * @param response servlet response
     * @throws SQLException if there is trouble with the DB.
     */
    private User isValid(String username, String password) throws SQLException {
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet results = statement.executeQuery();

        if (results.next()) {
            User user = new User();
            user.setID(results.getInt("user_id"));
            user.setUN(results.getString("username"));
            user.setEmail(results.getString("email"));
            user.setLibraryID(results.getString("librarynumber"));
            results.close();
            statement.close();
            connection.close();
            return user;
        } else {
            results.close();
            statement.close();
            connection.close();
            return null;
        }
    }
}

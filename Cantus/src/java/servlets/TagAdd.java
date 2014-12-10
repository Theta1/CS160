/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library_handling.MusicLibraryDatabase;
import library_handling.Song;
import tagging.SongGroup;

/**
 *
 * @author Busairo
 */
@WebServlet(name = "TagAdd", urlPatterns = {"/TagAdd"})
public class TagAdd extends HttpServlet {

    final String LANDING_PAGE = "LandingPage.jsp";
    boolean artistCheck;
    boolean albumCheck;
    boolean groupCheck;
    boolean performanceCheck;
    boolean successfullyAdded;
    MusicLibraryDatabase mld = new MusicLibraryDatabase();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String title = request.getParameter("name_of_song");
            String artist = request.getParameter("artist");
            String album = request.getParameter("album"); //not added
            String genre = request.getParameter("genre");
            String group = request.getParameter("group");
            String performance = request.getParameter("performance"); //not added

            Song s = MusicLibraryDatabase.addSong(title, genre);
            SongGroup sg;

            //If the user gives no group, then set group to just be artist
            //Need to know if backend handles duplicates properly
            if (group.length() == 0) {
                sg = SongGroup.createGroup(artist);
            } else {
                sg = SongGroup.createGroup(group);
            }

            sg.addArtist(artist);
            s.setGroup(sg);
            //redirect seems to not be working...
            response.sendRedirect("LandingPage.jsp");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

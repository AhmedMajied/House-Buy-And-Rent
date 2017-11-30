/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    /**
     * 
     */
    public void signIn() {
        // TODO implement here
    }

    /**
     * 
     */
    public void signUp() {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean addPicture() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean addPhoneNumber() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean updatePicture() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean updatePassword() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean updatePhoneNumber() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean deletePicture() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean deletePhoneNumber() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean requestUserContact() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean addInterest() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Vector<Notification> getUserNotifications() {
        // TODO implement here
        return null;
    }


}

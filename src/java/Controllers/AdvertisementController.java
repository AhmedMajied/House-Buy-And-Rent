/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBModels.AdvertisementDBModel;
import Models.Advertisement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(name = "AdvertisementController", urlPatterns = {"/AdvertisementController"})
public class AdvertisementController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            switch(action){
                case "createAdvertisementPage":
                    createAdvertisementPage(request,response);
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvertisementController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    
    
    
    public Vector<Advertisement> getAllAdvertisements() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean createAdvertisement() {
        // TODO implement here
        return false;
    }

    /**
     * @param ID 
     * @return
     */
    public boolean updateAdvertisement(int ID) {
        // TODO implement here
        return false;
    }

    /**
     * @param ID 
     * @return
     */
    public boolean deleteAdvertisement(int ID) {
        // TODO implement here
        return false;
    }

    private void createAdvertisementPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ServletException, IOException {
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        request.setAttribute("Statuses", advDB.retrieveAllStatuses());
        request.setAttribute("Types", advDB.retrieveAllTypes());
        request.getRequestDispatcher("createAdvertisement.jsp").forward(request, response);
    }
}

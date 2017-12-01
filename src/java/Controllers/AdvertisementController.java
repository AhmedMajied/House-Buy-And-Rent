package Controllers;

import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdvertisementController", urlPatterns = {"/AdvertisementController"})
public class AdvertisementController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("Action");
        switch(action){
            case "getAllAds":
                getAllAds(response);
            case "createNewAd":
                createNewAd(request,response);
            case "changeAdProperties":
                changeAdProperties(request,response);
            case "closeAd":
                closeAd(request,response);
            case "openAd":
                openAd(request, response);
            case "getCurrentUserAds":
                getCurrentUserAds(request, response);
            case "getAnotherUserAds":
                getAnotherUserAds(request, response);
            case "rateAd":
                rateAd(request, response);
            case "commentOnAd":
                commentOnAd(request, response);
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

     public void getAllAds(HttpServletResponse response) {
        // TODO implement here
        
    }

    public void createNewAd(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void changeAdProperties(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void closeAd(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
       
    }

    public void openAd(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void getCurrentUserAds(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void getAnotherUserAds(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void rateAd(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
        
    }

    public void commentOnAd(HttpServletRequest request, HttpServletResponse response) {
        // TODO implement here
      
    }


}

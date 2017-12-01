/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBModels.UserDBModel;
import Models.Interest;
import Models.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MariamAshraf
 */
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
           String action=request.getParameter("ACTION");
           if(action.equals("authenticateUser"))
           {
               String userName=request.getParameter("name");
               String password=request.getParameter("password");
               authenticateUser(request,response,userName,password);
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
    
    
    

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response,String name,String password) throws IOException {
           UserDBModel userDBModel = new UserDBModel();
           boolean result= userDBModel.authenticateUser(name, password);
           PrintWriter out = response.getWriter();
           out.print(result);
    }
    public void signIn()
    {
        
    }
    public void signUp() {
        // TODO implement here
    }

    public boolean addPicture() {
        // TODO implement here
        return false;
    }

    public boolean addPhoneNumber() {
        // TODO implement here
        return false;
    }

    public boolean updatePicture() {
        // TODO implement here
        return false;
    }

    public boolean updatePassword() {
        // TODO implement here
        return false;
    }

    public boolean updatePhoneNumber() {
        // TODO implement here
        return false;
    }

    public boolean deletePicture() {
        // TODO implement here
        return false;
    }

    public boolean deletePhoneNumber() {
        // TODO implement here
        return false;
    }

    public boolean requestUserContact() {
        // TODO implement here
        return false;
    }

  /*  public boolean addInterest(int size,int statusID,int typeID,int userID) {
        Interest interest = new Interest(size,statusID,typeID,userID);
        boolean success = userDBModel.addInterest(interest);
        
        return success;
    }

    public Vector<Notification> getUserNotifications(int userID) {
        return userDBModel.getUserNotifications(userID);
    }*/

}

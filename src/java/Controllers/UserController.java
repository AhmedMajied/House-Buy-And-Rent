/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBModels.UserDBModel;
import Models.Interest;
import Models.Notification;
import Models.User;
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
 * @author MariamAshraf
 */
@WebServlet(urlPatterns = {"/UserController"})
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
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
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
           else if(action.equals("validateUserName"))
           {
               String userName=request.getParameter("name"); 
               validateUserName(request, response, userName);
           }
           else if(action.equals("addNewUser"))
           {
               String Username=request.getParameter("Username");
               String password=request.getParameter("password");
               String phone=request.getParameter("phone");
               User user=new User();
               user.setUsername(Username);
               user.setPhone(phone);
               user.setPassword(password);
               signUp(request, response, user);
           }
           else if(action.equals("DisplayHome"))
           {
               DisplayHome(response);
           }
           else if(action.equals("addPhone"))
           {
               String name=request.getParameter("name");
               String phone=request.getParameter("phone");
               addPhoneNumber(response,name,phone);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response,String name,String password) throws IOException 
    {
        UserDBModel userDBModel = new UserDBModel();
        boolean result= userDBModel.authenticateUser(name, password);
        PrintWriter out = response.getWriter();
        out.print(result);
    }
    public void DisplayHome(HttpServletResponse response) throws IOException
    {
        response.sendRedirect("jsp/Home.jsp");
    }
    public void validateUserName(HttpServletRequest request, HttpServletResponse response,String name) throws IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
    {
        UserDBModel userDBModel = new UserDBModel();
        PrintWriter out = response.getWriter();
       boolean result= userDBModel.validateUserName(name);
       out.print(result);
    }
    public void signUp(HttpServletRequest request, HttpServletResponse response,User user) throws IOException, InstantiationException
    {
        try {
            UserDBModel userDBModel = new UserDBModel();
            boolean result=userDBModel.addNewUser(user);
            
            response.sendRedirect("jsp/Home.jsp");
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addPhoneNumber(HttpServletResponse response,String name,String phone) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException
    {
        UserDBModel userDBModel=new UserDBModel();
        userDBModel.savePhoneNumber(name, phone);
        response.sendRedirect("jsp/profile.jsp");

    }
    public boolean addPicture() {
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

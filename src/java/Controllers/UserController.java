package Controllers;

import DBModels.UserDBModel;
import Models.*;
import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
       
        String action = request.getParameter("action");
        
        switch(action){
            case "adInterest":
                addInterest(request, response);
            case "login":
                getBuildingStatuses(request, response);
                getBuildingTypes(request, response);
                request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);

            case "authenticateUser":
                   authenticateUser(request,response);
                   break;
            case "validateUserName":
                 validateUserName(request, response);
                 break;
            case "addNewUser":
                 signUp(request, response);
                 break;
            case "DisplayHome":
                 DisplayHome(request,response);
                 break;
            case "addPhone":
                addPhoneNumber(request,response);
                break;
             case "deletePhone":
                deletePhoneNumber(request,response);
                break;
             case "changePassword":
                 changePassword(request,response);
                 break;
             case "addPhoto":
                 addPicture(request,response);
                 break;
             case "deletePhoto":
                 deletePicture(request,response);
                 break;

        
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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

    private void addInterest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int size,statusID,typeID,userID;
        UserDBModel userDBModel = new UserDBModel();
        
        size = Integer.parseInt(request.getParameter("size"));
        statusID = Integer.parseInt(request.getParameter("status"));
        typeID = Integer.parseInt(request.getParameter("type"));
        //userID = ((User)request.getSession().getAttribute("User")).getID();
        
        //boolean success = userDBModel.addInterest(size,statusID,typeID,userID);
        //response.getWriter().print(size+" "+statusID+" "+typeID);
        
        //TODO handle if false
        response.sendRedirect("jsp/Home.jsp");
    }
    
    private void getBuildingStatuses(HttpServletRequest request, HttpServletResponse response){
        UserDBModel userDBModel = new UserDBModel();
        Vector<BuildingStatus> statuses = userDBModel.fetchBuildingStatuses();
        request.setAttribute("Statuses", statuses);
    }
    
    private void getBuildingTypes(HttpServletRequest request, HttpServletResponse response){
        UserDBModel userDBModel = new UserDBModel();
        Vector<BuildingType> types = userDBModel.fetchBuildingTypes();
        request.setAttribute("Types", types);
    }

      public void authenticateUser(HttpServletRequest request, HttpServletResponse response)throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException 
      {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        UserDBModel userDBModel = new UserDBModel();
        boolean result= userDBModel.authenticateUser(name, password);
        PrintWriter out = response.getWriter();
        if(result)
        {
            ServletContext servletContext = request.getServletContext();
            if(servletContext.getAttribute("User")==null)
            {
                User user=new User();
                user=getUser(name);
                HttpSession currentSession=request.getSession(true);
                currentSession.setAttribute("User", user);
                currentSession.setMaxInactiveInterval(3*60);
                servletContext.setAttribute("Session", currentSession);
            }
        }
        out.print(result);
    }
    public void DisplayHome(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        response.sendRedirect("jsp/Home.jsp");
    }
    public void validateUserName(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
    {
        String name=request.getParameter("name"); 
        UserDBModel userDBModel = new UserDBModel();
        PrintWriter out = response.getWriter();
        boolean result= userDBModel.validateUserName(name);
       out.print(result);
    }
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException
    {
        String Username=request.getParameter("name");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        User user=new User();
        user.setUsername(Username);
        user.setPhone(phone);
        user.setPassword(password);
        try {
            UserDBModel userDBModel = new UserDBModel();
            
            boolean result=userDBModel.addNewUser(user);
            
             String userName=request.getParameter("name");
            ServletContext servletContext = request.getServletContext();
            if(servletContext.getAttribute("User")==null)
            {
                //user=getUser(userName);
                HttpSession currentSession=request.getSession(true);
                currentSession.setAttribute("User", user);
                currentSession.setMaxInactiveInterval(3*60);
                servletContext.setAttribute("Session", currentSession);
            }
            response.sendRedirect("jsp/Home.jsp");
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addPhoneNumber(HttpServletRequest request,HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException
    {
        String name=request.getParameter("userName");
        String phone=request.getParameter("phoneNumber");
        UserDBModel userDBModel=new UserDBModel();
        userDBModel.savePhoneNumber(name, phone);
        response.sendRedirect("jsp/profile.jsp");
    }
    public void deletePhoneNumber(HttpServletRequest request,HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException
    {
        String name=request.getParameter("userName");
        UserDBModel userDBModel=new UserDBModel();
        userDBModel.deletePhoneNumber(name);
        response.sendRedirect("jsp/profile.jsp");
    }
    public void changePassword(HttpServletRequest request,HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException
    {
        String newPassword=request.getParameter("newPassword");
        String name=request.getParameter("userName");
        UserDBModel userDBModel=new UserDBModel();
        userDBModel.updatePassword(name, newPassword);
        response.sendRedirect("jsp/profile.jsp");
    }
    public void addPicture(HttpServletRequest request,HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException
    {
        String name=request.getParameter("userName");
        System.out.println("name "+name);
        Part filePart=request.getPart("photo");
        System.out.println(filePart.toString());
        UserDBModel userDBModel=new UserDBModel();
        InputStream inputStream=null;
        inputStream=filePart.getInputStream();
        if(inputStream!=null){
            boolean res=userDBModel.savePicture(name, inputStream);
        }
    }
    public void deletePicture(HttpServletRequest request,HttpServletResponse response)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        UserDBModel userDBModel=new UserDBModel();
        String name=request.getParameter("userName");
        userDBModel.deletePicture(name);
    }
     public User getUser(String userName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        UserDBModel userDBModel=new UserDBModel();
                
        return userDBModel.getUser(userName);
        
    }


    
}

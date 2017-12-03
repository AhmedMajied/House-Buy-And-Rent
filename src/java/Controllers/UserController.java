package Controllers;

import DBModels.UserDBModel;
import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch(action){
            case "adInterest":
                addInterest(request, response);
            case "login":
                getBuildingStatuses(request, response);
                getBuildingTypes(request, response);
                request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
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
    
}

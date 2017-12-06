package Controllers;

import DBModels.AdvertisementDBModel;
import Models.Advertisement;
import Models.BuildingStatus;
import Models.BuildingType;
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

@WebServlet(name = "AdvertisementController", urlPatterns = {"/AdvertisementController"})
public class AdvertisementController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            System.out.print(action);
            
            switch(action){
                case "createAdvertisementPage":
                    createAdvertisementPage(request,response);
                    break;
                case "addAdvertisement":
                    createAdvertisement(request,response);
                    break;
                case "Advertisement":
                    displayAdvertisement(request,response);
                    break;
                case "AllAds":
                    getAllAdvertisements(request,response);
                case "rateAd":
                    rateAd(request,response);
                    break;
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
    
    public void getAllAdvertisements(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdvertisementDBModel adDBModel = new AdvertisementDBModel();
        Vector<Advertisement> AllAds = adDBModel.retrieveAllAds();
        request.setAttribute("AllAds", AllAds);
        request.getRequestDispatcher("jsp/AllAds.jsp").forward(request, response);
    }

    /**
     * @return
     */
    public void createAdvertisement(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Advertisement adv = new Advertisement();
        adv.setTitle(request.getParameter("Title"));
        adv.setBuildingSize(Integer.parseInt(request.getParameter("Size")));
        adv.setBuildingFloor(Integer.parseInt(request.getParameter("Floor")));
        adv.setStatus(new BuildingStatus(Integer.parseInt(request.getParameter("Status")),""));
        adv.setType(new BuildingType(Integer.parseInt(request.getParameter("Type")),""));
        adv.setAdType(request.getParameter("AdType"));
        adv.setDescription(request.getParameter("Description"));
        adv.setLatitude(Double.parseDouble(request.getParameter("Latitude")));
        adv.setLongitude(Double.parseDouble(request.getParameter("Longitude")));
        adv.setAdvertisorID(((User)request.getSession(false).getAttribute("User")).getID());
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        advDB.saveNewAd(adv);
        
        //TO BE IMPLEMENTED
        // GO TO HOME PAGE
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
        request.getRequestDispatcher("jsp/createAdvertisement.jsp").forward(request, response);
    }

    private void displayAdvertisement(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        Advertisement adv = advDB.retrieveAd(id);
        request.setAttribute("Advertisement", adv);
        request.getRequestDispatcher("jsp/advertisement.jsp").forward(request, response);
    }
    
    public void rateAd(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        AdvertisementDBModel AdDBModel = new AdvertisementDBModel();
        
        String rateStatus = (String) request.getParameter("rateStatus");
        int AdID = Integer.parseInt(request.getParameter("AdID"));
        double value = Double.parseDouble(request.getParameter("value"));
        //int userID = ((User)request.getSession().getAttribute("User")).getID();
        
        if(rateStatus.equals("new")){
          //  AdDBModel.saveNewRating(userID, AdID, value);
        }
        else{
            //AdDBModel.updateExistingRating(userID, AdID, value);
        }
        
        //response.getWriter().print(AdID+" "+value+" "+rateStatus);
    }
    
}

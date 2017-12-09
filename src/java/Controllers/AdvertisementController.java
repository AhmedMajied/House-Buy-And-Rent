package Controllers;

import DBModels.AdvertisementDBModel;
import Models.Advertisement;
import Models.BuildingStatus;
import Models.BuildingType;
import Models.User;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
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

        response.setContentType("text/html;charset=UTF-8");

    
            /* TODO output your page here. You may use following sample code. */
        String action = request.getParameter("action");
        switch(action){
            case "createAdvertisementPage":
                createAdvertisementPage(request,response);
                break;
            case "updateAdvertisementPage":
                updateAdvertisementPage(request,response);
                break;
            case "addAdvertisement":
                createAdvertisement(request,response);
                break;
            case "updateAdvertisement":
                updateAdvertisement(request,response);
                break;
            case "deleteAdvertisement":
                deleteAdvertisement(request,response);
                break;
            case "Advertisement":
                displayAdvertisement(request,response);
                break;
            case "AllAds":
                getAllAdvertisements(request,response);
            case "rateAd":
                rateAd(request,response);
                break;
            case "addPhoto":
                addPhoto(request, response);
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
  
    
    
    
    
    public void getAllAdvertisements(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException, ServletException {
        AdvertisementDBModel adDBModel = new AdvertisementDBModel();
        Vector<Advertisement> AllAds = adDBModel.retrieveAllAds();
        request.setAttribute("AllAds", AllAds);
        request.getRequestDispatcher("jsp/AllAds.jsp").forward(request, response);

    }
    
    public void createAdvertisement(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Advertisement adv = new Advertisement();
        adv.setTitle(request.getParameter("Title"));
        adv.setBuildingSize(Integer.parseInt(request.getParameter("Size")));
        adv.setBuildingFloor(Integer.parseInt(request.getParameter("Floor")));
        adv.setStatus(new BuildingStatus(Integer.parseInt(request.getParameter("Status")), ""));
        adv.setType(new BuildingType(Integer.parseInt(request.getParameter("Type")), ""));
        adv.setAdType(request.getParameter("AdType"));
        adv.setDescription(request.getParameter("Description"));
        adv.setLatitude(Double.parseDouble(request.getParameter("Latitude")));
        adv.setLongitude(Double.parseDouble(request.getParameter("Longitude")));
        adv.setAdvertiserName(((User) request.getSession(false).getAttribute("User")).getUsername());
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        advDB.saveNewAd(adv);

        //TO BE IMPLEMENTED
        // GO TO HOME PAGE
    }

    /**
     * @param ID
     * @param response the value of response
     */
    public void updateAdvertisement(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Advertisement adv = new Advertisement();
        adv.setID(Integer.parseInt(request.getParameter("ID")));
        adv.setTitle(request.getParameter("Title"));
        adv.setBuildingSize(Integer.parseInt(request.getParameter("Size")));
        adv.setBuildingFloor(Integer.parseInt(request.getParameter("Floor")));
        adv.setStatus(new BuildingStatus(Integer.parseInt(request.getParameter("Status")), ""));
        adv.setType(new BuildingType(Integer.parseInt(request.getParameter("Type")), ""));
        adv.setAdType(request.getParameter("AdType"));
        adv.setDescription(request.getParameter("Description"));
        adv.setLatitude(Double.parseDouble(request.getParameter("Latitude")));
        adv.setLongitude(Double.parseDouble(request.getParameter("Longitude")));
        adv.setAdvertiserName(((User) request.getSession(false).getAttribute("User")).getUsername());
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        advDB.updateAd(adv);
        
    }

    /**
     * @param request
     * @param response the value of response
     */
    public void deleteAdvertisement(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException, IOException {
        int adID = Integer.parseInt(request.getParameter("adID"));
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        advDB.deleteAd(adID);
        request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);

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
    
    public void rateAd(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException{
        
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
    
    private void addPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException {
        response.setContentType("text/html");
        int adID = Integer.parseInt(request.getParameter("adID"));
        PrintWriter out = response.getWriter();
        String saveFile = "";
        String contentType = request.getContentType();
        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();
            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;
            while (totalBytesRead < formDataLength) {
                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                totalBytesRead += byteRead;
            }
            String file = new String(dataBytes);
            saveFile = file.substring(file.indexOf("filename=\"") + 10);
            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1, contentType.length());
            int pos;
            pos = file.indexOf("filename=\"");
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            int boundaryLocation = file.indexOf(boundary, pos) - 4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            File ff = new File(saveFile);
            FileOutputStream fileOut = new FileOutputStream(ff);
            fileOut.write(dataBytes, startPos, (endPos - startPos));
            fileOut.flush();
            fileOut.close();
            out.println("You have successfully upload the file by the name of: " + saveFile);
            File f = new File(saveFile);
            AdvertisementDBModel db = new AdvertisementDBModel();
            db.addPhoto(f, adID);
            response.sendRedirect("AdvertisementController?action=Advertisement&id="+adID);
            
        }
        /*AdvertisementDBModel advDB = new AdvertisementDBModel();
        Advertisement adv = advDB.retrieveAd(adID);
        request.setAttribute("Advertisement", adv);
        request.getRequestDispatcher("jsp/advertisement.jsp").forward(request, response);*/
    }

    private void updateAdvertisementPage(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException, IOException {
        AdvertisementDBModel advDB = new AdvertisementDBModel();
        request.setAttribute("Statuses", advDB.retrieveAllStatuses());
        request.setAttribute("Types", advDB.retrieveAllTypes());
        request.getRequestDispatcher("jsp/updateAdvertisement.jsp").forward(request, response);//To change body of generated methods, choose Tools | Templates.
    }

}

package Controllers;

import DBModels.*;
import Models.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletContext;
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
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {

        String action = request.getParameter("action");

        switch (action) {
            case "adInterest":
                addInterest(request, response);
                break;
            case "authenticateUser":
                authenticateUser(request, response);
                break;
            case "validateUserName":
                validateUserName(request, response);
                break;
            case "addNewUser":
                signUp(request, response);
                break;
            case "logIn":
                getBuildingStatuses(request, response);
                getBuildingTypes(request, response);
                logIn(request, response);
                break;
            case "addPhone":
                addPhoneNumber(request, response);
                break;
            case "deletePhone":
                deletePhoneNumber(request, response);
                break;
            case "changePassword":
                changePassword(request, response);
                break;
            case "addPhoto":
                addPicture(request, response);
                break;
            case "deletePhoto":
                deletePicture(request, response);
                break;
            case "markNotificationsAsRead":
                markNotificationsAsRead(request);
                break;
           case "requestContact":
                requestUserContactInformation(request,response);
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

    
    private void addInterest(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ServletException, IOException {
        int size, statusID, typeID;
        String UserName;
        UserDBModel userDBModel = new UserDBModel();

        size = Integer.parseInt(request.getParameter("size"));
        statusID = Integer.parseInt(request.getParameter("status"));
        typeID = Integer.parseInt(request.getParameter("type"));
        UserName = ((User)request.getSession().getAttribute("User")).getUsername();

        boolean success = userDBModel.addInterest(size,statusID,typeID,UserName);
        //response.getWriter().print(size+" "+statusID+" "+typeID);
        //TODO handle if false
        response.sendRedirect("jsp/Home.jsp");
    }
    
    private void getBuildingStatuses(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        AdvertisementDBModel adDBModel = new AdvertisementDBModel();
        Vector<BuildingStatus> statuses = adDBModel.retrieveAllStatuses();
        request.setAttribute("Statuses", statuses);
    }

    private void getBuildingTypes(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        AdvertisementDBModel adDBModel = new AdvertisementDBModel();
        Vector<BuildingType> types = adDBModel.retrieveAllTypes();
        request.setAttribute("Types", types);
    }

    public void authenticateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDBModel userDBModel = new UserDBModel();
        boolean result = userDBModel.authenticateUser(name, password);
        PrintWriter out = response.getWriter();
        out.print(result);
        
    }

    public void DisplayHome(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, ServletException {
        getBuildingStatuses(request, response);
        getBuildingTypes(request, response);
        request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
    }

    public void validateUserName(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        String name = request.getParameter("name");
        UserDBModel userDBModel = new UserDBModel();
        PrintWriter out = response.getWriter();
        boolean result = userDBModel.validateUserName(name);
        out.print(result);
    }
    public void logIn(HttpServletRequest request,HttpServletResponse response) throws SQLException, SQLException, InstantiationException, InstantiationException, IllegalAccessException, InstantiationException, InstantiationException, InstantiationException, InstantiationException, ClassNotFoundException, IOException, ServletException
    {

        String name=request.getParameter("name");
        HttpSession currentSession=request.getSession(true);
        User user=new User();
        user = getUser(name);
        currentSession.setAttribute("User", user);
        currentSession.setMaxInactiveInterval(3 * 60);
        
        // get All Ads
        AdvertisementDBModel AdDBModel = new AdvertisementDBModel();
        Vector<Advertisement> allAds = AdDBModel.retrieveAllAds();
        request.setAttribute("AllAds", allAds);
        
        DisplayHome(request, response);
    }
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException {
        String Username = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        User user = new User();
        user.setUsername(Username);
        user.setPhone(phone);
        user.setPassword(password);
        try {
            UserDBModel userDBModel = new UserDBModel();

            boolean result = userDBModel.addNewUser(user);
            
            HttpSession currentSession = request.getSession(true);
            if (currentSession.getAttribute("User") == null) {
                user = getUser(Username);
                currentSession.setAttribute("User", user);
                currentSession.setMaxInactiveInterval(3 * 60);
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

    public void addPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException {
        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        String phone = request.getParameter("phoneNumber");
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.savePhoneNumber(name, phone);
        response.sendRedirect("jsp/profile.jsp");
    }

    public void deletePhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException {
        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.deletePhoneNumber(name);
        response.sendRedirect("jsp/profile.jsp");
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException {
        String newPassword = request.getParameter("newPassword");
        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.updatePassword(name, newPassword);
        response.sendRedirect("jsp/profile.jsp");
    }

    public void addPicture(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException {

        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String saveFile = "";
        String contentType = request.getContentType();
        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
        {
            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();
            byte dataBytes[] = new byte[formDataLength];
            in.read(dataBytes, 0, formDataLength);
               
            String file = new String(dataBytes);
            saveFile = file.substring(file.indexOf("filename=\"") + 10);
            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1, contentType.length());
            int pos;
            pos = file.indexOf("filename=\"");
            pos = file.indexOf("\n", pos) + 1;
            int boundaryLocation = file.indexOf(boundary, pos)-4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            File ff = new File(saveFile);
            FileOutputStream fileOut = new FileOutputStream(ff);
            fileOut.write(dataBytes, startPos, (endPos - startPos));
            fileOut.flush();
            fileOut.close();
            File f = new File(saveFile);
            System.out.println("\n\n"+f.getName()+"  "+f.getAbsolutePath()+" lll "+f.length());
            UserDBModel dbModel=new UserDBModel();
            dbModel.savePicture(f,name); 
            response.sendRedirect("jsp/profile.jsp");
        }
    }

    public void deletePicture(HttpServletRequest request, HttpServletResponse response) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        UserDBModel userDBModel = new UserDBModel();
        String name = getNameFromSession(request);
        userDBModel.deletePicture(name);
        response.sendRedirect("jsp/profile.jsp");
    }
    public String getNameFromSession(HttpServletRequest request)
    {
        HttpSession currentSession=request.getSession(true);
        String name=null;
        if(currentSession.getAttribute("User")!=null)
        {
            name=((User)currentSession.getAttribute("User")).getUsername();
        }
        
        return name;
    }

    public User getUser(String userName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        UserDBModel userDBModel = new UserDBModel();

        return userDBModel.getUser(userName);

    }
    
    private void markNotificationsAsRead(HttpServletRequest request)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        String UserName = ((User)request.getSession().getAttribute("User")).getUsername();
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.markNotificationsAsRead(UserName);
    }

    public void requestUserContactInformation(HttpServletRequest request,HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException
    {
        int advertiserID=Integer.parseInt(request.getParameter("advertiserID"));
        Notification notification=new Notification();
        PrintWriter out= response.getWriter();
        notification.setID(advertiserID);
        notification.setLink("#");
        notification.setText("there are user requested your phone number");
        Calendar cal = Calendar.getInstance();
        Date currentTime = (Date) cal.getTime();
        notification.setTime(currentTime);
        UserDBModel dbModel=new UserDBModel();
        dbModel.addNotificationToUser(notification);
        out.print(dbModel.getPhone(advertiserID));
    }

}

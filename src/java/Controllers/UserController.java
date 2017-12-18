package Controllers;

import DBModels.*;
import Models.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
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

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {

        String action = request.getParameter("action");

        switch (action) {
            case "addInterest":
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
            case "requestContact":
                requestUserContactInformation(request,response);
                break;
            case "displayHome":
               DisplayHome(request, response);
               break;
            case "logOut":
               LogOut(request,response);
               break;
            case "markNotificationsAsRead":
                markNotificationsAsRead(request);
                break;

            case "changeUserPassword":
                changeUserPassword(request,response);
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
        String username;
        UserDBModel userDBModel = new UserDBModel();

        size = Integer.parseInt(request.getParameter("size"));
        statusID = Integer.parseInt(request.getParameter("status"));
        typeID = Integer.parseInt(request.getParameter("type"));
        username = ((User)request.getSession().getAttribute("User")).getUsername();

        boolean success = userDBModel.addInterest(size,1,1,username);
        
        response.getWriter().print(success);
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
        
        // prepare needed data
        getBuildingStatuses(request, response);
        getBuildingTypes(request, response);
        AdvertisementDBModel AdDBModel = new AdvertisementDBModel();
        Vector<Advertisement> allAds = AdDBModel.retrieveAllAds();
        request.setAttribute("AllAds", allAds);
        String name=getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        else{
        request.getRequestDispatcher("jsp/Home.jsp").forward(request, response);
        }
        
        
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
        Vector<Notification> notifications = getUserNotifications(name);
        user.setNotifications(notifications);
        currentSession.setAttribute("User", user);
        currentSession.setMaxInactiveInterval(30*60);
        
        DisplayHome(request, response);
    }
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, ServletException {
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
                user.setNotifications(new Vector<Notification>());
                currentSession.setAttribute("User", user);
                currentSession.setMaxInactiveInterval(30*60);
            }
            DisplayHome(request,response);

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
        updateSession(request);
        if(name!=null){
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    public void deletePhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException {
        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.deletePhoneNumber(name);
        updateSession(request);
        if(name!=null){
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException, ServletException {
        String newPassword = request.getParameter("newPassword");
        String name = getNameFromSession(request);
        if(name==null){
            response.sendRedirect("index.jsp");
            return;
        }
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.updatePassword(name, newPassword);
        updateSession(request);
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
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
            pos = file.indexOf("\n", pos) + 1;
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
            updateSession(request);
           if(name!=null){
            request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
            }
            else{
            response.sendRedirect("/");
            }
        }
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

    public void requestUserContactInformation(HttpServletRequest request,HttpServletResponse response) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException
    {
        String advertiserName=request.getParameter("advertiserName");
        Notification notification=new Notification();
        PrintWriter out= response.getWriter();
        notification.setUsername(advertiserName);
        notification.setLink("#");
        notification.setText("there is user requested your phone number");
        Timestamp time = new Timestamp(new Date().getTime());
        notification.setTime(time);
        UserDBModel dbModel=new UserDBModel();
        dbModel.addNotificationToUser(notification);
        out.print(dbModel.getPhone(advertiserName));
    }
    public void LogOut(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        HttpSession currentSession=request.getSession(true);
        String name=null;
        if(currentSession!=null)
        {
            currentSession.invalidate();
        }
        response.sendRedirect("index.jsp");
        
    }
    
    private Vector<Notification> getUserNotifications(String username)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        UserDBModel userDBModel = new UserDBModel();
        return userDBModel.getUserNotifications(username);
    }
    
    private void markNotificationsAsRead(HttpServletRequest request)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
        String UserName = ((User)request.getSession().getAttribute("User")).getUsername();
        int notificationID = Integer.parseInt(request.getParameter("notificationID"));
        UserDBModel userDBModel = new UserDBModel();
        userDBModel.markNotificationsAsRead(UserName,notificationID);
    }
    private void updateSession(HttpServletRequest request) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        String name=getNameFromSession(request);
        HttpSession currentSession=request.getSession(true);
        if(!(currentSession.equals(null)))
        {
            currentSession.removeAttribute("User");
            User user=new User();
            user=getUser(name);
            currentSession.setAttribute("User", user);
            return;
        }
        
    }


    private void changeUserPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException, ServletException {
        String name=request.getParameter("userName");
        String password=request.getParameter("newPassword");
        System.out.println(name+"   "+password);
        String adminName=getNameFromSession(request);
        if(adminName==null)
        {
            response.sendRedirect("index.jsp");
            return;
        }
        UserDBModel userDBModel=new UserDBModel();
        userDBModel.updatePassword(name, password);
        User user=getUser(adminName);
        DisplayHome(request,response);
       // response.sendRedirect("/UserController?action=displayHome");

    }

}

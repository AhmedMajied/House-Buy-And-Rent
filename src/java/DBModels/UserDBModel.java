package DBModels;

import java.util.*;
import Models.*;
import config.DBConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDBModel {

    
    public UserDBModel() {
    }

    /*public static void main(String [] args){
        
        try{
            //Notification n = new Notification("t1","l1","user2");
            //addNotificationToUser(n);
            
            Vector<Notification> ns = getUserNotifications("user2");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println(dateFormat.format(ns.get(0).getTime()));
        }catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }*/


    public boolean authenticateUser(String name,String password)
    {
        boolean valid=false;
        try {
            Statement stmt;
            try (Connection conn = DBConfig.getConnection()) {
                stmt = conn.createStatement();
                ResultSet result=stmt.executeQuery("SELECT * FROM users WHERE Username = '"+name+"'"+" AND Password = '"+password+"'"+";");
                if(result.next())
                {
                    valid=true;
                }
                conn.close();
            }
            stmt.close();  
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;

    }
    public boolean validateUserName(String name) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
    {
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet result=stmt.executeQuery("SELECT * FROM users where Username = '"+name+"'"+";");
        
        if(result.next())
        {
            stmt.close();
            conn.close();
            return false;
        }
        stmt.close();
        conn.close();
        return true;
        
    }
    public boolean addNewUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        int numrows=stmt.executeUpdate("INSERT INTO users (Username,Password,Phone) values( '"+user.getUsername()+"' , '"+user.getPassword()+"' , '"+user.getPhone()+"' );");
        conn.close();
        return numrows>0;
    }
    public boolean savePhoneNumber(String name, String phoneNumber) throws InstantiationException, SQLException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, ClassNotFoundException {
        
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate("UPDATE users SET Phone = '"+phoneNumber+"' WHERE Username = '"+name+"'"+";");
        conn.close();
        stmt.close();
        return result>0;
    }
    public boolean deletePhoneNumber(String name)throws InstantiationException, SQLException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, ClassNotFoundException {
       Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet result=stmt.executeQuery("SELECT * FROM users where Username = '"+name+"'"+";");
        String phone="";
        int row=0;
        if(result.next())
        {
            phone=result.getString("Phone");
            System.out.println(phone);
        }
        if(!(phone==""))
        {
           row=stmt.executeUpdate("UPDATE users SET Phone = "+NULL+" WHERE Username = '"+name+"'"+";");
        }
        conn.close();
        stmt.close();
        return row>0;
    }
    public boolean updatePassword(String name, String password) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate("UPDATE users SET Password = '"+password+"' WHERE Username = '"+name+"'"+";");
        conn.close();
        stmt.close();
        return result>0;
    }
    public boolean savePicture(File f,String name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        Connection conn=DBConfig.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET Picture = (?) WHERE Username = '"+name+"'"+";");
        FileInputStream fis = new FileInputStream(f);
        pstmt.setBlob(1, (InputStream) fis, (int) (f.length()));
        int s = pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        return s>0;
    }

 
    public boolean deletePicture(String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException 
    {
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        int result=stmt.executeUpdate("UPDATE users SET Picture = "+NULL+" WHERE Username = '"+name+"'"+";");
        conn.close();
        stmt.close();
        return result>0;
    }
    public User getUser(String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException 
    {
        User user=new User();
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet result=stmt.executeQuery("SELECT * FROM users where Username = '"+name+"'"+";");
        if(result.next())
        {
            user.setUsername(name);
            user.setPhone(result.getString("Phone"));
            user.setPicture(result.getBlob("Picture"));
        }
        return user;

    }
    public boolean requestUserContact(int userID, int requestedContactUserID) {
        // TODO implement here
        return false;
    }

    public boolean addInterest(int size,int statusID,int typeID,String UserName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {    
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("insert into Interests values(null,?,?,?,?);");

        prepStmt.setInt(1, size);
        prepStmt.setInt(2, statusID);
        prepStmt.setInt(3, typeID);
        prepStmt.setString(4, UserName);

        int affectedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

        if(affectedRows > 0)
            return true;

        return false;
    }
    
   
    public Vector<Notification> getUserNotifications(String UserName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Vector<Notification> allNotifications = new Vector<>();
   
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("select ID,Text,Time,Link"
                                    + " from Notifications"
                                    +" where Username = ? and isRead = 0");
        prepStmt.setString(1, UserName);
        ResultSet resultSet = prepStmt.executeQuery();

        while(resultSet.next()){
            Notification notification = new Notification();
            notification.setID(resultSet.getInt("ID"));
            notification.setText(resultSet.getString("Text"));
            notification.setTime(resultSet.getTimestamp("Time"));
            notification.setLink(resultSet.getString("Link"));

            allNotifications.add(notification);
        }

        prepStmt.close();
        conn.close();

        return allNotifications;
    }

    public void addNotificationToUser(Notification notification) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{ 
       
        Connection conn = DBConfig.getConnection();

        PreparedStatement prepStmt = conn.prepareStatement("insert into Notifications values(null,?,?,?,?,default)");
        prepStmt.setString(1, notification.getText());
        prepStmt.setTimestamp(2, new java.sql.Timestamp(notification.getTime().getTime()));
        prepStmt.setString(3, notification.getLink());
        prepStmt.setString(4, notification.getUsername());
        prepStmt.executeUpdate();

        prepStmt.close();
        conn.close();
    }
    
    public String getPhone(int advertiserID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn=DBConfig.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet result=stmt.executeQuery("SELECT * FROM users WHERE ID = '"+advertiserID+"'"+";");
        stmt.close();
        conn.close();
        return result.getString("Phone");
    }
    
    public void saveAdAsInterestNotification(Advertisement Ad,String AdLink) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Vector<String> interestedUsers = retrieveAllEquivalentInterests(Ad.getBuildingSize(),Ad.getStatus().getID(),Ad.getType().getID());
        
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("insert into Notifications values(null,?,?,?,?,default)");
        prepStmt.setString(1, "A new Advertisemnet that meets your interests was recently added");
        //prepStmt.setTime(2, "");
        prepStmt.setString(3, AdLink);
        
        for(int i=0;i<interestedUsers.size();i++){
            prepStmt.setString(4, interestedUsers.get(i));
            prepStmt.executeUpdate();
        }
        
        prepStmt.close();
        conn.close();
    }
    
    private Vector<String> retrieveAllEquivalentInterests(int size,int statusID,int typeID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Vector<String> interestedUsers = new Vector<>();
        Connection conn = DBConfig.getConnection();

        PreparedStatement prepStmt = conn.prepareStatement("select Username from Users,Interests where "
                                        + "Interests.UserID = Users.ID and Size=? and Status=? and Type=?");
        prepStmt.setInt(1, size);
        prepStmt.setInt(2, statusID);
        prepStmt.setInt(3, typeID);
        ResultSet result = prepStmt.executeQuery();
        
        while(result.next()){
            interestedUsers.add(result.getString("Username"));
        }

        result.close();
        prepStmt.close();
        conn.close();
        
        return interestedUsers;
    }
    
    public void markNotificationsAsRead(String UserName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Connection conn = DBConfig.getConnection();

        PreparedStatement prepStmt = conn.prepareStatement("update Notifications set isRead=1 where Username=? and isRead=0");
        prepStmt.setString(1, UserName);
        prepStmt.executeUpdate();
        
        prepStmt.close();
        conn.close();
    }


}

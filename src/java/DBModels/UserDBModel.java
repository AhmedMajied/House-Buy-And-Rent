package DBModels;

import java.util.*;
import Models.*;
import config.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDBModel {

    public UserDBModel() {
    }

    public static void main(String [] args){
        Vector<BuildingType> types = new Vector<>();
        int ID;
        String name;
        
        try{
            Connection conn = DBConfig.getConnection();
        
            PreparedStatement prepStmt = conn.prepareStatement("select * from BuildingTypes");

            ResultSet result = prepStmt.executeQuery();
            while(result.next()){ 
                ID = result.getInt("ID");
                name = result.getString("Name");

                types.add(new BuildingType(ID, name));
            }
            System.out.println(types.get(0).getName());
            result.close();
            prepStmt.close();
            conn.close();
        }catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public User validateUser(String name, String password) {
        // TODO implement here
        return null;
    }

    public boolean addNewUser(User user) {
        // TODO implement here
        return false;
    }

    public boolean savePicture(String name, Byte picture) {
        // TODO implement here
        return false;
    }

    public boolean savePhoneNumber(String name, String phoneNumber) {
        // TODO implement here
        return false;
    }

    public boolean updateUsername(String oldName, String newName) {
        // TODO implement here
        return false;
    }

    public boolean updatePicture(String name, Byte picture) {
        // TODO implement here
        return false;
    }

    public boolean updatePassword(String name, String password) {
        // TODO implement here
        return false;
    }

    public boolean updatePhoneNumber(String name, String phoneNumber) {
        // TODO implement here
        return false;
    }

    public boolean deletePicture(String name) {
        // TODO implement here
        return false;
    }

    public boolean deletePhoneNumber(String name) {
        // TODO implement here
        return false;
    }

    public boolean requestUserContact(int userID, int requestedContactUserID) {
        // TODO implement here
        return false;
    }

    public boolean addInterest(int size,int statusID,int typeID,int userID) {
        
        try {
            Connection conn = DBConfig.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement("insert into Interests values(null,?,?,?,?);");
            
            prepStmt.setInt(1, size);
            prepStmt.setInt(2, statusID);
            prepStmt.setInt(3, typeID);
            prepStmt.setInt(4, userID);
            
            int affectedRows = prepStmt.executeUpdate();
            prepStmt.close();
            conn.close();
            
            if(affectedRows > 0)
                return true;
            
        } catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public Vector<BuildingStatus> fetchBuildingStatuses(){
        Vector<BuildingStatus> statuses = new Vector<>();
        int ID;
        String name;
        
        try{
            Connection conn = DBConfig.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement("select * from BuildingStatuses");

            ResultSet result = prepStmt.executeQuery();
            while(result.next()){ 
                ID = result.getInt("ID");
                name = result.getString("Name");

                statuses.add(new BuildingStatus(ID, name));
            }

            result.close();
            prepStmt.close();
            conn.close();
        
        } catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statuses;
    }
    
    public Vector<BuildingType> fetchBuildingTypes(){
        Vector<BuildingType> types = new Vector<>();
        int ID;
        String name;
        
        try{
            Connection conn = DBConfig.getConnection();
        
            PreparedStatement prepStmt = conn.prepareStatement("select * from BuildingTypes");

            ResultSet result = prepStmt.executeQuery();
            while(result.next()){ 
                ID = result.getInt("ID");
                name = result.getString("Name");

                types.add(new BuildingType(ID, name));
            }

            result.close();
            prepStmt.close();
            conn.close();
        }catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return types;
    }

    public Vector<Notification> getUserNotifications(int userID) {
        Vector<Notification> allNotifications = null;
        try {
            Connection conn = DBConfig.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement("select Notifications.ID,Notifications.Text,Notifications.Time,Notifications.Link"
                                        + " from Notifications,UserNotifications"
                                        +" where UserNotifications.UserID = ? and isRead = 0"
                                        + " and UserNotifications.NotificationID = Notifications.ID");
            prepStmt.setInt(1, userID);
            ResultSet resultSet = prepStmt.executeQuery();
            allNotifications = new Vector<>();
            
            while(resultSet.next()){
                Notification notification = new Notification();
                notification.setID(resultSet.getInt("ID"));
                notification.setText(resultSet.getString("Text"));
                notification.setTime(resultSet.getDate("Time"));// ensure that it is correct
                notification.setLink(resultSet.getString("Link"));
                
                allNotifications.add(notification);
            }
            
            prepStmt.close();
            conn.close();
            
        } catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allNotifications;
    }

}

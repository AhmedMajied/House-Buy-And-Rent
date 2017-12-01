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

    /*public static void main(String [] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DBConfig.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement("select * from Interests");
            
            ResultSet result = prepStmt.executeQuery();
            
            while(result.next()){
                String email = result.getString("ID");
            }
            
            System.out.println("here");
            
            result.close();
            prepStmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    */
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

    public boolean addInterest(Interest userInterest) {
        // TODO implement here
        return false;
    }

    public Vector<Notification> getUserNotifications(int userID) {
        // TODO implement here
        return null;
    }

}

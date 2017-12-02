package Controllers;

import java.util.*;
import DBModels.UserDBModel;
import Models.*;

public class UserController {

    private UserDBModel userDBModel;
    
    public UserController() {
        userDBModel = new UserDBModel();
    }

    public void signIn() {
        // TODO implement here
    }

    public void signUp() {
        // TODO implement here
    }

    public boolean addPicture() {
        // TODO implement here
        return false;
    }

    public boolean addPhoneNumber() {
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

    public boolean addInterest(int size,int statusID,int typeID,int userID) {
        //Interest interest = new Interest(size,statusID,typeID,userID);
       // boolean success = userDBModel.addInterest(interest);
        
        return false;
    }

    public Vector<Notification> getUserNotifications(int userID) {
        return userDBModel.getUserNotifications(userID);
    }
}
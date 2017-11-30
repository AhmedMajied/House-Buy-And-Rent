/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBModels;

import java.util.*;
import Models.*;
/**
 * 
 */
public class UserDBModel {

    /**
     * Default constructor
     */
    public UserDBModel() {
    }

    /**
     * @param name 
     * @param password 
     * @return
     */
    public User validateUser(String name, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @return
     */
    public boolean addNewUser(User user) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param picture 
     * @return
     */
    public boolean savePicture(String name, Byte picture) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param phoneNumber 
     * @return
     */
    public boolean savePhoneNumber(String name, String phoneNumber) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param name 
     * @return
     */
    public boolean updateUsername(String oldName, String newName) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param picture 
     * @return
     */
    public boolean updatePicture(String name, Byte picture) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param password 
     * @return
     */
    public boolean updatePassword(String name, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param phoneNumber 
     * @return
     */
    public boolean updatePhoneNumber(String name, String phoneNumber) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @return
     */
    public boolean deletePicture(String name) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @return
     */
    public boolean deletePhoneNumber(String name) {
        // TODO implement here
        return false;
    }

    /**
     * @param userID 
     * @param requestedContactUserID 
     * @return
     */
    public boolean requestUserContact(int userID, int requestedContactUserID) {
        // TODO implement here
        return false;
    }

    /**
     * @param userInterest 
     * @return
     */
    public boolean addInterest(Interest userInterest) {
        // TODO implement here
        return false;
    }

    /**
     * @param userID 
     * @return
     */
    public Vector<Notification> getUserNotifications(int userID) {
        // TODO implement here
        return null;
    }

}

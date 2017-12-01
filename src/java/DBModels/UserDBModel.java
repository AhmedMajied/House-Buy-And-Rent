
package DBModels;

import java.util.*;
import Models.*;

public class UserDBModel {

    public UserDBModel() {
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

    public boolean addInterest(Interest userInterest) {
        // TODO implement here
        return false;
    }

    public Vector<Notification> getUserNotifications(int userID) {
        // TODO implement here
        return null;
    }

}

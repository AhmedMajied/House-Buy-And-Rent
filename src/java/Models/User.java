package Models;

import java.util.ArrayList;

public class User {
    private int ID;
    private String username;
    private String password;
    private String phone;
    private boolean isAdmin;
    private byte[] picture;
    private ArrayList<Advertisement> advertisements;
    private ArrayList<UserNotification> notifications;
    private ArrayList<Interest> interests;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public ArrayList<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public ArrayList<UserNotification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<UserNotification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }
    
    
}

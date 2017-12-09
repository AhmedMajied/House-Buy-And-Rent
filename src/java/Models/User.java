package Models;

import java.sql.Blob;
import java.util.Vector;

public class User {
    private String username;
    private String password;
    private String phone;
    private boolean isAdmin;
    private Blob picture;
    private Vector<Notification> notifications;

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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Vector<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Vector<Notification> notifications) {
        this.notifications = notifications;
    }

    
}

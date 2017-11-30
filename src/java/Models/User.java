/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class User {
    public int ID;
    public String username;
    public String password;
    public String phone;
    public boolean isAdmin;
    public byte[] picture;
    public ArrayList<Advertisement> advertisements;
    public ArrayList<UserNotification> notifications;
    public ArrayList<Interest> interests;
    
}

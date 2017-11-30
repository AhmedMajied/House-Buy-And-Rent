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
public class Advertisement {
    public int ID;
    public String title;
    public String adType;
    public String description;
    public int buildingSize;
    public int buildingFloor;
    public byte[][] photos;
    public double latitude;
    public double longitude;
    public User advertisor;
    public BuildingType type;
    public BuildingStatus status;
    public ArrayList<Comment> comments;
    public ArrayList<Rating> ratings;
}

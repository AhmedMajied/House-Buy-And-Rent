package Models;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Vector;

public class Advertisement {
    private int ID;
    private String title;
    private String adType;
    private String description;
    private int buildingSize;
    private int buildingFloor;
    private Vector<Blob> photos;
    private double latitude;
    private double longitude;
    private String advertiserName;
    private BuildingType type;
    private BuildingStatus status;
    private Vector<Comment> comments;
    private Vector<Rating> ratings;
    private boolean open;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBuildingSize() {
        return buildingSize;
    }

    public void setBuildingSize(int buildingSize) {
        this.buildingSize = buildingSize;
    }

    public int getBuildingFloor() {
        return buildingFloor;
    }

    public void setBuildingFloor(int buildingFloor) {
        this.buildingFloor = buildingFloor;
    }

    public Vector<Blob> getPhotos() {
        return photos;
    }

    public void setPhotos(Vector<Blob> photos) {
        this.photos = photos;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public BuildingStatus getStatus() {
        return status;
    }

    public void setStatus(BuildingStatus status) {
        this.status = status;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    public Vector<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Vector<Rating> ratings) {
        this.ratings = ratings;
    }
    
}

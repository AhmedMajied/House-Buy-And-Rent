package Models;

public class Rating {
    private int userID;
    private int advertisementID;
    private double value;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAdvertisementID() {
        return advertisementID;
    }

    public void setAdvertisementID(int advertisementID) {
        this.advertisementID = advertisementID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}

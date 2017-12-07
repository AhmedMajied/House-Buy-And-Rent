package Models;

public class Rating {
    private int userID;
    private int advertisementID;
    private int value;

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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}

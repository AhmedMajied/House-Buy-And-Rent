package Models;

public class Comment {
    private int ID;
    private int userID;
    private int advertisementID;
    private String text;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}

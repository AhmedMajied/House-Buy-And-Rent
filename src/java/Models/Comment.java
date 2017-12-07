package Models;

public class Comment {
    private int ID;
    private String userName;
    private int advertisementID;
    private String text;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userName;
    }

    public void setUserID(String userName) {
        this.userName = userName;
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

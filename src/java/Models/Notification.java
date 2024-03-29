
package Models;

import java.util.Date;

public class Notification {
    private int ID;
    private String text;
    private Date time;
    private String link;
    private String username;
    private boolean read;
    
    public Notification(){}
    public Notification(String text,String link,String userName){
        this.text = text;
        this.link = link;
        this.username = userName;
        time = new Date();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;

    }

}

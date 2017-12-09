
package Models;

import java.util.Date;

public class Notification {

    private int ID;
    private String text;
    private Date time;
    private String link;
    private String userName;
    private boolean isRead;
    
    public Notification(){}
    public Notification(String text,String link,String userName){
        this.text = text;
        this.link = link;
        this.userName = userName;
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
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

}

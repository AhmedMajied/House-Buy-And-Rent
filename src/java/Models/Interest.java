
package Models;

public class Interest {
    private int ID;
    private int size;
    private int userID;
    private BuildingType buildingType;
    private BuildingStatus buildingStatus;
    
    public Interest(int size,int statusID,int typeID,int userID){
        this.size = size;
        buildingStatus = new BuildingStatus(statusID);
        buildingType = new BuildingType(typeID);
        this.userID = userID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public BuildingStatus getBuildingStatus() {
        return buildingStatus;
    }

    public void setBuildingStatus(BuildingStatus buildingStatus) {
        this.buildingStatus = buildingStatus;
    }
    
}

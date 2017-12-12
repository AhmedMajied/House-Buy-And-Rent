
package Models;

public class Interest {
    private int ID;
    private int size;
    private String username;
    private BuildingType buildingType;
    private BuildingStatus buildingStatus;
    
    public Interest(int size,BuildingStatus status,BuildingType type,String username){
        this.size = size;
        buildingStatus = status;
        buildingType = type;
        this.username = username;
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

    public String getUserName() {
        return username;
    }

    public void setUserID(String username) {
        this.username = username;
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

package DBModels;

import java.util.*;
import Models.*;
import config.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

public class AdvertisementDBModel {

    public AdvertisementDBModel() {
    }
    
    public Vector<BuildingStatus> retrieveAllStatuses() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM BuildingStatuses");
        Vector<BuildingStatus> ret = new Vector<>();
        while(rs.next()) {
        	ret.add(new BuildingStatus(rs.getInt("ID"),rs.getString("Name")));
        }
        rs.close();
        stmt.close();
        conn.close();
        return ret;
    }
    
    
    public Vector<BuildingType> retrieveAllTypes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM BuildingTypes");
        Vector<BuildingType> ret = new Vector<>();
        while(rs.next()) {
        	ret.add(new BuildingType(rs.getInt("ID"),rs.getString("Name")));
        }
        rs.close();
        stmt.close();
        conn.close();
        return ret;
    }
    
    public Vector<Advertisement> retrieveAllAds() {
        // TODO implement here
        return null;
    }

    public void saveNewAd(Advertisement ad) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        stmt.executeUpdate("INSERT INTO Advertisement(Title,Size,Floor,Description,Latitude,Longitude,AdvertisorID,AdType,buildingStatus,buildingType) VALUES('"
                            +ad.getTitle()+"',"+ad.getBuildingSize()+","+ad.getBuildingFloor()+",'"
                            +ad.getDescription()+"',"+ad.getLatitude()+","+ad.getLongitude()+","+ad.getAdvertisorID()+",'"
                            +ad.getAdType()+"',"+ad.getStatus()+","+ad.getType()+")"
        );
        stmt.close();
        conn.close();
    }

    public boolean updateAd(Advertisement ad) {
        // TODO implement here
        return false;
    }

    public boolean deleteAd(int adID) {
        // TODO implement here
        return false;
    }

    public Vector<Advertisement> retrieveUserAds(int adID) {
        // TODO implement here
        return null;
    }

    public boolean rateAd(int userID, int adID, double value) {
        // TODO implement here
        return false;
    }

    public boolean commentOnAd(int userID, int adID, String commentText) {
        // TODO implement here
        return false;
    }

    public Advertisement retrieveAd(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Advertisements WHERE ID = "+id);
        rs.next();
        Advertisement ret = new Advertisement();
        ret.setID(rs.getInt("ID"));
        ret.setTitle(rs.getString("Title"));
        ret.setDescription(rs.getString("Description"));
        ret.setBuildingSize(rs.getInt("buildingSize"));
        ret.setBuildingFloor(rs.getInt("buildingFloor"));
        ret.setLatitude(rs.getDouble("Latitude"));
        ret.setLongitude(rs.getDouble("Longitude"));
        ret.setAdvertisorID(rs.getInt("AdvertisorID"));
        int buildingType=rs.getInt("buildingType");
        int buildingStatus=rs.getInt("buildingStatus");
        ret.setAdType(rs.getString("AdType"));

        ResultSet rs2 = stmt.executeQuery("SELECT * FROM BuildingTypes WHERE ID = "+buildingType);
        if(rs2.next())ret.setType(new BuildingType(rs2.getInt("ID"),rs2.getString("Name")));
        ResultSet rs3 = stmt.executeQuery("SELECT * FROM BuildingStatuses WHERE ID = "+buildingStatus);
        if(rs3.next())ret.setStatus(new BuildingStatus(rs3.getInt("ID"),rs3.getString("Name")));
        
        ResultSet rs4 = stmt.executeQuery("SELECT Photo FROM BuildingPhotos WHERE AdID = "+ret.getID());
        Vector<Blob> pics= new Vector<>();
        while(rs4.next()){
            pics.add(rs4.getBlob("Photo"));
        }
        ret.setPhotos(pics);
        rs.close();
        stmt.close();
        conn.close();
        return ret;
    }

}
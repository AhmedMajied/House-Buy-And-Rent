package DBModels;

import java.util.*;
import Models.*;
import config.*;
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
                            +ad.getDescription()+"',"+ad.getLatitude()+","+ad.getLongitude()+","+ad.getAdvertisor().getID()+",'"
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

}
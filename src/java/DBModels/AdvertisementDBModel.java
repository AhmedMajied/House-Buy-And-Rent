package DBModels;

import java.util.*;
import Models.*;
import config.DBConfig;
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
        ResultSet rs = stmt.executeQuery("SELECT * FROM BuildingStatuses");
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

    public boolean saveNewAd(Advertisement ad) {
        // TODO implement here
        return false;
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
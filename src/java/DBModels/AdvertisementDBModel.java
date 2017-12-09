package DBModels;

import java.util.*;
import Models.*;
import config.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public Vector<Advertisement> retrieveAllAds() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Vector<Advertisement> AllAds = new Vector<>();
        
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("select * from Advertisements,BuildingStatuses,BuildingTypes"
                + " where Advertisements.BuildingStatus = BuildingStatuses.ID and "
                + "Advertisements.BuildingType = BuildingTypes.ID;");        
        PreparedStatement prepStmt2 = null;
        ResultSet result = prepStmt.executeQuery() , rs2 =null;
        int typeID,statusID;


        while(result.next()){
            Advertisement ad = new Advertisement();
            ad.setID(result.getInt("ID"));
            ad.setTitle(result.getString("Title"));
            ad.setAdType(result.getString("adType"));
            ad.setAdvertiserName(result.getString("AdvertiserName"));
            ad.setDescription(result.getString("Description"));
            ad.setBuildingSize(result.getInt("BuildingSize"));
            ad.setBuildingFloor(result.getInt("BuildingFloor"));
            ad.setLatitude(result.getDouble("Latitude"));
            ad.setLongitude(result.getDouble("Longitude"));
            ad.setStatus(new BuildingStatus(result.getInt("BuildingStatuses.ID"),result.getString("BuildingStatuses.Name")));
            ad.setType(new BuildingType(result.getInt("BuildingTypes.ID"),result.getString("BuildingTypes.Name")));

            prepStmt2 = conn.prepareStatement("select ID,Photo from BuildingPhotos where AdID = "+ad.getID());
            rs2 = prepStmt2.executeQuery();
            //TODO get photos from rs2

            // get Ad ratings
            Vector<Rating> AdRates = new Vector<>();
            rs2 = prepStmt2.executeQuery("select Username,Value from Ratings where AdvertisementID = "+ad.getID());
            while(rs2.next()){
                Rating AdRate = new Rating();
                AdRate.setUserName(rs2.getString("Username"));
                AdRate.setValue(rs2.getInt("Value"));
                AdRates.add(AdRate);
            }

            // get Ad Comments
            Vector<Comment> AdComments = new Vector<>();
            rs2 = prepStmt2.executeQuery("select ID,Username,Text from Comments where AdvertisementID = "+ad.getID());
            while(rs2.next()){
                Comment AdComment = new Comment();
                AdComment.setID(rs2.getInt("ID"));
                AdComment.setUserName(rs2.getString("Username"));
                AdComment.setText(rs2.getString("Text"));
                AdComments.add(AdComment);
            }

            ad.setRatings(AdRates);
            ad.setComments(AdComments);
            AllAds.add(ad);
        }

        result.close();
        rs2.close();
        prepStmt.close();
        conn.close();
        
        return AllAds;
    }

    public void saveNewAd(Advertisement ad) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        stmt.executeUpdate("INSERT INTO Advertisement(Title,Size,Floor,Description,Latitude,Longitude,AdvertiserName,AdType,buildingStatus,buildingType) VALUES('"
                            +ad.getTitle()+"',"+ad.getBuildingSize()+","+ad.getBuildingFloor()+",'"
                            +ad.getDescription()+"',"+ad.getLatitude()+","+ad.getLongitude()+","+ad.getAdvertiserName()+",'"
                            +ad.getAdType()+"',"+ad.getStatus()+","+ad.getType()+")"
        );
        stmt.close();
        conn.close();
    }

    public boolean saveNewComment(String UserName, int adID, String commentText) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("insert into Comments values(null,?,?,?)");

        prepStmt.setString(1, UserName);
        prepStmt.setInt(2, adID);
        prepStmt.setString(3, commentText);
        int affectedRows = prepStmt.executeUpdate();

        if(affectedRows > 0)
            return true;
        
        prepStmt.close();
        conn.close();
        
        return false;
    }
    
    public void saveNewRating(String UserName, int adID, int value) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
     
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("insert into Ratings values(?,?,?)");

        prepStmt.setString(1, UserName);
        prepStmt.setInt(2, adID);
        prepStmt.setInt(3, value);
        prepStmt.executeUpdate();

        prepStmt.close();
        conn.close();

    }
    
    
    public void updateExistingRating(String UserName, int adID, int value) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("update Ratings set value = ? where Username = ? and AdvertismentID = ?");

        prepStmt.setInt(1, value);
        prepStmt.setString(2, UserName);
        prepStmt.setInt(3, adID);
        prepStmt.executeUpdate();

        prepStmt.close();
        conn.close();
         
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
        ret.setAdvertiserName(rs.getString("AdvertiserName"));
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
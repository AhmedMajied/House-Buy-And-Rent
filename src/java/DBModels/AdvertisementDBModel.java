package DBModels;

import java.util.*;
import Models.*;
import config.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdvertisementDBModel {

    /*public static void main(String [] args) throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException{
        openAd(1);
    }*/
    
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
        PreparedStatement prepStmt2 = null;
        PreparedStatement prepStmt = conn.prepareStatement("select Advertisements.ID,Title,AdType,AdvertiserName,"
                                                    + "isOpen,BuildingSize,BuildingStatuses.ID,BuildingStatuses.Name,"
                                                    + "BuildingTypes.ID,BuildingTypes.Name "
                                                    + "from Advertisements,BuildingStatuses,BuildingTypes"
                                                    + " where Advertisements.BuildingStatus = BuildingStatuses.ID and "
                                                    + "Advertisements.BuildingType = BuildingTypes.ID;");        
        ResultSet result = prepStmt.executeQuery();

        while(result.next()){
            Advertisement ad = new Advertisement();
            ad.setID(result.getInt("Advertisements.ID"));
            ad.setTitle(result.getString("Title"));
            ad.setAdType(result.getString("adType"));
            ad.setAdvertiserName(result.getString("AdvertiserName"));
            ad.setBuildingSize(result.getInt("BuildingSize"));
            ad.setStatus(new BuildingStatus(result.getInt("BuildingStatuses.ID"),result.getString("BuildingStatuses.Name")));
            ad.setType(new BuildingType(result.getInt("BuildingTypes.ID"),result.getString("BuildingTypes.Name")));
            ad.setOpen(result.getBoolean("isOpen"));

            // get Ad ratings
            Vector<Rating> AdRates = new Vector<>();
            prepStmt2 = conn.prepareStatement("select Username,Value from Ratings where AdvertisementID = "+ad.getID());
            ResultSet rs2 = prepStmt2.executeQuery(); 

            while(rs2.next()){
                Rating AdRate = new Rating();
                AdRate.setUsername(rs2.getString("Username"));
                AdRate.setValue(rs2.getInt("Value"));
                AdRates.add(AdRate);
            }
            
            ad.setRatings(AdRates);
            AllAds.add(ad);

        }

        result.close();
        prepStmt.close();
        conn.close();
        
        return AllAds;
    }

    public void saveNewAd(Advertisement ad) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        Statement stmt= conn.createStatement();
        boolean isOpen=true;
        stmt.executeUpdate("INSERT INTO Advertisements(Title,BuildingSize,BuildingFloor,Description,Latitude,Longitude,AdvertiserName,AdType,buildingStatus,buildingType,isOpen) VALUES('"
                            +ad.getTitle()+"',"+ad.getBuildingSize()+","+ad.getBuildingFloor()+",'"
                            +ad.getDescription()+"',"+ad.getLatitude()+","+ad.getLongitude()+",'"+ad.getAdvertiserName()+"','"
                            +ad.getAdType()+"',"+ad.getStatus().getID()+","+ad.getType().getID()+","+isOpen+")"
        );
        stmt.close();
        conn.close();
    }

    public void updateAd(Advertisement ad) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("Update Advertisements SET Title = ? ,BuildingSize = ?,BuildingFloor = ?,Description = ? ,Latitude = ? ,Longitude = ? ,AdvertiserName = ? ,AdType = ? ,buildingStatus = ?,buildingType = ? WHERE ID = ?");
        prepStmt.setString(1, ad.getTitle());
        prepStmt.setInt(2, ad.getBuildingSize());
        prepStmt.setInt(3, ad.getBuildingFloor());
        prepStmt.setString(4, ad.getDescription());
        prepStmt.setDouble(5, ad.getLatitude());
        prepStmt.setDouble(6, ad.getLongitude());
        prepStmt.setString(7, ad.getAdvertiserName());
        prepStmt.setString(8, ad.getAdType());
        prepStmt.setInt(9, ad.getStatus().getID());
        prepStmt.setInt(10, ad.getType().getID());
        prepStmt.setInt(11, ad.getID());
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }

    public boolean openAd(int AdID)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("update Advertisements set isOpen = true where ID = ? ");
        prepStmt.setInt(1, AdID);
        int affectedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        
        if(affectedRows > 0)
            return true;
        
        return false;
    }
    
    public boolean closeAd(int AdID)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("update Advertisements set isOpen = false where ID = ? ");
        prepStmt.setInt(1, AdID);
        int affectedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        
        if(affectedRows > 0)
            return true;
        
        return false;
    }

    public static boolean deleteAd(int adID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM Advertisements WHERE ID = ? ");
        prepStmt.setInt(1, adID);
        int affectedRows = prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
        
        if(affectedRows > 0)
            return true;
        
        return false;
    }
    
    public static boolean saveNewRating(String UserName, int adID, int value) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
     
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("insert into Ratings values(?,?,?)");

        prepStmt.setString(1, UserName);
        prepStmt.setInt(2, adID);
        prepStmt.setInt(3, value);
        int affectedRows = prepStmt.executeUpdate();
        
        if(affectedRows > 0)
            return true;
        
        prepStmt.close();
        conn.close();
        
        return false;
    }
        
    public static boolean updateExistingRating(String UserName, int adID, int value) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
        Connection conn = DBConfig.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement("update Ratings set value = ? where Username = ? and AdvertisementID = ?");

        prepStmt.setInt(1, value);
        prepStmt.setString(2, UserName);
        prepStmt.setInt(3, adID);
        int affectedRows = prepStmt.executeUpdate();

        if(affectedRows > 0)
            return true;
        
        prepStmt.close();
        conn.close();
         
        return false;
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
        
        // get Ad ratings
        Vector<Rating> AdRates = new Vector<>();
        ResultSet rs5 = stmt.executeQuery("select Username,Value from Ratings where AdvertisementID = "+ret.getID());
        while(rs5.next()){
            Rating AdRate = new Rating();
            AdRate.setUsername(rs5.getString("Username"));
            AdRate.setValue(rs5.getInt("Value"));
            AdRates.add(AdRate);
        }
        
        // get Ad Comments
        Vector<Comment> AdComments = new Vector<>();
        ResultSet rs6 = stmt.executeQuery("select ID,Username,Text from Comments where AdvertisementID = "+ret.getID());
        while(rs6.next()){
            Comment AdComment = new Comment();
            AdComment.setID(rs6.getInt("ID"));
            AdComment.setUsername(rs6.getString("Username"));
            AdComment.setText(rs6.getString("Text"));
            AdComments.add(AdComment);
        }
        
        ret.setRatings(AdRates);
        ret.setComments(AdComments);
       
        rs5.close();
        rs6.close();
        rs.close();
        stmt.close();
        conn.close();
        return ret;
    }

    public void addPhoto(File f,int adID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, FileNotFoundException {
        Connection connection = DBConfig.getConnection();
        PreparedStatement psmnt = connection.prepareStatement("INSERT INTO BuildingPhotos(AdID,Photo)VALUES(?,?)");
        FileInputStream fis = new FileInputStream(f);
        psmnt.setInt(1, adID);
        psmnt.setBlob(2, (InputStream) fis, (int) (f.length()));
        psmnt.executeUpdate();
        psmnt.close();
        connection.close();
    }
    public Vector<Advertisement> searchAdvertisements(String buyOrRent,int status,int type,int size) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException
    {
        Vector<Advertisement> ads=new Vector<Advertisement>();
        Connection conn=DBConfig.getConnection();
        String sql="select * from Advertisements where AdType = '"+buyOrRent+"' or BuildingStatus = '"+status+"' or BuildingType = '"+type+"'"+"or BuildingSize = '"+size+"'";
        Statement statment=conn.createStatement();
        ResultSet result=statment.executeQuery(sql);
        while(result.next())
        {
            Advertisement a=new Advertisement();
            a.setAdType(result.getString("AdType"));
            a.setBuildingFloor(result.getInt("BuildingFloor"));
            a.setID(result.getInt("ID"));
            a.setBuildingSize(result.getInt("BuildingSize"));
            a.setTitle(result.getString("Title"));
            //a.setDescription(result.getString("Description"));
            ads.add(a);
        }
        return ads;
    }

}
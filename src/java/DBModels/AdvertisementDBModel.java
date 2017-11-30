package DBModels;


import java.util.*;
import Models.*;

/**
 * 
 */
public class AdvertisementDBModel {

    /**
     * Default constructor
     */
    public AdvertisementDBModel() {
    }

    /**
     * @return
     */
    public Vector<Advertisement> retrieveAllAds() {
        // TODO implement here
        return null;
    }

    /**
     * @param ad 
     * @return
     */
    public boolean saveNewAd(Advertisement ad) {
        // TODO implement here
        return false;
    }

    /**
     * @param adID 
     * @return
     */
    public boolean updateAd(int adID) {
        // TODO implement here
        return false;
    }

    /**
     * @param adID 
     * @return
     */
    public boolean deleteAd(int adID) {
        // TODO implement here
        return false;
    }

    /**
     * @param adID 
     * @return
     */
    public Vector<Advertisement> retrieveUserAds(int adID) {
        // TODO implement here
        return null;
    }

    /**
     * @param userID 
     * @param adID 
     * @param value 
     * @return
     */
    public boolean rateAd(int userID, int adID, double value) {
        // TODO implement here
        return false;
    }

    /**
     * @param userID 
     * @param adID 
     * @param commentText 
     * @return
     */
    public boolean commentOnAd(int userID, int adID, String commentText) {
        // TODO implement here
        return false;
    }

}
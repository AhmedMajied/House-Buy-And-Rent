package DBModels;


import java.util.*;
import Models.*;

public class AdvertisementDBModel {

    public AdvertisementDBModel() {
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
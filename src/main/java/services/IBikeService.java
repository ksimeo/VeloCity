package services;

import model.Bike;

import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public interface IBikeService {
    public Bike addBike(String bikeModel, String bikeDescription);
    public List<Bike> getAllBikes();
    public List<String> getAllBikesModels();
    public Bike getBikeByModel (String bikeModel);
    public Bike getBikeById (int id);
    public void setDescription (String bikeModel, String bikeDescription);
}
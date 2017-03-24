package dao;

import model.Bike;

import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public interface IBikeDao {

    public List<Bike> getAllBikes();
    public boolean addBike(Bike bike);
    public List<String> getAllBikesModels();
    public Bike getBikeByModel(String model);
    public Bike getBikeById(int id);
    public boolean setDescription(String bikeModel, String bikeDescription);
    public int getLastId();
}

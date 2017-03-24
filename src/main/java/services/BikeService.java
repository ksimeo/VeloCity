package services;

import dao.BikeDao;
import dao.IBikeDao;
import model.Bike;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public enum BikeService implements IBikeService {
    INSTANCE;
    private AtomicInteger lastId;
    private IBikeDao bd;

    private BikeService() {
        bd = new BikeDao();
        int lId = bd.getLastId();
        lastId = new AtomicInteger(lId);
    }

    @Override
    public Bike addBike(String bikeModel, String bikeDescription)
    {

        Bike b = new Bike(lastId.incrementAndGet(), bikeModel, bikeDescription);
        return bd.addBike(b) ? b : null;
    }

    @Override
    public List<Bike> getAllBikes()
    {
        return bd.getAllBikes();
    }

    @Override
    public List<String> getAllBikesModels(){return bd.getAllBikesModels();}

    @Override
    public Bike getBikeByModel(String model){return bd.getBikeByModel(model);}

    @Override
    public Bike  getBikeById(int id){return bd.getBikeById(id);};

    @Override
    public void setDescription(String bikeModel, String bikeDescription)
    {
        bd.setDescription(bikeModel, bikeDescription);
    }
}

package model;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public class Bike {
    private int bikeId;
    private String modelName;
    private String modelDescription;

    public Bike(int bikeId, String modelName, String modelDescription) {
        this.bikeId = bikeId;
        this.modelName = modelName;
        this.modelDescription = modelDescription;
    }

    public Bike () { }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }
}

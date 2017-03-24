package helpers;

import model.Bike;
import model.Client;
import model.Order;
import services.BikeService;
import services.ClientService;
import services.IBikeService;
import services.IClientService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 17.07.2014.
 */
public class BikeHelper {
    IBikeService bikeSer = BikeService.INSTANCE;
    IClientService clientSer = ClientService.INSTANCE;
    IOrderService orderSer = OrderService.INSTANCE;

    public List<String> getAllClientsNames() {

        return clientSer.getAllClientsNames();

    }

    public List<String> getAllBikesModels() {
        return bikeSer.getAllBikesModels();
    }

    public Order saveOrder(int orderId, int clientId, int bikeId) {
        return orderSer.saveOrder(orderId, clientId, bikeId);
    }

    public Client getClientByName(String name) {
        return clientSer.searchClient(name);
    }

    public Bike getBikeByModel(String model) {
        return bikeSer.getBikeByModel(model);
    }

    public List<String> ConvertToShow(List<Order> orders) {
        List<String> toReturn = new ArrayList<String>();
        Iterator<Order> iter = orders.iterator();
        while (iter.hasNext()) {
            Order tmp = iter.next();
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat sdformat = new SimpleDateFormat("dd.MM.yy HH:mm");
            sb.append(clientSer.getClientById(tmp.getClientId()).getClientName())
                    .append(" ")
                    .append(bikeSer.getBikeById(tmp.getBikeId()).getBikeId())
                    .append(" ")
                    .append(sdformat.format(tmp.getOrderDate()));

            toReturn.add(sb.toString());
        }

        return toReturn;
    }

    public String getDescriptionByModel(String model) {
        String toReturn = "";
        Bike bike = bikeSer.getBikeByModel(model);
        if (bike != null) {
            toReturn = bike.getModelDescription();
        }
        return toReturn;
    }

    public void setDescription(String model, String Description)
    {
        bikeSer.setDescription(model, Description);
    }

    public void saveTask(String model, String description)
    {

        bikeSer.addBike(model, description);
    }
}

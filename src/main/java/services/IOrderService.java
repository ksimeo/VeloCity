package services;

import model.Bike;
import model.Client;
import model.Order;
import model.Parcel;

import java.util.List;

/**
 * Created by Admin on 19.07.2014.
 */
public interface IOrderService {
    public Order saveOrder(int orderId, int clientId, int bikeId);
    public List<Order> getAllOrders();
    public List<Order> getOrdersByClientId(Client client);
    public List<Order> getAllByBikeId(Bike bike);
    public Parcel<Order> getOrderPage(Client client, int pageNumber);
    public Parcel<Order> getOrderPageAll(int pageNumber);
    public boolean setStartTime(Order order);
    public boolean setEndDate(Order order);
    public boolean setIsReserved(Order order);
}

package dao;

import model.Bike;
import model.Client;
import model.Order;
import model.Parcel;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by Ksimeo on 19.07.2014.
 */
public interface IOrderDao {
    public boolean saveOrder(Order order);
    public List<Order> getAllOrders();
    public List<Order> getAllOrdersByClientId(Client client);
    public List<Order> getAllOrdersByBikeId(Bike bike);
    public Parcel<Order> gerOrderPage(Client client, int from, int to);
    public Parcel<Order> getOrderPageAll(int from, int to);
    public boolean setOrderDate (Order order, Date date);
    public boolean setStartOrderTime (Order order, Time time);
    public boolean setEndOrderTime (Order order, Time time);
    public int getLastId();
}
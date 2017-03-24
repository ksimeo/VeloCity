package model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public class Order {
    private int orderId;
    private Time orderDate;
    private Time regOrderDate;
    private Time startOrderDate;
    private Time endOrderDate;
    private int bikeId;
    private int clientId;
    private boolean isReserved=false;

    public Order(int orderId, Time orderDate, Time startOrderDate, Time endOrderDate, int bikeId, int clientId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.startOrderDate = startOrderDate;
        this.endOrderDate = endOrderDate;
        this.bikeId = bikeId;
        this.clientId = clientId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Time getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Time orderDate) {
        this.orderDate = orderDate;
    }

    public Time getStartOrderDate() {
        return startOrderDate;
    }

    public void setStartOrderDate(Time startOrderDate) {
        this.startOrderDate = startOrderDate;
    }

    public Time getEndOrderDate() {
        return endOrderDate;
    }

    public void setEndOrderDate(Time endOrderDate) {
        this.endOrderDate = endOrderDate;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}

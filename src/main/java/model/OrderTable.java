package model;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public class OrderTable {
    Order order;
    Bike bike;
    Client reserver;
    Client boss;

    public OrderTable(Order order, Bike bike, Client boss) {
        this.order = order;
        this.bike = bike;
        this.boss = boss;
    }

    public OrderTable(Order order, Bike bike, Client reserver, Client boss) {
        this.order = order;
        this.bike = bike;
        this.reserver = reserver;
        this.boss = boss;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Client getReserver() {
        return reserver;
    }

    public void setReserver(Client reserver) {
        this.reserver = reserver;
    }

    public Client getBoss() {
        return boss;
    }

    public void setBoss(Client boss) {
        this.boss = boss;
    }
}

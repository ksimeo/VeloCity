package dao;

import model.Bike;
import model.Client;
import model.Order;
import model.Parcel;

import java.sql.*;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.List;

/**
 * Created by Ksimeo on 19.07.2014.
 */
public enum OrderDao implements IOrderDao {


    //    public boolean saveOrder(Order order);
//    public List<Order> getAllOrders();
//    public List<Order> getAllOrdersByClientId(Client client);
//    public List<Order> getAllOrdersByBikeId(Bike bike);
//    public Parcel<Order> gerOrderPage(Client client, int from, int to);
//    public Parcel<Order> getOrderPageAll(int from, int to);
//    public boolean setOrderDate (Order order, Date date);
//    public boolean setStartOrderTime (Order order, Time time);
//    public boolean setEndOrderTime (Order order, Time time);
//    public int getLastId();
@Override
public boolean saveOrder(Order order) {
    Connection conn = null;
    PreparedStatement ps = null;
    boolean flag = false;
    try {
        try {
            conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName,
                    ConnectionConfig.dbConnPass);
            ps = conn.prepareStatement(
                    "INSERT IGNORE INTO velocity.order"
                            + "(id, client_id, bike_id, order_date, start_time, end_time, is_reserved)"
                            + "VALUES(?,?,?,?,?,?,?)"
            );

            ps.setInt(1, order.getOrderId());
            ps.setInt(2, order.getClientId());
            ps.setInt(3, order.getBikeId());
            ps.setTime(4, order.getOrderDate());
            ps.setTime(5, order.getStartOrderDate());
            ps.setTime(6, order.getEndOrderDate());
            ps.setBoolean(7, order.isReserved());

            int res = ps.executeUpdate();

            if (res != 0) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } finally {
        if (conn != null) {
            conn = null;
        }
        if (ps != null) {
            ps = null;
        }

    }
    return flag;

}

    @Override
    public List<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName,
                        ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM velocity.order;");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("order_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Time(rs.getTimestamp("start_time").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    try
                    {
                        ed = new Time(rs.getTimestamp("end_time").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }

                    Order order = new Order(rs.getInt("id"),
                            rs.getInt("bike_id"),
                            rs.getInt("client_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("order_date").getTime()),);
                    orders.add(order);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrdersByClientId(Client client) {
        return null;
    }

    @Override
    public List<Order> getAllByClientId(Client client) {

        ArrayList<Order> orders = new ArrayList<Order>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM velocity.order WHERE(client_id = " + client.getClientId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try {
                        sd = new Date(rs.getTimestamp("order_date").getTime());
                    } catch (NullPointerException e) {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    Order order = new Order(
                            rs.getInt("id"),
                            rs.getInt("bike_id"),
                            rs.getInt("client_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()), sd, ed);
                    orders.add(order);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }


        return orders;
    }

    @Override
    public List<Order> getAllByOrderId(Client client) {

        ArrayList<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM velocity.order WHERE(client_id = " + client.getClientId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    Order order = new Order(rs.getInt("id"),
                            rs.getInt("bike_id"),
                            rs.getInt("client_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    orders.add(order);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrdersByBikeId(Bike bike) {

        ArrayList<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM velocity.order WHERE(bike_id = " + bike.getId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    Order order = new Order(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    orders.add(order);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return orders;
    }

    @Override
    public Parcel<Order> gerOrderPage(Client client, int from, int to) {
        return null;
    }

    @Override
    public Parcel<Order> getCurrentTaskPage(Client client, int from, int to) {
        ArrayList<Order> page = new ArrayList<>();
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT COUNT(id) AS m FROM velocity.order");
                rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("m");
                }

                if (from < count) {
                    ps = conn.prepareStatement(
                            "SELECT * FROM velocity.order WHERE client_id = ? ORDER BY id DESC LIMIT ?, ?");
                    ps.setInt(1, client.getClientId());
                    ps.setInt(2,  from);
                    ps.setInt(3, to-from);
                    rs = ps.executeQuery();
                    Date sd;
                    Date ed;
                    while (rs.next()) {
                        try
                        {
                            sd = new Date(rs.getTimestamp("start_date").getTime());
                        } catch (NullPointerException e)
                        {
                            sd = null;
                        }
                        try
                        {
                            ed = new Date(rs.getTimestamp("end_date").getTime());
                        } catch (NullPointerException e)
                        {
                            ed = null;
                        }

                        Order order = new Order(rs.getInt("id"),
                                rs.getInt("task_id"),
                                rs.getInt("creator_id"),
                                rs.getInt("recipient_id"),
                                rs.getString("state"),
                                rs.getString("priority"),
                                new java.util.Date(rs.getTimestamp("create_date").getTime()),
                                sd,
                                ed);
                        page.add(order);

                    }

                } else {
                    page = new ArrayList<>();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return new Parcel<Order>(count, page);
    }
    public Parcel<Order> getOrderPageAll(int from, int to) {
        ArrayList<Order> page = new ArrayList<>();
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT COUNT(id) AS m FROM velocity.order");
                rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("m");
                }

                if (from <= count) {
                    ps = conn.prepareStatement(
                            "SELECT * FROM taskcontrol.currenttask ORDER BY id DESC LIMIT ?, ?");
                    ps.setInt(1,  from);
                    ps.setInt(2, to-from);
                    rs = ps.executeQuery();
                    Date sd;
                    Date ed;
                    while (rs.next()) {
                        try
                        {
                            sd = new Date(rs.getTimestamp("order_date").getTime());
                        } catch (NullPointerException e)
                        {
                            sd = null;
                        }
                        try
                        {
                            ed = new Date(rs.getTimestamp("end_date").getTime());
                        } catch (NullPointerException e)
                        {
                            ed = null;
                        }

                        Order order = new Order(rs.getInt("id"),
                                rs.getInt("task_id"),
                                rs.getInt("creator_id"),
                                rs.getInt("recipient_id"),
                                rs.getString("state"),
                                rs.getString("priority"),
                                new java.util.Date(rs.getTimestamp("create_date").getTime()),
                                sd,
                                ed);
                        page.add(order);

                    }

                } else {
                    page = new ArrayList<>();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return new Parcel<Order>(count, page);
    }

    @Override
    public boolean setOrderDate(Order order, Date date) {
        return false;
    }

    @Override
    public boolean setStartOrderTime(Order order, Time time) {
        return false;
    }

    @Override
    public boolean setEndOrderTime(Order order, Time time) {
        return false;
    }

    @Override
    public boolean setDate(Order order, Date d)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        Timestamp time =  new Timestamp(d.getTime());
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE velocity.order SET order_date = ? where(id = " + order.getOrderId() + ")"
                );
                ps.setTimestamp(1, time);
                int res = ps.executeUpdate();

                if (res != 0) {
                    flag = true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }

        }
        return flag;
    }

    @Override
    public boolean setStartTime(Order order, Time time)
    {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        boolean flag = false;
//        Timestamp time =  new Timestamp(time.getTime());
//        try {
//            try {
//                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
//                ps = conn.prepareStatement(
//                        "UPDATE taskcontrol.currenttask SET end_date = ?  WHERE(id = " + ct.getId() + ")"
//
//                );
//                ps.setTimestamp(1, time);
//                int res = ps.executeUpdate();
//
//                if (res != 0) {
//                    flag = true;
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            if (conn != null) {
//                conn = null;
//            }
//            if (ps != null) {
//                ps = null;
//            }
//
//        }
//        return flag;
    }

    @Override
    public boolean setEndTime(Order order, Time time) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        boolean flag = false;
//        try {
//            try {
//                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
//                ps = conn.prepareStatement(
//                        "UPDATE taskcontrol.currenttask SET priority = ?  WHERE(id = " + ct.getId() + ")"
//
//                );
//                ps.setString(1, priority);
//                int res = ps.executeUpdate();
//
//                if (res != 0) {
//                    flag = true;
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            if (conn != null) {
//                conn = null;
//            }
//            if (ps != null) {
//                ps = null;
//            }
//
//        }
//        return flag;
    }

    @Override
    public boolean setIsReserved(Order order, boolean isReservered) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        boolean flag = false;
//        try {
//            try {
//                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
//                ps = conn.prepareStatement(
//                        "UPDATE taskcontrol.currenttask SET state = ?  WHERE(id = " + ct.getId() + ")"
//
//                );
//                ps.setString(1, state);
//                int res = ps.executeUpdate();
//
//                if (res != 0) {
//                    flag = true;
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            if (conn != null) {
//                conn = null;
//            }
//            if (ps != null) {
//                ps = null;
//            }
//
//        }
//        return flag;
    }

    @Override
    public int getLastId() {
        int lastId = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT MAX(id) AS m FROM velocity.order");
                rs = ps.executeQuery();

                if (rs.next())
                    lastId = rs.getInt("m");
                else
                    lastId = 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return lastId;
    }

}

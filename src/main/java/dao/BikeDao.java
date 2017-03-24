package dao;

import model.Bike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 17.07.2014.
 */
public class BikeDao implements IBikeDao {

    private static String mConnString = ConnectionConfig.mConnString;
    private static String dbConnName = ConnectionConfig.dbConnName;
    private static String dbConnPass = ConnectionConfig.dbConnPass;

    @Override
    public List<Bike> getAllBikes(){
        List<Bike> result = new LinkedList<Bike>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT*FROM velocity.bike");
                rs = ps.executeQuery();
                Bike b = null;
                while (rs.next()) {
                    b = new Bike(rs.getInt("id"), rs.getString("model"), rs.getString("description"));
                }
            } finally {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            }
        }
            catch (Exception e) {
                e.printStackTrace();
            }

        return result;
    }

    @Override
    public boolean addBike(Bike bike) {
        boolean f = false;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("INSERT IGNORE INTO taskcontrol.task"
                                +"(id, model, discription)"
                                +" VALUES(?,?,?)"
                );
                ps.setInt(1, bike.getBikeId());
                ps.setBytes(2, bike.getModelName().getBytes());
                ps.setBytes(3, bike.getModelDescription().getBytes());
                int res = ps.executeUpdate();
                f = res > 0;
            }
            finally {
                if (conn != null){
                    conn.close();
                    conn = null;
                }
                if (ps != null){
                    ps.close();
                    ps = null;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<String> getAllBikesModels() {
        List<String> res = new ArrayList<String>();
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT title FROM taskcontrol.task");
                rs = ps.executeQuery();

                while (rs.next())
                {
                    res.add(rs.getString("model"));

                }
            }
            finally
            {
                if(conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if(ps != null)
                {
                    ps.close();
                    ps = null;
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Bike getBikeByModel(String model) {
        Bike res = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.task WHERE(title = "+"'"+ model +"'"+ ")");
                rs = ps.executeQuery();
                rs.next();

                res = new Bike(rs.getInt("id"),rs.getString("title"), rs.getString("discription"));

            }
            finally
            {
                if(conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if(ps != null)
                {
                    ps.close();
                    ps = null;
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Bike getBikeById(int id) {
        Bike res = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM velocity.bike WHERE(id = " + id + ")");
                rs = ps.executeQuery();
                rs.next();

                res = new Bike(rs.getInt("id"),rs.getString("model"), rs.getString("discription"));

            }
            finally
            {
                if(conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if(ps != null)
                {
                    ps.close();
                    ps = null;
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean setDescription(String bikeModel, String bikeDescription) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE velocity.bike SET description = ? where(model = ?)"
                );
                ps.setString(1, bikeDescription);
                ps.setString(2, bikeModel);
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
                        "SELECT MAX(id) AS m FROM velocity.bike");
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

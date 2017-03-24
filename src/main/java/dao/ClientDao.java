package dao;

import helpers.AuthHelper;
import model.Client;
import dao.IClientDao;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.07.2014.
 */
public class ClientDao implements IClientDao {

    public boolean saveClient(Client client) {
        boolean result = false;

        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                client.setClientPass(AuthHelper.String2Hash(client.getClientPass()));

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("Insert into taskcontrol.user" + "(user_full_name, login, password, role)" +
                        " VALUES" + "(?, ?, ?, ?)");

                ps.setString(1, client.getClientName());
                ps.setString(2, client.getClientPhone());
                ps.setString(3, client.getClientPass());
                ps.setInt(4, client.getRole());
                int res = ps.executeUpdate();

                ResultSet lastid = ps.getGeneratedKeys();
                if (lastid.next()) {
                    client.setClientId(lastid.getInt(1));
                }
                result = res > 0;
            } finally {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Client getClientByPhonePassword(String phone, String password) throws NoSuchProviderException, NoSuchAlgorithmException {
        String query ="Select * from taskcontrol.user where "
                + " phone = '" + phone
                + "' and password= '" + AuthHelper.String2Hash(password) + "'";

        Client retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();

                while (res.next())
                {
                    retValue = new Client(res.getInt("id"),res.getString("name"), res.getString("phone"),
                            res.getString("password"), res.getInt("role"));
                    break;
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
                if(res != null)
                {
                    res.close();
                    res = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retValue;
    }

    @Override
    public Client searchClientByName(String name)
    {
        String query ="Select * from velocity. where "
                + " client_name = '" + name + "'";

        Client retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();

                while (res.next())
                {
                    retValue = new Client(res.getInt("id"),res.getString("name"), res.getString("phone"),
                            res.getString("password"), res.getInt("role"));
                    break;
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
                if(res != null)
                {
                    res.close();
                    res = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retValue;
    }


    @Override
    public List<String> getAllClientsNames()
     {

        List<String> res = new ArrayList<String>();
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT name FROM velocity.client WHERE (role = 2) ORDER BY name");
                rs = ps.executeQuery();

                while (rs.next())
                {
                    res.add(rs.getString("name"));

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
                if(res != null)
                {
                    rs.close();
                    rs = null;
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
    public Client getClientById(int id)
    {
        String query = "Select * from velocity.client where "
                + " id = " + id;

        Client retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();

                while (res.next())
                {
                    retValue = new Client(res.getInt("id"),res.getString("name"), res.getString("phone"),
                            res.getString("password"), res.getInt("role"));
                    break;
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
                if(res != null)
                {
                    res.close();
                    res = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retValue;
    }

}

package dao;

import model.Client;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

/**
 * Created by Admin on 17.07.2014.
 */
public interface IClientDao {
    boolean saveClient(Client client);
    public Client getClientByPhonePassword(String phone, String password) throws NoSuchProviderException, NoSuchAlgorithmException;
    public Client  searchClientByName(String name);
    public List<String> getAllClientsNames();
    public Client getClientById(int id);
}

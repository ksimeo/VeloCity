package services;

import model.Client;

import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public interface IClientService {
    public Client saveClient(String name, String phone, String password, int role);
    public Client searchClient(String name);
    public Client checkLogin(String login, String password);
    public List<String> getAllClientsNames();
    public Client getClientById(int id);
}
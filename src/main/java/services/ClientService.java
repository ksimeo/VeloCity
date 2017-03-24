package services;

import dao.ClientDao;
import model.Client;

import java.util.List;

/**
 * Created by Ksimeo on 17.07.2014.
 */
public enum ClientService implements IClientService{
    INSTANCE;
    private ClientDao clDao;

    private ClientService() { clDao = new ClientDao();}
    @Override
    public Client saveClient(String name, String phone, String password, int role) {
        Client client = new Client(name, phone, password, role);

        return clDao.saveClient(client) ? client : null;
        }

    @Override
    public Client searchClient(String name) { return clDao.searchClientByName(name); }

    @Override
    public Client checkLogin(String login, String password) {
        try
        {
            return clDao.getClientByLoginPassword(login, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return  null;
    }
    public List<String> getAllClientsNames();
    @Override
    public Client getClientById(int id){
        return clDao.getClientById(id);
    }
}


package Repository;

import Model.Child;
import Model.Client;

import java.util.ArrayList;

public class ClientRepository {
    ArrayList<Client> ClientList = new ArrayList<>();

    public ArrayList<Client> getClientList() {
        return ClientList;
    }

    public void addClient(Client client){
        ClientList.add(client);
    }

    public ArrayList<Client> getClientsByName(String name) {
        ArrayList<Client> newClientList = new ArrayList<>();
        for(Client c: ClientList)
            if(c != null)
                if(name.equals(c.getName()))
                    newClientList.add(c);

        return newClientList;
    }

    public Client getClientById(Integer Id) {
        for (Client c : ClientList)
            if (c != null)
                if (Id.equals(c.getClientId()))
                    return c;

        return null;
    }

    public Integer updateName(Integer Id, String name) {
        for (Client c : ClientList)
            if (c != null)
                if (Id.equals(c.getClientId())){
                    c.setName(name);
                    return Id;
                }
        return null;
    }


    public Integer updateName(String oldName, String newName) {
        for (Client c : ClientList)
            if (c != null)
                if (oldName.equals(c.getName())){
                    c.setName(newName);
                    return c.getClientId();
                }
        return null;
    }

    public Integer deleteClient(Integer Id) {
        for (Client c : ClientList){
            if (c != null)
                if (Id.equals(c.getClientId())) {
                   ClientList.remove(c);
                   return Id;
                }
        }
        return null;
    }

    @Override
    public String toString() {
        return "" + ClientList;
    }
}

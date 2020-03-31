package Service;

import Model.Client;
import Repository.ClientRepository;

import java.util.ArrayList;

public class ClientService {

    private static ClientService instance = new ClientService();
    private ClientRepository clientRepository = new ClientRepository();

    private ClientService() {}

    public static ClientService getInstance() {
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clientRepository.getClientList();
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public ArrayList<Client> getClientsByName(String name) {
        ArrayList<Client> result = clientRepository.getClientsByName(name);
        if(result.size() == 0){
            System.out.print("Name not found - ");
            return result;
        }
        else
            return result;
    }

    public Client getClientById(Integer Id) {
        Client result = clientRepository.getClientById(Id);
        if(result == null) {
            System.out.print("Id not found - ");
            return null;
        }
        else
            return result;

    }

    public void updateName(Integer Id, String name) {
        if(clientRepository.updateName(Id, name) == null)
            System.out.println("Id not found");
    }

    public void updateName(String oldName, String newName) {
        if(clientRepository.updateName(oldName, newName) == null)
            System.out.println("Name not found");
    }

    public void DeleteClient(Integer Id, TicketService ticketService) {
        if(clientRepository.getClientById(Id) != null) {
            ticketService.deleteTicket(clientRepository.getClientById(Id));
            clientRepository.deleteClient(Id);
        }
        else
            System.out.println("Id not found");

    }

    @Override
    public String toString() {
        return "ClientService{"
                 + clientRepository +
                '}';
    }
}

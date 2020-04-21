package Service;

import Model.*;
import Repository.TicketRepository;

import java.util.ArrayList;

public class TicketService {

    private static TicketService instance = new TicketService();
    private TicketRepository TicketRepository = new TicketRepository();

    private TicketWritingService ticketWritingService = TicketWritingService.getInstance();

    private TicketReadingService ticketReadingService = TicketReadingService.getInstance();

    private TicketService() {}

    public static TicketService getInstance() {
        return instance;
    }

    public TicketRepository getTicketRepository() {
        return TicketRepository;
    }


    public void addTicket(Ticket ticket) {
        int availableSeats = ticket.getEventDetails().getLocation().getNumberAvailableSeats();
        if( availableSeats > 0){
            TicketRepository.addTicket(ticket);
            ticket.getEventDetails().getLocation().setNumberAvailableSeats(availableSeats - 1);
            ticketWritingService.writeTicket(ticket);
        }
        else
            System.out.println("There are no available tickets at this event.");
    }

    public void readTickets(String file, ClientService clientService, EventDetailsService eventDetailsService){
        ArrayList<Ticket> TicketList;
        TicketList =  ticketReadingService.readTickets(file, clientService, eventDetailsService);

        for(Ticket ticket: TicketList)
            TicketRepository.addTicket(ticket);
    }

    public Ticket getTicketById(Integer Id) {
        Ticket result = TicketRepository.getTicketById(Id);
        if(result == null) {
            System.out.println("Id not found.");
            return null;
        }
        else
            return result;
    }

    public ArrayList<Ticket> getTicketsByClient(Client client) {
        ArrayList<Ticket> result = new ArrayList<>();
        if(client != null)
            result = TicketRepository.getTicketsByClient(client);
        if (result.size() == 0) {
                System.out.println("Client not found - ");
                return result;
            }
        else
            return result;
    }

    public ArrayList<Ticket> getTicketsByEventDetails(EventDetails eventDetails) {
        ArrayList<Ticket> result = TicketRepository.getTicketsByEventDetails(eventDetails);
        if(result.size() == 0){
            System.out.println("Event details not found - ");
            return result;
        }
        else
            return result;
    }

    public void updateClient(Integer Id, Client client) {
        if(TicketRepository.updateClient(Id, client) == null)
            System.out.println("Id not found");
        else
            ticketWritingService.updateTickets(TicketRepository.getTicketList());
    }

    public void updateEventDetails(Integer Id, EventDetails eventDetails) {
        if(TicketRepository.updateEventDetails(Id, eventDetails) == null)
            System.out.println("Event details not found");
        else
            ticketWritingService.updateTickets(TicketRepository.getTicketList());
    }

    public Double getTotalReceiptsPerEvent(EventDetails eventDetails) {
        ArrayList<Ticket> ticketsByEventDetails = TicketRepository.getTicketsByEventDetails(eventDetails);
        Double sum = 0.0;

        for (Ticket t : ticketsByEventDetails)
            if (t != null)
                sum += t.getClient().getPrice(eventDetails.getEvent());

        return sum;
    }

    public void deleteTicket(Client client) {
        TicketRepository.deleteTicket(client);
        ticketWritingService.updateTickets(TicketRepository.getTicketList());
    }

    public void deleteTicket(Integer Id) {
        if(TicketRepository.deleteTicket(Id) == null)
            System.out.println("Id not found.");
        else
            ticketWritingService.updateTickets(TicketRepository.getTicketList());

    }

    @Override
    public String toString() {
        return "TicketService{" +
                  TicketRepository +
                '}';
    }
}

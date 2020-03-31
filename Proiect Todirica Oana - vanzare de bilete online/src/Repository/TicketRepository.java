package Repository;

import Model.*;

import java.util.ArrayList;

public class TicketRepository {
    ArrayList<Ticket> TicketList = new ArrayList<>();

    public ArrayList<Ticket> getTicketList() {
        return TicketList;
    }

    public void addTicket(Ticket ticket){
            TicketList.add(ticket);
    }

    public Ticket getTicketById(Integer Id) {
        for (Ticket t : TicketList)
            if (t != null)
                if (Id.equals(t.getTicketId()))
                    return t;
        return null;
    }

    public ArrayList<Ticket> getTicketsByClient(Client client) {
        ArrayList<Ticket> newTicketList = new ArrayList<>();
        for (Ticket t : TicketList)
            if (t != null)
                if(client.getClientId().equals(t.getClient().getClientId()))
                    newTicketList.add(t);
        return newTicketList;
    }

    public ArrayList<Ticket> getTicketsByEventDetails(EventDetails eventDetails) {
        ArrayList<Ticket> newTicketList = new ArrayList<>();
        for (Ticket t : TicketList)
            if (t != null)
                if(eventDetails.getEventDetailsId().equals(t.getEventDetails().getEventDetailsId()))
                    newTicketList.add(t);
        return newTicketList;
    }

    public Integer updateClient(Integer Id, Client client) {
        for (Ticket t : TicketList)
            if (t != null)
                if(Id.equals(t.getTicketId())) {
                    t.setClient(client);
                    return Id;
                }
        return null;
    }

    public Integer updateEventDetails(Integer Id, EventDetails eventDetails) {
        for (Ticket t : TicketList)
            if (t != null)
                if(Id.equals(t.getTicketId())) {
                    t.setEventDetails(eventDetails);
                    return Id;
                }
        return null;
    }

    public void deleteTicket(Client client) {
        ArrayList<Ticket> newTicketList = new ArrayList<>(this.getTicketsByClient(client));
        for(Ticket t : newTicketList)
            TicketList.remove(t);

    }

    public Integer deleteTicket(Integer Id) {
        for (Ticket t : TicketList){
            if (t != null)
                if (Id.equals(t.getTicketId())) {
                    TicketList.remove(t);
                    return Id;
                }
        }
        return null;
    }

    @Override
    public String toString() {
        return "" + TicketList +
                '}';
    }
}

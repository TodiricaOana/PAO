package Model;

public class Ticket {
    private static Integer id;
    private Integer ticketId;

    static {
        id = 0;
    }

    private Client client;
    private EventDetails eventDetails;

    public Ticket() {
        id++;
    }

    public Ticket(Client client, EventDetails eventDetails) {
        this.client = client;
        this.eventDetails = eventDetails;
        id++;
        this.ticketId = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public static void setId(Integer id) {
        Ticket.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                 client +
                ", " + eventDetails +
                '}';
    }

}

package Service;

import Model.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TicketReadingService {
    private static TicketReadingService instance = new TicketReadingService();
    AuditService auditService = new AuditService();

    private TicketReadingService() {}

    public static TicketReadingService getInstance(){
        return instance;
    }

    ArrayList<Ticket> readTickets (String file, ClientService clientService, EventDetailsService eventDetailsService){
        ArrayList<Ticket> ticketList = new ArrayList<>();

        Path pathToFile = Paths.get(file);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while ( (line = br.readLine()) != null) {
                String[] ticketAttributes = line.split(", ");

                Ticket ticket = new Ticket();

                ticket.setTicketId(Integer.parseInt(ticketAttributes[0]));
                Ticket.setId(Integer.parseInt(ticketAttributes[0]));
                ticket.setClient(clientService.getClientById(Integer.parseInt(ticketAttributes[1])));
                ticket.setEventDetails(eventDetailsService.getEventDetailsById(Integer.parseInt(ticketAttributes[2])));

                ticketList.add(ticket);
            }

            auditService.timeStamp("Reading tickets from file");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return ticketList;
    }
}

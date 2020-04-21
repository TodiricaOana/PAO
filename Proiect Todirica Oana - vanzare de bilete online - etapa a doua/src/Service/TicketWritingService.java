package Service;

import Model.Ticket;

import java.io.*;
import java.util.ArrayList;

public class TicketWritingService {
    private static TicketWritingService instance = new TicketWritingService();
    AuditService auditService = new AuditService();

    private TicketWritingService() {}

    public static TicketWritingService getInstance() {
        return instance;
    }

    public void writeTicket(Ticket ticket) {
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/tickets.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/tickets.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Client id");
                sb.append(", ");
                sb.append("Event details id");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/tickets.csv", true)) {

            writer.append(ticket.getTicketId().toString());
            writer.append(", ");
            writer.append(ticket.getClient().getClientId().toString());
            writer.append(", ");
            writer.append(ticket.getEventDetails().getEventDetailsId().toString());
            writer.append("\n");
            writer.flush();

            auditService.timeStamp("Writing a ticket in file");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateTickets (ArrayList<Ticket> tickets){

        try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/tickets.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(", ");
            sb.append("Client id");
            sb.append(", ");
            sb.append("Event details id");
            sb.append("\n");

            for(Ticket ticket: tickets){
                sb.append(ticket.getTicketId().toString());
                sb.append(", ");
                sb.append(ticket.getClient().getClientId());
                sb.append(", ");
                sb.append(ticket.getEventDetails().getEventDetailsId());
                sb.append("\n");

            }

            auditService.timeStamp("Update all tickets");

            writer.write(sb.toString());
            writer.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

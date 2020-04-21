package Service;

import Model.EventDetails;

import java.io.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class EventDetailsWritingService {
    private static EventDetailsWritingService instance = new EventDetailsWritingService();
    AuditService auditService = new AuditService();

    private EventDetailsWritingService() {}

    public static EventDetailsWritingService getInstance() {
        return instance;
    }

    public void writeEventDetails(EventDetails eventDetails) {
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Event id");
                sb.append(", ");
                sb.append("Location id");
                sb.append(", ");
                sb.append("Date");
                sb.append(", ");
                sb.append("Category");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv", true)) {

            writer.append(eventDetails.getEventDetailsId().toString());
            writer.append(", ");
            writer.append(eventDetails.getEvent().getEventId().toString());
            writer.append(", ");
            writer.append(eventDetails.getLocation().getLocationId().toString());
            writer.append(", ");

            DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String date = simpleDateFormat.format(eventDetails.getDate());
            writer.append(date);

            writer.append(", ");
            writer.append(eventDetails.getCategory());
            writer.append("\n");
            writer.flush();
            auditService.timeStamp("Writing event details in file");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateEventDetails (ArrayList<EventDetails> eventDetails){

        try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(", ");
            sb.append("Event");
            sb.append(", ");
            sb.append("Location");
            sb.append(", ");
            sb.append("Date");
            sb.append(", ");
            sb.append("Category");
            sb.append("\n");

            for(EventDetails eventD: eventDetails){
                sb.append(eventD.getEventDetailsId().toString());
                sb.append(", ");
                sb.append(eventD.getEvent().getEventId().toString());
                sb.append(", ");
                sb.append(eventD.getLocation().getLocationId().toString());
                sb.append(", ");

                DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String date = simpleDateFormat.format(eventD.getDate());
                sb.append(date);

                sb.append(", ");
                sb.append(eventD.getCategory());
                sb.append("\n");

            }

            auditService.timeStamp("Updating all event details");

            writer.write(sb.toString());
            writer.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

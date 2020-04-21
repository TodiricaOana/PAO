package Service;

import Model.Event;

import java.io.*;
import java.util.ArrayList;

public class EventWritingService {
    private static EventWritingService instance = new EventWritingService();
    AuditService auditService = new AuditService();

    private EventWritingService() {}

    public static EventWritingService getInstance() {
        return instance;
    }

    public void writeEvent(Event event) {
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/events.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/events.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Name");
                sb.append(", ");
                sb.append("Price");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/events.csv", true)) {

                writer.append(event.getEventId().toString());
                writer.append(", ");
                writer.append(event.getName());
                writer.append(", ");
                writer.append(event.getPrice().toString());
                writer.append("\n");
                writer.flush();

                auditService.timeStamp("Writing an event in file");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void updateEvents (ArrayList<Event> events){

        try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/events.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(", ");
            sb.append("Name");
            sb.append(", ");
            sb.append("Price");
            sb.append("\n");

            for(Event event: events){
                sb.append(event.getEventId().toString());
                sb.append(", ");
                sb.append(event.getName());
                sb.append(", ");
                sb.append(event.getPrice());
                sb.append("\n");

            }

            auditService.timeStamp("Updating all events");

            writer.write(sb.toString());
            writer.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

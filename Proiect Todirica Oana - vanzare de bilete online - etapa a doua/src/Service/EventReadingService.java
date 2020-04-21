package Service;

import Model.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EventReadingService {
    private static EventReadingService instance = new EventReadingService();
    AuditService auditService = new AuditService();

    private EventReadingService() {}

    public static EventReadingService getInstance(){
        return instance;
    }

    ArrayList<Event> readEvents(String file){
        ArrayList<Event> EventList = new ArrayList<>();

        Path pathToFile = Paths.get(file);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while ( (line = br.readLine()) != null) {
                String[] eventAttributes = line.split(", ");

                Event event = new Event();

                event.setEventId(Integer.parseInt(eventAttributes[0]));
                Event.setId(Integer.parseInt(eventAttributes[0]));
                event.setName(eventAttributes[1]);
                event.setPrice(Double.parseDouble(eventAttributes[2]));
                EventList.add(event);
            }

            auditService.timeStamp("Reading events from file");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return EventList;
    }
}

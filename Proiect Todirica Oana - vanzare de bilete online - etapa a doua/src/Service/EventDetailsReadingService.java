package Service;

import Model.EventDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class EventDetailsReadingService {
    private static EventDetailsReadingService instance = new EventDetailsReadingService();
    AuditService auditService = new AuditService();

    private EventDetailsReadingService() {}

    public static EventDetailsReadingService getInstance(){
        return instance;
    }

    ArrayList<EventDetails> readEventsDetails(String file, EventService eventService, LocationService locationService){
        ArrayList<EventDetails> EventDetailsList = new ArrayList<>();

        Path pathToFile = Paths.get(file);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while ( (line = br.readLine()) != null) {

                String[] eventDetailsAttributes = line.split(", ");

                EventDetails eventDetails = new EventDetails();

                eventDetails.setEventDetailsId(Integer.parseInt(eventDetailsAttributes[0]));
                EventDetails.setId(Integer.parseInt(eventDetailsAttributes[0]));
                eventDetails.setEvent(eventService.getEventById(Integer.parseInt(eventDetailsAttributes[1])));
                eventDetails.setLocation(locationService.getLocationById(Integer.parseInt(eventDetailsAttributes[2])));
                eventDetails.setDate(new SimpleDateFormat("dd.MM.yyyy").parse(eventDetailsAttributes[3]));
                eventDetails.setCategory(eventDetailsAttributes[4]);
                EventDetailsList.add(eventDetails);

            }

            auditService.timeStamp("Reading event details from file");

        } catch (IOException | ParseException ioe) {
            ioe.printStackTrace();
        }

        return EventDetailsList;
    }
}

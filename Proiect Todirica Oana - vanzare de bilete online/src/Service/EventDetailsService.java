package Service;

import Model.Event;
import Model.EventDetails;
import Model.Location;
import Repository.EventDetailsRepository;

import java.util.ArrayList;
import java.util.Date;

public class EventDetailsService {

    private static EventDetailsService instance = new EventDetailsService();
    private EventDetailsRepository eventDetailsRepository = new EventDetailsRepository();

    private EventDetailsService() {}

    public static EventDetailsService getInstance() {
        return instance;
    }

    public ArrayList<EventDetails> getEventDetails() {
        return eventDetailsRepository.getEventDetailsList();
    }

    public boolean checkAvailableLocation(EventDetails eventDetails){
        for (EventDetails e : eventDetailsRepository.getEventDetailsList())
            if (e != null)
                if (e.getLocation().equals(eventDetails.getLocation())){
                    if (e.getDate().equals(eventDetails.getDate()))
                        return false;
                }
        return true;
    }

    public void addEventDetails(EventDetails eventDetails) {
        if(this.checkAvailableLocation(eventDetails))
            eventDetailsRepository.addEventDetails(eventDetails);
        else
            System.out.println("The selected location is occupied at the chosen date. The event was not add.");
    }

    public EventDetails getEventDetailsById(Integer Id) {
        EventDetails result = eventDetailsRepository.getEventDetailsById(Id);
        if(result == null) {
            System.out.print("Id not found - ");
            return null;
        }
        else
            return result;
    }

    public ArrayList<EventDetails> getEventsDetailsByEvent(Event event) {
        ArrayList<EventDetails> result = eventDetailsRepository.getEventsDetailsByEvent(event);
        if(result.size() == 0){
            System.out.print("Event not found - ");
            return result;
        }
        else
            return result;
    }

    public ArrayList<EventDetails> getEventsDetailsByLocation(Location location) {
        ArrayList<EventDetails> result = eventDetailsRepository.getEventsDetailsByLocation(location);
        if(result.size() == 0){
            System.out.print("Location not found - ");
            return result;
        }
        else
            return result;
    }

    public ArrayList<EventDetails> getEventsDetailsByDate(Date date) {
        ArrayList<EventDetails> result = eventDetailsRepository.getEventsDetailsByDate(date);
        if(result.size() == 0){
            System.out.print("Date not found - ");
            return result;
        }
        else
            return result;
    }

    public ArrayList<EventDetails> getEventsDetailsByCategory(String category) {
        ArrayList<EventDetails> result = eventDetailsRepository.getEventsDetailsByCategory(category);
        if(result.size() == 0){
            System.out.print("Category not found - ");
            return result;
        }
        else
            return result;
    }

    public void updateEvent(Integer Id, Event event) {
        if(eventDetailsRepository.updateEvent(Id, event) == null)
            System.out.println("Id not found");
    }

    public void updateLocation(Integer Id, Location location) {
        if (checkAvailableLocation(eventDetailsRepository.getEventDetailsById(Id))){
            if(eventDetailsRepository.updateLocation(Id, location) == null)
                System.out.println("Id not found");
        }
        else
            System.out.println("The selected location is occupied at the chosen date. The event was not updated");
    }

    public void updateDate(Integer Id, Date date) {
        if (checkAvailableLocation(eventDetailsRepository.getEventDetailsById(Id))) {
            if (eventDetailsRepository.updateDate(Id, date) == null)
                System.out.println("Id not found");
        }
        else
            System.out.println("The selected location is occupied at the chosen date. The event was not updated");
    }

    public void updateCategory(Integer Id, String category) {
        if(eventDetailsRepository.updateCategory(Id, category) == null)
            System.out.println("Id not found");
    }

    @Override
    public String toString() {
        return "EventDetailsService{" +
                 eventDetailsRepository +
                '}';
    }
}

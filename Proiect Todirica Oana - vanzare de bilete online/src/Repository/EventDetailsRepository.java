package Repository;

import Model.Event;
import Model.EventDetails;
import Model.Location;

import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;
import java.util.Date;

public class EventDetailsRepository {
    ArrayList<EventDetails> eventDetailsList = new ArrayList<>();

    public ArrayList<EventDetails> getEventDetailsList() {
        return eventDetailsList;
    }

    public void addEventDetails(EventDetails eventDetails){
        eventDetailsList.add(eventDetails);
    }

    public EventDetails getEventDetailsById(Integer Id) {
        for (EventDetails e : eventDetailsList)
            if (e != null)
                if (Id.equals(e.getEventDetailsId()))
                    return e;
        return null;
    }

    public ArrayList<EventDetails> getEventsDetailsByEvent(Event event) {
        ArrayList<EventDetails> newEventDetailsList = new ArrayList<>();
        for(EventDetails e: eventDetailsList)
            if(e != null)
                if(event.equals(e.getEvent()))
                    newEventDetailsList.add(e);
        return newEventDetailsList;
    }

    public ArrayList<EventDetails> getEventsDetailsByLocation(Location location) {
        ArrayList<EventDetails> newEventDetailsList = new ArrayList<>();
        for(EventDetails e: eventDetailsList)
            if(e != null)
                if(location.equals(e.getLocation()))
                    newEventDetailsList.add(e);
        return newEventDetailsList;
    }

    public ArrayList<EventDetails> getEventsDetailsByDate(Date date) {
        ArrayList<EventDetails> newEventDetailsList = new ArrayList<>();
        for(EventDetails e: eventDetailsList)
            if(e != null)
                if(date.equals(e.getDate()))
                    newEventDetailsList.add(e);
        return newEventDetailsList;
    }

    public ArrayList<EventDetails> getEventsDetailsByCategory(String category) {
        ArrayList<EventDetails> newEventDetailsList = new ArrayList<>();
        for(EventDetails e: eventDetailsList)
            if(e != null)
                if(category.equals(e.getCategory()))
                    newEventDetailsList.add(e);
        return newEventDetailsList;
    }

    public Integer updateEvent(Integer Id, Event event) {
        for (EventDetails e : eventDetailsList)
            if (e != null)
                if (Id.equals(e.getEventDetailsId())){
                    e.setEvent(event);
                    return Id;
                }
        return null;
    }

    public Integer updateLocation(Integer Id, Location location) {
        for (EventDetails e : eventDetailsList)
            if (e != null)
                if (Id.equals(e.getEventDetailsId())){
                    e.setLocation(location);
                    return Id;
                }
        return null;
    }

    public Integer updateDate(Integer Id, Date date) {
        for (EventDetails e : eventDetailsList)
            if (e != null)
                if (Id.equals(e.getEventDetailsId())){
                    e.setDate(date);
                    return Id;
                }
        return null;
    }

    public Integer updateCategory(Integer Id, String category) {
        for (EventDetails e : eventDetailsList)
            if (e != null)
                if (Id.equals(e.getEventDetailsId())){
                    e.setCategory(category);
                    return Id;
                }
        return null;
    }

    @Override
    public String toString() {
        return "" + eventDetailsList;
    }
}

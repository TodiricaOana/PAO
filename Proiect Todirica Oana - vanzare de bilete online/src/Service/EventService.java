package Service;

import Model.Event;
import Model.Location;
import Repository.EventRepository;

import java.util.ArrayList;

public class EventService {
    private static EventService instance = new EventService();
    private EventRepository eventRepository = new EventRepository();

    private EventService() {}

    public static EventService getInstance() {
        return instance;
    }

    public ArrayList<Event> getEvent() {
        return eventRepository.getEventList();
    }

    public void addEvent(Event event) {
        eventRepository.addEvent(event);
    }

    public ArrayList<Event> getEventsByName(String name) {
        ArrayList<Event> result = eventRepository.getEventsByName(name);
        if(result.size() == 0){
            System.out.print("Name not found - ");
            return result;
        }
        else
            return result;
    }

    public Event getEventById(Integer Id) {
        Event result = eventRepository.getEventById(Id);
        if(result == null) {
            System.out.print("Id not found - ");
            return null;
        }
        else
            return result;
    }

    public void updateName(Integer Id, String name) {
        if(eventRepository.updateName(Id, name) == null)
            System.out.println("Id not found");
    }

    public void updateName(String oldName, String newName) {
        if(eventRepository.updateName(oldName, newName) == null)
            System.out.println("Name not found");
    }

    public void updatePrice(Integer Id, Double number) {
        if(eventRepository.updatePrice(Id, number) == null)
            System.out.println("Id not found");
    }

    public void updatePrice(String name, Double number) {
        if(eventRepository.updatePrice(name, number) == null)
            System.out.println("Name not found");
    }

    @Override
    public String toString() {
        return "EventService{" +
                eventRepository +
                '}';
    }
}

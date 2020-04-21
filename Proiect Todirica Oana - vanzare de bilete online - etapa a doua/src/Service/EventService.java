package Service;

import Model.Event;
import Repository.EventRepository;

import java.util.ArrayList;

public class EventService {
    private static EventService instance = new EventService();
    private EventRepository eventRepository = new EventRepository();

    private EventWritingService eventWritingService = EventWritingService.getInstance();

    private EventReadingService eventReadingService = EventReadingService.getInstance();

    private EventService() {}

    public static EventService getInstance() {
        return instance;
    }

    public ArrayList<Event> getEvent() {
        return eventRepository.getEventList();
    }

    public void addEvent(Event event) {
        eventRepository.addEvent(event);
        eventWritingService.writeEvent(event);
    }

    public void readEvents(String file){
        ArrayList<Event> EventList;
        EventList =  eventReadingService.readEvents(file);

        for(Event ev: EventList)
            eventRepository.addEvent(ev);
    }

    public ArrayList<Event> getEventsByName(String name) {
        ArrayList<Event> result = eventRepository.getEventsByName(name);
        if(result.size() == 0){
            System.out.println("Name not found - ");
            return result;
        }
        else
            return result;
    }

    public Event getEventById(Integer Id) {
        Event result = eventRepository.getEventById(Id);
        if(result == null) {
            System.out.println("Id not found - ");
            return null;
        }
        else
            return result;
    }

    public void updateName(Integer Id, String name) {
        if(eventRepository.updateName(Id, name) == null)
            System.out.println("Id not found");
        else
            eventWritingService.updateEvents(eventRepository.getEventList());
    }

    public void updateName(String oldName, String newName) {
        if(eventRepository.updateName(oldName, newName) == null)
            System.out.println("Name not found");
        else
            eventWritingService.updateEvents(eventRepository.getEventList());
    }

    public void updatePrice(Integer Id, Double number) {
        if(eventRepository.updatePrice(Id, number) == null)
            System.out.println("Id not found");
        else
            eventWritingService.updateEvents(eventRepository.getEventList());
    }

    public void updatePrice(String name, Double number) {
        if(eventRepository.updatePrice(name, number) == null)
            System.out.println("Name not found");
        else
            eventWritingService.updateEvents(eventRepository.getEventList());
    }

    @Override
    public String toString() {
        return "EventService{" +
                eventRepository +
                '}';
    }
}

package Repository;

import Model.Event;

import java.util.ArrayList;

public class EventRepository {
    ArrayList<Event> EventList = new ArrayList<>();

    public void addEvent(Event event){
        EventList.add(event);
    }

    public ArrayList<Event> getEventList() {
        return EventList;
    }

    public ArrayList<Event> getEventsByName(String name) {
        ArrayList<Event> newEventList = new ArrayList<>();
        for(Event e: EventList)
            if(e != null)
                if(name.equals(e.getName()))
                    newEventList.add(e);
        return newEventList;
    }

    public Event getEventById(Integer Id) {
        for (Event e : EventList)
            if (e != null)
                if (Id.equals(e.getEventId()))
                    return e;
        return null;
    }

    public Integer updateName(Integer Id, String name) {
        for (Event e : EventList)
            if (e != null)
                if (Id.equals(e.getEventId())){
                    e.setName(name);
                    return Id;
                }
        return null;
    }

    public Integer updateName(String oldName, String newName) {
        for (Event e : EventList)
            if (e != null)
                if (oldName.equals(e.getName())){
                    e.setName(newName);
                    return e.getEventId();
                }
        return null;
    }

    public Integer updatePrice(Integer Id, Double price) {
        for (Event e : EventList)
            if (e != null)
                if (Id.equals(e.getEventId())){
                    e.setPrice(price);
                    return Id;
                }
        return null;
    }

    public Integer updatePrice(String name, Double price) {
        for (Event e : EventList)
            if (e != null)
                if (name.equals(e.getName())){
                    e.setPrice(price);
                    return e.getEventId();
                }
        return null;
    }

    @Override
    public String toString() {
        return "" + EventList;
    }
}

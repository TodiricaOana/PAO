package Model;

import java.util.Objects;

public class Event {
    private static Integer id;
    private Integer eventId;

    static {
        id = 0;
    }

    private String name;
    private Double price;

    public Event() {
        id++;
    }

    public Event(String name, Double price) {
        this.name = name;
        this.price = price;
        id++;
        this.eventId = id;
    }

    public static void setId(Integer id) {
        Event.id = id;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getEventId().equals(event.getEventId()) &&
                getName().equals(event.getName()) &&
                getPrice().equals(event.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

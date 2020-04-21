package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class EventDetails {
    private static Integer id;
    private Integer eventDetailsId;

    static {
        id = 0;
    }

    private Event event;
    private Location location;
    private Date date;
    private String category;

    public EventDetails() {
        id++;
    }

    public EventDetails(Event event, Location location, Date date, String category) {
        this.location = new Location(location);
        this.date = date;
        this.event = event;
        this.category = category;
        id++;
        eventDetailsId = id;
    }

    public static void setId(Integer id) {
        EventDetails.id = id;
    }

    public void setEventDetailsId(Integer eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }

    public Integer getEventDetailsId() {
        return eventDetailsId;
    }

    public Location getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public String getCategory() {
        return category;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventDetails)) return false;
        EventDetails that = (EventDetails) o;
        return Objects.equals(getEventDetailsId(), that.getEventDetailsId()) &&
                Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventDetailsId(), getEvent(), getLocation(), getDate(), getCategory());
    }

    @Override
    public String toString() {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String newDate = simpleDateFormat.format(date);

        return  "EventDetails{" +
                event +
                ", " +location +
                ", date=" + newDate +
                ", category='" + category + '\'' +
                '}';
    }
}

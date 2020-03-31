package Model;

import java.util.Objects;

public class Location {
    private static Integer id;
    private Integer locationId;

    static {
        id = 0;
    }

    private String name;
    private Integer numberAvailableSeats;

    public Location() {
        id++;
    }

    public Location(String name, Integer numberAvailableSeats) {
        this.name = name;
        this.numberAvailableSeats = numberAvailableSeats;
        id++;
        this.locationId = id;
    }

    public Location(Location location) {
        this.name = location.name;
        this.numberAvailableSeats = location.numberAvailableSeats.intValue();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberAvailableSeats(Integer numberAvailableSeats) {
        this.numberAvailableSeats = numberAvailableSeats;
    }

    public int getNumberAvailableSeats() {
        return numberAvailableSeats;
    }

    public void decreaseAvailableSeats() {
        this.numberAvailableSeats --;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getLocationId(), location.getLocationId()) &&
                Objects.equals(getName(), location.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationId(), getName());
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", numberAvailableSeats=" + numberAvailableSeats +
                '}';
    }
}

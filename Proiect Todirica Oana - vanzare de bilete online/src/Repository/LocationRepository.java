package Repository;


import Model.Location;

import java.util.ArrayList;

public class LocationRepository {
    ArrayList<Location> LocationList = new ArrayList<>();

    public ArrayList<Location> getLocationList() {
        return LocationList;
    }

    public void addLocation(Location location){
        LocationList.add(location);
    }

    public ArrayList<Location> getLocationsByName(String name) {
        ArrayList<Location> newLocationList = new ArrayList<>();
        for(Location L: LocationList)
            if(L != null)
                if(name.equals(L.getName()))
                    newLocationList.add(L);

        return newLocationList;
    }

    public Location getLocationById(Integer Id) {
        for(Location L: LocationList)
            if(L != null)
                if(Id.equals(L.getLocationId()))
                    return L;

        return null;
    }

    public Integer updateName(Integer Id, String name) {
        for(Location L: LocationList)
            if(L != null)
                if(Id.equals(L.getLocationId())){
                    L.setName(name);
                    return Id;
                }
        return null;
    }

    public Integer updateName(String oldName, String newName) {
        for(Location L: LocationList)
            if(L != null)
                if(oldName.equals(L.getName())){
                    L.setName(newName);
                    return L.getLocationId();
                }
        return null;
    }

    public Integer updateNumberAvailableSeats(Integer Id, Integer number) {
        for(Location L: LocationList)
            if(L != null)
                if(Id.equals(L.getLocationId())){
                    L.setNumberAvailableSeats(number);
                    return Id;
                }
        return null;
    }

    public Integer updateNumberAvailableSeats(String name, Integer number) {
        for(Location L: LocationList)
            if(L != null)
                if(name.equals(L.getName())){
                    L.setNumberAvailableSeats(number);
                    return L.getLocationId();
                }
        return null;
    }

    @Override
    public String toString() {
        return ""  + LocationList;
    }
}

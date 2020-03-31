package Service;

import Model.Client;
import Model.Location;
import Repository.LocationRepository;

import java.util.ArrayList;

public class LocationService {
    private static LocationService instance = new LocationService();
    private LocationRepository locationRepository = new LocationRepository();

    private LocationService() {}

    public static LocationService getInstance() {
        return instance;
    }

    public ArrayList<Location> getLocations() {
        return locationRepository.getLocationList();
    }

    public void addLocation(Location location) {
        locationRepository.addLocation(location);
    }

    public ArrayList<Location> getLocationsByName(String name) {
        ArrayList<Location> result = locationRepository.getLocationsByName(name);
        if(result.size() == 0){
            System.out.print("Name not found - ");
            return result;
        }
        else
            return result;
    }

    public Location getLocationById(Integer Id) {
        Location result = locationRepository.getLocationById(Id);
        if(result == null) {
            System.out.print("Id not found - ");
            return null;
        }
        else
            return result;

    }

    public void updateName(Integer Id, String name) {
        if(locationRepository.updateName(Id, name) == null)
            System.out.println("Id not found");
    }

    public void updateName(String oldName, String newName) {
        if(locationRepository.updateName(oldName, newName) == null)
            System.out.println("Name not found");
    }

    public void updateNumberAvailableSeats(Integer Id, Integer number) {
        if(locationRepository.updateNumberAvailableSeats(Id, number) == null)
            System.out.println("Id not found");
    }

    public void updateNumberAvailableSeats(String name, Integer number) {
        if(locationRepository.updateNumberAvailableSeats(name, number) == null)
            System.out.println("Name not found");
    }

    @Override
    public String toString() {
        return "LocationService{" +
                  locationRepository +
                '}';
    }
}

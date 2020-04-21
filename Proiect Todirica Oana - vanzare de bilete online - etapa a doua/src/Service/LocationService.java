package Service;

import Model.Location;
import Repository.LocationRepository;

import java.util.ArrayList;

public class LocationService {
    private static LocationService instance = new LocationService();
    private LocationRepository locationRepository = new LocationRepository();

    private LocationWritingService locationWritingService = LocationWritingService.getInstance();

    private LocationReadingService locationReadingService = LocationReadingService.getInstance();

    private LocationService() {}

    public static LocationService getInstance() {
        return instance;
    }

    public ArrayList<Location> getLocations() {
        return locationRepository.getLocationList();
    }

    public void addLocation(Location location) {
        locationRepository.addLocation(location);
        locationWritingService.writeLocation(location);
    }

    public void readLocations(String file){
        ArrayList<Location> LocationList;
        LocationList =  locationReadingService.readLocations(file);

        for(Location location: LocationList)
            locationRepository.addLocation(location);
    }

    public ArrayList<Location> getLocationsByName(String name) {
        ArrayList<Location> result = locationRepository.getLocationsByName(name);
        if(result.size() == 0){
            System.out.println("Name not found - ");
            return result;
        }
        else
            return result;
    }

    public Location getLocationById(Integer Id) {
        Location result = locationRepository.getLocationById(Id);
        if(result == null) {
            System.out.println("Id not found - ");
            return null;
        }
        else
            return result;

    }

    public void updateName(Integer Id, String name) {
        if(locationRepository.updateName(Id, name) == null)
            System.out.println("Id not found");
        else
            locationWritingService.updateLocations(locationRepository.getLocationList());
    }

    public void updateName(String oldName, String newName) {
        if(locationRepository.updateName(oldName, newName) == null)
            System.out.println("Name not found");
        else
            locationWritingService.updateLocations(locationRepository.getLocationList());
    }

    public void updateNumberAvailableSeats(Integer Id, Integer number) {
        if(locationRepository.updateNumberAvailableSeats(Id, number) == null)
            System.out.println("Id not found");
        else
            locationWritingService.updateLocations(locationRepository.getLocationList());
    }

    public void updateNumberAvailableSeats(String name, Integer number) {
        if(locationRepository.updateNumberAvailableSeats(name, number) == null)
            System.out.println("Name not found");
        else
            locationWritingService.updateLocations(locationRepository.getLocationList());
    }

    @Override
    public String toString() {
        return "LocationService{" +
                  locationRepository +
                '}';
    }
}

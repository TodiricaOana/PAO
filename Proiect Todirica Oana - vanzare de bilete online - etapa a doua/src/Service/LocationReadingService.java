package Service;

import Model.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LocationReadingService {
    private static LocationReadingService instance = new LocationReadingService();
    AuditService auditService = new AuditService();

    private LocationReadingService() {}

    public static LocationReadingService getInstance(){
        return instance;
    }

    ArrayList<Location> readLocations(String file){
        ArrayList<Location> LocationList = new ArrayList<>();

        Path pathToFile = Paths.get(file);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while ( (line = br.readLine()) != null) {

                String[] eventAttributes = line.split(", ");

                Location location = new Location();

                location.setLocationId(Integer.parseInt(eventAttributes[0]));
                Location.setId(Integer.parseInt(eventAttributes[0]));
                location.setName(eventAttributes[1]);
                location.setNumberAvailableSeats(Integer.parseInt(eventAttributes[2]));
                LocationList.add(location);
            }

            auditService.timeStamp("Reading locations from file");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return LocationList;
    }
}

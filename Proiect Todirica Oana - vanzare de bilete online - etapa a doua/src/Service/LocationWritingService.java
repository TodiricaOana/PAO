package Service;

import Model.Location;

import java.io.*;
import java.util.ArrayList;

public class LocationWritingService {
    private static LocationWritingService instance = new LocationWritingService();
    AuditService auditService = new AuditService();

    private LocationWritingService() {}

    public static LocationWritingService getInstance() {
        return instance;
    }

    public void writeLocation(Location location) {
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/locations.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/locations.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Name");
                sb.append(", ");
                sb.append("Number available seats");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/locations.csv", true)) {

            writer.append(location.getLocationId().toString());
            writer.append(", ");
            writer.append(location.getName());
            writer.append(", ");
            writer.append(location.getNumberAvailableSeats().toString());
            writer.append("\n");
            writer.flush();

            auditService.timeStamp("Writing a location in file");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateLocations (ArrayList<Location> locations){

        try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/locations.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(", ");
            sb.append("Name");
            sb.append(", ");
            sb.append("Number available seats");
            sb.append("\n");

            for(Location location: locations){
                sb.append(location.getLocationId().toString());
                sb.append(", ");
                sb.append(location.getName());
                sb.append(", ");
                sb.append(location.getNumberAvailableSeats().toString());
                sb.append("\n");

            }

            writer.write(sb.toString());
            writer.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

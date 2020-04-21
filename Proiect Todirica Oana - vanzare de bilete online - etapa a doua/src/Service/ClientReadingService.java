package Service;

import Model.Child;
import Model.Client;
import Model.Retired;
import Model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ClientReadingService {
    private static ClientReadingService instance = new ClientReadingService();
    AuditService auditService = new AuditService();

    private ClientReadingService() {}

    public static ClientReadingService getInstance(){
        return instance;
    }

     ArrayList<Client> readClients(String file){
        ArrayList<Client> ClientList = new ArrayList<>();

        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv");

        if (newFile.length() != 0) {
            Path pathToFile = Paths.get(file);

            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

                String line = br.readLine();

                while ( (line = br.readLine()) != null) {

                    String[] clientDetail = line.split(", ");

                    Client client = null;

                    if(clientDetail[2].equals("Client")) {
                        client = new Client();
                    }
                    if(clientDetail[2].equals("Retired")) {
                        client = new Retired();
                    }
                    if(clientDetail[2].equals("Child")) {
                        client = new Child();
                    }
                    if(clientDetail[2].equals("Student")) {
                        client = new Student();
                    }
                    client.setClientId(Integer.parseInt(clientDetail[0]));
                    Client.setId(Integer.parseInt(clientDetail[0]));
                    client.setName(clientDetail[1]);
                    ClientList.add(client);

                }

                auditService.timeStamp("Reading clients from file");

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return ClientList;
    }

}

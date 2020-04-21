package Service;

import Model.Client;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class ClientWritingService {
    private static ClientWritingService instance = new ClientWritingService();
    AuditService auditService = new AuditService();

    private ClientWritingService() {}

    public static ClientWritingService getInstance() {
        return instance;
    }

    public void writeClient(Client client) {
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/clients.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/clients.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Name");
                sb.append(", ");
                sb.append("Type");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/clients.csv", true)) {

                writer.append(client.getClientId().toString());
                writer.append(", ");
                writer.append(client.getName());
                writer.append(", ");
                writer.append(client.getType());
                writer.append("\n");
                writer.flush();

                auditService.timeStamp("Writing a client in file");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void updateClients (ArrayList<Client> clients){

        try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/clients.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Id");
                sb.append(", ");
                sb.append("Name");
                sb.append(", ");
                sb.append("Type");
                sb.append("\n");

                for(Client client: clients){
                    sb.append(client.getClientId().toString());
                    sb.append(", ");
                    sb.append(client.getName());
                    sb.append(", ");
                    sb.append(client.getType());
                    sb.append("\n");

                }

                auditService.timeStamp("Updating all clients");
                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

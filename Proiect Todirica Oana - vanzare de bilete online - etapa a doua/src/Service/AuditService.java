package Service;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {

    public AuditService() {
    }

    public void timeStamp(String actionName){
        File newFile = new File("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/audit.csv");

        if (newFile.length() == 0) {
            try (PrintWriter writer = new PrintWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/audit.csv")) {

                StringBuilder sb = new StringBuilder();
                sb.append("Action name");
                sb.append(", ");
                sb.append("Action timestamp");
                sb.append("\n");

                writer.write(sb.toString());
                writer.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/audit.csv", true)) {

            writer.append(actionName);
            writer.append(", ");
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            writer.append(timeStamp);
            writer.append("\n");
            writer.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


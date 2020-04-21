package com.company;

import Model.*;
import Service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Press 0 to read data from existing files and run, 1 for introducing new clients, 2 for introducing new events, 3 for introducing new locations, 4 for introducing new event details, 5 for introducing new tickets: ");
            int myint;

            ClientService clientService = ClientService.getInstance();
            clientService.readClients("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/clients.csv");

            EventService eventService = EventService.getInstance();
            eventService.readEvents("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/events.csv");

            LocationService locationService = LocationService.getInstance();
            locationService.readLocations("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/locations.csv");

            EventDetailsService eventDetailsService = EventDetailsService.getInstance();
            eventDetailsService.readEventsDetails("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/eventsDetails.csv", eventService, locationService);

            TicketService ticketService = TicketService.getInstance();
            ticketService.readTickets("E:/HARD HDD/doc faculatte/pao/Proiect Todirica Oana - vanzare de bilete online/tickets.csv", clientService, eventDetailsService);

            while( (myint = keyboard.nextInt() ) != 0) {
                switch (myint) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Press 0 to exit, 1 for adult client, 2 for child, 3 for student, 4 for retired: ");
                        int clientOption;
                        while ((clientOption = keyboard.nextInt()) != 0) {

                            Client client = null;
                            System.out.println("Enter name: ");
                            keyboard.nextLine();
                            String name = keyboard.nextLine();
                            switch (clientOption) {
                                case 1:
                                    client = new Client(name);
                                    break;
                                case 2:
                                    client = new Child(name);
                                    break;
                                case 3:
                                    client = new Student(name);
                                    break;
                                case 4:
                                    client = new Retired(name);
                            }
                            clientService.addClient(client);
                            System.out.println("Press 0 to exit, 1 for adult client, 2 for child, 3 for student, 4 for retired ");
                        }
                        break;
                    case 2:
                        int eventOption = 1;
                        while (eventOption != 0) {

                            System.out.println("Enter name: ");
                            keyboard.nextLine();
                            String name = keyboard.nextLine();
                            System.out.println("Enter price: ");
                            Double price = keyboard.nextDouble();
                            Event event = new Event(name, price);
                            eventService.addEvent(event);
                            System.out.println("Press 0 to exit, 1 for new event:  ");
                            eventOption = keyboard.nextInt();

                        }
                        break;
                    case 3:
                        int locationOption = 1;
                        while (locationOption != 0) {

                            System.out.println("Enter name: ");
                            keyboard.nextLine();
                            String name = keyboard.nextLine();
                            System.out.println("Enter number available seats: ");
                            Integer nrAvailableSeats = keyboard.nextInt();
                            Location location = new Location(name, nrAvailableSeats);
                            locationService.addLocation(location);
                            System.out.println("Press 0 to exit, 1 for new location:  ");
                            locationOption = keyboard.nextInt();
                        }
                        break;
                    case 4:
                        int eventDetailsOption = 1;
                        while (eventDetailsOption != 0) {
                            System.out.println("Enter event id: ");
                            Integer IdEvent = keyboard.nextInt();
                            System.out.println("Enter location id: ");
                            Integer IdLocation = keyboard.nextInt();
                            System.out.println("Enter date in format dd.MM.yyyy");
                            String d = keyboard.next();
                            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(d);
                            System.out.println("Enter the category of the event: ");
                            String category = keyboard.next();
                            EventDetails eventDetails = new EventDetails(eventService.getEventById(IdEvent), locationService.getLocationById(IdLocation), date, category);
                            eventDetailsService.addEventDetails(eventDetails);
                            System.out.println("Press 0 to exit, 1 for new event details:  ");
                            eventDetailsOption = keyboard.nextInt();
                        }
                    case 5:
                        int ticketOption = 1;
                        while (ticketOption != 0) {
                            System.out.println("Enter client id: ");
                            Integer IdClient = keyboard.nextInt();
                            System.out.println("Enter event details id: ");
                            Integer IdEventDetails = keyboard.nextInt();
                            Ticket ticket = new Ticket(clientService.getClientById(IdClient), eventDetailsService.getEventDetailsById(IdEventDetails));
                            ticketService.addTicket(ticket);
                            System.out.println("Press 0 to exit, 1 for new ticket:  ");
                            ticketOption = keyboard.nextInt();
                        }
                }
                System.out.println("Press 0 to run, 1 for introducing new clients, 2 for introducing new events, 3 for introducing new locations, 4 for introducing new event details, 5 for introducing new tickets:  ");
            }

            System.out.println(clientService.getClientById(3));

            eventService.updatePrice("Concert Pian", 99.9);
            eventService.updateName("Concert", "Concert Voltaj");
            System.out.println(eventService.getEventsByName("Seara de talente"));
            System.out.println(eventService.getEventById(1));
            System.out.println(eventService);

            System.out.println(clientService.getClientsByName("Popa Ion").get(0).getPrice(eventService.getEventById(1)));
            clientService.updateName("Voinea Miruna","Voinea Oana");
            clientService.DeleteClient(9, ticketService);
            System.out.println(clientService.getClientById(1).getPrice(eventService.getEventById(2)));
            System.out.println(clientService);

            locationService.updateNumberAvailableSeats(2,250);
            locationService.updateName("Quantic", "Quantic Club");
            locationService.updateNumberAvailableSeats(3,3);
            System.out.println(locationService);

            System.out.println(eventDetailsService.getEventsDetailsByCategory("Stand-up"));
            System.out.println(eventDetailsService.getEventsDetailsByEvent(eventDetailsService.getEventDetailsById(1).getEvent()));
            System.out.println(eventDetailsService);

            System.out.println(ticketService.getTicketsByEventDetails(eventDetailsService.getEventDetailsById(3)));
            System.out.println(ticketService.getTotalReceiptsPerEvent(eventDetailsService.getEventDetailsById(3)));
            ticketService.updateClient(2, clientService.getClientById(8));
            System.out.println(ticketService.getTicketsByClient(clientService.getClientById(9)));
            ticketService.updateClient(10, clientService.getClientById(3));
            ticketService.deleteTicket(1);
            ticketService.getTicketById(1);
            System.out.println(ticketService);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

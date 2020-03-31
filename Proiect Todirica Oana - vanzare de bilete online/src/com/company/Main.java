package com.company;

import Model.*;
import Service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            EventService eventService = EventService.getInstance();
            eventService.addEvent(new Event("Concert Pian", 70.0));
            eventService.addEvent(new Event("Concert Firma", 60.0));
            eventService.addEvent(new Event("Seara de talente",10.0));
            eventService.addEvent(new Event("Stand-up Costel", 40.0));

            eventService.updatePrice("Concert Pian", 99.9);
            eventService.updateName("Seara de talente", "Concurs de talente");
            System.out.println(eventService.getEventsByName("Seara de talente"));
            System.out.println(eventService.getEventById(1));
            System.out.println(eventService);

            ClientService clientService = ClientService.getInstance();

            clientService.addClient(new Child("Popescu Diana"));
            clientService.addClient(new Student("Dinu Maria"));
            clientService.addClient(new Client("Ionescu George"));
            clientService.addClient(new Retired("Popa Ion"));
            clientService.addClient(new Client("Enescu Vasile"));
            clientService.addClient(new Client("Eminescu Mihai"));
            clientService.addClient(new Client("Toma Camelia"));
            clientService.addClient(new Client("Oprea Andreea"));
            clientService.addClient(new Student("Enea Sonia"));
            clientService.addClient(new Child("Voinea Miruna"));

            System.out.println(clientService.getClientsByName("Popa Ion").get(0).getPrice(eventService.getEventById(1)));
            clientService.updateName("Mari","Diana");
            System.out.println(clientService.getClientById(1).getPrice(eventService.getEventById(2)));
            System.out.println(clientService);


            LocationService locationService = LocationService.getInstance();
            locationService.addLocation(new Location("Casa de Cultura a Studentilor", 500));
            locationService.addLocation(new Location("Quantic", 300));
            locationService.addLocation(new Location("True Club", 150));
            locationService.addLocation(new Location("Club 99", 300));

            locationService.updateNumberAvailableSeats(2,250);
            locationService.updateName("Quantic", "Quantic Club");
            locationService.updateNumberAvailableSeats(3,3);

            System.out.println(locationService);

            Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse("12.05.2020");
            Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse("18.06.2020");
            Date date3 = new SimpleDateFormat("dd.MM.yyyy").parse("28.06.2020");
            Date date4 = new SimpleDateFormat("dd.MM.yyyy").parse("24.05.2020");

            EventDetailsService eventDetailsService = EventDetailsService.getInstance();
            eventDetailsService.addEventDetails(new EventDetails(eventService.getEventById(1), locationService.getLocationById(1), date1, "Concert"));
            eventDetailsService.addEventDetails(new EventDetails(eventService.getEventById(2), locationService.getLocationById(2), date2, "Concert"));
            eventDetailsService.addEventDetails(new EventDetails(eventService.getEventById(3), locationService.getLocationById(3), date3, "Concert"));
            eventDetailsService.addEventDetails(new EventDetails(eventService.getEventById(4), locationService.getLocationById(4), date4, "Stand-up"));

            System.out.println(eventDetailsService.getEventsDetailsByCategory("Stand-up"));
            eventDetailsService.updateLocation(1, locationService.getLocationById(2));
            System.out.println(eventDetailsService.getEventsDetailsByEvent(eventDetailsService.getEventDetailsById(1).getEvent()));
            System.out.println(eventDetailsService);

            TicketService ticketService = TicketService.getInstance();
            ticketService.addTicket(new Ticket(clientService.getClientById(1), eventDetailsService.getEventDetailsById(3)));
            ticketService.addTicket(new Ticket(clientService.getClientById(2), eventDetailsService.getEventDetailsById(3)));
            ticketService.addTicket(new Ticket(clientService.getClientById(3), eventDetailsService.getEventDetailsById(3)));
            ticketService.addTicket(new Ticket(clientService.getClientById(4), eventDetailsService.getEventDetailsById(3)));
            ticketService.addTicket(new Ticket(clientService.getClientById(4), eventDetailsService.getEventDetailsById(1)));
            ticketService.addTicket(new Ticket(clientService.getClientById(5), eventDetailsService.getEventDetailsById(1)));
            ticketService.addTicket(new Ticket(clientService.getClientById(6), eventDetailsService.getEventDetailsById(2)));
            ticketService.addTicket(new Ticket(clientService.getClientById(7), eventDetailsService.getEventDetailsById(4)));
            ticketService.addTicket(new Ticket(clientService.getClientById(8), eventDetailsService.getEventDetailsById(2)));
            ticketService.addTicket(new Ticket(clientService.getClientById(9), eventDetailsService.getEventDetailsById(4)));
            ticketService.addTicket(new Ticket(clientService.getClientById(10), eventDetailsService.getEventDetailsById(1)));
            ticketService.addTicket(new Ticket(clientService.getClientById(9), eventDetailsService.getEventDetailsById(2) ));

            clientService.DeleteClient(9, ticketService);

            System.out.println(ticketService.getTicketsByEventDetails(eventDetailsService.getEventDetailsById(3)));
            System.out.println(ticketService.getTotalReceiptsPerEvent(eventDetailsService.getEventDetailsById(3)));

            ticketService.updateClient(2, clientService.getClientById(8));
            
            System.out.println(ticketService);

            System.out.println(ticketService.getTicketsByClient(clientService.getClientById(9)));
            ticketService.updateClient(10, clientService.getClientById(3));

            ticketService.deleteTicket(1);
            ticketService.getTicketById(1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

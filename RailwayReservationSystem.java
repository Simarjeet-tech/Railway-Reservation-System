import java.util.ArrayList;
import java.util.*;.Scanner;
// ----------------trainclass
class Train {
    String trainNumber;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    public Train(String trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean bookTicket(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }

    public void cancelTicket(int seats) {
        availableSeats += seats;
        if (availableSeats > totalSeats) {
            availableSeats = totalSeats; // Prevent overbooking
        }
    }

    public void displayInfo() {
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
    }
}
// -----------------userclass
class User {
    String name;
    String email;
    String phoneNumber;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
// -----------------reservationclass
    // Add fields, constructors, and methods here as needed
class Reservation {
    User user;
    Train train;
    int seatsBooked;

    public Reservation(User user, Train train, int seatsBooked) {
        this.user = user;
        this.train = train;
        this.seatsBooked = seatsBooked;
    }

    public void displayInfo() {
        System.out.println("Reservation Details:");
        user.displayInfo();
        train.displayInfo();
        System.out.println("Seats Booked: " + seatsBooked);
    }
}
// -----------------railwayreservationsystemclass
class RailwayReservationSystem {
    private List<Train> trains;
    private List<Reservation> reservations;

    public RailwayReservationSystem() {
        trains = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void makeReservation(User user, Train train, int seats) {
        if (train.bookTicket(seats)) {
            Reservation reservation = new Reservation(user, train, seats);
            reservations.add(reservation);
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Not enough available seats.");
        }
    }

    public void cancelReservation(Reservation reservation) {
        reservation.train.cancelTicket(reservation.seatsBooked);
        reservations.remove(reservation);
        System.out.println("Reservation cancelled.");
    }

    public void displayTrains() {
        System.out.println("Available Trains:");
        for (Train train : trains) {
            train.displayInfo();
            System.out.println();
        }
    }

    public void displayReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            reservation.displayInfo();
            System.out.println();
        }
    }
}
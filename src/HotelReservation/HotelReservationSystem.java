package HotelReservation;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    String category; // Type of room (Single, Double, Suite)
    boolean isAvailable; // Room availability status

    // Constructor to initialize room category and availability
    Room(String category) {
        this.category = category;
        this.isAvailable = true; // Rooms are available by default
    }
}

public class HotelReservationSystem {
    // Static list of rooms available in the hotel
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        // Adding sample rooms to the list (you can modify as needed)
        rooms.add(new Room("Single"));
        rooms.add(new Room("Double"));
        rooms.add(new Room("Suite"));

        // Initialize Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to show the menu until the user chooses to exit
        while (true) {
            System.out.println("\nHotel Reservation System:");
            System.out.println("1. View Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Get the user's menu choice

            // Perform action based on the user's choice
            switch (choice) {
                case 1:
                    viewRooms(); // Show the list of rooms with availability status
                    break;
                case 2:
                    makeReservation(scanner); // Reserve a room based on user input
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close(); // Close scanner and exit
                    return; // Exit the loop and program
                default:
                    System.out.println("Invalid choice. Try again."); // Handle invalid choices
            }
        }
    }

    // Method to display the availability of each room
    public static void viewRooms() {
        System.out.println("Room Availability:");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i).category + " - " + (rooms.get(i).isAvailable ? "Available" : "Booked"));
        }
    }

    // Method to make a reservation for a specific room
    public static void makeReservation(Scanner scanner) {
        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt(); // Get the room number to reserve

        // Check if room number is valid and if room is available
        if (roomNumber > 0 && roomNumber <= rooms.size() && rooms.get(roomNumber - 1).isAvailable) {
            rooms.get(roomNumber - 1).isAvailable = false; // Set room to booked
            System.out.println("Room " + roomNumber + " reserved successfully.");
        } else {
            System.out.println("Invalid room selection or room already booked."); // Handle errors
        }
    }
}



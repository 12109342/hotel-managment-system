import java.util.Scanner;

class Hotel {
    String name;
    int roomNumber;
    int numberOfDays;
    int roomType;
    int pricePerDay;
    boolean isBooked;

    Hotel(String name, int roomNumber, int numberOfDays, int roomType, int pricePerDay, boolean isBooked) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.numberOfDays = numberOfDays;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.isBooked = isBooked;
    }

    int calculateTotal() {
        return numberOfDays * pricePerDay;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Number of Days: " + numberOfDays);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Day: " + pricePerDay);
        System.out.println("Total Price: " + calculateTotal());
        System.out.println("Is Booked: " + isBooked);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize hotels
        Hotel[] hotels = new Hotel[3];
        hotels[0] = new Hotel("Hotel A", 101, 5, 1, 1000, false);
        hotels[1] = new Hotel("Hotel B", 201, 3, 2, 2000, true);
        hotels[2] = new Hotel("Hotel C", 301, 7, 3, 3000, false);

        // Display all hotels
        for (Hotel hotel : hotels) {
            hotel.display();
        }

        // Book a hotel
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        for (Hotel hotel : hotels) {
            if (hotel.roomNumber == roomNumber) {
                if (hotel.isBooked) {
                    System.out.println("This room is already booked.");
                } else {
                    System.out.print("Enter your name: ");
                    scanner.nextLine(); // consume newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter number of days: ");
                    int numberOfDays = scanner.nextInt();
                    hotel.name = name;
                    hotel.numberOfDays = numberOfDays;
                    hotel.isBooked = true;
                    System.out.println("Booking confirmed.");
                }
                break;
            }
        }

        // Display all hotels after booking
        for (Hotel hotel : hotels) {
            hotel.display();
        }

        scanner.close();
    }
}
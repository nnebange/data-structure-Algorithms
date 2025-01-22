import java.util.Scanner;

public class MovieTheater {
    private static final int ROWS = 5;
    private static final int SEATS_PER_ROW = 10;
    private static boolean[][] seats = new boolean[ROWS][SEATS_PER_ROW];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMovie Theater Seat Reservation System");
            System.out.println("1. View seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Movie Theater Seat Reservation System!");
    }

    private static void displaySeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                System.out.print(seats[i][j] ? "[X] " : "[O] ");
            }
            System.out.println();
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.print("Enter row number (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat number (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (isValidSeat(row, seat)) {
            if (!seats[row][seat]) {
                seats[row][seat] = true;
                System.out.println("Seat reserved successfully!");
            } else {
                System.out.println("Seat is already taken. Suggesting an available seat...");
                suggestAvailableSeat();
            }
        } else {
            System.out.println("Invalid seat selection. Please try again.");
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter row number (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat number (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (isValidSeat(row, seat)) {
            if (seats[row][seat]) {
                seats[row][seat] = false;
                System.out.println("Reservation cancelled successfully!");
            } else {
                System.out.println("Seat is not reserved yet.");
            }
        } else {
            System.out.println("Invalid seat selection. Please try again.");
        }
    }

    private static boolean isValidSeat(int row, int seat) {
        return row >= 0 && row < ROWS && seat >= 0 && seat < SEATS_PER_ROW;
    }

    private static void suggestAvailableSeat() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                if (!seats[i][j]) {
                    System.out.println("Suggested seat: Row " + (i + 1) + ", Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }
}

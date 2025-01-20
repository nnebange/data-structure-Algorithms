import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of temperature entries from the user
        System.out.print("Enter the number of days: ");
        int numDays = scanner.nextInt();

        // Step 2: Prompt the user to enter the temperature values
        double[] temperatures = new double[numDays];
        double sum = 0;

        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter the temperature for day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        // Step 3: Calculate the average temperature
        double average = sum / numDays;
        System.out.printf("\nThe average temperature is: %.2f\n", average);

        // Step 4: Find how many days are above the average temperature
        int countAboveAverage = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                countAboveAverage++;
            }
        }

        // Step 5: Display the result
        System.out.println("Number of days above the average temperature: " + countAboveAverage);

        scanner.close();
    }
}

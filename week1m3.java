import java.util.Scanner;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s\n", (i + 1), heights[i], weights[i], bmi, status);
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of team members: ");
        int n = scanner.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Height (in meters): ");
            heights[i] = scanner.nextDouble();
            System.out.print("  Weight (in kg): ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);
        scanner.close();
    }
}
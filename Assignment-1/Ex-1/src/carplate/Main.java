package carplate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs;

        while (true) {
            System.out.println("1=Manual input, 2=Random generation, X=Exit");
            System.out.print("Enter choice: ");
            inputs = scanner.nextLine().trim().toUpperCase();

            if (inputs.equals("X")) {
                System.out.println("Program terminated.");
                break;
            }

            switch (inputs) {
                case "1":
                    handleManualInput(scanner);
                    break;
                case "2":
                    handleRandomGeneration();
                    break;
                default:
                    System.out.println("Incorrect choice.");
            }
        }

        scanner.close();
    }

    private static void handleManualInput(Scanner scanner) {
        String plate;
        do {
            System.out.print("Enter plate number: ");
            plate = scanner.nextLine().trim().toUpperCase();
            if (CarplateInfo.plateValidity(plate)) {
                System.out.println("Incorrect plate.");
            }
        } while (CarplateInfo.plateValidity(plate));

        System.out.println("Next plate number is " + CarplateInfo.nextPlate(plate));
    }

    private static void handleRandomGeneration() {
        String randomPlate = CarplateInfo.randomPlate();
        System.out.println("Random plate number: " + randomPlate);
        System.out.println("Next plate number is " + CarplateInfo.nextPlate(randomPlate));
    }
}
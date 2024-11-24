package equilibrium;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user on the statement size
        System.out.print("Enter statement size: ");
        int size = scanner.nextInt();

        // Input validation
        if (size < 1 || size > 100) {
            System.out.println("Statement size must be between 1 and 100");
            scanner.close();
            return;
        }

        // Make sure that the input is within the required value
        System.out.println("Enter statement:");
        int[] transactions = new int[size];  // Use an array instead of List
        for (int i = 0; i < size; i++) {
            int transaction = scanner.nextInt();

            // Tell the user whether the transaction is a Deposit or a Withdrawal
            if (transaction > 0) {
                System.out.println("Transaction " + (i + 1) + ": Deposit of " + transaction);
            } else if (transaction < 0) {
                System.out.println("Transaction " + (i + 1) + ": Withdrawal of " + Math.abs(transaction));
            }
            // Tells the user that the transaction cannot be 0
            if (transaction == 0) {
                System.out.println("Transactions must be non-zero integers");
                scanner.close();
                return;
            }
            transactions[i] = transaction;  // Add transaction to the array
        }

        // Find the longest equilibrium period
        Statement statement = new Statement(transactions);  // Pass the array to the Statement class
        int[] longestEquilibrium = statement.findLongestEquilibriumPeriod();

        // Output result
        if (longestEquilibrium[0] == -1) {
            System.out.println("No equilibrium longestEquilibrium found");
        } else {
            System.out.printf("Longest Equilibrium Period is [%d..%d]%n",
                    longestEquilibrium[0], longestEquilibrium[1]);
        }

        scanner.close();
    }
}

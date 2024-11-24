package equilibrium;

public class Statement {
    private final int[] transactions;

    public Statement(int[] transactions) {
        this.transactions = transactions;
    }

    // This method finds the longest period where the sum of transactions is 0 (equilibrium)
    public int[] findLongestEquilibriumPeriod() {
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = -1;

        // Check all possible periods
        for (int start = 0; start < transactions.length; start++) {
            int sum = 0;
            for (int end = start; end < transactions.length; end++) {
                sum += transactions[end];

                // Check if the sum of the current period is 0 (equilibrium point)
                if (sum == 0) {
                    int currentLength = end - start + 1;
                    // If the current period is longer than the previous one (or same length but later)
                    if (currentLength >= maxLength) {
                        maxLength = currentLength;
                        startIndex = start;
                        endIndex = end;
                    }
                }
            }
        }

        // If no equilibrium period found
        if (endIndex == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{startIndex, endIndex};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int transaction : transactions) {
            if (transaction > 0) {
                sb.append("+");
            }
            sb.append(transaction).append(" ");
        }
        return sb.toString().trim();
    }
}

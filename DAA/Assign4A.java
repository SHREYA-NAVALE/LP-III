// 0-1 Knapsack using Dynamic Programming
public class Assign4A {

    // Function to solve knapsack using DP
    public static int knapsack(int weight[], int profit[], int capacity) {
        int n = weight.length;

        // DP table of size (n+1) x (capacity+1)
        int dp[][] = new int[n + 1][capacity + 1];

        // Build table row by row
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {

                // If current item can fit in remaining capacity
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            profit[i - 1] + dp[i - 1][w - weight[i - 1]], // include
                            dp[i - 1][w]                                  // exclude
                    );
                } else {
                    dp[i][w] = dp[i - 1][w]; // cannot include
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int profit[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int capacity = 50;

        int maxProfit = knapsack(weight, profit, capacity);

        System.out.println("Maximum Profit using 0-1 Knapsack (DP) = " + maxProfit);
    }
}

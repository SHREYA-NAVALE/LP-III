public class Assign5 {

    // Function to generate Binomial Coefficients using DP
    public static int binomialCoefficient(int n, int k) {

        int dp[][] = new int[n + 1][k + 1];

        // Fill DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                // Base cases: C(i,0)=1 and C(i,i)=1
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    // Recurrence: C(i,j) = C(i-1,j-1) + C(i-1,j)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {

        int n = 5;
        int k = 2;

        int result = binomialCoefficient(n, k);

        System.out.println("Binomial Coefficient C(" + n + "," + k + ") = " + result);
    }
}

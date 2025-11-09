public class Assign1 {

    static int recursiveSteps = 0;
    static int iterativeSteps = 0;

    // Recursive Fibonacci with step count
    public static int fibonacciRecursive(int n) {
        recursiveSteps++; // function call

        if (n == 0 || n == 1) {
            recursiveSteps++; // base case check
            return n;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci with step count
    public static int fibonacciIterative(int n) {
        iterativeSteps++; // entering function

        if (n == 0 || n == 1) {
            iterativeSteps++; // base case
            return n;
        }

        int a = 0, b = 1, c = 0;
        iterativeSteps++; // initialization

        for (int i = 2; i <= n; i++) {
            iterativeSteps++; // loop iteration
            c = a + b;
            iterativeSteps++; // calculation
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {

        int n = 10; // change input here

        // Recursive call
        int resRec = fibonacciRecursive(n);
        System.out.println("Recursive Fibonacci of " + n + " = " + resRec);
        System.out.println("Recursive Step Count = " + recursiveSteps);

        // Iterative call
        int resItr = fibonacciIterative(n);
        System.out.println("Iterative Fibonacci of " + n + " = " + resItr);
        System.out.println("Iterative Step Count = " + iterativeSteps);
    }
}

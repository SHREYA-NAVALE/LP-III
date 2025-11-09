import java.util.Arrays;

class Item {
    int weight;
    int profit;
    double ratio;  // profit/weight

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight; // calculate profit/weight
    }
}

public class Assign3 {

    public static void main(String[] args) {

        // Sample items (weight, profit)
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int capacity = 50;  // knapsack capacity
        double totalProfit = 0;

        // Step 1: Sort items by highest profit/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        // Step 2: Pick items greedily
        for (Item item : items) {
            if (capacity == 0)
                break;

            if (item.weight <= capacity) {
                // take whole item
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                // take fraction of item
                double fraction = (double) capacity / item.weight;
                totalProfit += item.profit * fraction;
                capacity = 0; // knapsack is full
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}

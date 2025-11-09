import java.util.Arrays;

class Job {
    String id;
    int profit;
    int deadline;

    public Job(String id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

public class Assign2 {

    public static void main(String[] args) {

        // Sample Jobs: {JobID, Profit, Deadline}
        Job[] jobs = {
                new Job("J1", 35, 3),
                new Job("J2", 30, 4),
                new Job("J3", 25, 4),
                new Job("J4", 20, 2),
                new Job("J5", 15, 3),
                new Job("J6", 12, 1),
                new Job("J7", 5, 2)
        };

        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline)
                maxDeadline = job.deadline;
        }

        // Create time slots
        String[] result = new String[maxDeadline + 1]; // index 1 to maxDeadline

        int totalProfit = 0;

        // Step 2: Assign jobs to available slots
        for (Job job : jobs) {
            for (int slot = job.deadline; slot > 0; slot--) {
                if (result[slot] == null) { // slot is free
                    result[slot] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Display scheduled jobs
        System.out.println("Scheduled Jobs:");
        for (int i = 1; i < result.length; i++) {
            if (result[i] != null)
                System.out.println("Time Slot " + i + " --> " + result[i]);
        }

        System.out.println("Total Profit = Rs. " + totalProfit);
    }
}

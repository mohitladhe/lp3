import java.util.*;

class Item {
    int weight;
    int profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class Prac3_DAA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item "
                    + (i + 1) + ": ");

            int weight = sc.nextInt();
            int profit = sc.nextInt();

            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort according to profit/weight ratio
        Arrays.sort(items, (a, b) ->
                Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for (Item item : items) {

            if (capacity >= item.weight) {
                // Take complete item
                capacity -= item.weight;
                totalProfit += item.profit;
            } 
            else {
                // Take fractional part
                double fraction = (double) capacity / item.weight;

                totalProfit += item.profit * fraction;

                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}



// Fractional Knapsack Using Greedy Method

// Theory
// The Fractional Knapsack Problem is an optimization problem where we have a set of items, each having a weight and profit/value. We need to maximize the total profit while keeping the total weight within the given knapsack capacity.

// Unlike 0/1 Knapsack, in Fractional Knapsack we are allowed to take a fraction of an item.

// The greedy strategy is:
// 1. Calculate the profit/weight ratio for every item.
// 2. Sort the items in descending order of profit/weight ratio.
// 3. Select the item with the highest ratio first.
// 4. If the complete item fits, take it completely.
// 5. Otherwise, take the fraction that fits into the remaining capacity.
// 6. Continue until the knapsack is full.

// Formula
// Profit/Weight Ratio = Profit ÷ Weight

// Objective
// To maximize the total profit of the knapsack using a greedy approach.
import java.util.Scanner;

public class Prac4_DAA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n + 1];
        int[] profit = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter weight of item " + i + ": ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit of item " + i + ": ");
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // DP table
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                if (weight[i] <= w) {

                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            profit[i] + dp[i - 1][w - weight[i]]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][capacity]);
    }
}
















// 0/1 Knapsack Using Dynamic Programming

// Theory
// The 0/1 Knapsack Problem is an optimization problem where we have a set of items, each having a weight and profit/value. 
// We need to select items such that the total weight does not exceed the knapsack capacity and the total profit is maximum.

// It is called 0/1 Knapsack because each item can either be:
// - 0 → Not selected
// - 1 → Selected completely
// Unlike Fractional Knapsack, we cannot take a fraction of an item.


// Dynamic Programming Approach
// We create a table dp[i][w], where:
// - i = number of items considered
// - w = current knapsack capacity
// - dp[i][w] = maximum profit possible using the first i items with capacity w


// For every item, we have two choices:
// 1. Exclude the item
// 2. Include the item, if its weight fits


// The recurrence relation is:

// If weight[i] <= w:

// dp[i][w] = max(
//     dp[i-1][w],
//     profit[i] + dp[i-1][w-weight[i]]
// )

// Otherwise:

// dp[i][w] = dp[i-1][w]

// Objective
// To find the maximum possible profit by selecting items such that their total weight does not exceed the knapsack capacity.
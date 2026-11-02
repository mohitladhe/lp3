
// Non-Recursive:
import java.util.Scanner;

public class NonRecursive {

    static void fibonacciIterative(int n) {
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        fibonacciIterative(n);
    }
}

// Recursive

// import java.util.Scanner;

// public class FibonacciRecursive {

//     static int fibonacci(int n) {
//         if (n <= 1) {
//             return n;
//         }

//         return fibonacci(n - 1) + fibonacci(n - 2);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of terms: ");
//         int n = sc.nextInt();

//         System.out.print("Fibonacci Series: ");

//         for (int i = 0; i < n; i++) {
//             System.out.print(fibonacci(i) + " ");
//         }
//     }
// }


// 1. Non-Recursive / Iterative Approach
// In this approach, a loop is used to calculate the Fibonacci numbers. Two variables store the previous two values, and the next value is calculated by adding them.
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// 2. Recursive Approach
// In this approach, a function calls itself to calculate F(n-1) and F(n-2) until it reaches the base cases F(0) and F(1).
// - Time Complexity: O(2ⁿ)
// - Space Complexity: O(n) due to the recursive call stack.
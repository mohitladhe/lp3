import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class Prac2_DAA {

    static void generateCodes(Node root, String code) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        String text = "aabccdeee";

        // Count frequency
        Map<Character, Integer> frequency = new HashMap<>();

        for (char ch : text.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Min Heap
        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        // Create nodes
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node(
                    left.freq + right.freq,
                    left,
                    right
            );

            pq.add(newNode);
        }

        Node root = pq.poll();

        System.out.println("Huffman Codes:");
        generateCodes(root, "");
    }
}






// Huffman Encoding Using Greedy Strategy
// Theory
// Huffman Encoding is a lossless data compression technique used to reduce the size of data.

// It uses a greedy strategy to construct a binary tree called the Huffman Tree.

// The basic idea is:
// 1. Count the frequency of each character.
// 2. Create a node for every character.
// 3. Select the two nodes with the smallest frequencies.
// 4. Combine them into a new node whose frequency is their sum.
// 5. Repeat until only one node remains.
// 6. Assign 0 to the left edge and 1 to the right edge.
// 7. The path from the root to each character gives its Huffman Code.

// Characters with higher frequency generally receive shorter codes, while less frequent characters receive longer codes.

// Why is it called Greedy?
// At every step, Huffman Algorithm chooses the two least frequent nodes. This locally optimal choice eventually produces an optimal prefix code.
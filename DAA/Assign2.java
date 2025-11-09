import java.util.PriorityQueue;

// Node class for Huffman Tree
class Node {
    char ch;
    int frequency;
    Node left, right;

    Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}

public class Assign2 {

    // Function to print Huffman Codes by traversing tree
    public static void printCodes(Node root, String code) {
        if (root == null) return;

        // If leaf node -> print character and code
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + " : " + code);
        }

        // traverse left (add 0) and right (add 1)
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        // Sample characters and frequencies
        char chars[] = { 'A', 'B', 'C', 'D', 'E', 'F' };
        int freq[] = { 5, 9, 12, 13, 16, 45 };

        // Min-Heap based on frequency
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        // Create leaf nodes and add to min-heap
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();     // lowest frequency
            Node right = pq.poll();    // second lowest

            // create parent node with merged frequency
            Node newNode = new Node('-', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Root of Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}

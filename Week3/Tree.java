package Week3;

public class Tree {
    
    public static class Node {

        public Node left, right;
        public int value;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            }
            if (value >= this.value) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

    }

    static Node root;

    public static void printTreeInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        printTreeInOrderTraversal(node.left);
        System.out.print(node.value + " - ");
        printTreeInOrderTraversal(node.right);
    }

    static void printTreeRec(Node root, int space, String prefix) {
        if (root == null)
            return;

        // Increase distance between levels
        space += 5;

        // Process right child first
        printTreeRec(root.right, space, " /");
        
        // Print current node after space
        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.println(prefix + root.value);

        // Process left child
        printTreeRec(root.left, space, " \\");
    }

    static void printTree(Node root) {
        printTreeRec(root, 0, "");
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 9, 1, 6, 4};
        Node root = new Node(3);
        for (int num : nums) {
            root.insert(num);
        }
        printTree(root);
    }


}

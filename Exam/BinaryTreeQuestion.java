package Exam;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeQuestion<E extends Comparable<E>> {

    public boolean isBalanced(BinaryTree<E> tree) {

        if (tree == null || !tree.hasRoot()) {
            return false;
        }
        return Math.abs(isBalanced(tree.getRoot())) <= 1;
    }

    private int isBalanced(BinaryTreeNode<E> node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftSubtreeHeight = isBalanced(node.getLeftChild());

        if (leftSubtreeHeight == -1)
        {
            return -1;
        }

        int rightSubtreeHeight = isBalanced(node.getRightChild());

        if (rightSubtreeHeight == -1)
        {
            return -1;
        }

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
        {
            return -1;
        }
        else
        {
            return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
        }
    }

    private int getHeight(BinaryTreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeftChild());
        int rightHeight = getHeight(node.getRightChild());
        int height = Math.max(leftHeight, rightHeight);
        return height + 1;
    }

    public boolean isBinaryTree(BinaryTree<E> tree) {

        if (!tree.hasRoot()) {
            return false;
        }
        return isBinaryTree(tree.getRoot());
    }

    // private boolean isBinaryTree(BinaryTreeNode<E> root) {

    //     boolean left = true, right = true;
    //     if (root.hasLeftChild()) {
    //         if (root.getElement().compareTo(root.getLeftChild().getElement()) <= 0) {
    //             return false;
    //         }
    //         left = isBinaryTree(root.getLeftChild());
    //     }

    //     if (root.hasRightChild()) {
    //         if (root.getElement().compareTo(root.getRightChild().getElement()) > 0) {
    //             return false;
    //         }
    //         right = isBinaryTree(root.getRightChild());
    //     }

    //     return left && right;
    // }

    private boolean isBinaryTree(BinaryTreeNode<E> root) {
        List<BinaryTreeNode<E>> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);

        for (int i = 1; i < nodes.size(); i++)  {
            if (nodes.get(i).getElement().compareTo(nodes.get(i - 1).getElement()) < 0) {
                return false;
            }
        }
        return true;
    }



    private void inOrderTraversal(BinaryTreeNode<E> root, List<BinaryTreeNode<E>> nodes) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftChild(), nodes);
        nodes.add(root);
        inOrderTraversal(root.getRightChild(), nodes);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();

        // Add a root to the tree
        binaryTree.addRoot(10);

       

        // Add left and right children to the root
        binaryTree.getRoot().addLeftChild(5);

        binaryTree.getRoot().addRightChild(11);

        // Add children to the left child of the root
        binaryTree.getRoot().getLeftChild().addLeftChild(1);
        binaryTree.getRoot().getLeftChild().getLeftChild().addLeftChild(10);

        binaryTree.getRoot().getRightChild().addRightChild(10);
      

        // Add children to the right child of the root
        // binaryTree.getRoot().getRightChild().addLeftChild();
        // binaryTree.getRoot().getRightChild().addRightChild();

        BinaryTreeQuestion<Integer> question = new BinaryTreeQuestion<>();
        System.out.println(question.isBalanced(binaryTree));
    }
    
}


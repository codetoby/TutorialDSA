package Exam;

public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
    private BinaryTreeNodeImpl<E> root = null;

    @Override
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public void addRoot(E element) throws IllegalStateException {
        if (hasRoot()) {
            throw new IllegalStateException("Root already exists.");
        }
        root = new BinaryTreeNodeImpl<>(element, null, this);
    }

    @Override
    public boolean hasRoot() {
        return root != null;
    }

    private static class BinaryTreeNodeImpl<E extends Comparable<E>> implements BinaryTreeNode<E> {
        private E element;
        private BinaryTreeNodeImpl<E> parent, left, right;
        private LinkedBinaryTree<E> tree;

        public BinaryTreeNodeImpl(E element, BinaryTreeNodeImpl<E> parent, LinkedBinaryTree<E> tree) {
            this.element = element;
            this.parent = parent;
            this.tree = tree;
        }

        @Override
        public E getElement() {
            return element;
        }

        @Override
        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public BinaryTreeNodeImpl<E> getParent() {
            return parent;
        }

        @Override
        public BinaryTreeNodeImpl<E> getLeftChild() {
            return left;
        }

        @Override
        public BinaryTreeNodeImpl<E> getRightChild() {
            return right;
        }

        @Override
        public void addLeftChild(E element) {
            if (this.left == null) {
                this.left = new BinaryTreeNodeImpl<>(element, this, tree);
            } else {
                throw new IllegalStateException("Left child already exists.");
            }
        }

        @Override
        public void addRightChild(E element) {
            if (this.right == null) {
                this.right = new BinaryTreeNodeImpl<>(element, this, tree);
                // System.out.println(this.right.getElement());
            } else {
                throw new IllegalStateException("Right child already exists.");
            }
        }

        @Override
        public void delete() {
            if (this == tree.root) {
                tree.root = null;
            } else if (this == parent.left) {
                parent.left = null;
            } else if (this == parent.right) {
                parent.right = null;
            }
            this.parent = null;
        }

        @Override
        public boolean hasLeftChild() {
            return left != null;
        }

        @Override
        public boolean hasRightChild() {
            return right != null;
        }
    }
}

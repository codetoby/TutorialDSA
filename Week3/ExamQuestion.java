package Week3;

public class ExamQuestion<E> {

    static int count = 0;
    
    public Integer countNodesWithHeight(BinaryTree<E> tree, Integer h) {
        
        checkHeightOfNode(tree.getRoot(), h);
        return count;

    }

    private Integer checkHeightOfNode(BinaryTreeNode<E> root, Integer h) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        int height = 0;
        leftHeight = checkHeightOfNode(root.getLeftChild(), h);
        rightHeight = checkHeightOfNode(root.getRightChild(), h);
        height = Math.max(leftHeight, rightHeight);
        if (h == height) {
            count += 1;
        }

        return height + 1;
    }

}

interface BinaryTree<E> {

    BinaryTreeNode<E> getRoot();
    public void addRoot(E element);
    public boolean hasRoot();

}

interface BinaryTreeNode<E> {

    public E getElement();
    public void setElement(E element);
    public BinaryTreeNode<E> getParent();
    public BinaryTreeNode<E> getLeftChild();
    public BinaryTreeNode<E> getRightChild();
    public void addLeftChild(E element);
    public void addRightChild(E element);
    public void delete();
    public boolean hasLeftChild();
    public boolean hasRightChild();

}

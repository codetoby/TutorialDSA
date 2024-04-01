package Exam;

public interface BinaryTreeNode<E> {
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

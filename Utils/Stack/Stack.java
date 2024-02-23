package Utils.Stack;

import Utils.LinkedList;
import Utils.Node;

public class Stack<E> extends LinkedList<E> implements StackADT<Node<E>> {

    @Override
    public Node<E> top() {
        return header;
    }

    @Override
    public Node<E> pop() {
        Node<E> oldTop = header;
        header = header.next;
        return oldTop;
    }

    @Override
    public void add(Node<E> element) {
        element.next = header;
        header = element;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);

        Stack<Integer> stack = new Stack<>();

        stack.add(node1);
        stack.add(node2);
        stack.add(node3);
        stack.add(node4);

        stack.printList();


    }
    
    

}

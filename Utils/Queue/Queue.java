package Utils.Queue;

import Utils.LinkedList;
import Utils.Node;

public class Queue<E> extends LinkedList<E> implements QueueADT<Node<E>>  {

    @Override
    public void enqueue(Node<E> element) {
        add(element);
    }

    @Override
    public Node<E> dequeue() {
        Node<E> oldHeader = header;
        header = header.next;
        return oldHeader;
    }

    @Override
    public Node<E> front() {
        return header;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);

        Queue<Integer> queue = new  Queue<>();  
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        queue.enqueue(node4);

        queue.dequeue();

        queue.printList();
    }
  
}

package Week1;

import Utils.LinkedList;
import Utils.Node;

public class BenAndJerry extends LinkedList<Integer> {

    public void reorderStudents() {

        Node<Integer> midElement = findMidElement();
        midElement.next = reverseList(midElement.next);
        printList();

    }

    public Node<Integer> findMidElement() {
        Node<Integer> slow = header;
        Node<Integer> fast = header;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(5);
        Node<Integer> node6 = new Node<Integer>(6);
        Node<Integer> node7 = new Node<Integer>(7);
        Node<Integer> node8 = new Node<Integer>(8);

        BenAndJerry benAndJerry = new BenAndJerry();

        benAndJerry.add(node1);
        benAndJerry.add(node2);
        benAndJerry.add(node3);
        benAndJerry.add(node4);
        benAndJerry.add(node5);
        benAndJerry.add(node6);
        benAndJerry.add(node7);
        benAndJerry.add(node8);

        benAndJerry.reorderStudents();


    }

    
}
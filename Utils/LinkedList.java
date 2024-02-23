package Utils;

public class LinkedList<E> {

    protected Node<E> header;
    protected int size;

    public void add(Node<E> node) {

        if (header == null) {
            header = node;
        } else {

            Node<E> current = header;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        size++;

    }

    public void remove(Node<E> node) {

        if (header == null) {
            return;
        }

        if (header.data.equals(node.data)) {
            header = null;
            size--;
            return;
        }

        Node<E> previous = null;
        Node<E> current = header;

        while (current.next != null) {
            if (current.data.equals(node.data)) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }

    }

    public void printList() {

        if (header == null) {
            System.out.println("List is empty");
            return;
        }

        Node<E> current = header;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.data);
            } else {
                System.out.print(current.data + " -> ");
            }
            current = current.next;
        }
        System.out.println();

    }

    public Node<E> reverseList(Node<E> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<E> newHeader = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHeader;
    }

    public int size() {
        return size;
    }

    
}

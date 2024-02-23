package Utils.Queue;

public interface QueueADT<E> {

    void enqueue(E element);
    E dequeue();
    E front();
    int size();
    boolean isEmpty();

}

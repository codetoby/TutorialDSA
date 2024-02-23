package Utils.Stack;

public interface StackADT<E> {
    
    E top();
    void add(E element);
    E pop();
    int size();
    boolean isEmpty();

}

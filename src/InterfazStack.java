public interface InterfazStack<T>{
    T pop();
    void push(T dato);
    T top();
    int size();
    boolean isEmpty();
}
package main;

public interface IStack<T>{
    T pop();
    void push(T dato);
    T peek();
    int size();
    boolean isEmpty();
    void clear();
}
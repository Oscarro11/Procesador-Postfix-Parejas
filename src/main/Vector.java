package main;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Vector<T> implements InterfazStack<T>{
    private ArrayList<T> stack;

    public Vector(){
        stack = new ArrayList<T>();
    }

    public T pop() throws NoSuchElementException{
        try{
            T elementoSuperior = stack.removeLast();
            return elementoSuperior;
        }
        catch (NoSuchElementException e) {
            throw e;
        }   
    }

    public void push(T dato){
        stack.add(dato);
    }

    public T top() throws NoSuchElementException{
        try{
            T elementoSuperior = stack.getLast();
            return elementoSuperior;
        }
        catch (NoSuchElementException e) {
            throw e;
        }  
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
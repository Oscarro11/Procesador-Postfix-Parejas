import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Vector<T> implements InterfazStack<T>{
    
    private ArrayList<T> stack;

    public T pop(){
        try{
            T elementoSuperior = stack.removeLast();
            return elementoSuperior;
        }
        catch (NoSuchElementException e) {
            return null;
        }   
    }

    public void push(T dato){
        stack.add(dato);
    }

    public T top(){
        try{
            T elementoSuperior = stack.getLast();
            return elementoSuperior;
        }
        catch (NoSuchElementException e) {
            return null;
        }  
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
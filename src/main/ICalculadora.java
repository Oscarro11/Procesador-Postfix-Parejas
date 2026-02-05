package main;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public interface ICalculadora {
    public Vector<Integer> vector = new Vector<Integer>();

    public int procesarLineaPostfix(String linea) throws NoSuchElementException, InvalidParameterException;
    public int calcular(String operador, int operandoA, int operandoB) throws InvalidParameterException;
    public void reiniciarVector();
}

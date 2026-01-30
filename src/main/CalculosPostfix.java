package main;

import java.security.InvalidParameterException;

public abstract class CalculosPostfix {
    
    public static Integer realizarCalculo(String operador, int operandoA, int operandoB){
        switch (operador) {
            case "+":
                return operandoA + operandoB;
                
            case "-":
                return operandoA - operandoB;

            case "*":
                return operandoA * operandoB;

            case "/":
                return operandoA / operandoB;

            case "%":
                return operandoA % operandoB;

            default:
                throw new InvalidParameterException("El simbolo " + operador + " no se reconoce, por lo que no se puede realizar la operacion");
        }
    }

    public static boolean lineaPostfixValida(String linea){
        String[] contenidoLinea = linea.split("\\s+");
        int cuentaNumero = 0;

        for (String elemento : contenidoLinea){
            try {
                Integer.parseInt(elemento);
                cuentaNumero++;
            } catch (Exception e) {
                cuentaNumero--;
            }
        }

        return cuentaNumero > 0;
    } 
}

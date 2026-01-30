package main;

import java.io.IOException;
import java.util.ArrayList;

public class Controlador {
    private Vector<Integer> vector;
    private LectorDeTexto lector;

    public Controlador(String rutaArchivo){
        crearLector(rutaArchivo);
    }

    public void crearLector(String rutaArchivo){
        rutaArchivo = rutaArchivo.replace("\"", "");
        
        try {
           lector = new LectorDeTexto(rutaArchivo); 
        } catch (IOException e) {
            System.out.println("La ruta de archivo usada para el lector de texto es invalida");
            lector = null;
        } 

        reiniciarVector();
    }

    public String procesarDocumentoRString(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lector.cantidadLineas(); i++){
            String linea = lector.textoLinea(i);
            int resultadoLinea = procesarLinea(linea);
            builder.append(mostrarResultado(linea, resultadoLinea));
            builder.append("\n");
        }

        return builder.toString();
    }

    public ArrayList<Integer> procesarDocumentoRNumero(){
        ArrayList<Integer> resultados = new ArrayList<Integer>();

        for (int i = 0; i < lector.cantidadLineas(); i++){
            String linea = lector.textoLinea(i);
            int resultadoLinea = procesarLinea(linea);
            resultados.add(resultadoLinea);
        }

        return resultados;
    }

    private int procesarLinea(String linea){
        String[] contenidoLinea = linea.split("\\s+");

        for (String elemento : contenidoLinea) {
            try {
                int numero = Integer.parseInt(elemento);
                vector.push(numero);
            } catch (Exception e) {
                int operandoB = vector.pop();
                int operandoA = vector.pop();
                int resultado = decifrarCalculo(elemento, operandoA, operandoB);
                vector.push(resultado);
            }
        }

        return vector.pop();
    }

    private int decifrarCalculo(String operador, int operandoA, int operandoB){
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
                System.out.println("El operando " + operador + " no se reconoce, por lo que no se puede operar con el");
                return operandoA;
        }
    }

    private void reiniciarVector(){
        vector = new Vector<Integer>();
    }

    public String mostrarResultado(String linea, int resultado){
        return "El resultado de operar la expresion '" + linea + "' es: " + resultado;
    }
}

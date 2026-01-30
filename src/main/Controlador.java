package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Controlador {
    private Vector<Integer> vector;
    private LectorDeTexto lector;

    public Controlador(String rutaArchivo) throws InputMismatchException{
        try {
            crearLector(rutaArchivo);
        } catch (IOException e) {
            throw new InputMismatchException("La ruta del archivo a leer es invalida");
        }
    }

    public void crearLector(String rutaArchivo) throws IOException{
        rutaArchivo = formatearRuta(rutaArchivo);
        
        try {
           lector = new LectorDeTexto(rutaArchivo); 
        } catch (IOException e) {
            throw e;
        } 

        reiniciarVector();
    }

    private String formatearRuta(String rutaArchivo){
        return rutaArchivo.replace("\"", "");
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

package main;

import java.io.IOException;
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

    public String procesarDocumento(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lector.cantidadLineas(); i++){
            String linea = lector.textoLinea(i);

            if (CalculosPostfix.lineaPostfixValida(linea)) {
                int resultadoLinea = procesarLineaPostfix(linea);
                builder.append(mostrarResultado(linea, resultadoLinea));
                builder.append("\n");    
            }
            else {
                builder.append(mensajeLineaInvalida(linea));
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private int procesarLineaPostfix(String linea){
        String[] contenidoLinea = linea.split("\\s+");

        for (String elemento : contenidoLinea) {
            try {
                int numero = Integer.parseInt(elemento);
                vector.push(numero);
            } catch (Exception e) {
                int operandoB = vector.pop();
                int operandoA = vector.pop();
                int resultado = CalculosPostfix.realizarCalculo(elemento, operandoA, operandoB);
                vector.push(resultado);
            }
        }

        return vector.pop();
    }

    private String mensajeLineaInvalida(String linea) {
        return "La linea '" + linea + "' no puede ser procesada en el formato postfix";
    }

    private void reiniciarVector(){
        vector.clear();
    }

    public String mostrarResultado(String linea, int resultado){
        return "El resultado de operar la expresion '" + linea + "' es: " + resultado;
    }
}

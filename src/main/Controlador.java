package main;

import java.io.IOException;
import java.util.InputMismatchException;

public class Controlador {
    private LectorDeTexto lector;
    private Calculadora calculadora = new Calculadora();

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

        calculadora.reiniciarVector();
    }

    private String formatearRuta(String rutaArchivo){
        return rutaArchivo.replace("\"", "");
    }

    public String procesarDocumento(){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lector.cantidadLineas(); i++){
            String linea = lector.textoLinea(i);

            try{
                int resultadoLinea = calculadora.procesarLineaPostfix(linea);
                builder.append(mostrarResultado(linea, resultadoLinea));
                builder.append("\n");    
            } catch (Exception e) {
                builder.append(mensajeLineaInvalida(linea));
                builder.append(e.getMessage());
                builder.append("\n\n");
            }
        }

        return builder.toString();
    }

    private String mensajeLineaInvalida(String linea) {
        return "La linea '" + linea + "' no puede ser procesada en el formato postfix, debido a lo siguiente: \n";
    }

    public String mostrarResultado(String linea, int resultado){
        return "El resultado de operar la expresion '" + linea + "' es: " + resultado;
    }
}

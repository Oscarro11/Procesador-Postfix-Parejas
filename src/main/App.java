package main;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static Controlador controlador;
    public static void main(String[] args) throws Exception {
        boolean continuarMenu = true;
        escribir("Bienvenido al programa de calculo de postfix\n");
        
        while (continuarMenu) {
            escribir("""
                    Elija el numero de una de las siguientes opciones:
                    1. Elegir archivo de texto
                    2. Procesar documento
                    3. Terminar programa

                    """);

            switch (scanner.nextLine()) {
                case "1":
                    escribir("Ingrese la ruta absoluta del archivo a usar\n");
                    controlador = new Controlador(scanner.nextLine());
                    escribir("El archivo se ha creado exitosamente\n");
                    break; 

                case "2":
                    if (controlador != null) {
                        escribir(controlador.procesarDocumentoRString());
                        escribir("El archivo no contiene más operaciones\n");
                    }
                    else {
                        escribir("Debe completar la opcion 1 con exito para usar esta opcion\n");
                    }
                    break;
            
                case "3":
                    escribir("Gracias por usar el programa, esperamos volver a verlo pronto\n");
                    continuarMenu = false;
                    break;

                default:
                    escribir("La opcion ingresada no corresponde con alguna del menu, intentelo de nuevo\n");
                    break;
            }
        }
    }

    public static void escribir(String texto){
        System.out.print(texto);
    }
}

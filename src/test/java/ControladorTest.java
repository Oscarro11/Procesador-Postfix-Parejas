package test.java;

import org.junit.Assert;
import org.junit.Test;
import main.Controlador;

public class ControladorTest {

    @Test
    public void texto1(){
        Controlador controlador = new Controlador("src/test/resources/postfix2.txt");
        StringBuilder builder = new StringBuilder();

        builder.append("El resultado de operar la expresion '6 2 * 3 / 4 +' es: 8\n");
        builder.append("El resultado de operar la expresion '1 2 + 3 + 4 +' es: 10\n");
        builder.append("El resultado de operar la expresion '12 4 / 3 -' es: 0\n");

        Assert.assertEquals(builder.toString(), controlador.procesarDocumento());
    }

    @Test
    public void texto2(){
        Controlador controlador = new Controlador("src/test/resources/postfix1.txt");
        StringBuilder builder = new StringBuilder();

        builder.append("El resultado de operar la expresion '1 2 + 4 *' es: 12\n");
        builder.append("El resultado de operar la expresion '18 3 - 5 %' es: 0\n");

        Assert.assertEquals(builder.toString(), controlador.procesarDocumento());
    }

    @Test 
    public void falla1() {
        Controlador controlador = new Controlador("src/test/resources/postfix3.txt");
        StringBuilder builder = new StringBuilder();

        builder.append("La linea '1 * 4 5' no puede ser procesada en el formato postfix, debido a lo siguiente: \n");
        builder.append("La linea no tiene suficientes numeros para poder ser operada en formato postfix\n\n");
        builder.append("La linea '1 2 $ 7' no puede ser procesada en el formato postfix, debido a lo siguiente: \n");
        builder.append("El simbolo '$' no se reconoce, por lo que no se puede realizar la operacion\n\n");

        Assert.assertEquals(builder.toString(), controlador.procesarDocumento());
    }
}

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
}

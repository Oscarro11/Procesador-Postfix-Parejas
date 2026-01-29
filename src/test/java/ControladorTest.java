package test.java;

import org.junit.Assert;
import org.junit.Test;
import main.Controlador;
import java.util.ArrayList;

public class ControladorTest {
    
    @Test
    public void Numeros1(){
        Controlador controlador = new Controlador("src/test/resources/postfix1.txt");
        ArrayList<Integer> array = controlador.procesarDocumentoRNumero();
        int[] arrayRes = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            arrayRes[i] = array.get(i);
        }

        int[] realRes = {12, 0};

        Assert.assertArrayEquals(realRes, arrayRes);
    }

    @Test
    public void texto1(){
        Controlador controlador = new Controlador("src/test/resources/postfix2.txt");
        StringBuilder builder = new StringBuilder();

        builder.append("El resultado de operar la expresion '6 2 * 3 / 4 +' es: 8\n");
        builder.append("El resultado de operar la expresion '1 2 + 3 + 4 +' es: 10\n");
        builder.append("El resultado de operar la expresion '12 4 / 3 -' es: 0\n");

        Assert.assertEquals(builder.toString(), controlador.procesarDocumentoRString());
    }
}

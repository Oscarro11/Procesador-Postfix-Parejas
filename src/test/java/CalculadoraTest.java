package test.java;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import org.junit.*;
import main.Calculadora;

public class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    public void calculo1(){
        String operacion = "1 2 + 10 * 4 %";
        int resultado = ((1 + 2) * 10) % 4;
        Assert.assertEquals(resultado, calculadora.procesarLineaPostfix(operacion));
    }

    @Test
    public void error1(){
        String operacion = "- 1 2";
        Assert.assertThrows(NoSuchElementException.class, () -> calculadora.procesarLineaPostfix(operacion));
    }

    @Test
    public void error2(){
        String operacion = "1 3 @";
        Assert.assertThrows(InvalidParameterException.class, () -> calculadora.procesarLineaPostfix(operacion));
    }
}

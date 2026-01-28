package test.java;

import org.junit.*;
import main.LectorDeTexto;

public class LectorDeTextoTest {
    LectorDeTexto lector;

    @Before
    public void setUp(){
        try{
            lector = new LectorDeTexto("src/test/resources/ejemplo.txt");
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void linea1(){
        Assert.assertEquals("Hola buenas que tal", lector.textoLinea(0));    
    }

    @Test
    public void linea2(){
        Assert.assertEquals("", lector.textoLinea(1));
    }

    @Test
    public void cuenta(){
        Assert.assertEquals(3, lector.cantidadLineas());
    }
}

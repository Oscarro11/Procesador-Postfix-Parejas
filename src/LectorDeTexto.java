import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectorDeTexto {
    private List<String> contenidoArchivo;

    public LectorDeTexto(String rutaArchivo) throws IOException{
        Path filePath = findPath(rutaArchivo);

        try {
            contenidoArchivo = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw e;
        }
    }

    private Path findPath(String rutaArchivo){
        return Paths.get(rutaArchivo);
    }

    public String textoLinea(int posicion){
        return contenidoArchivo.get(posicion);
    }

    public int cantidadLineas(){
        return contenidoArchivo.size();
    }
}

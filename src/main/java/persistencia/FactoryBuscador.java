package persistencia;

public class FactoryBuscador {
    public static Buscador getInstance(String extension) {
        Buscador estrategia = null;
        switch(extension) {
            case "txt":estrategia = new ArchivoTexto();
                break;
        }
        return estrategia;
    }
}

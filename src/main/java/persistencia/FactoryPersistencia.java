package persistencia;

public class FactoryPersistencia {
    public static Persistor getInstance(String extension) {
        Persistor estrategia = null;
        switch(extension) {
            case "txt":estrategia = new ArchivoTexto();
                break;
        }
        return estrategia;
    }
}

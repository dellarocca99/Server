package modeloPaqueteInfo;

public class PaqueteNuevoCliente implements IPaquete {
    private final int idOperacion = 1;

    @Override
    public int getIdOperacion() {
        return idOperacion;
    }
}

package persistencia;

public interface Buscador {
    public String buscarNombre(Integer dni);
    public String[] buscaCategoriaYNombre(Integer dni);
}
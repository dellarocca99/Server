package modeloInfo;

import java.util.GregorianCalendar;

public class InfoCliente implements Informable {
    private final int idOperacion = 1;
    private int dni;
    private String nombre=null;
    private int categoria=-1;
    private GregorianCalendar fechaYHoraRegistro=null;

    public InfoCliente(int dni){
        this.dni=dni;
    }

    @Override
    public int getIdOperacion() {
        return idOperacion;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public GregorianCalendar getFechaYHoraRegistro() {
        return fechaYHoraRegistro;
    }
}

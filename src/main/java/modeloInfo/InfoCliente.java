package modeloInfo;

import java.util.Date;

public class InfoCliente implements Informable {
    private final int idOperacion = 1;
    private int dni;
    private String nombre=null;
    private int categoria=-1;
    private Date fechaYHoraRegistro=null;

    public InfoCliente(int dni, Date fechaYHoraRegistro){
        this.dni=dni;
        this.fechaYHoraRegistro=fechaYHoraRegistro;
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

    public Date getFechaYHoraRegistro() {
        return fechaYHoraRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}


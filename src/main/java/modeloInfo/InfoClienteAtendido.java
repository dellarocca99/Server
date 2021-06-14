package modeloInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoClienteAtendido implements Informable {
    private InfoCliente infoCliente;
    private int box;
    private Date fechaYHoraAtencion;

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public InfoClienteAtendido(InfoCliente info, int box) {
        this.infoCliente = info;
        this.box = box;
    }

    public int getDni() {
        return this.infoCliente.getDni();
    }

    public int getCategoria() {
        return this.infoCliente.getCategoria();
    }

    public Date getFechaYHoraAtencion() {
        return fechaYHoraAtencion;
    }

    public Date getFechaYHoraRegistro() {
        return this.infoCliente.getFechaYHoraRegistro();
    }

    public String getNombre() {
        return this.infoCliente.getNombre();
    }

    public void setFechaYHoraAtencion(Date fechaYHoraAtencion) {
        this.fechaYHoraAtencion = fechaYHoraAtencion;
    }

    @Override
    public int getIdOperacion() {
        return 2;
    }

    @Override
    public String toString() {
        String formato = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return this.getNombre()+"-"+this.getDni()+"-"+this.getCategoria()+"-"+this.getBox()+"-"+sdf.format(this.fechaYHoraAtencion)+
                "-"+sdf.format(getFechaYHoraRegistro());
    }

}
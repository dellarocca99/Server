package modeloInfo;

import java.util.Date;

public class InfoInicioAtencion implements Informable {

    private Date fechaYHora;
    private int box;

    public InfoInicioAtencion() {
        this.fechaYHora = new Date();
    }

    @Override
    public int getIdOperacion() {
        return 4;
    }

    public Date getFecha() {
        return fechaYHora;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

}

package servicios;

import modeloInfo.InfoCliente;
import modeloInfo.InfoTiempoAtencion;
import repositorio.Repositorio;

public class ServicioTotem {

    public void nuevoCliente(InfoCliente paquete) {
        Repositorio.getInstance().agregaNuevoCliente(paquete);
    }

    public InfoTiempoAtencion recuperaTiempoAtencionPromedio() {
        InfoTiempoAtencion paquete=new InfoTiempoAtencion();
        paquete.setTiempoAtencion(Repositorio.getInstance().getTiempoAtencionPromedio());
        return paquete;
    }
}

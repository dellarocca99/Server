package repositorio;

import modeloInfo.InfoCliente;

import java.util.Comparator;

public class EstrategiaFIFO extends EstrategiaProxCliente{
    @Override
    public InfoCliente proximoCliente() {
        Comparator<InfoCliente> comparador= new Comparator<InfoCliente>() {
            @Override
            public int compare(InfoCliente o1, InfoCliente o2) {
                return o1.getFechaYHoraRegistro().compareTo(o2.getFechaYHoraRegistro());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        return this.colaClientes.stream().
                min(comparador).get();
    }
}

package repositorio;

import modeloInfo.InfoCliente;

import java.util.Comparator;

public class EstrategiaPorDniCreciente extends EstrategiaProxCliente{
    @Override
    public InfoCliente proximoCliente() {
        Comparator<InfoCliente> comparador= new Comparator<InfoCliente>() {
            @Override
            public int compare(InfoCliente o1, InfoCliente o2) {
                if (o1.getDni()<o2.getDni())
                    return -1;
                else
                    return 1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        InfoCliente infoCliente=this.colaClientes.stream().
                min(comparador).orElse(null);
        this.colaClientes.remove(infoCliente);
        return infoCliente;
    }
}

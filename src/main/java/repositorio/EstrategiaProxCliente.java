package repositorio;

import modeloInfo.InfoCliente;

import java.util.ArrayList;

public abstract class EstrategiaProxCliente {
    protected ArrayList<InfoCliente> colaClientes=null;

    public abstract InfoCliente proximoCliente();
}

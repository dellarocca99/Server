package modeloInfo;

import java.util.ArrayList;

public class InfoClientesEspera implements Informable {

    private ArrayList<InfoCliente> clientes;

    @Override
    public int getIdOperacion() {
        return 0;
    }

    public void setClientes(ArrayList<InfoCliente> clientes){
        this.clientes = clientes;
    }

    public ArrayList<InfoCliente> getClientes(){
        return this.clientes;
    }

}
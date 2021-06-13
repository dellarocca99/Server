package modeloInfo;

import java.util.ArrayList;
import java.util.LinkedList;

public class InfoClientesEspera implements Informable {

    private ArrayList<InfoCliente> dnis;

    @Override
    public int getIdOperacion() {
        return 0;
    }

    public void setDnis(ArrayList<InfoCliente> dnis){
        this.dnis = dnis;
    }

    public ArrayList<InfoCliente> getDnis(){
        return this.dnis;
    }

}

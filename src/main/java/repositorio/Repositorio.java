package repositorio;

import modeloInfo.*;
import modeloUtil.TiempoAtencion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Repositorio implements Serializable {

    private static Repositorio instance=null;
    private ArrayList<InfoCliente> colaClientes=null;
    private Stack<InfoClienteAtendido> pilaClientesAtendidos=null;
    private TiempoAtencion tiempoAtencionPromedio=null;
    private int cantTiempos=0;
    private EstrategiaProxCliente estrategia;

    private Repositorio(){
        this.colaClientes=new ArrayList<InfoCliente>();
        this.pilaClientesAtendidos=new Stack<InfoClienteAtendido>();
        this.tiempoAtencionPromedio=new TiempoAtencion(0,0,0);
    };

    public static Repositorio getInstance(){
        if (instance==null)
            instance=new Repositorio();
        return instance;
    }

    public ArrayList<InfoCliente> getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(ArrayList<InfoCliente> colaClientes) {
        this.colaClientes = colaClientes;
    }

    public TiempoAtencion getTiempoAtencionPromedio() {
        return tiempoAtencionPromedio;
    }

    public void setTiempoAtencionPromedio(TiempoAtencion tiempoAtencionPromedio) {
        this.tiempoAtencionPromedio = tiempoAtencionPromedio;
    }

    public int getCantTiempos() {
        return cantTiempos;
    }

    public void setCantTiempos(int cantTiempos) {
        this.cantTiempos = cantTiempos;
    }

    public Stack getPilaClientesAtendidos() {
        return pilaClientesAtendidos;
    }

    public void setPilaClientesAtendidos(Stack<InfoClienteAtendido> pilaClientesAtendidos) {
        this.pilaClientesAtendidos = pilaClientesAtendidos;
    }

    public void agregaBox(InfoBoxDisponible paquete) {

    }

    public void agregaNuevoCliente(InfoCliente paquete) {
        this.colaClientes.add(paquete);
    }

    public Informable getProximoCliente() {
        return estrategia.proximoCliente(); //por polimorfismo, se ejecutara la estrategia que corresponda
    }

    public void establecerEstrategiaFIFO(){
        this.estrategia=new EstrategiaFIFO();
    }

    public void establecerEstrategiaPorDniCreciente(){
        this.estrategia=new EstrategiaPorDniCreciente();
    }

    public void establecerEstrategiaPorDniDecreciente(){
        this.estrategia=new EstrategiaPorDniDecreciente();
    }

    public void establecerEstrategiaPorCategoria(){
        this.estrategia=new EstrategiaPorCategoria();
    }
}

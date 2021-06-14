package repositorio;

import modeloInfo.*;
import modeloUtil.TiempoAtencion;
import persistencia.Buscador;
import persistencia.Persistor;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Repositorio implements Serializable {

    private static Repositorio instance=null;
    private ArrayList<InfoCliente> colaClientes=null;
    private Stack<InfoClienteAtendido> pilaClientesAtendidos=null;
    private TiempoAtencion tiempoAtencionPromedio=null;
    private int cantTiempos=0;
    private EstrategiaProxCliente estrategia;
    private InfoCliente ultimoCliente;
    private Persistor persistor;
    private Buscador buscador;

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

    public void agregaNuevoCliente(InfoCliente paquete) {
        String[] datosSeparados= this.buscador.buscaCategoriaYNombre(paquete.getDni());
        if (datosSeparados == null){
            System.out.println("no levanta bien los datos del txt");
        }
        else {
            paquete.setCategoria(Integer.parseInt(datosSeparados[1]));
            paquete.setNombre(datosSeparados[0]);
        }
        this.colaClientes.add(paquete);
    }

    public InfoCliente getProximoCliente() {
        ultimoCliente=estrategia.proximoCliente();
        return ultimoCliente; //por polimorfismo, se ejecutara la estrategia que corresponda
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

    public void combinaBoxYCliente(InfoBoxDisponible paquete) {
        this.pilaClientesAtendidos.add(FactoryInfoClienteAtendido.getInfoClienteAtendido(ultimoCliente,paquete.getBox()));
    }

    //Recorro la pila como una lista desde el final hacia el principio,ya que cada box puede atender un unico cliente por lo que la ultima
    //aparicion de una atencion en el box pasado por parametro,sera la correcta.
    //Luego de setearle el tiempo de inicio de atencion lo persisto.Si el cliente no se presenta por el box no se persiste.
    public void agregaTiempoInicioAtencion(int box,Date tiempo) {
        int tope = this.pilaClientesAtendidos.size()-1;
        boolean boxEncontrado = false;
        InfoClienteAtendido act;
        while(tope != -1 && boxEncontrado == false) {
            act = this.pilaClientesAtendidos.get(tope);
            if(act.getBox() == box) {
                act.setFechaYHoraAtencion(tiempo);
                this.persistor.persistir(act);
                boxEncontrado = true;
            }
        }
    }

    public void setPersistor(Persistor persistor) {
        this.persistor = persistor;
    }

    public void setBuscador(Buscador buscador) {
        this.buscador = buscador;
    }
}

package prueba;

import controlador.*;
import persistencia.Buscador;
import persistencia.FactoryBuscador;
import persistencia.FactoryPersistencia;
import persistencia.Persistor;
import repositorio.Repositorio;
import servicios.ServicioEmpleado;
import servicios.ServicioMonitor;
import servicios.ServicioTotem;

public class Prueba {

    public static void main(String[] args) {
        Buscador buscador= FactoryBuscador.getInstance(args[0]);
        Persistor persistor= FactoryPersistencia.getInstance(args[1]);
        Repositorio.getInstance().setBuscador(buscador);
        Repositorio.getInstance().setPersistor(persistor);
        if (args.length==3){
            if (args[2].equals("categoria")) {
                Repositorio.getInstance().establecerEstrategiaPorCategoria();
                System.out.println("ESTRATEGIA: por categoria");
            }
            else if (args[2].equals("dnicreciente")){
                Repositorio.getInstance().establecerEstrategiaPorDniCreciente();
                System.out.println("ESTRATEGIA: por DNI creciente");
            }
            else if (args[2].equals("dnidecreciente")){
                Repositorio.getInstance().establecerEstrategiaPorDniDecreciente();
                System.out.println("ESTRATEGIA: por DNI decreciente");
            }
            else System.out.println("ERROR DE PARAMETRO: estrategia no definida");
        } else {
            Repositorio.getInstance().establecerEstrategiaFIFO();
            System.out.println("ESTRATEGIA: por orden de llegada");
        }
        ControllerDNS controllerDNS=new ControllerDNS();
        ControllerServerSecu controllerServerSecu=new ControllerServerSecu();
        ServicioEmpleado servicioEmpleado=new ServicioEmpleado();
        ControllerEmpleado controllerEmpleado = new ControllerEmpleado(servicioEmpleado);
        ServicioTotem servicioTotem=new ServicioTotem();
        ControllerTotem controllerTotem = new ControllerTotem(servicioTotem);
        ServicioMonitor servicioMonitor=new ServicioMonitor();
        ControllerMonitor controllerMonitor = new ControllerMonitor(servicioMonitor);
        Thread t1=new Thread(controllerEmpleado);
        Thread t2=new Thread(controllerTotem);
        Thread t3=new Thread(controllerMonitor);
        Thread t4=new Thread(controllerDNS);
        Thread t5=new Thread(controllerServerSecu);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

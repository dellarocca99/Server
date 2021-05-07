package prueba;

import comunicacion.ReceptorEmpleado;
import comunicacion.ReceptorMonitor;
import comunicacion.ReceptorTotem;

public class Prueba {

    public static void main(String[] args) {
        ReceptorEmpleado receptorEmpleado= ReceptorEmpleado.getInstance();
        ReceptorTotem receptorTotem= ReceptorTotem.getInstance();
        ReceptorMonitor receptorMonitor= ReceptorMonitor.getInstance();
        Thread t1=new Thread(receptorEmpleado);
        Thread t2=new Thread(receptorTotem);
        Thread t3=new Thread(receptorMonitor);
        t1.start();
        t2.start();
        t3.start();
    }
}

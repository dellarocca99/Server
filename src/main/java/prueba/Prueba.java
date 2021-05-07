package prueba;

import comunicacion.ReceptorEmpleado;
import comunicacion.ReceptorMonitor;
import comunicacion.ReceptorTotem;

public class Prueba {

    public static void main(String[] args) {
        ReceptorEmpleado receptorEmpleado= ReceptorEmpleado.getInstance();
        ReceptorTotem receptorTotem= ReceptorTotem.getInstance();
        ReceptorMonitor receptorMonitor= ReceptorMonitor.getInstance();
        receptorEmpleado.run();
        receptorTotem.run();
        receptorMonitor.run();
    }
}

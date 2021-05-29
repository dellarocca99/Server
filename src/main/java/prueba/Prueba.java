package prueba;

import controlador.ControllerEmpleado;
import controlador.ControllerMonitor;
import controlador.ControllerTotem;
import servicios.ServicioEmpleado;
import servicios.ServicioMonitor;
import servicios.ServicioTotem;

public class Prueba {

    public static void main(String[] args) {
        ServicioEmpleado servicioEmpleado=new ServicioEmpleado();
        ControllerEmpleado controllerEmpleado = new ControllerEmpleado(servicioEmpleado);
        ServicioTotem servicioTotem=new ServicioTotem();
        ControllerTotem controllerTotem = new ControllerTotem(servicioTotem);
        ServicioMonitor servicioMonitor=new ServicioMonitor();
        ControllerMonitor controllerMonitor = new ControllerMonitor(servicioMonitor);
        Thread t1=new Thread(controllerEmpleado);
        Thread t2=new Thread(controllerTotem);
        Thread t3=new Thread(controllerMonitor);
        t1.start();
        t2.start();
        t3.start();
    }
}

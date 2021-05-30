package prueba;

import controlador.*;
import servicios.ServicioEmpleado;
import servicios.ServicioMonitor;
import servicios.ServicioTotem;

public class Prueba {

    public static void main(String[] args) {
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

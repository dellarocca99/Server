package comunicacion;

import modeloPaqueteInfo.IPaquete;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Emisor {
    private static Emisor instance=null;
    private Socket socketTotem=null;
    private Socket socketEmpleado=null;
    private Socket socketMonitor=null;

    private Emisor(){

    }

    public static Emisor getInstance(){
        if (instance==null)
            instance=new Emisor();
        return instance;
    }

    public void enviarPaquete(IPaquete paquete, int dispositivo){
        try {
            ObjectOutputStream oos=null;
            switch (dispositivo){
                case 1: socketEmpleado=ReceptorEmpleado.getInstance().getSocket();
                        oos= new ObjectOutputStream(socketEmpleado.getOutputStream());
                        break;
                case 2: socketTotem=ReceptorTotem.getInstance().getSocket();
                        oos= new ObjectOutputStream(socketTotem.getOutputStream());
                        break;
                case 3: socketMonitor=ReceptorMonitor.getInstance().getSocket();
                        oos= new ObjectOutputStream(socketMonitor.getOutputStream());
                        break;
            }
            oos.writeObject(paquete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

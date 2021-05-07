package comunicacion;

import modeloPaqueteInfo.IPaquete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceptorEmpleado implements Runnable{
    private Socket socket=null;
    private static ReceptorEmpleado instance=null;
    private ServerSocket ss=null;

    private ReceptorEmpleado(){

    }

    public static ReceptorEmpleado getInstance(){
        if (instance==null)
            instance=new ReceptorEmpleado();
        return instance;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9999);
            System.out.println("Server initailized");
            socket=ss.accept();
            System.out.println("Client connected");
            while (true){
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                IPaquete paquete= (IPaquete) ois.readObject();
                if (paquete.getIdOperacion()==1){// es un mensaje del Empleado que llama al proximo cliente (PaqueteProxCliente)
                    Emisor.getInstance().enviarPaquete(paquete,3);// se lo envio al monitor
                    //

                    //aca envio a los empleados el dni para q lo borren

                    //
                } else if (paquete.getIdOperacion()==2){// es un mensaje del Empleado que notifica la duración de la última atención (PaqueteTiempoAtencion)
                    //

                    //aca hago el promedio de los tiempos de atencion

                    //
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }
}

package controlador;

import modeloInfo.FactoryInfoClienteAtendido;
import modeloInfo.InfoBoxDisponible;
import modeloInfo.InfoCliente;
import modeloInfo.InfoClienteAtendido;
import modeloInfo.InfoInicioAtencion;
import modeloInfo.Informable;
import modeloInfo.InfoTiempoAtencion;
import servicios.ServicioEmpleado;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerEmpleado implements Runnable{
    private Socket socket=null;
    private ServerSocket ss=null;
    private ServicioEmpleado servicio=null;

    public ControllerEmpleado(ServicioEmpleado servicio){
        this.servicio=servicio;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9696);
            System.out.println("Server initailized (Empleado)");
            while (true){
                socket=ss.accept();
                System.out.println("Empleado connected");
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                Informable paquete= (Informable) ois.readObject();
                switch(paquete.getIdOperacion()) {
                    case 1:// es un mensaje del Empleado que llama al proximo cliente (InfoBoxDisponible)
                        this.emiteMensaje(this.servicio.proximoCliente());
                        this.servicio.combinaBoxYCliente((InfoBoxDisponible)paquete);
                        break;
                    case 2:// es un mensaje del Empleado que notifica la duración de la última atención (InfoTiempoAtencion)
                        this.servicio.tiempoAtencion((InfoTiempoAtencion)paquete);
                        break;
                    case 3:// es un mensaje del Empleado que pregunta si hay nuevos clientes en espera (InfoPeticion)
                        this.emiteMensaje(this.servicio.recuperaNuevosClientes());
                        break;
                    case 4:// es un mensaje del Empleado que notifica el inicio de la atencion.
                        this.servicio.agregaTiempoInicioAtencion((InfoInicioAtencion)paquete);
                        break;
                }
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void emiteMensaje(Informable paquete) throws IOException {
        ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(paquete);
    }

}
package comunicacion;

import modeloPaqueteInfo.IPaquete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceptorTotem implements Runnable{
    private Socket socket=null;
    private ServerSocket ss=null;
    private static ReceptorTotem instance=null;

    private ReceptorTotem(){

    }

    public static ReceptorTotem getInstance(){
        if (instance==null)
            instance=new ReceptorTotem();
        return instance;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9797);
            System.out.println("Server initailized");
            socket=ss.accept();
            System.out.println("Client connected");
            while (true){
                ObjectInputStream ois= new ObjectInputStream(socket.getInputStream());
                IPaquete paquete= (IPaquete) ois.readObject();
                //el unico paquete que recibo del totem es el PaqueteNuevoCliente
                Emisor.getInstance().enviarPaquete(paquete,1);// se lo envio al empleado
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }
}

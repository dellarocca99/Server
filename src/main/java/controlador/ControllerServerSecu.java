package controlador;

import modeloInfo.Informable;
import repositorio.Repositorio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerServerSecu implements Runnable{
    private Socket socket;
    private ServerSocket ss;

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9393);
            System.out.println("Server initialized (ServerSecu)");
            while (true){
                socket=ss.accept();
                System.out.println("ServerSecu connected");
                ObjectInputStream ois= new ObjectInputStream(socket.getInputStream());
                Informable paquete= (Informable) ois.readObject();
                ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(Repositorio.getInstance());
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

package comunicacion;

import modeloPaqueteInfo.IPaquete;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceptorMonitor implements Runnable{
    private Socket socket=null;
    private ServerSocket ss=null;
    private static ReceptorMonitor instance=null;

    private ReceptorMonitor(){

    }

    public static ReceptorMonitor getInstance(){
        if (instance==null)
            instance=new ReceptorMonitor();
        return instance;
    }

    @Override
    public void run() {
        try {
            ss=new ServerSocket(9797);
            System.out.println("Server initailized");
            socket=ss.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }
}

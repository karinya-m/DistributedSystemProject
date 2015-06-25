package project3task5;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class communicates between server and client
 *
 * @author Karinya
 */
public class Binder_Skeleton {

    Binder myBinder;

    public Binder_Skeleton(Binder b) {
        myBinder = b;
    }

    /**
     * This method runs definitely waiting for request for bind and lookup method, and perform the action accordingly.
     */
    public void serve() {
        try {
            ServerSocket s = new ServerSocket(9090);
            while (true) {
                Socket socket = s.accept();               
                ObjectInputStream i = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
                //get input as array of object, containing method name and argument for method.
                Object[] msg = (Object[]) i.readObject();
                if (msg[0].equals("lookup")) {
                    String name = msg[1].toString();
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    o.writeObject(myBinder.lookup(name));
                    o.flush();
                } else if (msg[0].equals("bind")) {
                    myBinder.bind(msg[1].toString(), (RemoteObjectReference) msg[2]);
                }
            }
        } catch (Exception t) {
            System.out.println("Error " + t);
            System.exit(0);
        }
    }
}

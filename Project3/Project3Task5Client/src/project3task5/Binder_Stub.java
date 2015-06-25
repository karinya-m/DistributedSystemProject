package project3task5;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represent binder stub, connects to registry to store and look up data.
 * @author Karinya
 */
public class Binder_Stub implements Binder {
    // create an IP address of a reistry, in this case local host

    static final String inet = "127.0.0.1";

    /**
     * This method connects to registry and looks for remote object of the given
     * name
     *
     * @param name
     * @return remote object of that person
     */
    public RemoteObjectReference lookup(String name) {
        Socket s = null;
        try {

            // the selected port of a registry is 9090
            int serverPort = 9090;
            // create a socket that connects to the registry
            s = new Socket(inet, serverPort);

            // create an oupput stream object
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            // write the object to the server. The first argument indicates a name of the method,
            // the second of argument is a name that is needed to be looked up.
            out.writeObject(new Object[]{"lookup", name});
            out.flush();
            // create an input stream object and then read object from the registry           
            ObjectInputStream in = new ObjectInputStream(new DataInputStream(s.getInputStream()));
            Object o = in.readObject();
            return (RemoteObjectReference) o;

        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound:" + ex.getMessage());
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * This method stores pair value of a person name and remote object in
     * registry.
     *
     * @param name
     * @param obj
     */
    public void bind(String name, RemoteObjectReference obj) {
        Socket s = null;
        try {
            // define a port of registry, in this case 9090
            int serverPort = 9090;
            // create a socket to connect to registry
            s = new Socket(inet, serverPort);
            // create an ouput stream of an object
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            // write the object to the registry. 
            // The arguments are method name, name to be looked up, and remote object reference.
            out.writeObject(new Object[]{"bind", name, obj});
            out.flush();
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());

                }
            }
        }
    }
}

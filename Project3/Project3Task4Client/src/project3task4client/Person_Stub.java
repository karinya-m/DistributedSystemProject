package project3task4client;

// file: Person_Stub.java found only on the client side 
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * This class implements Person interface. It interacts with server.
 *
 * @author Karinya
 */
public class Person_Stub implements Person {

    Socket socket;
    ObjectOutputStream o;
    ObjectInputStream i;

    public Person_Stub() throws Exception {
    }

    /**
     * get person's ID number
     *
     * @return ID of a person
     * @throws Exception
     */
    public int getID() throws Exception {
        // create a socket to connect to server
        socket = new Socket("localhost", 9000);
        // create output stream, write and send to server
        o = new ObjectOutputStream(socket.getOutputStream());
        o.writeObject("ID");
        o.flush();
        //create input stream and get response
        i = new ObjectInputStream(socket.getInputStream());
        int ret = i.readInt();
        socket.close();
        return ret;
    }

    /**
     * get person's name
     *
     * @return name of a person
     * @throws Exception
     */
    public String getName() throws Exception {
        // create a socket to connect to server
        socket = new Socket("localhost", 9000);
        // create output stream, write and send to server
        o = new ObjectOutputStream(socket.getOutputStream());
        o.writeObject("name");
        o.flush();
        //create input stream and get response
        i = new ObjectInputStream(socket.getInputStream());
        String ret = (String) (i.readObject());
        socket.close();
        return (String) ret;
    }
}

package project3task5;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class represents person and communicate to server
 *
 * @author Karinya
 */
public class Person_Stub implements Person {

    RemoteObjectReference obj_ref;
    // counter for request ID
    static int count = 0;

    public Person_Stub(RemoteObjectReference obj_ref) {
        this.obj_ref = obj_ref;
    }

    /**
     * This method connect to server and gets ID of the person
     *
     * @return ID of the person
     * @throws Exception
     */
    public int getID() throws Exception {
        // create a request-reply message
        RequestReplyMessage r = new RequestReplyMessage();
        r.setRemoteObjectReference(obj_ref);
        // type = 0 --> request message
        r.setMessageType(0);
        // id = 0 --> getID
        r.setMethodID(0);
        r.setRequestID(count++);
        // create a socket to the server
        Socket s = new Socket((new String(obj_ref.getIPAddress())), obj_ref.getPortNumber());
        // Person creates an object output stream in getID and write the object to request0reply message
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(r);
        out.flush();
        // create an input stream of an object
        ObjectInputStream in = new ObjectInputStream(new DataInputStream(s.getInputStream()));
        // read request-reply message from the server
        RequestReplyMessage o = (RequestReplyMessage) in.readObject();
        s.close();
        return Integer.parseInt(new String(o.getArguments()));
    }

    /**
     * This method connects to server and gets name of the person
     *
     * @return name of the person
     * @throws Exception
     */
    public String getName() throws Exception {
        // create a request-reply message
        RequestReplyMessage r = new RequestReplyMessage();
        r.setRemoteObjectReference(obj_ref);
        // type = 0 --> request message
        r.setMessageType(0);
        // id = 1 --> getname
        r.setMethodID(1);
        r.setRequestID(count++);
        // create a socket to the server
        Socket s = new Socket((new String(obj_ref.getIPAddress())), obj_ref.getPortNumber());
        // Person creates an object output stream in getID and write the object to request0reply message
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(r);
        out.flush();
        // create an input stream of an object
        ObjectInputStream in = new ObjectInputStream(new DataInputStream(s.getInputStream()));
        // read request-reply message from the server
        RequestReplyMessage o = (RequestReplyMessage) in.readObject();
        s.close();
        return (new String(o.getArguments()));
    }
}

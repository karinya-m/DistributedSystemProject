package project3task5;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class contains serve method that runs indefinitely, waiting for client
 * request.
 *
 * @author Karinya
 */
public class Person_Skeleton {

    Person p;
    RequestReplyMessage msg_out = new RequestReplyMessage();
    static int count = 0;

    public Person_Skeleton(Person p) {
        this.p = p;
    }

    /**
     * This method runs indefinitely, waiting for client request for name/ID.
     */
    public void serve() {
        try {
            ServerSocket s = new ServerSocket(9000);
            //keeps waiting for request
            while (true) {
                // accept an incoming socket
                Socket socket = s.accept();
                // create input and output stream objects
                ObjectInputStream i = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
                ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                // read a message from a client
                RequestReplyMessage msg_in = (RequestReplyMessage) i.readObject();
                // for getId method
                if (msg_in.getMethodID() == 0) {
                    // type = 1 --> reply message
                    msg_out.setMessageType(1);
                    msg_out.setMethodID(0);
                    msg_out.setRequestID(count++);
                    msg_out.setArguments(Integer.toString(p.getID()).getBytes());
                    o.writeObject(msg_out);
                    o.flush();
                    // for getName method
                } else if (msg_in.getMethodID() == 1) {
                    msg_out.setMessageType(1);
                    msg_out.setMethodID(1);
                    msg_out.setRequestID(count++);
                    msg_out.setArguments(p.getName().getBytes());
                    o.writeObject(msg_out);
                    o.flush();
                }
            }
        } catch (Exception t) {
            System.out.println("Error " + t);
            System.exit(0);
        }
    }
}

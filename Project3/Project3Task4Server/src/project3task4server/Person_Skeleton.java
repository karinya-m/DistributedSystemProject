package project3task4server;


// file: Person_Skeleton.java exists only on the server side 
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * This class communicates with clients.
 *
 * @author Karinya
 */
public class Person_Skeleton {

    Person myServer;

    public Person_Skeleton(Person s) {
        myServer = s;
    }

    /**
     * This method responses to a request by getting ID or name and send it
     * back.
     */
    public void serve() {
        try {
            ServerSocket s = new ServerSocket(9000);
            //keeps waiting for request
            while (true) {
                //accept connection
                Socket socket = s.accept();
                //create input stream
                ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
                //read method name from object sent and do action accordingly
                String method = (String) i.readObject();
                if (method.equals("ID")) {
                    int a = myServer.getID();
                    //create output stream, put resonse and reply to client
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    o.writeInt(a);
                    o.flush();
                } else if (method.equals("name")) {
                    String n = myServer.getName();
                    //create output stream, put resonse and reply to client
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    o.writeObject(n);
                    o.flush();
                }
            }
        } catch (Exception t) {
            System.out.println("Error " + t);
            System.exit(0);
        }
    }
}

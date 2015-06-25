package project3task3;

/**
 * This class represents TCP server
 *
 * @author Karinya
 */
import java.net.*;
import java.io.*;
import java.util.Random;

public class TCPServer {

    /**
     * This main class creates socket and keep waiting for request and create
     * new connection
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());

        }
    }
}

/**
 * This class represents connection for TCP server
 *
 * @author Karinya
 */
class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    static Random rnd = new Random();

    /**
     * Constructor that initialize socket, input and output stream
     *
     * @param aClientSocket
     */
    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    /**
     * This method reads request and sends back the response.
     */
    public void run() {
        try {			                 // an echo server
            String response = "";
            String data = in.readUTF();	                  // read a line of data from the stream
            if (isApproved()) {
                response = "The plan to " + data + " has been approved.";
            } else {
                response = "The plan to " + data + " has been rejected.";
            }
            String cipher = CaesarCipher.encrypt(response);
            out.writeUTF(cipher);
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/

            }
        }
    }

    /**
     * This method decides if the plan should be approved (50% chance)
     *
     * @return true if approved, false otherwise.
     */
    private boolean isApproved() {
        if (rnd.nextInt(10) < 5) {
            return true;
        } else {
            return false;
        }

    }
}
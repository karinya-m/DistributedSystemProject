package project3task3;

/**
 * This class represents TCP client.
 *
 * @author Karinya
 */
import java.net.*;
import java.io.*;

public class TCPClient {

    /**
     * This main method receive input from user and connect to server to see if
     * the plan is approved.
     *
     * @param args
     */
    public static void main(String args[]) {
        // arguments supply message and hostname
        Socket s = null;
        try {
            int serverPort = 7896;
            s = new Socket(args[1], serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(args[0]);
            String data = in.readUTF();
            //decript the response from server
            String plaintext = CaesarCipher.decrypt(data);
            System.out.println("Received: " + plaintext);
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
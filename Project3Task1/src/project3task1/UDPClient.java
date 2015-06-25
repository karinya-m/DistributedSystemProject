package project3task1;

import java.net.*;
import java.io.*;

/**
 * This class represents UDP client.
 *
 * @author Karinya
 */
public class UDPClient {

    /**
     * Main method receives input from command line and do operation accordingly
     *
     * @param args
     */
    public static void main(String args[]) {
        // args give message contents and destination hostname
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            // get input equation from arguments and put them into message to be sent
            byte[] m = (args[0] + " " + args[1] + " " + args[2]).getBytes();
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            DatagramPacket request =
                    new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
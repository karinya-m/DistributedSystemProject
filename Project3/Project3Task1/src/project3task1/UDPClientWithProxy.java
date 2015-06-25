package project3task1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * This class UDP client that uses proxy
 *
 * @author Karinya
 */
public class UDPClientWithProxy {

    /**
     * Main method calculates addition of 1-100
     *
     * @param args
     */
    public static void main(String args[]) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = add(sum, i);
        }
        System.out.println("Sum of 1-100 is " + sum);
    }

    /**
     * This method connect to server to do math operation for the 2 input
     * parameters.
     *
     * @param x
     * @param y
     * @return
     */
    public static int add(int x, int y) {
        // args give message contents and destination hostname
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            // get input equation from arguments and put them into message to be sent
            byte[] m = (x + " " + "+" + " " + y).getBytes();
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            DatagramPacket request =
                    new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            return (int) (Double.parseDouble(new String(reply.getData())));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
        return -1;
    }
}

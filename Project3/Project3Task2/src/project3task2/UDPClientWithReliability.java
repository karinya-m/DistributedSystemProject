package project3task2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * This class represent UDP client that keep resend msg if it does not receive a
 * reply.
 *
 * @author Karinya
 */
public class UDPClientWithReliability {

    /**
     * This main method adds up 1-100
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
     * This method connect to server to do add operation of the 2 numbers
     *
     * @param x
     * @param y
     * @return result of the addition
     */
    public static int add(int x, int y) {
        //resend request if there is no reply in 2 seconds
        while (true) {
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
                aSocket.setSoTimeout(2000);
                aSocket.receive(reply);
                return (int) (Double.parseDouble(new String(reply.getData())));
            } catch (SocketTimeoutException e) {
                System.out.println("Socket: " + e.getMessage());
                System.out.println("Resend request");

            } catch (SocketException e) {
                System.out.println("Socket: " + e.getMessage());
                return 0;
            } catch (IOException e) {
                System.out.println("IO: " + e.getMessage());
                return 0;
            } finally {
                if (aSocket != null) {
                    aSocket.close();
                }
            }
        }
    }
}

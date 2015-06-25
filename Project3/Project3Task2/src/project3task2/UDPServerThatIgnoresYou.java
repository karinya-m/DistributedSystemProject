
package project3task2;


import java.net.*;
import java.io.*;
import java.util.Random;

/**
 * This Class represents UDP server with 70% rejection
 *
 * @author Karinya
 */
public class UDPServerThatIgnoresYou {

    static Random rnd = new Random();

    /**
     * This main method keep waiting for request but will reject 70% of the
     * request it received.
     *
     * @param args
     */
    public static void main(String args[]) {
        DatagramSocket aSocket = null;
        try {
            // create socket at 6789 port
            aSocket = new DatagramSocket(6789);

            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                // reject at 70% chance
                if (rnd.nextInt(10) < 7) {
                    System.out.println("Got request "
                            + new String(request.getData())
                            + " but ignoring it.");
                    continue;
                } else {
                    System.out.println("Got request"
                            + new String(request.getData()));
                    // receive byte array of equation and put it in string
                    String equation = new String(request.getData());
                    String answer = "";
                    String[] split = equation.split(" ");
                    // parse string to double and calculate
                    String op = split[1];
                    double var1 = Double.parseDouble(split[0]);
                    double var2 = Double.parseDouble(split[2]);
                    if (op.equals("+")) {
                        answer = Double.toString(var1 + var2);
                    } else if (op.equals("-")) {
                        answer = Double.toString(var1 - var2);
                    } else if (op.toLowerCase().equals("X") || op.toLowerCase().equals("x")) {
                        answer = Double.toString(var1 * var2);
                    } else if (op.equals("/")) {
                        answer = Double.toString(var1 / var2);
                    }
                    // sent back answer
                    DatagramPacket reply = new DatagramPacket(answer.getBytes(), (answer.getBytes()).length,
                            request.getAddress(), request.getPort());
                    aSocket.send(reply);
                }
            }
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

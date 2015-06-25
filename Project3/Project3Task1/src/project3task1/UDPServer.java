package project3task1;

/**
 * This class represent UDP server
 *
 * @author Karinya
 */
import java.net.*;
import java.io.*;

public class UDPServer {

    /**
     * Main method keeps waiting for request and do math operation accordingly
     *
     * @param args
     */
    public static void main(String args[]) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                //receive byte array of equation and put it in string
                String equation = new String(request.getData());
                String answer = "";
                String[] split = equation.split(" ");
                // parse to integer and calculate
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
                // send answer back
                DatagramPacket reply = new DatagramPacket(answer.getBytes(), (answer.getBytes()).length,
                        request.getAddress(), request.getPort());
                aSocket.send(reply);
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

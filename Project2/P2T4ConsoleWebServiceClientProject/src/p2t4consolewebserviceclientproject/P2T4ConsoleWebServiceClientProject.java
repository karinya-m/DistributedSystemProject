/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t4consolewebserviceclientproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Karinya
 */
public class P2T4ConsoleWebServiceClientProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //get input from user
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the hotel ID:");
            int hotelID = keyboard.nextInt();

            System.out.println("Enter number of rooms you want to book:");
            int rooms_num = keyboard.nextInt();

            System.out.println("Enter car rental ID:");
            int carID = keyboard.nextInt();

            System.out.println("Enter number of cars you want to book:");
            int cars_num = keyboard.nextInt();

            System.out.println("Enter the airline ID:");
            int planeID = keyboard.nextInt();

            System.out.println("Enter number of seats you want to book:");
            int seats_num = keyboard.nextInt();

            //output result of booking
            if (bookTrip(hotelID, rooms_num, carID, cars_num, planeID, seats_num)) {
                System.out.println("Trip booked.");
            } else {
                System.out.println("Error: Trip cannot be booked. One or more constraints are violated.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid Input");
            System.exit(0);
        }


    }

    /**
     *
     * bookTrip method from web service
     *
     * @return true if successfully booked
     */
    private static boolean bookTrip(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        p2t2webserviceproject.BookTripWebService_Service service = new p2t2webserviceproject.BookTripWebService_Service();
        p2t2webserviceproject.BookTripWebService port = service.getBookTripWebServicePort();
        return port.bookTrip(arg0, arg1, arg2, arg3, arg4, arg5);
    }
}

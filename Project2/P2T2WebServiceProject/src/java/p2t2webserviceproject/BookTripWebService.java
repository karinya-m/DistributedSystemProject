/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t2webserviceproject;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Web service to book trip and update available amount of hotel rooms, cars, and plane seats
 * 
 * @author Karinya
 */
@WebService(serviceName = "BookTripWebService")
public class BookTripWebService {

    /**
     * book and update available cars, plane seats, hotel rooms when trip is booked
     *
     * @param hotelID ID of a hotel
     * @param numRooms number of rooms available
     * @param carID ID of a car
     * @param numCars number of cars available
     * @param planeID ID of a plane
     * @param numSeats number of seats available
     * @return true, if successfully updated, false otherwise.
     */
    @WebMethod(operationName = "bookTrip")
    public boolean bookTrip(int hotelID, int numRooms, int carID, int numCars, int planeID, int numSeats){
        //check if input numbers are valid (not minus)
        if (hotelID < 0 || numRooms < 0 || carID < 0 || numCars < 0 || planeID < 0 || numSeats < 0) {
            return false;
        }
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Trip", "karinya", "karinya");
        } catch (Exception e) {
            //cannot connect
            return false;
        }

        try {
            //do not commit changes to database until everything can be booked
            con.setAutoCommit(false);

            Hotel bookHotel = new Hotel();
            bookHotel.read(hotelID, con);

            Car bookCar = new Car();
            bookCar.read(carID, con);

            Plane bookPlane = new Plane();
            bookPlane.read(planeID, con);

            //Set new available numbers
            bookHotel.setRooms_avail(bookHotel.getRooms_avail() - numRooms);
            bookCar.setCars_avail(bookCar.getCars_avail() - numCars);
            bookPlane.setSeats_avail(bookPlane.getSeats_avail() - numSeats);

            bookHotel.update(con);
            bookCar.update(con);
            bookPlane.update(con);

            //commit once everything can be booked
            con.commit();
            System.out.println("Trip booked");
        } catch (Exception e) {
            try {
                //roll back when at least one thing cannot be booked
                System.out.println("Booking aborted - Rolling back changes.");
                con.rollback();
            } catch (Exception re) {
                System.out.println("Problem doing rollback. Exception " + re);
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
}

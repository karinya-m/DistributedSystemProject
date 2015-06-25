/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2t2webserviceproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represent car in database
 *
 * @author Karinya
 */
public class Car {
    // A simple Car object - wraps a row in the Car table.

    private int ID;
    private String name;
    private String location;
    private String URL;
    private int cars_avail;

    public String toString() {
        return "ID " + ID + "\t" + "Name " + name + "\t" + "location "
                + location + "\t" + "URL " + URL + "\t" + "car available "
                + cars_avail;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {

        name = n;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String s) {

        URL = s;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loc) {
        location = loc;
    }

    public int getCars_avail() {

        return cars_avail;
    }

    public void setCars_avail(int amt) {
        cars_avail = amt;
    }

    /**
     * create car record to database
     *
     * @param ID ID of a car rental
     * @param name name of car rental
     * @param location location of car rental
     * @param URL URL of the car rental
     * @param amt_avail number of cars available
     * @param con database connection
     */
    public void create(int ID, String name, String location, String URL, int amt_avail, Connection con)
            throws SQLException, Exception {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.URL = URL;
        this.cars_avail = amt_avail;

        PreparedStatement statement = null;

        // prepare statement and update it to database.
        try {
            statement = con.prepareStatement("Insert into app.Car (ID,"
                    + "name, location, URL, cars_avail)"
                    + "Values ( ?,?,?,?,?)");
            statement.setInt(1, this.ID);
            statement.setString(2, this.name);
            statement.setString(3, this.location);
            statement.setString(4, this.URL);
            statement.setInt(5, this.cars_avail);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Caught exception in create" + e);
            throw new Exception(e);
        } //always close connection
        finally {
            if (statement != null) {
                statement.close();

            }
        }
    }

    /**
     * read car record to database
     *
     * @param ID ID of a car rental
     * @param con database connection
     */
    public void read(int ID, Connection con) throws SQLException, RecordNotFoundException {

        PreparedStatement statement = null;
        try {
            //prepare statement and get record from database
            statement = con.prepareStatement("Select name, location, URL, cars_avail FROM app.Car"
                    + " where ID = ?");
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                this.ID = ID;
                this.name = result.getString(1);
                this.location = result.getString(2);
                this.URL = result.getString(3);
                this.cars_avail = result.getInt(4);
            } else {
                System.out.println("Could not read a record");
                throw new RecordNotFoundException();
            }
        } //always close connection
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * update car record to database
     *
     * @param con database connection
     */
    public void update(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Update app.Car set name = ?,"
                    + "location = ?, URL = ?, cars_avail = ?"
                    + "where ID = ?");
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setString(3, URL);
            statement.setInt(4, cars_avail);
            statement.setInt(5, ID);

            statement.executeUpdate();
        } //always close connection
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * delete car record to database
     *
     * @param con database connection
     */
    public void delete(Connection con) throws SQLException {
        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Delete from app.Car Where ID = ?");
            statement.setInt(1, ID);
            int h = statement.executeUpdate();
            System.out.println("Tried to delete " + ID + " Changed " + h + " records");
        } //always close connection
        finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    /**
     * delete car record to database
     *
     * @param ID ID of a car rental
     * @param con database connection
     */
    public void delete(int ID, Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Delete from app.Car Where ID = ?");
            statement.setInt(1, ID);
            statement.executeUpdate();
        } //always close connection
        finally {
            if (statement != null) {
                statement.close();
            }
        }

    }
}

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
 * represent Plane in database
 *
 * @author Karinya
 */
public class Plane {

    // Professional Java Server Programming J2EE Edition (modified)
    // A simple Plane object - wraps a row in the Plane table.
    private int ID;
    private String name;
    private String location;
    private String URL;
    private int seats_avail;

    public String toString() {
        return "ID " + ID + "\t" + "Name " + name + "\t" + "location "
                + location + "\t" + "URL " + URL + "\t" + "seat available "
                + seats_avail;
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

    public int getSeats_avail() {

        return seats_avail;
    }

    public void setSeats_avail(int amt) {
        seats_avail = amt;
    }

    /**
     * create plane record to database
     *
     * @param ID ID of airline
     * @param name name of airline
     * @param location location of airline
     * @param URL URL of airline
     * @param amt_avail number of seats available
     * @param con database connection
     */
    public void create(int ID, String name, String location, String URL, int amt_avail, Connection con)
            throws SQLException, Exception {

        this.ID = ID;
        this.name = name;
        this.location = location;
        this.URL = URL;
        this.seats_avail = amt_avail;

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Insert into app.Plane (ID,"
                    + "name, location, URL, seats_avail)"
                    + "Values ( ?,?,?,?,?)");
            statement.setInt(1, this.ID);
            statement.setString(2, this.name);
            statement.setString(3, this.location);
            statement.setString(4, this.URL);
            statement.setInt(5, this.seats_avail);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Caught exception in create" + e);
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();

            }
        }
    }

    /**
     * read plane record to database
     *
     * @param ID ID of airline
     * @param con database connection
     */
    public void read(int ID, Connection con) throws SQLException, RecordNotFoundException {

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Select name, location, URL, seats_avail FROM app.Plane"
                    + " where ID = ?");

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                this.ID = ID;
                this.name = result.getString(1);
                this.location = result.getString(2);
                this.URL = result.getString(3);
                this.seats_avail = result.getInt(4);

            } else {
                System.out.println("Could not read a record");
                throw new RecordNotFoundException();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * update plane record to database
     *
     * @param con database connection
     */
    public void update(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Update app.Plane set name = ?,"
                    + "location = ?, URL = ?, seats_avail = ?"
                    + "where ID = ?");

            statement.setString(1, name);
            statement.setString(2, location);
            statement.setString(3, URL);
            statement.setInt(4, seats_avail);
            statement.setInt(5, ID);

            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * delete plane record to database
     *
     * @param con database connection
     */
    public void delete(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Delete from app.Plane Where ID = ?");
            statement.setInt(1, ID);
            int h = statement.executeUpdate();
            System.out.println("Tried to delete " + ID + " Changed " + h + " records");
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    /**
     * create plane record to database
     *
     * @param ID ID of airline
     * @param con database connection
     */
    public void delete(int ID, Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Delete from app.Plane Where ID = ?");
            statement.setInt(1, ID);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }
}

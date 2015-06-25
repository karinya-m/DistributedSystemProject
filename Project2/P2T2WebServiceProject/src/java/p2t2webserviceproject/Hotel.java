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
 * represent Hotel in database
 *
 * @author Karinya
 */
public class Hotel {

    // Professional Java Server Programming J2EE Edition (modified)
    // A simple Hotel object - wraps a row in the Hotel table.
    private int ID;
    private String name;
    private String location;
    private String URL;
    private int rooms_avail;

    public String toString() {
        return "ID " + ID + "\t" + "Name " + name + "\t" + "location "
                + location + "\t" + "URL " + URL + "\t" + "room available "
                + rooms_avail;
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

    public int getRooms_avail() {

        return rooms_avail;
    }

    public void setRooms_avail(int amt) {
        rooms_avail = amt;
    }

    /**
     * create hotel record to database
     *
     * @param ID ID of a hotel
     * @param name name of hotel
     * @param location location of hotel
     * @param URL URL of a hotel
     * @param amt_avail number of rooms available
     * @param con database connection
     */
    public void create(int ID, String name, String location, String URL, int amt_avail, Connection con)
            throws SQLException, Exception {

        this.ID = ID;
        this.name = name;
        this.location = location;
        this.URL = URL;
        this.rooms_avail = amt_avail;

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Insert into app.Hotel (ID,"
                    + "name, location, URL, rooms_avail)"
                    + "Values ( ?,?,?,?,?)");
            statement.setInt(1, this.ID);
            statement.setString(2, this.name);
            statement.setString(3, this.location);
            statement.setString(4, this.URL);
            statement.setInt(5, this.rooms_avail);

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
     * read hotel record to database
     *
     * @param ID ID of a hotel
     * @param con database connection
     */
    public void read(int ID, Connection con) throws SQLException, RecordNotFoundException {

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Select name, location, URL, rooms_avail FROM app.Hotel"
                    + " where ID = ?");

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                this.ID = ID;
                this.name = result.getString(1);
                this.location = result.getString(2);
                this.URL = result.getString(3);
                this.rooms_avail = result.getInt(4);

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
     * update hotel record to database
     *
     * @param con database connection
     */
    public void update(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Update app.Hotel set name = ?,"
                    + "location = ?, URL = ?, rooms_avail = ?"
                    + "where ID = ?");

            statement.setString(1, name);
            statement.setString(2, location);
            statement.setString(3, URL);
            statement.setInt(4, rooms_avail);
            statement.setInt(5, ID);

            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * delete hotel record to database
     *
     * @param con database connection
     */
    public void delete(Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Delete from app.Hotel Where ID = ?");
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
     * delete hotel record to database
     *
     * @param ID ID of a hotel
     * @param con database connection
     */
    public void delete(int ID, Connection con) throws SQLException {

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Delete from app.Hotel Where ID = ?");
            statement.setInt(1, ID);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task4client;

/**
 * This class contains main method that gets ID and name of a person and print
 * them out.
 *
 * @author Karinya
 */
public class PersonClient {

    /**
     * Main method gets ID and name of a person and print them out.
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            Person p = new Person_Stub();
            int id = p.getID();
            System.out.println("ID = " + id);
            String name = p.getName();
            System.out.println(name + " has ID number" + id);
        } catch (Exception t) {
            t.printStackTrace();
            System.exit(0);
        }
    }
}


package project3task4server;

/**
 * This class implements Person. Provide person info, when requested.
 *
 * @author Karinya
 */
public class Person_Servant implements Person {

    int id;
    String name;

    public Person_Servant(String n, int i) {
        name = n;
        id = i;
    }

    /**
     * Provide ID of the person
     *
     * @return ID number
     */
    public int getID() {
        return id;
    }

    /**
     * Provide name of the person
     *
     * @return name of the person
     */
    public String getName() {
        return name;
    }
}

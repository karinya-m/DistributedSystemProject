package project3task5;

/**
 * This interface represents person.
 *
 * @author Karinya
 */
// file: Person.java on both the client and server side 
public interface Person {

    /**
     * This method gets ID of a person
     * @return ID of a person
     * @throws Exception 
     */
    public int getID() throws Exception;

    /**
     * This method returns name of a person
     * @return name of a person
     * @throws Exception 
     */
    public String getName() throws Exception;
}

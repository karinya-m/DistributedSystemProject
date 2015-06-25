
package project3task4server;

/**
 * Clsss PersonServer contains main method that creates person servant and put
 * it in skeleton, then wait for request.
 *
 * @author Karinya
 */
public class PersonServer {

    /**
     * This method creates person servant and put it in skeleton, then wait for
     * request.
     *
     * @param args
     */
    public static void main(String args[]) {
        Person p = new Person_Servant("Mike", 23);
        Person_Skeleton ps = new Person_Skeleton(p);
        ps.serve();
    }
}

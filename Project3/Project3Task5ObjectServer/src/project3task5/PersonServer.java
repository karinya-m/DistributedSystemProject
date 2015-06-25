
package project3task5;

/**
 * This class contains main method for person server
 * @author Karinya
 */
public class PersonServer {
    
    /**
     * This main method creates person and send the pair to store at registry, then run its server.
     * @param args 
     */
      public static void main(String args[]) {
        // create a person and set all parameters
        Person_Servant p = new Person_Servant("Mike",23);
        RemoteObjectReference r = new RemoteObjectReference();
        r.setIPAddress("127.0.0.1".getBytes());
        r.setPortNumber(9000);
        // create a binder stub and bind it to a registry
        Binder_Stub stub = new Binder_Stub();
        stub.bind("Mike", r);
        // create a person skeleton to run a server
        Person_Skeleton skeleton = new Person_Skeleton(p);
        skeleton.serve();
    }

}

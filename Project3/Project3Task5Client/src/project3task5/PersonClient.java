
package project3task5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains main method that looks for person information from registry and server.
 * @author Karinya
 */
public class PersonClient {
    
    /**
     * This main method gets person's reference object from registry then look for ID and name from the server.
     * @param args 
     */
    public static void main(String args[]) { 
     try {
            // create a bider stub
            Binder_Stub b = new Binder_Stub();
            // look up for Mike using binder stub
            RemoteObjectReference obj = b.lookup("Mike");
            // create a person stub to retrieve ID and name
            Person_Stub p = new Person_Stub(obj);
            int id = p.getID();
            String name = p.getName();
            System.out.println(name +" has an ID of "+id);
        }
        catch (Exception ex) {
            Logger.getLogger(PersonClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  
}




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * This class represents writer that writes to the server.
 * @author Karinya
 */
public class WriterClient {

    /**
     * This main method keeps getting input from user and write it to server.
     * @param args
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception {
        String name = "";
        boolean isNameNotExist = false;
        System.out.println("Please enter your name.");
        // read a text that a user types in.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // get a remote reference to the ChatList object from rmiregistry.
        ChatList c = (ChatList) Naming.lookup("//localhost/ChatList");

        // collect a name of the client, and add to client list if not already exist
        do {
            name = in.readLine();
            isNameNotExist = c.newName(name);
            if (!isNameNotExist) {
                System.out.println("The name is already existed. Please enter anoter name: ");
            }
        } while (!isNameNotExist);

        while (true) {
            try {
                // prompt the user and get message                  
                System.out.print(name + " >");
                String line = in.readLine();
                // if "!" is entered, exit the program, remove client name and exit                  	
                if (line.equals("!")) {
                    c.deleteName(name);
                    System.exit(0);
                }
                // if it's not empty, add a new line to the server.                
                if (!line.equals("")) {
                    c.newChat(name + "> " + line);
                }
            } catch (RemoteException e) {
                System.out.println("Remote exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Client: " + e.getMessage());
            }
        }
    }
}

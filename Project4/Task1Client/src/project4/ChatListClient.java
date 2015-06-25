
package project4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * This class contains main method for chat client.
 *
 * @author Karinya
 */
public class ChatListClient {

    /**
     * This main method receive message from user and send to server via remote
     * object, then wait for response from server.
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        BufferedReader in =
                new BufferedReader(
                new InputStreamReader(System.in));
        // get a remote reference to ChatList object from rmiregistry.         
        ChatList chatListObj = (ChatList) Naming.lookup("//localhost/ChatList");
        while (true) {
            try {
                // prompt the user and get message                  
                System.out.print("client>");
                String line = in.readLine();
                // if "!" is entered, exit the program                  	
                if (line.equals("!")) {
                    System.exit(0);
                }
                // if it's not empty, add a new line to the server.
                // then print out all chats in the Vector received from the server.                 
                if (!line.equals("")) {
                    chatListObj.newChat(line);
                    Vector sList = chatListObj.allChats();
                    for (int i = 0; i < sList.size(); i++) {
                        String g = ((Chat) sList.elementAt(i)).getAllState();
                        System.out.println(g);
                    }
                }
            } catch (RemoteException e) {
                System.out.println("Remote exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Client: " + e.getMessage());
            }
        }
    }
}

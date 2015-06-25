

import java.rmi.*;

/**
 * This class contains main method for the chat server.
 *
 * @author Karinya
 */
public class ChatServer {

    /**
     * Main method creates object of ChatListServant and put it into rmiregistry
     *
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("Main OK");
        try {
            ChatList mychatlist = new ChatListServant();
            System.out.println("ChatList created");
            // bind mychatlist object with the rmi registry.
            Naming.rebind("ChatList", mychatlist);
            System.out.println("ChatList server ready");
        } catch (Exception e) {
            System.out.println("ChatList server main " + e.getMessage());
        }
    }
}

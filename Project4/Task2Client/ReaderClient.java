
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * This class represents a reader that reads from server.
 *
 * @author Karinya
 */
public class ReaderClient extends UnicastRemoteObject implements ChatList {

    public ReaderClient() throws Exception {
    }
    public ChatList c;

    /**
     * This main method reads users' input from servers.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        ReaderClient o = new ReaderClient();
        // get a remote reference to the ChatList object from rmiregistry.	
        o.c = (ChatList) Naming.lookup("//localhost/ChatList");
        o.c.registration(o);

    }

    /**
     * This method will get a vector from the MyChatList vector and then print
     * out the last message in the vector
     *
     * @throws RemoteException
     */
    public void print() throws RemoteException {

        try {
            // get a vector that contains all lines of chats.
            Vector sList = c.allChats();
            System.out.println(((Chat) sList.lastElement()).getAllState());
        } catch (RemoteException e) {
            System.out.println("allComments: " + e.getMessage());
        }
    }

    /**
     * This method is not implemented here
     *
     * @param s
     * @return
     * @throws RemoteException
     */
    public Chat newChat(String s) throws RemoteException {
        return null;
    }

    /**
     * This method is not implemented here
     *
     * @return
     * @throws RemoteException
     */
    public Vector allChats() throws RemoteException {
        return null;
    }

    /**
     * This method is not implemented here
     *
     * @return
     * @throws RemoteException
     */
    public int getVersion() throws RemoteException {
        return -1;
    }

    /**
     * This method is not implemented here
     *
     * @param l
     * @throws RemoteException
     */
    public void registration(ChatList l) throws RemoteException {
    }

    /**
     * This method is not implemented here
     *
     * @param s
     * @return
     * @throws RemoteException
     */
    public boolean newName(String s) throws RemoteException {
        return false;
    }

    /**
     * This method is not implemented here
     *
     * @param s
     * @return
     * @throws RemoteException
     */
    public boolean deleteName(String s) throws RemoteException {
        return false;
    }
}



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * ChatListServant class implements from ChatList interface and inherits from
 * UnicastRemoteObject.
 *
 * @author Karinya
 */
public class ChatListServant extends UnicastRemoteObject implements ChatList {

    private Vector theList;
    private int version;
    private Vector<ChatList> clients;     // clients contain a MyChatList object of client.
    private Vector<String> name;    // name vector contains name of clients.

    /**
     * This constructor initializes value of the list and version
     *
     * @throws RemoteException
     */
    public ChatListServant() throws RemoteException {
        super();
        theList = new Vector();
        version = 0;
        clients = new Vector<ChatList>();
        name = new Vector<String>();
    }

    /**
     * This method will add one more object (with chat string) of ChatServant
     * into the list.
     *
     * @param s
     * @return Chat object that new ChatServant object has been added.
     * @throws RemoteException
     */
    public Chat newChat(String s) throws RemoteException {
        version++;
        Chat chat = new ChatServant(s, version);
        theList.addElement(chat);
        if (!clients.isEmpty()) {
            // print out message to all clients.
            for (int i = 0; i < clients.size(); i++) {
                clients.elementAt(i).print();
            }
        }
        return chat;
    }

    /**
     * This method returns list of ChatServant.
     *
     * @return list of ChatServant
     * @throws RemoteException
     */
    public Vector allChats() throws RemoteException {
        return theList;
    }

    /**
     * This method returns version of each ChatServant object.
     *
     * @return version of each ChatServant object
     * @throws RemoteException
     */
    public int getVersion() throws RemoteException {
        return version;
    }

    /**
     * This method checks if the name already exists in name vector, and add it
     * if not exists.
     *
     * @param s
     * @return true is the name is successfully added, false otherwise.
     * @throws RemoteException
     */
    public boolean newName(String s) throws RemoteException {
        if (name.indexOf(s) != -1) {
            return false;
        } else {
            name.addElement(s);
            return true;
        }
    }
    
    /**
     * This method deletes client name from name list
     * @param s
     * @return
     * @throws RemoteException 
     */
        public boolean deleteName(String s) throws RemoteException {
        if (name.indexOf(s) != -1) {
            name.remove(s);
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method is not implemented here.
     *
     * @throws RemoteException
     */
    public void print() throws RemoteException {
    }

    /**
     * This method add new client.
     *
     * @param client
     */
    public void registration(ChatList client) {
        clients.addElement(client);
    }
}

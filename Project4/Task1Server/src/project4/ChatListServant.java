package project4;

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

    /**
     * This constructor initializes value of the list and version
     *
     * @throws RemoteException
     */
    public ChatListServant() throws RemoteException {
        super();
        theList = new Vector();
        version = 0;
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
}

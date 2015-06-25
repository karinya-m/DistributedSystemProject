package project4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class implements Chat interface and inherits from UnicastRemoteObject
 *
 * @author Karinya
 */
public class ChatServant extends UnicastRemoteObject implements Chat {

    int myVersion;
    String theS;

    /**
     * Constructor method sets attributes according to given arguments.
     *
     * @param s
     * @param version
     * @throws RemoteException
     */
    public ChatServant(String s, int version) throws RemoteException {
        theS = s;
        myVersion = version;
    }

    /**
     * This method returns version of the chat log
     *
     * @return a version of the chat log
     * @throws RemoteException
     */
    public int getVersion() throws RemoteException {
        return myVersion;
    }

    /**
     * This method returns chat message.
     *
     * @return chat message
     * @throws RemoteException
     */
    public String getAllState() throws RemoteException {
        return theS;
    }
}

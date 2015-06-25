

import java.rmi.*;
import java.util.Vector;

/**
 * This ChatList interface contains 6 methods, newChat, allChats, getVersion,
 * newName, print, and registration.
 *
 * @author Karinya
 */
public interface ChatList extends Remote {

    Chat newChat(String s) throws RemoteException;

    Vector allChats() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean newName(String s) throws RemoteException;
    
    boolean deleteName(String s) throws RemoteException;

    void print() throws RemoteException;

    void registration(ChatList l) throws RemoteException;
}

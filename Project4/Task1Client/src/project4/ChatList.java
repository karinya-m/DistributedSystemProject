package project4;

import java.rmi.*;
import java.util.Vector;

/**
 * This ChatList interface contains 3 methods, newChat, allChats, and getVersion
 *
 * @author Karinya
 */
public interface ChatList extends Remote {

    Chat newChat(String s) throws RemoteException;

    Vector allChats() throws RemoteException;

    int getVersion() throws RemoteException;
}

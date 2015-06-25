

import java.rmi.*;

/**
 * Chat interface contains 2 methods, getVersion and getAllState
 *
 * @author Karinya
 */
public interface Chat extends Remote {

    int getVersion() throws RemoteException;

    String getAllState() throws RemoteException;
}

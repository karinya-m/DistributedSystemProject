package project3task5;

/**
 * This interface represent binder. It defines the lookup method and bind method
 *
 * @author Karinya
 */
public interface Binder {

    /**
     * This method look for remote object, given the input string
     * @param input
     * @return 
     */
    public RemoteObjectReference lookup(String input);

    /**
     * This method stores pair of input string and remote object in registry
     * @param input
     * @param remoteObj 
     */
    public void bind(String input, RemoteObjectReference remoteObj);
}

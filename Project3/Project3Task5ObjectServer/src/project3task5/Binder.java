package project3task5;

/**
 * This interface represent binder. It defines the lookup method and bind method
 *
 * @author Karinya
 */
public interface Binder {

    /**
     * This method look for pair remote object of the given string
     * @param input
     * @return remote object of the pair value
     */
    public RemoteObjectReference lookup(String input);

    /**
     * This method stores given string and its remote reference object.
     * @param input
     * @param remoteObj 
     */
    public void bind(String input, RemoteObjectReference remoteObj);
}

package project3task5;

/**
 * This interface represent binder. It defines the lookup method and bind method
 *
 * @author Karinya
 */
public interface Binder {

    /**
     * This method looks up for remote reference pair of the input string
     *
     * @param input
     * @return pair remote reference of the input string value
     */
    public RemoteObjectReference lookup(String input);

    /**
     * This method stores pair value of the string and remote ref object
     * together.
     *
     * @param input
     * @param remoteObj
     */
    public void bind(String input, RemoteObjectReference remoteObj);
}

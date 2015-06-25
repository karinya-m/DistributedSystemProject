package project3task5;

import java.util.TreeMap;

/**
 * This class implements Binder, contains lookup and bind method.
 *
 * @author Karinya
 */
public class Binder_Servant implements Binder {

    private static TreeMap<String, RemoteObjectReference> treemap = new TreeMap<String, RemoteObjectReference>();

    Binder_Servant() {
        RemoteObjectReference testobj = new RemoteObjectReference();
        treemap.put("testname", testobj);
    }

    /**
     * This method look for remote object reference, give name of a person.
     *
     * @param input
     * @return reference of remote object
     */
    public RemoteObjectReference lookup(String input) {
        return treemap.get(input);
    }

    /**
     * This method stores name and reference of remote object in pair.
     *
     * @param input
     * @param remoteObj
     */
    public void bind(String input, RemoteObjectReference remoteObj) {
        treemap.put(input, remoteObj);
    }
}

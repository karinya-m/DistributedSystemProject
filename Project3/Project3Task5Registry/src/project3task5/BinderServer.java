package project3task5;

/**
 * This class contains main method of binder server.
 *
 * @author Karinya
 */
public class BinderServer {

    /**
     * This main method creates object of binderServant, pass it to an object of
     * BinderSkeleton, and finally call serve method to wait for a request.
     *
     * @param args
     */
    public static void main(String args[]) {
        Binder_Servant binderServant = new Binder_Servant();
        Binder_Skeleton skeleton = new Binder_Skeleton(binderServant);
        skeleton.serve();
    }
}

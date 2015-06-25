
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class MyCool_Skeleton {

    MyCoolClass mcc;

    public MyCool_Skeleton(MyCoolClass p) {

        mcc = p;
    }

    public void serve() {
        try {
            ServerSocket s = new ServerSocket(9000);
            while (true) {
                Socket socket = s.accept();
                System.out.println("We have a visitor");
                ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
                String choice = (String) i.readObject();
              //  System.out.println(choice);  //????????
                if ("1".equals(choice)) {
                    System.out.println("They want get deivce");

                    String name = (String) i.readObject();
                    String result = mcc.getDevice(name);
                    System.out.println("Sending back" + result);
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    o.writeObject(result);
                    o.flush();
                } else {
                    System.out.println("They want set device");
                    String name = (String) i.readObject();
 System.out.println("name: " + name);
                    String maker = (String) i.readObject();
                     System.out.println("maker: " + maker);
                    mcc.setDevice(name, maker);
                    String result = "Device set";
                    System.out.println("Sending back " + result);
                    ObjectOutputStream o = new ObjectOutputStream(socket.getOutputStream());
                    o.writeObject(result);
                    o.flush();
                }

            }
        } catch (Throwable t) {
            System.out.println("Error " + t);
            System.exit(0);
        }
    }
}

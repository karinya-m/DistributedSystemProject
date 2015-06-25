
public class MyCoolClassServant implements MyCoolClass {

    private String n[] = {"printer","stereo","TV","ipod","pda"};

    private String a[] = {"HP200XT","Kenwood200","Panasonic","Apple","Palm"};

    public String getDevice(String name) {

       for(int i = 0; i < n.length; i++) {
            if(n[i].equals(name)) return a[i];
       }
       return "No device";
    }
    
        public void setDevice(String name, String maker) {

       for(int i = 0; i < n.length; i++) {
            if(n[i].equals(name)) a[i] = maker;
       }
       
    }
}
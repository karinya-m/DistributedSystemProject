public class CoolClient {

    public static void main(String args[]) {

      try {

              MyCoolClass p = new CoolClass_Stub();
              System.out.println(p.getDevice("TV"));
             // p.setDevice("TV", "maker name1");
      }
      catch(Throwable t) {
          t.printStackTrace();
          System.exit(0);
      }
    }
}

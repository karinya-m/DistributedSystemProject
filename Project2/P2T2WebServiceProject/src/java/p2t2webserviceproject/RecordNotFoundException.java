// 95-702 Distributed Systems

package p2t2webserviceproject;

public class RecordNotFoundException extends Exception{

        public RecordNotFoundException() {

    }
        public String toString() {
            return "Could not find database record";
        }
}

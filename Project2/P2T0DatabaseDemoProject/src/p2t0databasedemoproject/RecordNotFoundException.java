// 95-702 Distributed Systems

package p2t0databasedemoproject;

public class RecordNotFoundException extends Exception{

        public RecordNotFoundException() {

    }
        public String toString() {
            return "Could not find database record";
        }
}

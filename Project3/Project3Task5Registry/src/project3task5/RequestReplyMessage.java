package project3task5;

import java.io.Serializable;

/**
 *
 *
 * The class RequestReplyMessage represents a generic request reply message. It
 * contains setter and getter methods for each field.
 *
 * @author Karinya
 */
public class RequestReplyMessage implements Serializable {

    private int messageType; // 0 = Request, 1 = Reply
    private int requestID;
    private RemoteObjectReference remoteObjectRef;
    private int methodID;
    private byte[] arguments;

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int msgType) {
        messageType = msgType;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int reqId) {
        requestID = reqId;
    }

    public RemoteObjectReference getRemoteObjectRef() {
        return remoteObjectRef;
    }

    public void setRemoteObjectReference(RemoteObjectReference obj) {
        remoteObjectRef = obj;
    }

    public int getMethodID() {
        return methodID;
    }

    public void setMethodID(int methodId) {
        this.methodID = methodId;
    }

    public byte[] getArguments() {
        return arguments;
    }

    public void setArguments(byte[] arguments) {
        this.arguments = arguments;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task5;

import java.io.Serializable;

/**
 *
 * @author Karinya
 */
public class RemoteObjectReference implements Serializable {

    private byte[] IPAddress = new byte[4];
    private int portNumber;
    private int time;
    private int objectNumber;
    private String interfaceRemoteObject;

    public byte[] getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(byte[] ip) {
        this.IPAddress = ip;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int port) {
        this.portNumber = port;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getObjectNumber() {
        return objectNumber;
    }

    public void setObjNum(int objNum) {
        this.objectNumber = objNum;
    }

    public String getInterfaceRemoteObj() {
        return interfaceRemoteObject;
    }
    
     public void setInterfaceRemoteObj(String interfaceRemoteObj) {
        this.interfaceRemoteObject = interfaceRemoteObj;
    }
}

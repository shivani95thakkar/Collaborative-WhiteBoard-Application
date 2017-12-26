
package ServerSide;

import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import paint.ClientIF;

public interface ServerIF extends Remote {
    public void registerClient(ClientIF client,String name) throws RemoteException;
    public String[] listChatter() throws RemoteException;
    public void postMessage(int x1,int y1,int x2,int y2,String type,String s) throws RemoteException;
    
}

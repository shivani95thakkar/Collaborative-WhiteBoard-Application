
package paint;
import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientIF extends Remote{
    
    public void notifyMe(int x1,int y1,int x2,int y2,String type,String c) throws RemoteException;
    public String getName() throws RemoteException;
   
}


package ServerSide;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Vector;
import paint.ClientIF;

public class Server extends UnicastRemoteObject implements ServerIF {

private Vector chatters=new Vector();
Talker talker;
    protected Server() throws RemoteException
    {
        super();
        System.out.println("initializing server");
    }

    @Override
    synchronized public void registerClient(ClientIF client, String name) throws RemoteException {
        chatters.addElement(new Talker(client,name));
    }

    @Override
    public String[] listChatter() throws RemoteException {
        String list[]=new String[chatters.size()];
        Talker c;
        for(int i=0;i<list.length;i++)
        {
            c=(Talker)chatters.elementAt(i);
            list[i]=c.getChatterName();
        }
        return list;
    }

    @Override
    synchronized public void postMessage(int x1, int y1, int x2, int y2, String type,String c) throws RemoteException {
       Talker t;
       for(int i=0;i<chatters.size();i++)
       {
           t=(Talker)chatters.elementAt(i);
           t.addMessage(x1,y1,x2,y2,type,c);
       }
    }
    

}
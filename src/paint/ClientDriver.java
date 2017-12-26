
package paint;

import ServerSide.ServerIF;
import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ClientDriver {

    
    String name;
    ServerIF server=null;
    public static  ServerTalker st=null;
    
    
    public ClientDriver(String name)
    {
        this.name=name;
    }
    public void startclient() throws NotBoundException, MalformedURLException, RemoteException
    {
        
        String url="rmi://localhost:1098/RMIServer";
        server=(ServerIF)Naming.lookup(url);
        
        try
        {
            ClientIF c = new Client(name);
            UnicastRemoteObject.exportObject(c,0);
            System.out.println("client " + " " + name + " " + "is ready too");
            server.registerClient(c, name);      
            st = new ServerTalker(server);
        }
        catch(Exception ex)
        {
            System.out.println("stack trace : " + ex);
        }
    }
    
    public static void passMessage(int x1, int y1, int x2, int y2, String s)
    {
        st.addMessage(x1, y1, x2, y2, s);
    }
    
    
    
}

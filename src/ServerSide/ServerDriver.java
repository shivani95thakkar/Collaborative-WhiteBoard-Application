package ServerSide;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ServerDriver extends UnicastRemoteObject {
    
    public ServerDriver() throws RemoteException
    {
        
    }
    public static void main(String []args) throws RemoteException,MalformedURLException
    {
       
            ServerDriver sd=new ServerDriver();
            sd.startServer();
        
    }
    public void startServer() throws RemoteException
    {
        ServerIF s=new Server();
        Registry r = java.rmi.registry.LocateRegistry.createRegistry(1098);
        r.rebind("RMIServer",s);
        System.out.println("server is up and running");
    }
}
   

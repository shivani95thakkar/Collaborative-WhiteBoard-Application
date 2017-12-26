
package paint;

import ServerSide.ServerIF;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.*;

public class Test extends UnicastRemoteObject {
    static String name=null;
    private static Option start=null;
    private static MyFrame mf=null;
    public Test() throws RemoteException
    {
        String lf = UIManager.getSystemLookAndFeelClassName();
        if(lf != null)
        {
            try
            {
                UIManager.setLookAndFeel(lf);
            }
            catch(Exception e)
            {
                System.out.println(" " + e);
            }
        }
        
        start=new Option();
        start.setSize(600,300);
        start.setLocation(100,150);
        start.show();
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void call(int choice,String name) throws MalformedURLException,RemoteException,NotBoundException
    {
        if(choice == 1)
        {
               Test.name=name;
               start.setVisible(false);
               mf = new MyFrame();
               mf.setSize(650,550);
               mf.show();
        }
        else
        {
            System.exit(0);
        }
        
         ClientDriver cd=new ClientDriver(name);
         cd.startclient();
        
    }
    
    public static void main(String []args) throws MalformedURLException,RemoteException,NotBoundException
    {
        new Test();
    }

  
        
}

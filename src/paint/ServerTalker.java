
package paint;

import ServerSide.ServerIF;
import java.awt.Color;
import java.util.Vector;


public class ServerTalker extends Thread {
    static ServerIF server=null;
    
    private static Vector messages1=new Vector();
    private static Vector messages2=new Vector();
    private static Vector messages3=new Vector();
    private static Vector messages4=new Vector();
    private static Vector messages5=new Vector();
    private static Vector messages6=new Vector();
    
    public ServerTalker(ServerIF server)
    {
        this.server=server;
        this.start();
    }
    
    public void addMessage(int x1,int y1,int x2,int y2,String type)
    {
        resume();
        if(server == null)
        {
            System.out.println("server is down");
        }
        messages1.addElement(x1);
        messages2.addElement(y1);
        messages3.addElement(x2);
        messages4.addElement(y2);
        messages5.addElement(type);
        messages6.addElement(Test.name);
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                if(messages1.isEmpty())
                {
                    suspend();
                }
                

                        server.postMessage((int)messages1.elementAt(0),(int)messages2.elementAt(0),(int)messages3.elementAt(0),(int)messages4.elementAt(0),(String)messages5.elementAt(0),(String)messages6.elementAt(0));
                        messages1.removeElementAt(0);
                        messages2.removeElementAt(0);
                        messages3.removeElementAt(0);
                        messages4.removeElementAt(0);
                        messages5.removeElementAt(0);
                        messages6.removeElementAt(0);
                    
                    
               
            }
                    
            catch(Exception e)
            {}
            yield();
            
        }
    }
    
    
    
    
}

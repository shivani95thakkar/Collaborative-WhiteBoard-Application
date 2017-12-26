package ServerSide;

import java.awt.Color;
import java.util.Vector;
import paint.ClientIF;



public class Talker extends Thread{
    private Vector messages1=new Vector();
    private Vector messages2=new Vector();
    private Vector messages3=new Vector();
    private Vector messages4=new Vector();
    private Vector messages5=new Vector();
    private Vector messages6=new Vector(); 
    private Vector messageQueue1 = new Vector();
    private Vector messageQueue2 = new Vector();
    private ClientIF c;
    private String name;
    int a;
    int b;
    int d;
    int f;
    String g;
    String h;
    
    public Talker(ClientIF c,String name)
    {
     
        this.c=c;
        this.name=name;
        this.start();
    }
    
    public void addMessage(int x1,int y1,int x2,int y2,String type,String c)
    {
        
        resume();
        messages1.addElement(x1);
        messages2.addElement(y1);
        messages3.addElement(x2);
        messages4.addElement(y2);
        messages5.addElement(type);
       messages6.addElement(c);
       
        
           
        
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
                    
                     
                    a=(int)messages1.elementAt(0);
                    b=(int)messages2.elementAt(0);
                    d=(int)messages3.elementAt(0);
                    f=(int)messages4.elementAt(0);
                    g=(String)messages5.elementAt(0);
                    h=(String)messages6.elementAt(0);                    
                    c.notifyMe(a,b,d,f,g,h);
                 messages1.removeElementAt(0);
                 messages2.removeElementAt(0);
                 messages3.removeElementAt(0);
                 messages4.removeElementAt(0);
                 messages5.removeElementAt(0);
                 messages6.removeElementAt(0);

                    
             
             
                
            }
            catch(Exception e){
            }
            yield();
        }
    }
    
    public String getChatterName()
    {
        return name;
    }
    
    
    
}

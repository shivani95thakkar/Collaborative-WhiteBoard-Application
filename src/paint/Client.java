
package paint;

import ServerSide.ServerIF;
import java.awt.Color;
import java.rmi.RemoteException;


public class Client implements ClientIF {
    
    public static ServerIF server;
    private String name=null;
    public static DrawArea1 da=null;
    
    
    
  
    Client(String name) throws RemoteException{
       this.name=name;
    }
 
 
    @Override
    public String getName() throws RemoteException{
            return name;
    }
    @Override
    public void notifyMe(int x1, int y1, int x2, int y2, String type,String c) throws RemoteException {        
            if(type.equalsIgnoreCase("pencil"))
            {
                da.takePencil(x1, y1, x2, y2,1);
            }
            else if(type.equalsIgnoreCase("eraser"))
            {
                
                 da.takeEraser(x1, y1, x2, y2,1);
            }
            else if(type.equalsIgnoreCase("line"))
            {
                 da.takeLine(x1, y1, x2, y2,1);
            }
            else if(type.equalsIgnoreCase("rectangle"))
            {
                 da.takeRectangle(x1, y1, x2, y2,1);
            }
            else if(type.equalsIgnoreCase("oval"))
            {
                 da.takeOval(x1, y1, x2, y2,1);
            }
            else
            {
                da.ta.append("[" + c + "]" + type);
                da.ta.append("\n");
            }
    }
    
    public static int giveTool()
    {
        return 0;
    }

   
    
    public static void setBc()
    {
        da.setBc();
    }
}

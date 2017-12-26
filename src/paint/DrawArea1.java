
package paint;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawArea1 extends Canvas implements ActionListener , ChangeListener ,MouseListener ,MouseMotionListener{

    int a;
    int b;
    int c;
    int d;
    int f;
    Color h;
    int b1;
   
    
    static int LINE=1;
    static int ERASER=2;
    static int RECT=3;
    static int ROUND=4;
    static int PENCIL=5;
    static int currentTool=0;
    int mouseX,mouseY,newmouseX,newmouseY,lastX,lastY,eX,eY,neweX,neweY,pX,pY,newpX,newpY;
    Graphics2D g2;
    private PaintToolBar mPaintToolBar;
    TextArea ta=null;
    static Color currentColor=Color.BLACK;
    
    DrawArea1(PaintToolBar ptb,TextArea ta)
    {
        this.ta=ta;
        addMouseListener(this);
        addMouseMotionListener(this);
        mPaintToolBar = ptb;
       this.setSize(500, 500);
       this.setBackground(Color.WHITE);
    }
    
     
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        
        if(getTool() == LINE)
        {
            g2.setColor(h);
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(a, b, c, d);
            if(b1 == 2)  
                ClientDriver.passMessage(a, b, c, d, "line");
        }
        else if(getTool() == RECT)
        {
            g2.setColor(h);
            g2.setStroke(new BasicStroke(1));
            g2.drawRect(a, b ,c ,d);
            if(b1 == 2)
            ClientDriver.passMessage(a, b, c, d, "rectangle");
        }
        else if(getTool() == ROUND)
        {
            g2.setColor(h);
            g2.setStroke(new BasicStroke(1));
            g2.drawOval(a, b, c, d);
            if(b1 == 2)
            ClientDriver.passMessage(a, b, c, d, "oval");
        }
        else if(getTool() == PENCIL)
        {
            g2.setColor(h);
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(a, b, c, d);
            if(b1 == 2)
            ClientDriver.passMessage(a, b, c, d, "pencil");
        }
        else if(getTool() == ERASER)
        {
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(10));
            g2.draw(new Line2D.Double(a,b,c,d));
            if(b1 == 2)
            ClientDriver.passMessage(a, b, c, d, "eraser");
        }
        
        else
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0,500 ,500);
            
        }
    }
    @Override
        public void update(Graphics g)
        {
            paint(g);
        }
      
     @Override
     public void actionPerformed(ActionEvent e) 
     {
            
            if(e.getActionCommand().equalsIgnoreCase("CLEAR"))
            {        
                this.setBackground(Color.WHITE);
                
            }
    }

        @Override
        public void stateChanged(ChangeEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            newpX=e.getX();
            newpY=e.getY();
            neweX=e.getX();
            neweY=e.getY();
            
            if(mPaintToolBar.getTool() == PaintToolBar.ERASER)
            {
                b1=2;
                setTool(ERASER);
                a=eX;
                b=eY;
                c=neweX;
                d=neweY;
                f=0;
                h=Color.WHITE;
                repaint();
                eX=neweX;
                eY=neweY;
                
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.PENCIL) 
	    {
                b1=2;         
		setTool(PENCIL);
                a=pX;
                b=pY;
                c=newpX;
                d=newpY;
                f=0;
                h=currentColor;

        	repaint();
                pX=newpX;
                pY=newpY;
	   }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
             b1=2;
             mouseX=e.getX();
             mouseY=e.getY();
             eX=e.getX();
             eY=e.getY();
             pX=e.getX();
             pY=e.getY();
             
        }
        

        @Override
        public void mouseReleased(MouseEvent e)
        {
            b1=2;
            neweX=e.getX();
            neweY=e.getY();
            newpX=e.getX();
            newpY=e.getY();
            newmouseX=e.getX();
            newmouseY=e.getY();
            lastX=-mouseX+newmouseX;
            lastY=-mouseY+newmouseY;
            
            if(mPaintToolBar.getTool() == PaintToolBar.LINE)
            {
                b1=2;
                setTool(LINE);
                a=mouseX;
                b=mouseY;
                c=newmouseX;
                d=newmouseY;
                f=0;
                h=currentColor;
                repaint();
                
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.RECTANGLE)
            {
                b1=2;
                setTool(RECT);
                a=mouseX;
                b=mouseY;
                c=lastX;
                d=lastY;
                f=0;
                h=currentColor;
                repaint();
                 
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.ELLIPSE)
            {
                b1=2;
                  setTool(ROUND);
                a=mouseX;
                b=mouseY;
                c=lastX;
                d=lastY;
                f=0;
                h=currentColor;
                repaint();
                 
            }
            
            else if(mPaintToolBar.getTool() == PaintToolBar.ERASER)
            {
                b1=2;
               setTool(ERASER);
                a=eX;
                b=eY;
                c=neweX;
                d=neweY;
                f=0;
                h=Color.WHITE;
                repaint();
                /*eX=neweX;
                eY=neweY;*/
                
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.PENCIL) 
	    {
                b1=2;         
		setTool(PENCIL);
                a=pX;
                b=pY;
                c=newpX;
                d=newpY;
                f=0;
                h=currentColor;
                repaint();
                /*pX=newpX;
                pY=newpY;*/
	   }
           
        }

       
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        
   
        void takeRectangle(int x1,int y1,int x2,int y2,int bl)
        {
                b1=1;
                setTool(RECT);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                
                repaint();
                
                

        }
        
        
        void takeLine(int x1,int y1,int x2,int y2,int bl)
        {
                b1=1;
                setTool(LINE);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                
                repaint();
             
        }
        
        void takeOval(int x1,int y1,int x2,int y2,int bl)
        {
            b1=1;
            setTool(ROUND);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                
                repaint();

        }
        void takeEraser(int x1,int y1,int x2,int y2,int bl)
        {
            b1=1;
            setTool(ERASER);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                
                repaint();

        }
        
        void takePencil(int x1,int y1,int x2,int y2,int bl)
        {
            b1=1;
            setTool(PENCIL);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                
                repaint();

        }
        
        public void setBc()
        {
            this.setTool(0);
            repaint();
        }
        
        int getTool()
        {
           return currentTool;
        }
        
        void setTool(int z)
        {
            this.currentTool=z;
        }
        
       void printMessage(String s)
       {
           String str="\n";
           ta.append(s);
           ta.append(str);
       }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Admin
 */
public class DrawArea extends Canvas implements ActionListener , ChangeListener ,MouseListener ,MouseMotionListener{

    int a;
    int b;
    int c;
    int d;
    int f;
    Color h;
    
    static int LINE=1;
    static int ERASER=2;
    static int RECT=3;
    static int ROUND=4;
    static int PENCIL=5;
    int currentTool=0;
    
        int mouseX,mouseY,newmouseX,newmouseY,lastX,lastY,epX,epY,newepX,newepY;
    public static BufferedImage currentImage;
    Image i;
    Graphics db;
    Graphics temp=null;
    Graphics2D g2;
    private PaintToolBar mPaintToolBar;
    
    TextArea ta=null;
    Color currentColor=Color.BLUE;
    DrawArea(PaintToolBar ptb,TextArea ta)
    {
        this.ta=ta;
        addMouseListener(this);
        addMouseMotionListener(this);
        mPaintToolBar = ptb;
       this.setSize(500, 500);
       this.setBackground(Color.WHITE);
        
        
           

    }
    
     DrawArea()
    {
        
    }
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(h);
        if(getTool() == LINE)
        {
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(a, b, c, d);
        }
        else if(getTool() == RECT)
        {
            g2.setStroke(new BasicStroke(1));
            g2.drawRect(a, b ,c ,d);
        }
        else if(getTool() == ROUND)
        {
            g2.setStroke(new BasicStroke(1));
            g2.drawOval(a, b, c, d);
        }
        else if(getTool() == PENCIL)
        {
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(a, b, c, d);
        }
        else if(getTool() == ERASER)
        {
            g2.setStroke(new BasicStroke(10));
            g2.draw(new Line2D.Double(a,b,c,d));
        }
        else{}
    }
    @Override
        public void update(Graphics g)
        {
            paint(g);
        }
      
         
    

  
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public void stateChanged(ChangeEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            newepX=e.getX();
            newepY=e.getY();
            if(mPaintToolBar.getTool() == PaintToolBar.ERASER)
            {
                
                setTool(ERASER);
                a=epX;
                b=epY;
                c=newepX;
                d=newepY;
                f=0;
                h=Color.WHITE;
                repaint();
                epX=newepX;
                epY=epY;
                
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.PENCIL) 
	    {
                         
		setTool(PENCIL);
                a=epX;
                b=epY;
                c=newepX;
                d=newepY;
                f=0;
                h=currentColor;

        	repaint();
                epX=newepX;
                epY=newepY;
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
             mouseX=e.getX();
             mouseY=e.getY();
             epX=e.getX();
             epY=e.getY();
             
        }
        

        @Override
        public void mouseReleased(MouseEvent e)
        {
            newepX=e.getX();
            newepY=e.getY();
            newmouseX=e.getX();
            newmouseY=e.getY();
            lastX=-mouseX+newmouseX;
            lastY=-mouseY+newmouseY;
            
            if(mPaintToolBar.getTool() == PaintToolBar.LINE)
            {
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
                
               setTool(ERASER);
                a=epX;
                b=epY;
                c=newepX;
                d=newepY;
                f=0;
                h=Color.WHITE;
                repaint();
                epX=newepX;
                epY=epY;
                
            }
            else if(mPaintToolBar.getTool() == PaintToolBar.PENCIL) 
	    {
                         
		setTool(PENCIL);
                a=epX;
                b=epY;
                c=newepX;
                d=newepY;
                f=0;
                h=currentColor;
                repaint();
                epX=newepX;
                epY=newepY;
	   }
           
        }

       
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        
   
        void takeRectangle(int x1,int y1,int x2,int y2,int bl,Color cr)
        {
                setTool(RECT);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                h=cr;
                
                

        }
        
       void  takeMessage(String name,String s,int b,Color c)
        {
           
        }
       
       
        void takeLine(int x1,int y1,int x2,int y2,int bl,Color cr)
        {
                setTool(LINE);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                h=cr;
        }
        
        void takeOval(int x1,int y1,int x2,int y2,int bl,Color cr)
        {
            setTool(ROUND);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                h=cr;

        }
        void takeEraser(int x1,int y1,int x2,int y2,int bl,Color cr)
        {
            setTool(ERASER);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                h=cr;

        }
        void takePencil(int x1,int y1,int x2,int y2,int bl,Color cr)
        {
            setTool(PENCIL);
                a=x1;
                b=y1;
                c=x2;
                d=y2;
                f=bl;
                h=cr;

        }
        
        public void setColor(Color c)
        {
            currentColor=c;
            System.out.println("color : " + c);
        }
        
        int getTool()
        {
           return currentTool;
        }
        
        void setTool(int z)
        {
            this.currentTool=z;
        }
}

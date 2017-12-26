
package paint;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class PaintToolBar extends JToolBar implements ActionListener
{
        private ButtonGroup group=null;
	public static final int ERASER = 1; 
	public static final int PENCIL = 3;
	public static final int LINE = 4;
	public static final int RECTANGLE = 5;
	public static final int ELLIPSE = 7;	
        public static final int CLEAR = 10;
        public static final int GREENBUTTON=11;
        
 	public PaintToolBar()
	{
		group = new ButtonGroup();
                setBackground(Color.BLACK);
             
    		JToggleButton eraser = new JToggleButton(new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\eraser.gif"));
		eraser.setMargin(new Insets(0,0,0,0));
		eraser.setActionCommand("eraser");
		eraser.addActionListener(this);
		eraser.setToolTipText("Eraser");
                
		JToggleButton pencil = new JToggleButton( new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\pencil.gif"));
		pencil.setMargin(new Insets(0,0,0,0));
		pencil.setActionCommand("pencil");
		pencil.addActionListener(this);
		pencil.setToolTipText("Free Hand Sketch");                
                
		JToggleButton line = new JToggleButton( new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\line.gif"));
		line.setMargin(new Insets(0,0,0,0));
		line.setActionCommand("line");
		line.addActionListener(this);
		line.setToolTipText(" Line ");
		
		JToggleButton rectangle = new JToggleButton( new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\rectangle.gif"));
		rectangle.setMargin(new Insets(0,0,0,0));
		rectangle.setActionCommand("rectangle");
		rectangle.addActionListener(this);
		rectangle.setToolTipText(" Rectangle");
		
		JToggleButton ellipse = new JToggleButton( new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\ellipse.gif"));
		ellipse.setMargin(new Insets(0,0,0,0));
		ellipse.setActionCommand("ellipse");
		ellipse.addActionListener(this);
		ellipse.setToolTipText(" Ellipse ");
                
                JToggleButton clear = new JToggleButton( new ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\OurProject\\src\\paint\\clear.png"));
		clear.setMargin(new Insets(0,0,0,0));
		clear.setActionCommand("clear");
		clear.addActionListener(this);
		clear.setToolTipText(" Clear ");
                
                
                add(eraser);
                this.addSeparator();
                add(rectangle);
                this.addSeparator();
                add(pencil);
                this.addSeparator();
                add(line);
                this.addSeparator();
                add(ellipse);
                this.addSeparator();
                add(clear);
                this.addSeparator();
                
                
                
                this.setRollover(true);
                
                group.add(eraser);
                group.add(pencil);
                group.add(line);
                group.add(rectangle);
                group.add(ellipse);
                group.add(clear);
                
                 pencil.setSelected(true);  
                 

        }
        
        
       	public int getTool( )
	{
		String selected = group.getSelection().getActionCommand();
		
		
		if(selected.equals("eraser"))
		{
			return ERASER;
		}
		
		else if(selected.equals("pencil"))
		{
			return PENCIL;
		}
		
		else if(selected.equals("line"))
		{
			return LINE;
		}
		else if(selected.equals("rectangle"))
		{
			return RECTANGLE;
		}
		
		else if(selected.equals("ellipse"))
		{
			return ELLIPSE;
		}
        
		return -1;
	}


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("clear"))
        {
            Client.setBc();
        }
    }
    

}

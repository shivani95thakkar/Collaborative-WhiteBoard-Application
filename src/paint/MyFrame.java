
package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EtchedBorder;

public class MyFrame extends JFrame implements ActionListener, MouseMotionListener
{
   public static final int DEFAULT_WIDTH = 600;
   public static final int DEFAULT_HEIGHT = 500;  
   public PaintToolBar ptb=null;
   public Color selectedColor=Color.BLACK;
   public DrawArea1 area=null;
   public JTextField tf=null;
   public TextArea ta=null;

    public MyFrame() 
    {
       JPanel contentPane = (JPanel)getContentPane();
       JPanel pane = new JPanel();
       
      setTitle("WhiteBoard");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      	EtchedBorder etched = new EtchedBorder(Color.gray.brighter() ,Color.gray.darker());
	pane.setBorder(etched);

	contentPane.setBorder(etched);
	contentPane.setLayout(new BorderLayout());
        
	pane.setLayout(new BorderLayout());
        
        ptb = new PaintToolBar();
	ptb.setRollover(true);
	ptb.addMouseMotionListener(this);
	ptb.setFloatable(false);
        ptb.setVisible(true);
        
        Panel colorPanel=new Panel();
        colorPanel.setSize(20, 20);
        colorPanel.setLayout(new BorderLayout());
        
        ta = new TextArea(50,25);
        ta.setEditable(false);
        ta.setBackground(Color.LIGHT_GRAY);
        area = new DrawArea1(ptb,ta);
        
        Client.da=area; //very crucial line
        
        JPanel up = new JPanel();
        up.setBackground(Color.WHITE);
        JButton logout = new JButton("logout");
        logout.addActionListener(this);
        up.add(ptb);
        up.add(logout);
        JPanel down = new JPanel();
        down.add(area);
        contentPane.add(up,BorderLayout.NORTH);
        contentPane.add(area,BorderLayout.CENTER);

      Panel textPanel = new Panel();
      textPanel.setBackground(Color.PINK);
      textPanel.setLayout(new FlowLayout());
  
      JLabel l = new JLabel("message : ");
      tf = new JTextField(40);
      JButton send = new JButton("Send");
      send.addActionListener(this);
      JButton getList = new JButton("GetList");
      getList.addActionListener(this);
      
      textPanel.add(l);
      textPanel.add(tf);
      textPanel.add(send);
      textPanel.add(getList);
      
      contentPane.add(textPanel,BorderLayout.SOUTH);
      
      Panel tapanel = new Panel();
      tapanel.setLayout(new BorderLayout());
      tapanel.add(ta);
      
      
      contentPane.add(tapanel,BorderLayout.EAST);
    }

   @Override
    public void paint(Graphics g)
    {
        g.setColor(selectedColor);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("getlist"))
        {
            ta.setText("");
            try
            {
            String []names = ServerTalker.server.listChatter();
            for(int i=0;i<names.length;i++)
            {
                ta.append(names[i]);
                ta.append("\n");
            }
            }
            catch(Exception ex)
            {
                
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("send"))
            
        {
            try
            {
               ClientDriver.passMessage(0, 0, 0, 0,tf.getText().trim());
            }
            catch(Exception ex)
            {
                
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("logout"))
        {
            
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}

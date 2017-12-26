
package paint;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Option extends JFrame implements ActionListener
{
    private int option;
    public static final int width=500;
    public static final int height=500;
    private JButton OkButton;
    private JButton CancelButton;
    private JTextField tb;
  
    public Option()
    {
        setSize(width,height);
        setTitle("Login Form");
        Container contentPane = getContentPane();
        
        JLabel label = new JLabel("Enter Your Name : ");
        OkButton = new JButton("OK");
	CancelButton = new JButton("CANCEL");
        tb = new JTextField(30);
        
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(500,40);
        panel.add(label);
        panel.add(tb);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setSize(500,40);
        panel2.add(OkButton);
        panel2.add(CancelButton);
        OkButton.addActionListener(this);
        CancelButton.addActionListener(this);
        
        Box vbox=Box.createVerticalBox();
        vbox.add(Box.createVerticalStrut(100));
        vbox.add(panel);
        vbox.add(Box.createVerticalStrut(50));
        vbox.add(panel2);
        
        panel.setBackground(Color.cyan);
        panel2.setBackground(Color.cyan);
        contentPane.setBackground(Color.cyan);
        add(vbox);     
  }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals(OkButton))
        {
            option=1;
        }
        else
        {
            option=2;
        }
        try
        {
          Test.call(option,tb.getText());
        }
        catch(Exception ex)
        {}
    }
    
    
}

package my;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;      

public class MyAppUI{
    JFrame fr;
    JLabel lb1; 
    JLabel lb2;
    JTextField tf1;
    JTextArea ta1;
    JButton b1;
    JButton b2;
                              
    public MyAppUI(){
        initUI();
    }
    
    private void initUI(){
        fr = new JFrame("Base 10 to base 2 converter");
        fr.setSize(500,150);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lb1 = new JLabel("Number in base 10: ");
        lb1.setBounds(10, 10, 120, 25);
        fr.add(lb1);
       
        tf1 = new JTextField("1");
        tf1.setBounds(130, 10, 200, 25);
        fr.add(tf1);       
       
        lb2 = new JLabel("Number in base 2: ");
        lb2.setBounds(10, 50, 120, 25);
        fr.add(lb2);
       
        ta1 = new JTextArea("1", 2, 18);
        ta1.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta1); 
        ta1.setEditable(false);
        Dimension size = ta1.getPreferredSize();
        sp.setBounds(130, 50, size.width, size.height);
        fr.add(sp);
       
        b1 = new JButton("Recalculate");
        b1.setBounds(350, 10, 120, 25);
        fr.add(b1);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                actionPerformed_b1(e);
            } 
        }
        );
        
        b2 = new JButton("Exit");
        b2.setBounds(350, 50, 120, 25);
        fr.add(b2);
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            } 
        }
        );

        fr.setLayout(null);
        fr.setVisible(true); 
    }
    
    private void actionPerformed_b1(ActionEvent e) {
        // read the input
        String inputText = tf1.getText();
            
        if (Converter.isNumber(inputText)){
            ta1.setText(Converter.convertToBinary(inputText));
        } else{
            JOptionPane.showMessageDialog(null, "The value you have inserted " + 
                "is not a number");
        }                                
    }
    
    public static void main(String[] args){ 
        new MyAppUI(); 
    }
}

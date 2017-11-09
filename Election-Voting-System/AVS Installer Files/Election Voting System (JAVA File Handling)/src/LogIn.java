import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class LogIn extends JFrame{ 
    public LogIn() {
    	JFrame cont = new JFrame();
    	JPanel option = new JPanel();
    	JButton admin = new JButton("ADMINISTRATOR");
    	JButton voter = new JButton("VOTER");
    	
            //opening the main application
        		cont.setVisible(true);
        		cont.setSize(900,600);
        		cont.setTitle("Automated Voting System v.1");
        		cont.setLocation(235,50);
        		cont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		//cont.setResizable(false);
        		cont.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
        		cont.setContentPane(new JLabel(new ImageIcon(LogIn.class.getResource("/Main.JPG"))));
        		//Panel
        		option.setLayout(null);
        		option.setVisible(true);
        		option.setSize(300,230);
        		option.setBounds(100,220,700,170);
        		option.setBackground(new Color(20, 10, 1, 90));
        		cont.add(option);
        		//Administrator button
        		admin.setFont(new Font("Arial", Font.BOLD, 20));
        		admin.setBounds(48, 40, 270, 80);
        		admin.setIcon(new ImageIcon(LogIn.class.getResource("/AdminIcon.png")));
        		option.add(admin);
        		//Voter button
        		voter.setFont(new Font("Arial", Font.BOLD, 40));
        		voter.setBounds(380, 40, 270, 80);
        		voter.setLayout(new GridLayout(2,1));
        		voter.setIcon(new ImageIcon(LogIn.class.getResource("/UserIcon.png")));
        		option.add(voter);
        		cont.pack();
        		
        		admin.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				cont.dispose();
        				new adminLogInForm();
        			}
        		});
        		voter.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				cont.dispose();
        				new voterLogInForm();
        			}
        		});
        }

	public static void main(String args[]) throws Exception
    {
     new LogIn();       
    }//end of public static void main(String args[])
}//end of public class LogIn extends JFrame

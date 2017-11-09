import java.awt.Color;
import java.awt.Font;
import java.awt.*;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class adminLogInForm extends JFrame{
	private JFrame adminLog = new JFrame("Automated Voting System v.1");
	
	public adminLogInForm(){
		adminLog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		adminLog.setSize(950, 620);
		adminLog.setLocation(235,50);
		adminLog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		adminLog.setVisible(true);
		adminLog.setResizable(false);
		adminLog.setContentPane(new JLabel(new ImageIcon(adminLogInForm.class.getResource("/AdminForm.jpg"))));
		
		
		JLabel username = new JLabel("USERNAME");
		username.setFont(new Font("Arial", Font.BOLD, 20));
		username.setForeground(Color.WHITE);
		username.setBounds(300, 150, 150, 40);
		adminLog.add(username);
		
		JTextField uname = new JTextField("", 20);
		uname.setBounds(300, 200, 300, 30);
		adminLog.add(uname);
		
		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Arial", Font.BOLD,20));
		password.setForeground(Color.WHITE);
		password.setBounds(300, 240, 150, 40);
		adminLog.add(password);
		
		JPasswordField pass = new JPasswordField("", 20);
		pass.setBounds(300, 290, 300, 30);
		adminLog.add(pass);
		
		
		JButton alogIn = new JButton("LOG-IN");
		alogIn.setBounds(300, 340, 300,40);
		alogIn.setFont(new Font("Calibri", Font.BOLD,25));
		alogIn.setIcon(new ImageIcon(adminLogInForm.class.getResource("/LogIn.png")));
		adminLog.add(alogIn);
		
		alogIn.addActionListener(new ActionListener() {
			String usname = "admin";
			String pword = "admin";
			
			public void actionPerformed(ActionEvent ae) {
				
				if(usname.equals(uname.getText()) && pword.equals(pass.getText())){
					adminLog.dispose();
					new Administrator();
				}
				else{
					JOptionPane.showMessageDialog(adminLog, "Incorrect username/password","Automated Voting System v.1", JOptionPane.ERROR_MESSAGE);
					uname.setText("");
					pass.setText("");
					uname.requestFocus();
				}
			}
		});
		
		JButton acancel = new JButton("CANCEL");
		acancel.setBounds(300, 390, 300,40);
		acancel.setFont(new Font("Calibri", Font.BOLD,25));
		acancel.setIcon(new ImageIcon(adminLogInForm.class.getResource("/Cancel.PNG")));
		adminLog.add(acancel);
		adminLog.getRootPane().setDefaultButton(alogIn);
		acancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				adminLog.dispose();
				new LogIn();
			}
		});
			
		adminLog.pack();	
	}
  }		


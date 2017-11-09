import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class voterLogInForm extends JFrame implements ActionListener{
	private JFrame voterLog = new JFrame("Automated Voting System v.1");
	JFrame voter;
	JButton presBut, vicePresBut,secBut,treasBut,audiBut,pioBut,castBut;
	JTextField uname;
	public voterLogInForm(){
		voterLog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		voterLog.setSize(950, 620);
		voterLog.setLocation(235,50);
		voterLog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		voterLog.setVisible(true);
		voterLog.setResizable(false);
		voterLog.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/VoterForm.JPG"))));
	
		JLabel voterID = new JLabel("VOTER's ID");
		voterID.setFont(new Font("Arial", Font.BOLD, 20));
		voterID.setForeground(Color.WHITE);
		voterID.setBounds(300, 150, 150, 40);
		voterLog.add(voterID);
		
		uname = new JTextField("", 20);
		uname.setBounds(300, 200, 300, 30);
		voterLog.add(uname);
		
		JButton vlogIn = new JButton("Log-in");
		vlogIn.setBounds(300, 340, 300,40);
		vlogIn.setFont(new Font("Calibri", Font.BOLD,25));
		vlogIn.setIcon(new ImageIcon(voterLogInForm.class.getResource("/LogIn.png")));		
		voterLog.add(vlogIn);
		vlogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			 if(uname.getText().equals("")){
				 JOptionPane.showMessageDialog(null,"Kindly enter the voter's ID","Automated Voting System v.1",JOptionPane.WARNING_MESSAGE);
            	 uname.setText("");
            	 uname.requestFocus();
			 }
			 
			 else{
				 try
					{
		            	    File allInfo = new File("Voter.txt");
		  					allInfo.createNewFile();
		  					BufferedWriter out = new BufferedWriter(new FileWriter(allInfo,true));
						    BufferedReader in = new BufferedReader(new FileReader("Voter.txt"));
						    String text = "";
						    double count = 0;
		                      while((text = in.readLine()) != null){
		                    	  String[] words = text.split(" ");
		                    	 for(String word : words){
		                        if(word.equals(uname.getText())){
								    count++;
										}
		                    	      }
		                            }
		                         if(count >= 1)
		                         	{
		                        	 voterLog.dispose();
		                        	 voting();
		                         	}
		                         else{
		                        	 JOptionPane.showMessageDialog(null,"Voter did not exist/voted already","Automated Voting System v.1",JOptionPane.ERROR_MESSAGE);
		                        	 uname.setText("");
		                        	 uname.requestFocus();
		                         }

				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
 
			 }
		   }
		});
		JButton vcancel = new JButton("Cancel");
		vcancel.setBounds(300, 390, 300,40);
		vcancel.setFont(new Font("Calibri", Font.BOLD,25));
		vcancel.setIcon(new ImageIcon(voterLogInForm.class.getResource("/Cancel.PNG")));
		voterLog.add(vcancel);
		
		voterLog.pack();
		voterLog.getRootPane().setDefaultButton(vlogIn);
		vcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				voterLog.dispose();
				new LogIn();
			}
		});
			
	}
	@SuppressWarnings("deprecation")
	public void voting(){
		voter = new JFrame("Automated Voting System v.1");
		voter.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		voter.setVisible(true);
		voter.setSize(905, 629);
		voter.setLocation(235,50);
		voter.setResizable(false);
		voter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		voter.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/VoterF.jpg"))));
		
		JPanel voting = new JPanel();
		voting.setLayout(null);
		voting.setVisible(true);
		voting.setBorder(BorderFactory.createBevelBorder(45));
		voter.add(voting);
		
		presBut = new JButton("PRESIDENT");
		presBut.setBounds(40,150,260,90);
		presBut.setFont(new Font("Calibri",Font.BOLD,30));
		presBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/presBut.PNG")));
		voter.add(presBut);
		presBut.addActionListener(this);
		
		vicePresBut = new JButton("VICE-PRESIDENT");
		vicePresBut.setBounds(320,150,260,90);
		vicePresBut.setFont(new Font("Calibri",Font.BOLD,20));
		vicePresBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vicePresBut.PNG")));
		voter.add(vicePresBut);
		vicePresBut.addActionListener(this);
		
		secBut = new JButton("SECRETARY");
		secBut.setBounds(600,150,260,90);
		secBut.setFont(new Font("Calibri",Font.BOLD,30));
		secBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/secBut.png")));
		voter.add(secBut);
		secBut.addActionListener(this);
		
		treasBut = new JButton("TREASURER");
		treasBut.setBounds(40,270,260,90);
		treasBut.setFont(new Font("Calibri",Font.BOLD,30));
		treasBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/treasBut.png")));
		voter.add(treasBut);
		treasBut.addActionListener(this);
		
		audiBut = new JButton("AUDITOR");
		audiBut.setBounds(320,270,260,90);
		audiBut.setFont(new Font("Calibri",Font.BOLD,30));
		audiBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/audiBut.png")));
		voter.add(audiBut);
		audiBut.addActionListener(this);
		
		pioBut = new JButton("PUBLIC INFORMATION OFFICER");
		pioBut.setBounds(600,270,260,90);
		pioBut.setFont(new Font("Calibri",Font.BOLD,11));
		pioBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/pioBut.png")));
		voter.add(pioBut);
		pioBut.addActionListener(this);
		
		castBut = new JButton("Cast Vote");
		castBut.setBounds(373,420,150,60);
		voter.add(castBut);
		castBut.setIcon(new ImageIcon(voterLogInForm.class.getResource("/cVote.PNG")));
		castBut.addActionListener(this);
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(null);
		tempPanel.setVisible(true);
		voter.add(tempPanel);
	}
	public void actionPerformed(ActionEvent x){
		if(x.getSource() == presBut){
			president();
		}
		else if(x.getSource() == vicePresBut){
			vPres();
		}
		else if(x.getSource() == secBut){
			secretary();
		}
		else if(x.getSource() == treasBut){
			treasurer();
		}
		else if(x.getSource() == audiBut){
			auditor();
		}
		else if(x.getSource() == pioBut){
			PIO();
		}
		else if(x.getSource() == castBut){
			cast();
		}
	}
	
	public void president(){
		JFrame presVote = new JFrame("Choose 1 President:");
	    JComboBox pres = new JComboBox();
	    JButton Cvote = new JButton("VOTE");
	    JButton abstain = new JButton("ABSTAIN");
		presVote.setSize(400, 200);
		presVote.setVisible(true);
		presVote.setResizable(false);
		presVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		presVote.setLocation(480,255);
		presVote.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/presVote.jpg"))));
		presVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		presVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("President.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				pres.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    pres.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		presVote.add(abstain);
		presVote.add(pres);
		presVote.add(Cvote);
		
		
	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
			try{
				Scanner f = new Scanner(new FileReader("President.txt"));
				StringBuilder inp = new StringBuilder();
			 while(f.hasNext()){
				    String id = f.next();
					String lName = f.next();
					String fName = f.next();
					String mName = f.next();				  
					String vote = f.next();
					String nlName = lName.replaceAll(",", " ");
					String nfName = fName.replaceAll(",", " ");
					String nmName = mName.replaceAll(",", " ");
					String name = nlName+" "+nfName+" "+nmName;
					String temp = (String) pres.getSelectedItem();
					String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
				if(temp.equals(name)){
					 int  num = Integer.parseInt(vote);
		             int newnum = num + 1;
		             String nCount = Integer.toString(newnum);
		             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
		             inp.append(newLine);
		             inp.append(System.lineSeparator());
		             JOptionPane.showMessageDialog(null,"Voted: "+pres.getSelectedItem(),"PRESIDENT",JOptionPane.INFORMATION_MESSAGE);
	                 presVote.dispose();
	                 presBut.setEnabled(false);
				}
				else{
					inp.append(oldLine);
					inp.append(System.lineSeparator());
				}
			 }
			    BufferedWriter out = new BufferedWriter(new FileWriter("President.txt"));
			    out.write(inp.toString());
			    out.close(); 
			}
					catch(Exception c){
						c.getMessage();
					}
		}
	});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			presVote.dispose();
		}
	});
}
	public void vPres(){
		JFrame vPresVote = new JFrame("Choose 1 Vice-President:");
		JComboBox vPres = new JComboBox();
	    JButton Cvote = new JButton("VOTE");
	    JButton abstain = new JButton("ABSTAIN");
		vPresVote.setSize(400, 200);
		vPresVote.setVisible(true);
		vPresVote.setResizable(false);
		vPresVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		vPresVote.setLocation(480,255);
		vPresVote.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/vpresVote.jpg"))));
		vPresVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		vPresVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("Vice-President.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				vPres.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    vPres.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		vPresVote.add(abstain);
		vPresVote.add(vPres);
		vPresVote.add(Cvote);

	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
				try{
					Scanner f = new Scanner(new FileReader("Vice-President.txt"));
					StringBuilder inp = new StringBuilder();
				 while(f.hasNext()){
					    String id = f.next();
						String lName = f.next();
						String fName = f.next();
						String mName = f.next();				  
						String vote = f.next();
						String nlName = lName.replaceAll(",", " ");
						String nfName = fName.replaceAll(",", " ");
						String nmName = mName.replaceAll(",", " ");
						String name = nlName+" "+nfName+" "+nmName;
						String temp = (String) vPres.getSelectedItem();
						String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
					if(temp.equals(name)){
						 int  num = Integer.parseInt(vote);
			             int newnum = num + 1;
			             String nCount = Integer.toString(newnum);
			             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
			             inp.append(newLine);
			             inp.append(System.lineSeparator());
			             JOptionPane.showMessageDialog(null,"Voted: "+vPres.getSelectedItem(),"VICE-PRESIDENT",JOptionPane.INFORMATION_MESSAGE);
		                 vPresVote.dispose();
		                 vicePresBut.setEnabled(false);
					}
					else{
						inp.append(oldLine);
						inp.append(System.lineSeparator());
					}
				 }
				    BufferedWriter out = new BufferedWriter(new FileWriter("Vice-President.txt"));
				    out.write(inp.toString());
				    out.close(); 
				}
						catch(Exception c){
							c.getMessage();
						}
			}
		});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			vPresVote.dispose();
		}
	});
}
	public void secretary(){
		JFrame secVote = new JFrame("Choose 1 Secretary:");
		JComboBox sec = new JComboBox();
	    JButton Cvote = new JButton("VOTE");
	    JButton abstain = new JButton("ABSTAIN");
	    
		secVote.setSize(400, 200);
		secVote.setVisible(true);
		secVote.setResizable(false);
		secVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		secVote.setLocation(480,255);
		secVote.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/secVote.jpg"))));
		secVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		secVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("Secretary.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				sec.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    sec.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		secVote.add(abstain);
		secVote.add(sec);
		secVote.add(Cvote);

	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
				try{
					Scanner f = new Scanner(new FileReader("Secretary.txt"));
					StringBuilder inp = new StringBuilder();
				 while(f.hasNext()){
					    String id = f.next();
						String lName = f.next();
						String fName = f.next();
						String mName = f.next();				  
						String vote = f.next();
						String nlName = lName.replaceAll(",", " ");
						String nfName = fName.replaceAll(",", " ");
						String nmName = mName.replaceAll(",", " ");
						String name = nlName+" "+nfName+" "+nmName;
						String temp = (String) sec.getSelectedItem();
						String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
					if(temp.equals(name)){
						 int  num = Integer.parseInt(vote);
			             int newnum = num + 1;
			             String nCount = Integer.toString(newnum);
			             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
			             inp.append(newLine);
			             inp.append(System.lineSeparator());
			             JOptionPane.showMessageDialog(null,"Voted: "+sec.getSelectedItem(),"SECRETARY",JOptionPane.INFORMATION_MESSAGE);
		                 secVote.dispose();
		                 secBut.setEnabled(false);
					}
					else{
						inp.append(oldLine);
						inp.append(System.lineSeparator());
					}
				 }
				    BufferedWriter out = new BufferedWriter(new FileWriter("Secretary.txt"));
				    out.write(inp.toString());
				    out.close(); 
				}
						catch(Exception c){
							c.getMessage();
						}
			}
		});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			secVote.dispose();
		}
	});
}
	public void treasurer(){
		JFrame treasVote = new JFrame("Choose 1 Treasurer:");
		JComboBox treas = new JComboBox();
		JButton Cvote = new JButton("VOTE");
		JButton abstain = new JButton("ABSTAIN");
		
		treasVote.setSize(400, 200);
		treasVote.setVisible(true);
		treasVote.setResizable(false);
		treasVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		treasVote.setLocation(480,255);
		treasVote.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/treasVote.jpg"))));
		treasVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		treasVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("Treasurer.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				treas.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    treas.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		treasVote.add(abstain);
		treasVote.add(treas);
		treasVote.add(Cvote);

	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
				try{
					Scanner f = new Scanner(new FileReader("Treasurer.txt"));
					StringBuilder inp = new StringBuilder();
				 while(f.hasNext()){
					    String id = f.next();
						String lName = f.next();
						String fName = f.next();
						String mName = f.next();				  
						String vote = f.next();
						String nlName = lName.replaceAll(",", " ");
						String nfName = fName.replaceAll(",", " ");
						String nmName = mName.replaceAll(",", " ");
						String name = nlName+" "+nfName+" "+nmName;
						String temp = (String) treas.getSelectedItem();
						String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
					if(temp.equals(name)){
						 int  num = Integer.parseInt(vote);
			             int newnum = num + 1;
			             String nCount = Integer.toString(newnum);
			             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
			             inp.append(newLine);
			             inp.append(System.lineSeparator());
			             JOptionPane.showMessageDialog(null,"Voted: "+treas.getSelectedItem(),"TREASURER",JOptionPane.INFORMATION_MESSAGE);
		                 treasVote.dispose();
		                 treasBut.setEnabled(false);
					}
					else{
						inp.append(oldLine);
						inp.append(System.lineSeparator());
					}
				 }
				    BufferedWriter out = new BufferedWriter(new FileWriter("Treasurer.txt"));
				    out.write(inp.toString());
				    out.close(); 
				}
						catch(Exception c){
							c.getMessage();
						}
			}
		});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			treasVote.dispose();
		}
	});
}
	public void auditor(){
		JFrame audiVote = new JFrame("Choose 1 Auditor:");
		JComboBox audi = new JComboBox();
		JButton Cvote = new JButton("VOTE");
		JButton abstain = new JButton("ABSTAIN");
		
		audiVote.setSize(400, 200);
		audiVote.setVisible(true);
		audiVote.setResizable(false);
		audiVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		audiVote.setLocation(480,255);
		audiVote.setContentPane(new JLabel(new ImageIcon("audiVote.jpg")));
		audiVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		audiVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("Auditor.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				audi.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    audi.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		audiVote.add(abstain);
		audiVote.add(audi);
		audiVote.add(Cvote);

	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
				try{
					Scanner f = new Scanner(new FileReader("Auditor.txt"));
					StringBuilder inp = new StringBuilder();
				 while(f.hasNext()){
					    String id = f.next();
						String lName = f.next();
						String fName = f.next();
						String mName = f.next();				  
						String vote = f.next();
						String nlName = lName.replaceAll(",", " ");
						String nfName = fName.replaceAll(",", " ");
						String nmName = mName.replaceAll(",", " ");
						String name = nlName+" "+nfName+" "+nmName;
						String temp = (String) audi.getSelectedItem();
						String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
					if(temp.equals(name)){
						 int  num = Integer.parseInt(vote);
			             int newnum = num + 1;
			             String nCount = Integer.toString(newnum);
			             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
			             inp.append(newLine);
			             inp.append(System.lineSeparator());
			             JOptionPane.showMessageDialog(null,"Voted: "+audi.getSelectedItem(),"AUDITOR",JOptionPane.INFORMATION_MESSAGE);
		                 audiVote.dispose();
		                 audiBut.setEnabled(false);
					}
					else{
						inp.append(oldLine);
						inp.append(System.lineSeparator());
					}
				 }
				    BufferedWriter out = new BufferedWriter(new FileWriter("Auditor.txt"));
				    out.write(inp.toString());
				    out.close(); 
				}
						catch(Exception c){
							c.getMessage();
						}
			}
		});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			audiVote.dispose();
		}
	});
}
	public void PIO(){
		JFrame pioVote = new JFrame("Choose 1 Public Information Officer:");
		JComboBox pio = new JComboBox();
		JButton Cvote = new JButton("VOTE");
		JButton abstain = new JButton("ABSTAIN");
		
		pioVote.setSize(400, 200);
		pioVote.setVisible(true);
		pioVote.setResizable(false);
		pioVote.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pioVote.setLocation(480,255);
		pioVote.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/pioVote.jpg"))));
		pioVote.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		pioVote.getRootPane().setDefaultButton(Cvote);
		
		try{
			Scanner in = new Scanner(new FileReader("Public Information Officer.txt"));
			String line = "";
			int ctr = 0;
			do{
				String id = in.next();
				String lName = in.next();
				String fName = in.next();
				String mName = in.next();
				String nlName = lName.replaceAll(",", " ");
				String nfName = fName.replaceAll(",", " ");
				String nmName = mName.replaceAll(",", " ");
				String name = nlName+" "+nfName+" "+nmName;
				String[] name1 = {name};
				pio.addItem(name);
				ctr++;
			}while((line = in.nextLine()) != null);
			in.close();
		}
		
		catch(Exception e){
		   e.getMessage();		
		   }
	    pio.setBounds(75,62,250,30);
		Cvote.setBounds(90,120,100,40);
		abstain.setBounds(200,120,115,40);
		Cvote.setIcon(new ImageIcon(voterLogInForm.class.getResource("/vote.PNG")));
		abstain.setIcon(new ImageIcon(voterLogInForm.class.getResource("/abstainBut.PNG")));
		pioVote.add(abstain);
		pioVote.add(pio);
		pioVote.add(Cvote);

	Cvote.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent x){
				try{
					Scanner f = new Scanner(new FileReader("Public Information Officer.txt"));
					StringBuilder inp = new StringBuilder();
				 while(f.hasNext()){
					    String id = f.next();
						String lName = f.next();
						String fName = f.next();
						String mName = f.next();				  
						String vote = f.next();
						String nlName = lName.replaceAll(",", " ");
						String nfName = fName.replaceAll(",", " ");
						String nmName = mName.replaceAll(",", " ");
						String name = nlName+" "+nfName+" "+nmName;
						String temp = (String) pio.getSelectedItem();
						String oldLine = id+" "+lName+" "+fName+" "+mName+" "+vote;
					if(temp.equals(name)){
						 int  num = Integer.parseInt(vote);
			             int newnum = num + 1;
			             String nCount = Integer.toString(newnum);
			             String newLine = id+" "+lName+" "+fName+" "+mName+" "+nCount;
			             inp.append(newLine);
			             inp.append(System.lineSeparator());
			             JOptionPane.showMessageDialog(null,"Voted: "+pio.getSelectedItem(),"PUBLIC INFORMATION OFFICER",JOptionPane.INFORMATION_MESSAGE);
		                 pioVote.dispose();
		                 pioBut.setEnabled(false);
					}
					else{
						inp.append(oldLine);
						inp.append(System.lineSeparator());
					}
				 }
				    BufferedWriter out = new BufferedWriter(new FileWriter("Public Information Officer.txt"));
				    out.write(inp.toString());
				    System.out.println("input"+inp);
		            System.out.println("out"+out);
				    out.close(); 
				}
						catch(Exception c){
							c.getMessage();
						}
			}
		});
	
	abstain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d){
			pioVote.dispose();
			castBut.setEnabled(true);
		}
	});
}
	
	public void cast(){
		JFrame castV = new JFrame("Voter's Confirmation");
		JTextField IDnum = new JTextField("",20);
		JButton conf = new JButton("CONFIRM");
		castV.setSize(300, 200);
		castV.setVisible(true);
		castV.setResizable(false);
		castV.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		castV.setLocation(538,255);
		castV.setContentPane(new JLabel(new ImageIcon(voterLogInForm.class.getResource("/vConf.jpg"))));
		castV.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.PNG")));
		castV.getRootPane().setDefaultButton(conf);
		
		IDnum.setBounds(71,60,150,30);
		conf.setBounds(85,128,120,30);
		conf.setIcon(new ImageIcon(voterLogInForm.class.getResource("/conf.PNG")));
		
		castV.add(IDnum); castV.add(conf);
		
	conf.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent x){
			if(uname.getText().equals(IDnum.getText())){
				try{
					Scanner in = new Scanner(new FileReader("Voter.txt"));
					StringBuilder input = new StringBuilder(); 
			        int ctr = 0;
					while(in.hasNext()){
						 String ID = in.next();        
			             String lName = in.next();    
			             String fName = in.next();       
			             String mName = in.next();        
			             String age = in.next();   
			             String gender = in.next();
			             String month = in.next();
			             String day = in.next();
			             String year = in.next();
			             String prov1 = in.next();
			             String city1 = in.next();
			             String cStatus = in.next();
			             String spouse = in.next();
			             String occu = in.next();
			             String prov2 = in.next();
			             String city2 = in.next();
			             String bar = in.next();
			             String strit = in.next();
			       String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age+" "+gender+" "+month+" "+day+" "+year+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit;
			            if(ID.equals(IDnum.getText())){
			            	ctr++;   
			            }
			            else{
			            	input.append(oldLine);
			            	input.append(System.lineSeparator());
			            	continue;
			            }
					}
					BufferedWriter out = new BufferedWriter(new FileWriter("Voter.txt"));
		            out.write(input.toString());
		            out.append(System.lineSeparator());
		            out.close();
					if(ctr == 1){
		            	JOptionPane.showMessageDialog(null,"Vote successfully casted!","Voter's Confirmation",JOptionPane.INFORMATION_MESSAGE);
		            	IDnum.setText("");
		            	IDnum.requestFocus();
		                castV.dispose();
		            	voter.dispose();
		            	new LogIn();
					}
		            else{
		            	JOptionPane.showMessageDialog(null,"Voter did not exist","Voter's Confirmation",JOptionPane.ERROR_MESSAGE);
		            	IDnum.setText("");
		            	IDnum.requestFocus();
		            }
					
				}
				catch(Exception q){
					q.getMessage();
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Incorrect Voter's ID","Voter's Confirmation",JOptionPane.ERROR_MESSAGE);
				IDnum.setText("");
				IDnum.requestFocus();
			}	
		}
	});
  }
}		


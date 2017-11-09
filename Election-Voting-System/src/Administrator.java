import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
public class Administrator extends JFrame implements MenuListener,ActionListener,KeyListener{

	JFrame admin = new JFrame("Automated Voting System v.1");
	JMenuBar adMenu = new JMenuBar();
	JMenu result = new JMenu("Result");
	JMenu viewAll = new JMenu("View All");
	JMenu about = new JMenu("About");
	JMenu exit = new JMenu("Log-out");
	JMenuItem candidates = new JMenuItem("Search Position");
	JMenuItem vwAllC = new JMenuItem("Candidate");
	JMenuItem vwAllV = new JMenuItem("Voter");
	JMenuItem abtSys = new JMenuItem("Automated Voting System v.1");
	JMenuItem abtDev = new JMenuItem("Developers");
	JMenuItem LogOut = new JMenuItem("Log-out as Administrator");
	JMenuItem ExitSys = new JMenuItem("Exit");
	JButton addCanButton, editCanButton, delCanButton, seaCanButton;
	JButton addVotButton, editVotButton, delVotButton, seaVotButton;
	ImageIcon icon = new ImageIcon("C:\\Users\\User\\workspace\\Election Voting System(1)\\src\\icon.png");
	String filePath = ("C:\\Users\\User\\workspace\\Election Voting System(1)\\");
	public Administrator(){
		//Main frame
		admin.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	    admin.setSize(905,629);
		admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admin.setLocation(235,50);
		admin.setVisible(true);
		admin.setResizable(false);
		admin.setContentPane(new JLabel(new ImageIcon("Admin.JPG")));
		//Menu Bar
		adMenu.add(result);
		result.add(candidates);
		adMenu.add(viewAll);
		viewAll.add(vwAllC);
		viewAll.addSeparator();
		viewAll.add(vwAllV);
		adMenu.add(about);
		about.add(abtSys);
		about.addSeparator();
		about.add(abtDev);
		adMenu.add(exit);
		exit.add(LogOut);
		exit.addSeparator();
		exit.add(ExitSys);
		admin.setJMenuBar(adMenu);
		candidates.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				 result();  
			}
		});
		vwAllC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				allCan();
			}
		});
		vwAllV.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				allVot();
			}
		});
		abtSys.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				JOptionPane.showMessageDialog(null,"Automated Voting System v.1\n\nA system that can add, edit, delete a candidate and a voter as well\nyou can do all of that in our Automated Voting System","About (Automated Voting System v.1)",JOptionPane.INFORMATION_MESSAGE,icon);  
			}
		});
		abtDev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				JOptionPane.showMessageDialog(null,"                       Developers:\n           Ryan Joseph R. Samonte\n             Mikale Edriean A. Cirilo\n              Lowell Jay F. Vasquez\nPolytechnic University of the Philippines\n           College of Computer and\n              Information Sciences\n                       BSIT 2-FS1N","About (Developers)",JOptionPane.INFORMATION_MESSAGE,icon);  
			}
		});
		LogOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				String[] button = {"Yes","No"};
				int ch = JOptionPane.showOptionDialog(null,"Are you sure you want to log-out?","Automated Voting System v.1",JOptionPane.YES_NO_OPTION,0,null,button,button[0]);
					if(ch == 0){
						admin.dispose();
						new LogIn();
					}  
			}
		});
		ExitSys.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				String[] button = {"Yes","No"};
				int ch = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Automated Voting System v.1",JOptionPane.YES_NO_OPTION,0,null,button,button[0]);
					if(ch == 0){
						admin.dispose();
					}  
			}
		});
		
		
		
		//Candidate
		addCanButton = new JButton("Add Candidate");
		addCanButton.setBounds(15, 170, 180,30);
		addCanButton.setIcon(new ImageIcon("addCan.png"));
		admin.add(addCanButton);
		addCanButton.addActionListener(this);
	
		
		editCanButton = new JButton("Edit Candidate");
		editCanButton.setBounds(15, 210, 180,30);
		editCanButton.setIcon(new ImageIcon("editCan.png"));
		admin.add(editCanButton);
		editCanButton.addActionListener(this);
	
		delCanButton = new JButton("Delete Candidate");
		delCanButton.setBounds(15, 250, 180,30);
		delCanButton.setIcon(new ImageIcon("delCan.png"));
		admin.add(delCanButton);
		delCanButton.addActionListener(this);
		
		seaCanButton = new JButton("Search Candidate");
		seaCanButton.setBounds(15, 290, 180,30);
		seaCanButton.setIcon(new ImageIcon("seaCan.png"));
		admin.add(seaCanButton);
	    seaCanButton.addActionListener(this);
		//Voter
		addVotButton = new JButton("Add Voter");
		addVotButton.setIcon(new ImageIcon("addVot.png"));
		addVotButton.setBounds(15, 380, 180,30);
		admin.add(addVotButton);
		addVotButton.addActionListener(this);
		
		editVotButton = new JButton("Edit Voter");
		editVotButton.setBounds(15, 420, 180,30);
		editVotButton.setIcon(new ImageIcon("editVot.png"));
		admin.add(editVotButton);
		editVotButton.addActionListener(this);
		
		delVotButton = new JButton("Delete Voter");
		delVotButton.setBounds(15, 460, 180,30);
		delVotButton.setIcon(new ImageIcon("delVot.png"));
		admin.add(delVotButton);
		delVotButton.addActionListener(this);
		
		seaVotButton = new JButton("Search Voter");
		seaVotButton.setIcon(new ImageIcon("seaVot.png"));
		seaVotButton.setBounds(15, 500, 180,30);
		admin.add(seaVotButton);
		seaVotButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent a){
		if(a.getSource() == addCanButton){
			addingCandidate();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == editCanButton){
			editingCandidate();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == delCanButton){
			deletingCandidate();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == seaCanButton){
			searchingCandidate();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == addVotButton){
			addingVoter();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == editVotButton){
			editingVoter();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == delVotButton){
			deletingVoter();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
		else if(a.getSource() == seaVotButton){
			searchingVoter();
			addCanButton.setEnabled(false); editCanButton.setEnabled(false);  delCanButton.setEnabled(false);  seaCanButton.setEnabled(false);
			addVotButton.setEnabled(false); editVotButton.setEnabled(false);  delVotButton.setEnabled(false);  seaVotButton.setEnabled(false); 
		}
	}		

	//-----------ADDING CANDIDATE METHOD-----------//
	public String addingCandidate(){
		final JFrame addCan = new JFrame();
		JPanel addPan,candidateIDPanel,namePanel,agePanel,genderPanel;
		JPanel dateofBirthPanel,placeofBirthPanel,civilStatusPanel;
		JPanel nameOfSpousePanel,occupationPanel,addressPanel,positionPanel;
		JButton newButton, addButton, cancelButton;
		ButtonGroup gender;
		JRadioButton male, female;
	addCan.setUndecorated(true);
	addCan.setSize(680, 486);
	addCan.setVisible(true);
	addCan.setLocation(456,190);
	addCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	addCan.setResizable(false);
	addPan = new JPanel();
	addPan.setVisible(true);
	addPan.setLayout(null);
	addPan.setBounds(5, 5, 671, 430);
	addPan.setBackground(Color.white);
	addPan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	//Candidate ID No. Panel
	candidateIDPanel = new JPanel();
	addPan.add(candidateIDPanel);
	candidateIDPanel.setVisible(true);
	candidateIDPanel.setLayout(null);
	candidateIDPanel.setBounds(10,10,100,80);
	candidateIDPanel.setBorder(BorderFactory.createTitledBorder(" CANDIDATE ID"));
	candidateIDPanel.setBackground(Color.white);
	JLabel ast1 = new JLabel("*");
	ast1.setFont(new Font("Arial",Font.BOLD,20));
	ast1.setBounds(3, 2, 20,20);
	candidateIDPanel.add(ast1);

	JTextField candidateID = new JTextField("",20);
	candidateID.setBounds(10, 28, 80, 20);
    String can = candidateID.getText();
    
	//Name Panel
	namePanel = new JPanel();
	addPan.add(namePanel);
	namePanel.setVisible(true);
	namePanel.setLayout(null);
	namePanel.setBounds(110,10,480,80);
	namePanel.setBorder(BorderFactory.createTitledBorder(" NAME"));
	namePanel.setBackground(Color.white);
	JLabel ast2 = new JLabel("*");
	ast2.setFont(new Font("Arial",Font.BOLD,20));
	ast2.setBounds(3, 2, 20,20);
	namePanel.add(ast2);
	
	JTextField Lname = new JTextField("",40);
	Lname.setBounds(10, 28, 150, 20);
	JLabel lastName = new JLabel("Last Name");
	lastName.setBounds(10, 40, 100, 40);
	
	JLabel comma1 = new JLabel(",");
	comma1.setBounds(160, 30,20,20);
	comma1.setFont(new Font("Arial",Font.PLAIN,20));
	
	JTextField Fname = new JTextField("",40);
	Fname.setBounds(167, 28, 150, 20);
	JLabel firstName = new JLabel("First Name");
	firstName.setBounds(167, 40, 100, 40);
	
	JTextField Mname = new JTextField("",40);
	Mname.setBounds(320, 28, 150, 20);
	JLabel middleName = new JLabel("Middle Name");
	middleName.setBounds(330, 40, 100, 40);
	
	//Age Panel
	agePanel = new JPanel();
	addPan.add(agePanel);
	agePanel.setVisible(true);
	agePanel.setLayout(null);
	agePanel.setBounds(590,10,74,80);
	agePanel.setBorder(BorderFactory.createTitledBorder(" AGE"));
	agePanel.setBackground(Color.white);
	JLabel ast3 = new JLabel("*");
	ast3.setFont(new Font("Arial",Font.BOLD,20));
	ast3.setBounds(3, 2, 20,20);
	agePanel.add(ast3);
	
	JTextField age = new JTextField("",20);
	age.setBounds(10, 28, 50, 20);

	//Gender Panel
	genderPanel = new JPanel();
	addPan.add(genderPanel);
	genderPanel.setVisible(true);
	genderPanel.setLayout(null);
	genderPanel.setBounds(10,90,144,80);
	genderPanel.setBorder(BorderFactory.createTitledBorder(" GENDER"));
	genderPanel.setBackground(Color.white);
	JLabel ast4 = new JLabel("*");
	ast4.setFont(new Font("Arial",Font.BOLD,20));
	ast4.setBounds(3, 2, 20,20);
	genderPanel.add(ast4);
	
	gender = new ButtonGroup();
	male = new JRadioButton("Male");
	male.setBackground(Color.white);
	female = new JRadioButton("Female");
	female.setBackground(Color.white);
	gender.add(male);
	gender.add(female);
	male.setBounds(5,30,65,20);
	female.setBounds(68,30,70,20);
			
	//Date of Birth Panel
	dateofBirthPanel = new JPanel();
	addPan.add(dateofBirthPanel);
	dateofBirthPanel.setVisible(true);
	dateofBirthPanel.setLayout(null);
	dateofBirthPanel.setBounds(154,90,233,80);
	dateofBirthPanel.setBorder(BorderFactory.createTitledBorder(" DATE OF BIRTH"));
	dateofBirthPanel.setBackground(Color.white);
	JLabel ast5 = new JLabel("*");
	ast5.setFont(new Font("Arial",Font.BOLD,20));
	ast5.setBounds(3, 2, 20,20);
	dateofBirthPanel.add(ast5);
	
	String[] monthNames = {"...","January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox monthChoice = new JComboBox(monthNames);
	monthChoice.setBounds(10, 20, 100,20);
	JLabel monthLabel = new JLabel("Month");
	monthLabel.setBounds(10, 32, 350, 40);
	
	JComboBox day = new JComboBox();
	day.setBounds(117, 20, 40, 20);
	int dayCtr = 0;
	for(dayCtr = 1; dayCtr <= 31; dayCtr++){
		String dey = (String) Integer.toString(dayCtr); 
		String[] dayArray = {dey};
		day.addItem(dey);
	}
	JLabel dayLabel = new JLabel("Day");
	dayLabel.setBounds(117, 32, 350, 40);

    JComboBox year = new JComboBox();
	year.setBounds(165, 20, 55, 20);
	int yearCtr = 0;
	for(yearCtr = 2016; yearCtr >= 1900; yearCtr--){
		String yer = (String) Integer.toString(yearCtr); 
		String[] yearArray = {yer};
		year.addItem(yer);
	}
	JLabel yearLabel = new JLabel("Year");
	yearLabel.setBounds(165, 32, 350, 40);
	
	//Place of Birth Panel
	placeofBirthPanel = new JPanel();
	addPan.add(placeofBirthPanel);
	placeofBirthPanel.setVisible(true);
	placeofBirthPanel.setLayout(null);
	placeofBirthPanel.setBounds(387,90,277,80);
	placeofBirthPanel.setBorder(BorderFactory.createTitledBorder("PLACE OF BIRTH"));
	placeofBirthPanel.setBackground(Color.white);
	
	JTextField province = new JTextField("",40);
	province.setBounds(10, 20, 125, 20);
	JLabel provinceL = new JLabel("Province");
	provinceL.setBounds(10, 32, 100, 40);
	
	JTextField city = new JTextField("",40);
	city.setBounds(140, 20, 130, 20);
	JLabel cityMuni = new JLabel("City/Municipality");
	cityMuni.setBounds(140, 32, 100, 40);
	JLabel ast6 = new JLabel("*");
	ast6.setFont(new Font("Arial",Font.BOLD,20));
	ast6.setBounds(132, 45, 20,20);
	placeofBirthPanel.add(ast6);
	
	
	//Civil Status Panel
	civilStatusPanel = new JPanel();
	addPan.add(civilStatusPanel);
	civilStatusPanel.setVisible(true);
	civilStatusPanel.setLayout(null);
	civilStatusPanel.setBounds(10,170,140,80);
	civilStatusPanel.setBorder(BorderFactory.createTitledBorder(" CIVIL STATUS"));
	civilStatusPanel.setBackground(Color.white);
	JLabel ast7 = new JLabel("*");
	ast7.setFont(new Font("Arial",Font.BOLD,20));
	ast7.setBounds(3, 2, 20,20);
	civilStatusPanel.add(ast7);
	
	String[] civilStatusItems = {"...","Single","Married","Annulled/Divorce","Widow/er","Legally Separated"};
	JComboBox civilStatus= new JComboBox(civilStatusItems);
	civilStatus.setBounds(10, 20, 120, 20);
    
	//Name of Spouse Panel
	nameOfSpousePanel = new JPanel();
	addPan.add(nameOfSpousePanel);
	nameOfSpousePanel.setVisible(true);
	nameOfSpousePanel.setLayout(null);
	nameOfSpousePanel.setBounds(150,170,270,80);
	nameOfSpousePanel.setBorder(BorderFactory.createTitledBorder("NAME OF SPOUSE (If Married)"));
	nameOfSpousePanel.setBackground(Color.white);
			
	JTextField fullName = new JTextField("",50);
	fullName.setBounds(10, 22, 250, 20);
	
	//Occupation Panel
	occupationPanel = new JPanel();
	addPan.add(occupationPanel);
	occupationPanel.setVisible(true);
	occupationPanel.setLayout(null);
	occupationPanel.setBounds(420,170,244,80);
	occupationPanel.setBorder(BorderFactory.createTitledBorder(" OCCUPATION/PROFESSION"));
	occupationPanel.setBackground(Color.white);
	JLabel ast8 = new JLabel("*");
	ast8.setFont(new Font("Arial",Font.BOLD,20));
	ast8.setBounds(3, 2, 20,20);
	occupationPanel.add(ast8);
	
	JTextField occupationTF = new JTextField("",20);
	occupationTF.setBounds(10, 23, 225, 20);
	
	//Address Panel
    addressPanel = new JPanel();
    addPan.add(addressPanel);
	addressPanel.setVisible(true);
	addressPanel.setLayout(null);
	addressPanel.setBounds(10,250,654,80);
    addressPanel.setBorder(BorderFactory.createTitledBorder("ADDRESS"));
	addressPanel.setBackground(Color.white);
			
	JTextField provinceTF = new JTextField("",40);
	provinceTF.setBounds(10, 20, 140, 20);
	JLabel provinceLabel = new JLabel("Province");
	provinceLabel.setBounds(10, 32, 140, 40);
			
	JTextField cityTF = new JTextField("",40);
	cityTF.setBounds(160, 20, 140, 20);
	JLabel cityLabel = new JLabel("City/Municipality");
	cityLabel.setBounds(160, 32, 140, 40);
	JLabel ast9 = new JLabel("*");
	ast9.setFont(new Font("Arial",Font.BOLD,20));
	ast9.setBounds(152, 45, 20,20);
	addressPanel.add(ast9);
			
	JTextField barangayTF = new JTextField("",40);
	barangayTF.setBounds(310, 20, 140, 20);
	JLabel barangayLabel = new JLabel("Barangay");
	barangayLabel.setBounds(310, 32, 140, 40);
	JLabel ast10 = new JLabel("*");
	ast10.setFont(new Font("Arial",Font.BOLD,20));
	ast10.setBounds(302, 45, 20,20);
	addressPanel.add(ast10);
	
	JTextField streetTF = new JTextField("",40);
	streetTF.setBounds(460, 20, 183, 20);
	JLabel streetLabel = new JLabel("House No./Street/Subdivision");
	streetLabel.setBounds(460, 32, 183, 40);
	JLabel ast11 = new JLabel("*");
	ast11.setFont(new Font("Arial",Font.BOLD,20));
	ast11.setBounds(452, 45, 20,20);
	addressPanel.add(ast11);

	//Position Pane
	positionPanel = new JPanel();
	addPan.add(positionPanel);
	positionPanel.setVisible(true);
	positionPanel.setLayout(null);
	positionPanel.setBounds(10,330,230,80);
	positionPanel.setBorder(BorderFactory.createTitledBorder(" CANDIDACY FOR THE POSITION OF:"));
	positionPanel.setBackground(Color.white);
	JLabel ast12 = new JLabel("*");
	ast12.setFont(new Font("Arial",Font.BOLD,20));
	ast12.setBounds(3, 2, 20,20);
	positionPanel.add(ast12);
	
	String[] positionItems = {"...","President","Vice-President","Secretary","Treasurer","Auditor","Public Information Officer"};
	JComboBox position = new JComboBox(positionItems);
	position.setBounds(10, 20, 200, 20);

	
	
	newButton = new JButton("CLEAR");
	newButton.setBounds(280, 357,115,40);
	newButton.setIcon(new ImageIcon("clearBut.png"));
	addButton = new JButton("ADD");
	addButton.setBounds(400, 357,115,40);
	addButton.setIcon(new ImageIcon("addBut.png"));
	cancelButton = new JButton("BACK");
	cancelButton.setBounds(520, 357,115,40);
	cancelButton.setIcon(new ImageIcon("backBut.png"));
	
	newButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			candidateID.setText("");
			Lname.setText("");
			Fname.setText("");
			Mname.setText("");
			age.setText("");
			monthChoice.setSelectedIndex(0);
			city.setText("");
			province.setText("");
			civilStatus.setSelectedIndex(0);
			fullName.setText("");
			occupationTF.setText("");
			provinceTF.setText("");
			cityTF.setText("");
			barangayTF.setText("");
			streetTF.setText("");
			position.setSelectedIndex(0);
			candidateID.requestFocus();
		}
	});
	
	addButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent b) {
            try
			{
            	    File allInfo = new File(filePath+"Candidate.txt");
  					File candidateNames = new File(filePath+position.getSelectedItem()+".txt");
  					allInfo.createNewFile();
  					candidateNames.createNewFile();
  					BufferedWriter canOut = new BufferedWriter(new FileWriter(candidateNames,true));
  					BufferedWriter out = new BufferedWriter(new FileWriter(allInfo,true));
				    BufferedReader in = new BufferedReader(new FileReader("Candidate.txt"));
				    String text = "";
				    double count = 0;
				    String provinceTemp = "", fullNameTemp = "", provinceTFTemp = "";
   if(allInfo.exists() && candidateNames.exists())
				{
                      while((text = in.readLine()) != null){
                    	  String[] words = text.split(" ");
                    	 for(String word : words){
                        if(word.equals(candidateID.getText())){
						    count++;
								}
                    	      }
                            }
                         if(count >= 1)
                         	{
                        	 JOptionPane.showMessageDialog(null,"Candidate ID already exists","CANDIDATE ID",JOptionPane.ERROR_MESSAGE);
 							 candidateID.setText("");
                        	 candidateID.requestFocus();
                         	}
                         else if(candidateID.getText().equals("") || Lname.getText().equals("") || Fname.getText().equals("") || Mname.getText().equals("") || age.getText().equals("") || monthChoice.getSelectedIndex() == 0 || city.getText().equals("") || civilStatus.getSelectedIndex() == 0 || occupationTF.getText().equals("") || cityTF.getText().equals("") || barangayTF.getText().equals("") || streetTF.getText().equals("") || position.getSelectedIndex() == 0)
                         	{
                        	 ast1.setForeground(Color.RED); ast5.setForeground(Color.RED); ast9.setForeground(Color.RED);
                        	 ast2.setForeground(Color.RED); ast6.setForeground(Color.RED); ast10.setForeground(Color.RED);
                        	 ast3.setForeground(Color.RED); ast7.setForeground(Color.RED); ast11.setForeground(Color.RED);
                        	 ast4.setForeground(Color.RED); ast8.setForeground(Color.RED); ast12.setForeground(Color.RED);
                        	 String buttons[] = {"OK"};
                        	 int ch = JOptionPane.showOptionDialog(null,"All Fields with (*) are required","ADD CANDIDATE",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
                        	   if(ch == 0){
                        		   ast1.setForeground(Color.BLACK); ast5.setForeground(Color.BLACK); ast9.setForeground(Color.BLACK);
                        		   ast2.setForeground(Color.BLACK); ast6.setForeground(Color.BLACK); ast10.setForeground(Color.BLACK);
                        		   ast3.setForeground(Color.BLACK); ast7.setForeground(Color.BLACK); ast11.setForeground(Color.BLACK);
                        		   ast4.setForeground(Color.BLACK); ast8.setForeground(Color.BLACK); ast12.setForeground(Color.BLACK);
                        	   }
                         	}
                    
                         else if(province.getText().equals("") && fullName.getText().equals("") && provinceTF.getText().equals("")){
                        	 province.setText("N.A.");
                        	 fullName.setText("N.A.");
                        	 provinceTF.setText("N.A.");
                         }
                         else if(province.getText().equals("") && fullName.getText().equals("")){
                        	 province.setText("N.A.");
                        	 fullName.setText("N.A.");
                         }
                         else if(province.getText().equals("") && provinceTF.getText().equals("")){
                        	 province.setText("N.A.");
                        	 provinceTF.setText("N.A.");
                         }
                         else if(fullName.getText().equals("") && provinceTF.getText().equals("")){
                        	 fullName.setText("N.A.");
                        	 provinceTF.setText("N.A.");
                         }
                         else
                         	{ 
                        	String gend;
                        	if(male.isSelected()){
                        		gend = "Male";
                        	}
                        	else{
                        		gend = "Female";
                        	}
                       
							String month;
							if (monthChoice.getSelectedIndex() == 1){
								month = "January";
							}
							else if(monthChoice.getSelectedIndex() == 2){
								month = "February";
							}
						    else if(monthChoice.getSelectedIndex() == 3){
						    	month = "March";
							}
						    else if(monthChoice.getSelectedIndex() == 4){
						    	month = "April";
							}
						    else if(monthChoice.getSelectedIndex() == 5){
						    	month = "May";
							}
						    else if(monthChoice.getSelectedIndex() == 6){
						    	month = "June";
							}
						    else if(monthChoice.getSelectedIndex() == 7){
						    	month = "July";
							}
						    else if(monthChoice.getSelectedIndex() == 8){
						    	month = "August";
							}
						    else if(monthChoice.getSelectedIndex() == 9){
						    	month = "September";
							}
						    else if(monthChoice.getSelectedIndex() == 10){
						    	month = "October";
							}
						    else if(monthChoice.getSelectedIndex() == 11){
						    	month = "November";
							}
						    else{
						    	month = "December";
						    }
							
							String cStatus;
							
							if (civilStatus.getSelectedIndex() == 1){
								cStatus = "Single";
							}
							else if(civilStatus.getSelectedIndex() == 2){
								cStatus = "Married";
							}
						    else if(civilStatus.getSelectedIndex() == 3){
						    	cStatus = "Annulled/Divorce";
							}
						    else if(civilStatus.getSelectedIndex() == 4){
						    	cStatus = "Widow/er";
							}
						    else{
						    	cStatus = "Legally Separated";
							}
							
							String pos;
							
							if (position.getSelectedIndex() == 1){
								pos = "President";
							}
							else if(position.getSelectedIndex() == 2){
								pos = "Vice-President";
							}
						    else if(position.getSelectedIndex() == 3){
						    	pos = "Secretary";
							}
						    else if(position.getSelectedIndex() == 4){
						    	pos = "Treasurer";
							}
						    else if(position.getSelectedIndex() == 5){
						    	pos = "Auditor";
							}
						    else{
						    	pos = "Public Information Officer";
							}
					    //removing whitespaces
						String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos;
						nLname = Lname.getText().replaceAll("\\s", ",");
						nFname = Fname.getText().replaceAll("\\s", ",");
						nMname = Mname.getText().replaceAll("\\s", ",");
						nCity = city.getText().replaceAll("\\s", ",");
						nProv = province.getText().replaceAll("\\s", ",");
						nfullName = fullName.getText().replaceAll("\\s", ",");
						nOccu = occupationTF.getText().replaceAll("\\s", ",");
						nStreet = streetTF.getText().replaceAll("\\s", ",");
						nBara = barangayTF.getText().replaceAll("\\s", ",");
						nCity1 = cityTF.getText().replaceAll("\\s", ",");
						nProv1 = provinceTF.getText().replaceAll("\\s", ",");
						nPos = pos.replaceAll("\\s", ",");
						//removing whitespaces
						out.write(candidateID.getText()+" "+nLname+" "+nFname+" "+nMname+" "+age.getText()+" "+gend+" "+month+" "+day.getSelectedItem()+" "+year.getSelectedItem()+" "+nProv+" "+nCity+" "+cStatus+" "+nfullName+" "+nOccu+" "+nProv1+" "+nCity1+" "+nBara+" "+nStreet+" "+nPos+"\n");
						out.append(System.lineSeparator());
						out.flush();
						canOut.write(candidateID.getText()+" "+nLname+" "+nFname+" "+nMname+" 0");
						canOut.newLine();
						canOut.flush();
					       
                      
					if(allInfo.canWrite() && candidateNames.canWrite()){
								out.newLine();
								JOptionPane.showMessageDialog(null,"CANDIDATE SUCCESSFULLY ADDED!\nName: "+Lname.getText()+", "+Fname.getText()+" "+Mname.getText()+"\nPosition: "+pos,"CANDIDATE ADDED",JOptionPane.INFORMATION_MESSAGE);
								candidateID.setText("");
								Lname.setText("");
								Fname.setText("");
								Mname.setText("");
								age.setText("");
								monthChoice.setSelectedIndex(0);
								city.setText("");
								province.setText("");
								civilStatus.setSelectedIndex(0);
								fullName.setText("");
								occupationTF.setText("");
								provinceTF.setText("");
								cityTF.setText("");
								barangayTF.setText("");
								streetTF.setText("");
								position.setSelectedIndex(0);
								candidateID.requestFocus();
					     }
					else
					{
						JOptionPane.showMessageDialog(null,"Text is not written in candidate.txt","ERROR",JOptionPane.ERROR_MESSAGE);
				    }
				  }
                }
                   
  				    else
					{
  						JOptionPane.showMessageDialog(null,"File not Found!","ERROR",JOptionPane.ERROR_MESSAGE);
  				    }
  					
  			}
  			catch(Exception x){
  			
  				JOptionPane.showMessageDialog(null,x.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
  			}
  		}
	});
	
	cancelButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent b){
			addCan.setVisible(false);
			addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
			addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
		}
	});
	
	addCan.getRootPane().setDefaultButton(addButton);
	
	candidateIDPanel.add(candidateID); namePanel.add(Lname);   namePanel.add(comma1); namePanel.add(Fname);    namePanel.add(Mname);      agePanel.add(age);      
								       namePanel.add(lastName);                       namePanel.add(firstName);namePanel.add(middleName);
	genderPanel.add(male); genderPanel.add(female);      dateofBirthPanel.add(monthChoice); dateofBirthPanel.add(day);      dateofBirthPanel.add(year);      placeofBirthPanel.add(city);     placeofBirthPanel.add(province);
	                                                     dateofBirthPanel.add(monthLabel);  dateofBirthPanel.add(dayLabel); dateofBirthPanel.add(yearLabel); placeofBirthPanel.add(cityMuni); placeofBirthPanel.add(provinceL);
	civilStatusPanel.add(civilStatus); nameOfSpousePanel.add(fullName);     occupationPanel.add(occupationTF);
	addressPanel.add(provinceTF);    addressPanel.add(cityTF);    addressPanel.add(barangayTF);    addressPanel.add(streetTF);
	addressPanel.add(provinceLabel); addressPanel.add(cityLabel); addressPanel.add(barangayLabel); addressPanel.add(streetLabel);
	positionPanel.add(position);     addCan.add(newButton); addCan.add(addButton); addCan.add(cancelButton);

	
	
	JPanel tempPan1 = new JPanel();
	tempPan1.setVisible(true);
	tempPan1.setLayout(null);
	tempPan1.setBackground(Color.white);
	addCan.add(addPan);
	addCan.add(tempPan1);
	return can;
	}
	//-----------ADDING CANDIDATE METHOD END-----------//
	
	//-----------EDITING CANDIDATE METHOD-----------//
	public void editingCandidate(){
		final JFrame editCan = new JFrame();
		JPanel addPan,candidateIDPanel,namePanel,agePanel,genderPanel;
		JPanel dateofBirthPanel,placeofBirthPanel,civilStatusPanel;
		JPanel nameOfSpousePanel,occupationPanel,addressPanel,positionPanel;
		JButton newButton, searchButton, cancelButton1,updateButton1;
		ButtonGroup gender;
		JRadioButton male, female;
		JTextField Lname,Fname,Mname, age;
		editCan.setUndecorated(true);
		editCan.setSize(680, 486);
		editCan.setVisible(true);
		editCan.setLocation(456,190);
		editCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		editCan.setResizable(false);
	addPan = new JPanel();
	addPan.setVisible(true);
	addPan.setLayout(null);
	addPan.setBounds(5, 5, 671, 430);
	addPan.setBackground(Color.white);
	addPan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	//Candidate ID No. Panel
	candidateIDPanel = new JPanel();
	addPan.add(candidateIDPanel);
	candidateIDPanel.setVisible(true);
	candidateIDPanel.setLayout(null);
	candidateIDPanel.setBounds(10,10,100,80);
	candidateIDPanel.setBorder(BorderFactory.createTitledBorder(" CANDIDATE ID"));
	candidateIDPanel.setBackground(Color.white);
	JLabel ast1 = new JLabel("*");
	ast1.setFont(new Font("Arial",Font.BOLD,20));
	ast1.setBounds(3, 2, 20,20);
	candidateIDPanel.add(ast1);

	JTextField candidateID = new JTextField("",20);
	candidateID.setBounds(10, 28, 80, 20);
    String can = candidateID.getText();
    
	//Name Panel
	namePanel = new JPanel();
	addPan.add(namePanel);
	namePanel.setVisible(true);
	namePanel.setLayout(null);
	namePanel.setBounds(110,10,480,80);
	namePanel.setBorder(BorderFactory.createTitledBorder(" NAME"));
	namePanel.setBackground(Color.white);
	JLabel ast2 = new JLabel("*");
	ast2.setFont(new Font("Arial",Font.BOLD,20));
	ast2.setBounds(3, 2, 20,20);
	namePanel.add(ast2);
	
	Lname = new JTextField("",40);
	Lname.setBounds(10, 28, 150, 20);
	JLabel lastName = new JLabel("Last Name");
	lastName.setBounds(10, 40, 100, 40);
	
	JLabel comma1 = new JLabel(",");
	comma1.setBounds(160, 30,20,20);
	comma1.setFont(new Font("Arial",Font.PLAIN,20));
	
	Fname = new JTextField("",40);
	Fname.setBounds(167, 28, 150, 20);
	JLabel firstName = new JLabel("First Name");
	firstName.setBounds(167, 40, 100, 40);
	
	Mname = new JTextField("",40);
	Mname.setBounds(320, 28, 150, 20);
	JLabel middleName = new JLabel("Middle Name");
	middleName.setBounds(330, 40, 100, 40);
	
	//Age Panel
	agePanel = new JPanel();
	addPan.add(agePanel);
	agePanel.setVisible(true);
	agePanel.setLayout(null);
	agePanel.setBounds(590,10,74,80);
	agePanel.setBorder(BorderFactory.createTitledBorder(" AGE"));
	agePanel.setBackground(Color.white);
	JLabel ast3 = new JLabel("*");
	ast3.setFont(new Font("Arial",Font.BOLD,20));
	ast3.setBounds(3, 2, 20,20);
	agePanel.add(ast3);
	
	age = new JTextField("",20);
	age.setBounds(10, 28, 50, 20);

	//Gender Panel
	genderPanel = new JPanel();
	addPan.add(genderPanel);
	genderPanel.setVisible(true);
	genderPanel.setLayout(null);
	genderPanel.setBounds(10,90,144,80);
	genderPanel.setBorder(BorderFactory.createTitledBorder(" GENDER"));
	genderPanel.setBackground(Color.white);
	JLabel ast4 = new JLabel("*");
	ast4.setFont(new Font("Arial",Font.BOLD,20));
	ast4.setBounds(3, 2, 20,20);
	genderPanel.add(ast4);
	
	gender = new ButtonGroup();
	male = new JRadioButton("Male");
	male.setBackground(Color.white);
	female = new JRadioButton("Female");
	female.setBackground(Color.white);
	gender.add(male);
	gender.add(female);
	male.setBounds(5,30,65,20);
	female.setBounds(68,30,70,20);
			
	//Date of Birth Panel
	dateofBirthPanel = new JPanel();
	addPan.add(dateofBirthPanel);
	dateofBirthPanel.setVisible(true);
	dateofBirthPanel.setLayout(null);
	dateofBirthPanel.setBounds(154,90,233,80);
	dateofBirthPanel.setBorder(BorderFactory.createTitledBorder(" DATE OF BIRTH"));
	dateofBirthPanel.setBackground(Color.white);
	JLabel ast5 = new JLabel("*");
	ast5.setFont(new Font("Arial",Font.BOLD,20));
	ast5.setBounds(3, 2, 20,20);
	dateofBirthPanel.add(ast5);
	
	String[] monthNames = {"...","January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox monthChoice = new JComboBox(monthNames);
	monthChoice.setBounds(10, 20, 100,20);
	JLabel monthLabel = new JLabel("Month");
	monthLabel.setBounds(10, 32, 350, 40);
	
	JComboBox day = new JComboBox();
	day.setBounds(117, 20, 40, 20);
	int dayCtr = 0;
	for(dayCtr = 1; dayCtr <= 31; dayCtr++){
		String dey = (String) Integer.toString(dayCtr); 
		String[] dayArray = {dey};
		day.addItem(dey);
	}
	JLabel dayLabel = new JLabel("Day");
	dayLabel.setBounds(117, 32, 350, 40);

    JComboBox year = new JComboBox();
	year.setBounds(165, 20, 55, 20);
	int yearCtr = 0;
	for(yearCtr = 2016; yearCtr >= 1900; yearCtr--){
		String yer = (String) Integer.toString(yearCtr); 
		String[] yearArray = {yer};
		year.addItem(yer);
	}
	JLabel yearLabel = new JLabel("Year");
	yearLabel.setBounds(165, 32, 350, 40);
	
	//Place of Birth Panel
	placeofBirthPanel = new JPanel();
	addPan.add(placeofBirthPanel);
	placeofBirthPanel.setVisible(true);
	placeofBirthPanel.setLayout(null);
	placeofBirthPanel.setBounds(387,90,277,80);
	placeofBirthPanel.setBorder(BorderFactory.createTitledBorder("PLACE OF BIRTH"));
	placeofBirthPanel.setBackground(Color.white);
	
	JTextField province = new JTextField("",40);
	province.setBounds(10, 20, 125, 20);
	JLabel provinceL = new JLabel("Province");
	provinceL.setBounds(10, 32, 100, 40);
	
	JTextField city = new JTextField("",40);
	city.setBounds(140, 20, 130, 20);
	JLabel cityMuni = new JLabel("City/Municipality");
	cityMuni.setBounds(140, 32, 100, 40);
	JLabel ast6 = new JLabel("*");
	ast6.setFont(new Font("Arial",Font.BOLD,20));
	ast6.setBounds(132, 45, 20,20);
	placeofBirthPanel.add(ast6);
	
	
	//Civil Status Panel
	civilStatusPanel = new JPanel();
	addPan.add(civilStatusPanel);
	civilStatusPanel.setVisible(true);
	civilStatusPanel.setLayout(null);
	civilStatusPanel.setBounds(10,170,140,80);
	civilStatusPanel.setBorder(BorderFactory.createTitledBorder(" CIVIL STATUS"));
	civilStatusPanel.setBackground(Color.white);
	JLabel ast7 = new JLabel("*");
	ast7.setFont(new Font("Arial",Font.BOLD,20));
	ast7.setBounds(3, 2, 20,20);
	civilStatusPanel.add(ast7);
	
	String[] civilStatusItems = {"...","Single","Married","Annulled/Divorce","Widow/er","Legally Separated"};
	JComboBox civilStatus= new JComboBox(civilStatusItems);
	civilStatus.setBounds(10, 20, 120, 20);
    
	//Name of Spouse Panel
	nameOfSpousePanel = new JPanel();
	addPan.add(nameOfSpousePanel);
	nameOfSpousePanel.setVisible(true);
	nameOfSpousePanel.setLayout(null);
	nameOfSpousePanel.setBounds(150,170,270,80);
	nameOfSpousePanel.setBorder(BorderFactory.createTitledBorder("NAME OF SPOUSE (If Married)"));
	nameOfSpousePanel.setBackground(Color.white);
			
	JTextField fullName = new JTextField("",50);
	fullName.setBounds(10, 22, 250, 20);
	
	//Occupation Panel
	occupationPanel = new JPanel();
	addPan.add(occupationPanel);
	occupationPanel.setVisible(true);
	occupationPanel.setLayout(null);
	occupationPanel.setBounds(420,170,244,80);
	occupationPanel.setBorder(BorderFactory.createTitledBorder(" OCCUPATION/PROFESSION"));
	occupationPanel.setBackground(Color.white);
	JLabel ast8 = new JLabel("*");
	ast8.setFont(new Font("Arial",Font.BOLD,20));
	ast8.setBounds(3, 2, 20,20);
	occupationPanel.add(ast8);
	
	JTextField occupationTF = new JTextField("",20);
	occupationTF.setBounds(10, 23, 225, 20);
	
	//Address Panel
    addressPanel = new JPanel();
    addPan.add(addressPanel);
	addressPanel.setVisible(true);
	addressPanel.setLayout(null);
	addressPanel.setBounds(10,250,654,80);
    addressPanel.setBorder(BorderFactory.createTitledBorder("ADDRESS"));
	addressPanel.setBackground(Color.white);
			
	JTextField provinceTF = new JTextField("",40);
	provinceTF.setBounds(10, 20, 140, 20);
	JLabel provinceLabel = new JLabel("Province");
	provinceLabel.setBounds(10, 32, 140, 40);
			
	JTextField cityTF = new JTextField("",40);
	cityTF.setBounds(160, 20, 140, 20);
	JLabel cityLabel = new JLabel("City/Municipality");
	cityLabel.setBounds(160, 32, 140, 40);
	JLabel ast9 = new JLabel("*");
	ast9.setFont(new Font("Arial",Font.BOLD,20));
	ast9.setBounds(152, 45, 20,20);
	addressPanel.add(ast9);
			
	JTextField barangayTF = new JTextField("",40);
	barangayTF.setBounds(310, 20, 140, 20);
	JLabel barangayLabel = new JLabel("Barangay");
	barangayLabel.setBounds(310, 32, 140, 40);
	JLabel ast10 = new JLabel("*");
	ast10.setFont(new Font("Arial",Font.BOLD,20));
	ast10.setBounds(302, 45, 20,20);
	addressPanel.add(ast10);
	
	JTextField streetTF = new JTextField("",40);
	streetTF.setBounds(460, 20, 183, 20);
	JLabel streetLabel = new JLabel("House No./Street/Subdivision");
	streetLabel.setBounds(460, 32, 183, 40);
	JLabel ast11 = new JLabel("*");
	ast11.setFont(new Font("Arial",Font.BOLD,20));
	ast11.setBounds(452, 45, 20,20);
	addressPanel.add(ast11);
	
	newButton = new JButton("CLEAR");
	newButton.setBounds(80, 357,120,40);
	newButton.setIcon(new ImageIcon("clearBut.png"));
	searchButton = new JButton("SEARCH");
	searchButton.setBounds(340, 357,120,40);
	searchButton.setIcon(new ImageIcon("addBut.png"));
	cancelButton1 = new JButton("BACK");
	cancelButton1.setBounds(470, 357,120,40);
	cancelButton1.setIcon(new ImageIcon("backBut.png"));
	updateButton1 = new JButton("UPDATE");
	updateButton1.setBounds(210, 357,120,40);
	updateButton1.setIcon(new ImageIcon("backBut.png"));
	
	Lname.setEditable(false); Fname.setEditable(false); Mname.setEditable(false); age.setEditable(false);
	monthChoice.setEnabled(false); day.setEnabled(false); year.setEnabled(false); city.setEditable(false);
	province.setEditable(false); civilStatus.setEnabled(false); fullName.setEditable(false); occupationTF.setEditable(false);
	provinceTF.setEditable(false); cityTF.setEditable(false); barangayTF.setEditable(false); streetTF.setEditable(false);
	updateButton1.setEnabled(false);

	searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				int ctr = 0;
				int ctr1 = 0;
				int count = 0;
			try{
				Scanner in = new Scanner(new FileReader("Candidate.txt"));
				StringBuilder input = new StringBuilder();
				String tempPos = "";
				String pos = "";
				while(in.hasNext()){
					 String ID = in.next();        
		             String lName = in.next();    
		             String fName = in.next();       
		             String mName = in.next();        
		             String age1 = in.next();   
		             String gender = in.next();
		             String month = in.next();
		             String day1 = in.next();
		             String year1 = in.next();
		             String prov1 = in.next();
		             String city1 = in.next();
		             String cStatus = in.next();
		             String spouse = in.next();
		             String occu = in.next();
		             String prov2 = in.next();
		             String city2 = in.next();
		             String bar = in.next();
		             String strit = in.next();
		             String posit = in.next();
		       String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age1+" "+gender+" "+month+" "+day1+" "+year1+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit+" "+posit;
		            if(ID.equals(candidateID.getText())){
		            	Lname.setEditable(true); Fname.setEditable(true); Mname.setEditable(true); age.setEditable(true);
		            	monthChoice.setEnabled(true); day.setEnabled(true); year.setEnabled(true); city.setEditable(true);
		            	province.setEditable(true); civilStatus.setEnabled(true); fullName.setEditable(true); occupationTF.setEditable(true);
		            	provinceTF.setEditable(true); cityTF.setEditable(true); barangayTF.setEditable(true); streetTF.setEditable(true);	
		             tempPos = posit.replaceAll(",", " ");
		             Lname.setText(lName); Fname.setText(fName); Mname.setText(mName); age.setText(age1); 
		             monthChoice.setSelectedItem(month); day.setSelectedItem(day1); year.setSelectedItem(year1); 
		             province.setText(prov1); city.setText(city1); civilStatus.setSelectedItem(cStatus);
		             fullName.setText(spouse); occupationTF.setText(occu); provinceTF.setText(prov2);
		             cityTF.setText(city2); barangayTF.setText(bar); streetTF.setText(strit);
		             updateButton1.setEnabled(true); searchButton.setEnabled(false);
		             count++;
		       	     }
		            else{
		            	count = count;
		            }
			  }
				if(count < 1){
					JOptionPane.showMessageDialog(null,"Candidate not found","Edit Candidate",JOptionPane.ERROR_MESSAGE);
					candidateID.setText("");
					candidateID.requestFocus();
				}
		}
			
		catch(Exception e){
			e.getMessage();
		  }
		}
	});
		cancelButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				editCan.setVisible(false);
				addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
				addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
			}
		});
		
		updateButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x){
				int ctr = 0;
				int ctr1 = 0;
				int ctr2 = 0, ctr3 = 0;
				String nLname = "" , nFname = "", nMname = "", nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1 = "";
			try{
				Scanner in = new Scanner(new FileReader("Candidate.txt"));
				StringBuilder input = new StringBuilder();
				String tempPos = "";
				String pos = "";
				while(in.hasNext()){
					 String ID = in.next();        
		             String lName = in.next();    
		             String fName = in.next();       
		             String mName = in.next();        
		             String age1 = in.next();   
		             String gender = in.next();
		             String month = in.next();
		             String day1 = in.next();
		             String year1 = in.next();
		             String prov1 = in.next();
		             String city1 = in.next();
		             String cStatus = in.next();
		             String spouse = in.next();
		             String occu = in.next();
		             String prov2 = in.next();
		             String city2 = in.next();
		             String bar = in.next();
		             String strit = in.next();
		             String posit = in.next();
		       String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age1+" "+gender+" "+month+" "+day1+" "+year1+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit+" "+posit;
		             
		     //removing whitespaces
				
				nLname = Lname.getText().replaceAll("\\s", ",");
				nFname = Fname.getText().replaceAll("\\s", ",");
				nMname = Mname.getText().replaceAll("\\s", ",");
				nCity = city.getText().replaceAll("\\s", ",");
				nProv = province.getText().replaceAll("\\s", ",");
				nfullName = fullName.getText().replaceAll("\\s", ",");
				nOccu = occupationTF.getText().replaceAll("\\s", ",");
				nStreet = streetTF.getText().replaceAll("\\s", ",");
				nBara = barangayTF.getText().replaceAll("\\s", ",");
				nCity1 = cityTF.getText().replaceAll("\\s", ",");
				nProv1 = provinceTF.getText().replaceAll("\\s", ",");
				
				String gend;
            	if(male.isSelected()){
            		gend = "Male";
            	}
            	else{
            		gend = "Female";
            	}
            	if(ID.equals(candidateID.getText()) && (candidateID.getText().equals("") || Lname.getText().equals("") || Fname.getText().equals("") || Mname.getText().equals("") || age.getText().equals("") || monthChoice.getSelectedIndex() == 0 || city.getText().equals("") || civilStatus.getSelectedIndex() == 0 || occupationTF.getText().equals("") || cityTF.getText().equals("") || barangayTF.getText().equals("") || streetTF.getText().equals(""))== false){
		             tempPos = posit.replaceAll(",", " ");
		             String newLine = ID+" "+nLname+" "+nFname+" "+nMname+" "+age.getText()+" "+gend+" "+monthChoice.getSelectedItem()+" "+day.getSelectedItem()+" "+year.getSelectedItem()+" "+nProv+" "+nCity+" "+cStatus+" "+nfullName+" "+nOccu+" "+nProv1+" "+nCity1+" "+nBara+" "+nStreet+" "+posit; 
		       		 System.out.println(newLine);
		       		 System.out.println(tempPos);
		       		 input.append(newLine);
		       	     input.append(System.lineSeparator());
		       	     ctr++;
		       	     }
            	else{
	            	input.append(oldLine);
	            	input.append(System.lineSeparator());
	                ctr2++;
	              }
				}
				BufferedWriter out = new BufferedWriter(new FileWriter("Candidate.txt"));
	            out.write(input.toString());
	            out.append(System.lineSeparator());
	            System.out.println("input"+input);
	            System.out.println("out"+out);
	            out.close();
	            
	            Scanner in1 = new Scanner(new FileReader(tempPos+".txt"));
				StringBuilder input1 = new StringBuilder(); 
				while(in1.hasNext()){
					 String ID1 = in1.next();        
		             String lName1 = in1.next();    
		             String fName1 = in1.next();       
		             String mName1 = in1.next();        
		             String vote = in1.next();   
		             String oldLine1 = ID1+" "+lName1+" "+fName1+" "+mName1+" "+vote;
		       System.out.println(oldLine1);
		            if(ID1.equals(candidateID.getText()) && (candidateID.getText().equals("") || Lname.getText().equals("") || Fname.getText().equals("") || Mname.getText().equals("")) == false){
		             String newLine1 = ID1+" "+nLname+" "+nFname+" "+nMname+" "+vote; 
		       		 System.out.println(newLine1);
		       		 input1.append(newLine1);
		       	     input1.append(System.lineSeparator());
		       	     ctr1++;
		            }
		            else{
		            	input1.append(oldLine1);
		            	input1.append(System.lineSeparator());
		            	ctr3++;
		            }
				}
				BufferedWriter out1 = new BufferedWriter(new FileWriter(tempPos+".txt"));
	            out1.write(input1.toString());
	            out1.append(System.lineSeparator());
	            System.out.println("input"+input1);
	            System.out.println("out"+out1);
	            out1.close();
			}
			catch(Exception c){
				c.getMessage();
			}
			if(ctr >= 1 || ctr1 >= 1){
            	JOptionPane.showMessageDialog(null,"Candidate information\nsuccessfully edited!","Edit Candidate",JOptionPane.INFORMATION_MESSAGE);
            	Lname.setText(""); Fname.setText(""); Mname.setText(""); age.setText(""); city.setText("");
            	province.setText(""); civilStatus.setSelectedItem("..."); fullName.setText(""); occupationTF.setText("");
            	provinceTF.setText(""); cityTF.setText(""); barangayTF.setText(""); streetTF.setText("");
            	
            	Lname.setEditable(false); Fname.setEditable(false); Mname.setEditable(false); age.setEditable(false);
            	monthChoice.setEnabled(false); day.setEnabled(false); year.setEnabled(false); city.setEditable(false);
            	province.setEditable(false); civilStatus.setEnabled(false); fullName.setEditable(false); occupationTF.setEditable(false);
            	provinceTF.setEditable(false); cityTF.setEditable(false); barangayTF.setEditable(false); streetTF.setEditable(false);
            	updateButton1.setEnabled(false); searchButton.setEnabled(true);
            	
            	candidateID.setText("");
            	candidateID.requestFocus();
            }
            
            else if(ctr2 >= 1 || ctr3 >= 1){
            	ast1.setForeground(Color.RED); ast5.setForeground(Color.RED); ast9.setForeground(Color.RED);
           	    ast2.setForeground(Color.RED); ast6.setForeground(Color.RED); ast10.setForeground(Color.RED);
           	    ast3.setForeground(Color.RED); ast7.setForeground(Color.RED); ast11.setForeground(Color.RED);
           	    ast4.setForeground(Color.RED); ast8.setForeground(Color.RED); 
           	 String buttons[] = {"OK"};
           	 int ch = JOptionPane.showOptionDialog(null,"All Fields with (*) are required","EDITING CANDIDATE",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
           	   if(ch == 0){
           		   ast1.setForeground(Color.BLACK); ast5.setForeground(Color.BLACK); ast9.setForeground(Color.BLACK);
           		   ast2.setForeground(Color.BLACK); ast6.setForeground(Color.BLACK); ast10.setForeground(Color.BLACK);
           		   ast3.setForeground(Color.BLACK); ast7.setForeground(Color.BLACK); ast11.setForeground(Color.BLACK);
           		   ast4.setForeground(Color.BLACK); ast8.setForeground(Color.BLACK);
           	   }
            }
		}
	});
		
		editCan.getRootPane().setDefaultButton(searchButton);
		
		candidateIDPanel.add(candidateID); namePanel.add(Lname);   namePanel.add(comma1); namePanel.add(Fname);    namePanel.add(Mname);      agePanel.add(age);      
									       namePanel.add(lastName);                       namePanel.add(firstName);namePanel.add(middleName);
		genderPanel.add(male); genderPanel.add(female);      dateofBirthPanel.add(monthChoice); dateofBirthPanel.add(day);      dateofBirthPanel.add(year);      
		placeofBirthPanel.add(city);     placeofBirthPanel.add(province);
		dateofBirthPanel.add(monthLabel);  dateofBirthPanel.add(dayLabel); dateofBirthPanel.add(yearLabel); 
		placeofBirthPanel.add(cityMuni); placeofBirthPanel.add(provinceL);
		civilStatusPanel.add(civilStatus); nameOfSpousePanel.add(fullName);     occupationPanel.add(occupationTF);
		addressPanel.add(provinceTF);    addressPanel.add(cityTF);    addressPanel.add(barangayTF);    addressPanel.add(streetTF);
		addressPanel.add(provinceLabel); addressPanel.add(cityLabel); addressPanel.add(barangayLabel); addressPanel.add(streetLabel);
		editCan.add(newButton); editCan.add(searchButton); editCan.add(cancelButton1); editCan.add(updateButton1);

		
		
		JPanel tempPan1 = new JPanel();
		tempPan1.setVisible(true);
		tempPan1.setLayout(null);
		tempPan1.setBackground(Color.white);
		editCan.add(addPan);
		editCan.add(tempPan1);
	}
	
	public void deletingCandidate(){
		final JFrame delCan = new JFrame();
	          JTextField candidateID2;
	          JButton searchButton2, cancelButton2;
	    delCan.setUndecorated(true);
	    delCan.setSize(680, 486);
	    delCan.setVisible(true);
	    delCan.setLocation(456,190);
	    delCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    delCan.setResizable(false);
	    delCan.setContentPane(new JLabel(new ImageIcon("delCan.jpg")));
		
		searchButton2 = new JButton("SEARCH");
		searchButton2.setBounds(330, 280,120,40);
		searchButton2.setIcon(new ImageIcon("seaBut.png"));
		delCan.add(searchButton2);
		cancelButton2 = new JButton("BACK");
		cancelButton2.setBounds(480, 280,120,40);
		cancelButton2.setIcon(new ImageIcon("backBut.png"));
		delCan.add(cancelButton2);
		
		candidateID2 = new JTextField("",20);
		candidateID2.setBounds(340, 170, 250, 35);

		delCan.add(candidateID2);
		searchButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				int ctr = 0,ctr1 = 0;
				String tempPos = "";
				try{
					Scanner in = new Scanner(new FileReader("Candidate.txt"));
					StringBuilder input = new StringBuilder();
					String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos = "";
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
			             String posit = in.next();
			             String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age+" "+gender+" "+month+" "+day+" "+year+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit+" "+posit;                
			             
			           //putting whitespaces
							nLname = lName.replaceAll(",", " ");
							nFname = fName.replaceAll(",", " ");
							nMname = mName.replaceAll(",", " ");
							nCity = city1.replaceAll(",", " ");
							nProv = prov1.replaceAll(",", " ");
							nfullName = spouse.replaceAll(",", " ");
							nOccu = occu.replaceAll(",", " ");
							nStreet = strit.replaceAll(",", " ");
							nBara = bar.replaceAll(",", " ");
							nCity1 = city2.replaceAll(",", " ");
							nProv1 = prov2.replaceAll(",", " ");
							nPos = posit.replaceAll(",", " ");
						//putting whitespaces
			 
			       
			            if(ID.equals(candidateID2.getText())){
			            	tempPos = nPos;
			            	JOptionPane.showMessageDialog(null,"CANDIDATE FOUND!","Candidate ID:"+candidateID2.getText(),JOptionPane.INFORMATION_MESSAGE);
			        	    JOptionPane.showMessageDialog(null,"Candidate ID:"+ID+"\nName:"+nLname+","+nFname+" "+nMname+"\nAge:"+age+"\nGender:"+gender+"\nBirthday:"+month+" "+day+","+year+"\nBirthplace:\n     Province:"+nProv+"\n     City:"+nCity+"\nCivil Status:"+cStatus+"\nSpouse(if married):"+nfullName+"\nOccupation:"+nOccu+"\nAddress:\n     Province:"+nProv1+"\n     City:"+nCity1+"\n     Barangay:"+nBara+"\n     Street:"+nStreet+"\nPosition:"+nPos,"Candidate ID:"+candidateID2.getText(),JOptionPane.INFORMATION_MESSAGE);
			        	    	ctr++;			            
			            }
			            else{
			            	input.append(oldLine);
			            	input.append(System.lineSeparator());
			            	//continue;
			            }
					}
					BufferedWriter out = new BufferedWriter(new FileWriter("Candidate.txt"));
		            out.write(input.toString());
		            out.append(System.lineSeparator());
		            out.close();
					
		            //System.out.println(tempPos);
					Scanner in1= new Scanner(new FileReader(tempPos+".txt"));
					StringBuilder input1 = new StringBuilder();
					while(in1.hasNext()){   
			             String id = in1.next();
			             String last = in1.next();
			             String first = in1.next();
			             String mid = in1.next();
			             String vote = in1.next();
			     		 String oldLine1 = id+" "+last+" "+first+" "+mid+" "+vote;
			     		 
			            if(id.equals(candidateID2.getText())){
			            	ctr1++;   
			            }
			            else{
			            	input1.append(oldLine1);
			            	input1.append(System.lineSeparator());
			            	//continue;
			            }
					}
		            BufferedWriter out1 = new BufferedWriter(new FileWriter(tempPos+".txt"));
		            out1.write(input1.toString());
		            out1.append(System.lineSeparator());
		            out1.close();
				}
				catch(Exception x){
					x.getMessage();
				}
				if((ctr >= 1 && ctr1 >= 1)){
	            	JOptionPane.showMessageDialog(null,"Candidate information\nsuccessfully deleted!","Delete Candidate",JOptionPane.INFORMATION_MESSAGE);
	            	candidateID2.setText("");
	            	candidateID2.requestFocus();
				}
	            else{
	            	JOptionPane.showMessageDialog(null,"Candidate not found","Delete Candidate",JOptionPane.ERROR_MESSAGE);
	            	candidateID2.setText("");
	            	candidateID2.requestFocus();
	            }
			}
		});
		cancelButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				delCan.setVisible(false);
				addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
				addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
			}
		});
		delCan.getRootPane().setDefaultButton(searchButton2);
	}
	
	public void searchingCandidate(){
		final JFrame seaCan = new JFrame();
	          JTextField candidateID3;
	          JButton searchButton3, cancelButton3;
		seaCan.setUndecorated(true);
		seaCan.setSize(680, 486);
		seaCan.setVisible(true);
		seaCan.setLocation(456,190);
		seaCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		seaCan.setResizable(false);
		seaCan.setContentPane(new JLabel(new ImageIcon("seaCan.jpg")));
		
		searchButton3 = new JButton("SEARCH");
		searchButton3.setBounds(330, 280,120,40);
		searchButton3.setIcon(new ImageIcon("seaBut.png"));
		seaCan.add(searchButton3);
		cancelButton3 = new JButton("BACK");
		cancelButton3.setBounds(480, 280,120,40);
		cancelButton3.setIcon(new ImageIcon("backBut.png"));
		seaCan.add(cancelButton3);
		
		candidateID3 = new JTextField("",20);
		candidateID3.setBounds(340, 170, 250, 35);
		
		seaCan.add(candidateID3);
		
		searchButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				try{
					Scanner in = new Scanner(new FileReader("Candidate.txt"));
				    int count = 0;
				    String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos;
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
			             String posit = in.next();
			             
			     	    //putting whitespaces
							nLname = lName.replaceAll(",", " ");
							nFname = fName.replaceAll(",", " ");
							nMname = mName.replaceAll(",", " ");
							nCity = city1.replaceAll(",", " ");
							nProv = prov1.replaceAll(",", " ");
							nfullName = spouse.replaceAll(",", " ");
							nOccu = occu.replaceAll(",", " ");
							nStreet = strit.replaceAll(",", " ");
							nBara = bar.replaceAll(",", " ");
							nCity1 = city2.replaceAll(",", " ");
							nProv1 = prov2.replaceAll(",", " ");
							nPos = posit.replaceAll(",", " ");
						//putting whitespaces
			          if(ID.equals(candidateID3.getText())){
			        	    count++;
			        	    JOptionPane.showMessageDialog(null,"CANDIDATE FOUND!","Candidate ID:"+candidateID3.getText(),JOptionPane.INFORMATION_MESSAGE);
			        	    JOptionPane.showMessageDialog(null,"Candidate ID:"+ID+"\nName:"+nLname+","+nFname+" "+nMname+"\nAge:"+age+"\nGender:"+gender+"\nBirthday:"+month+" "+day+","+year+"\nBirthplace:\n     Province:"+nProv+"\n     City:"+nCity+"\nCivil Status:"+cStatus+"\nSpouse(if married):"+nfullName+"\nOccupation:"+nOccu+"\nAddress:\n     Province:"+nProv1+"\n     City:"+nCity1+"\n     Barangay:"+nBara+"\n     Street:"+nStreet+"\nPosition:"+nPos,"Candidate ID:"+candidateID3.getText(),JOptionPane.INFORMATION_MESSAGE);
			          }
			          else{
			        	  count = count;
						  continue;
			          }
					}
					  if(count >= 1){  
							candidateID3.setText("");
							candidateID3.requestFocus();		         
			          }
			          else{
			        	  JOptionPane.showMessageDialog(null,"Candidate not found","Search Candidate",JOptionPane.ERROR_MESSAGE);
							candidateID3.setText("");
							candidateID3.requestFocus(); 
			          }
					in.close();
				}
				catch(Exception i){
					i.getMessage();
				}
			}
		}); 
		
		cancelButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				seaCan.setVisible(false);
				addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
				addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
			}
		});
		seaCan.getRootPane().setDefaultButton(searchButton3);
	}
		public void addingVoter(){
			final JFrame addVot = new JFrame();
			JPanel addPan,voterIDPanel,namePanel,agePanel,genderPanel;
			JPanel dateofBirthPanel,placeofBirthPanel,civilStatusPanel;
			JPanel nameOfSpousePanel,occupationPanel,addressPanel;
			JButton newButton, addButton, cancelButton;
			ButtonGroup gender;
			JRadioButton male, female;
			addVot.setUndecorated(true);
			addVot.setSize(680, 486);
			addVot.setVisible(true);
			addVot.setLocation(456,190);
			addVot.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			addVot.setResizable(false);
		addPan = new JPanel();
		addPan.setVisible(true);
		addPan.setLayout(null);
		addPan.setBounds(5, 5, 671, 430);
		addPan.setBackground(Color.white);
		addPan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//Candidate ID No. Panel
		voterIDPanel = new JPanel();
		addPan.add(voterIDPanel);
		voterIDPanel.setVisible(true);
		voterIDPanel.setLayout(null);
		voterIDPanel.setBounds(10,10,100,80);
		voterIDPanel.setBorder(BorderFactory.createTitledBorder(" VOTER ID"));
		voterIDPanel.setBackground(Color.white);
		JLabel ast1 = new JLabel("*");
		ast1.setFont(new Font("Arial",Font.BOLD,20));
		ast1.setBounds(3, 2, 20,20);
		voterIDPanel.add(ast1);

		JTextField voterID = new JTextField("",20);
		voterID.setBounds(10, 28, 80, 20);
	    String can = voterID.getText();
	    
		//Name Panel
		namePanel = new JPanel();
		addPan.add(namePanel);
		namePanel.setVisible(true);
		namePanel.setLayout(null);
		namePanel.setBounds(110,10,480,80);
		namePanel.setBorder(BorderFactory.createTitledBorder(" NAME"));
		namePanel.setBackground(Color.white);
		JLabel ast2 = new JLabel("*");
		ast2.setFont(new Font("Arial",Font.BOLD,20));
		ast2.setBounds(3, 2, 20,20);
		namePanel.add(ast2);
		
		JTextField Lname = new JTextField("",40);
		Lname.setBounds(10, 28, 150, 20);
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(10, 40, 100, 40);
		
		JLabel comma1 = new JLabel(",");
		comma1.setBounds(160, 30,20,20);
		comma1.setFont(new Font("Arial",Font.PLAIN,20));
		
		JTextField Fname = new JTextField("",40);
		Fname.setBounds(167, 28, 150, 20);
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(167, 40, 100, 40);
		
		JTextField Mname = new JTextField("",40);
		Mname.setBounds(320, 28, 150, 20);
		JLabel middleName = new JLabel("Middle Name");
		middleName.setBounds(330, 40, 100, 40);
		
		//Age Panel
		agePanel = new JPanel();
		addPan.add(agePanel);
		agePanel.setVisible(true);
		agePanel.setLayout(null);
		agePanel.setBounds(590,10,74,80);
		agePanel.setBorder(BorderFactory.createTitledBorder(" AGE"));
		agePanel.setBackground(Color.white);
		JLabel ast3 = new JLabel("*");
		ast3.setFont(new Font("Arial",Font.BOLD,20));
		ast3.setBounds(3, 2, 20,20);
		agePanel.add(ast3);
		
		JTextField age = new JTextField("",20);
		age.setBounds(10, 28, 50, 20);

		//Gender Panel
		genderPanel = new JPanel();
		addPan.add(genderPanel);
		genderPanel.setVisible(true);
		genderPanel.setLayout(null);
		genderPanel.setBounds(10,90,144,80);
		genderPanel.setBorder(BorderFactory.createTitledBorder(" GENDER"));
		genderPanel.setBackground(Color.white);
		JLabel ast4 = new JLabel("*");
		ast4.setFont(new Font("Arial",Font.BOLD,20));
		ast4.setBounds(3, 2, 20,20);
		genderPanel.add(ast4);
		
		gender = new ButtonGroup();
		male = new JRadioButton("Male");
		male.setBackground(Color.white);
		female = new JRadioButton("Female");
		female.setBackground(Color.white);
		gender.add(male);
		gender.add(female);
		male.setBounds(5,30,65,20);
		female.setBounds(68,30,70,20);
				
		//Date of Birth Panel
		dateofBirthPanel = new JPanel();
		addPan.add(dateofBirthPanel);
		dateofBirthPanel.setVisible(true);
		dateofBirthPanel.setLayout(null);
		dateofBirthPanel.setBounds(154,90,233,80);
		dateofBirthPanel.setBorder(BorderFactory.createTitledBorder(" DATE OF BIRTH"));
		dateofBirthPanel.setBackground(Color.white);
		JLabel ast5 = new JLabel("*");
		ast5.setFont(new Font("Arial",Font.BOLD,20));
		ast5.setBounds(3, 2, 20,20);
		dateofBirthPanel.add(ast5);
		
		String[] monthNames = {"...","January","February","March","April","May","June","July","August","September","October","November","December"};
		JComboBox monthChoice = new JComboBox(monthNames);
		monthChoice.setBounds(10, 20, 100,20);
		JLabel monthLabel = new JLabel("Month");
		monthLabel.setBounds(10, 32, 350, 40);
		
		JComboBox day = new JComboBox();
		day.setBounds(117, 20, 40, 20);
		int dayCtr = 0;
		for(dayCtr = 1; dayCtr <= 31; dayCtr++){
			String dey = (String) Integer.toString(dayCtr); 
			String[] dayArray = {dey};
			day.addItem(dey);
		}
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setBounds(117, 32, 350, 40);

	    JComboBox year = new JComboBox();
		year.setBounds(165, 20, 55, 20);
		int yearCtr = 0;
		for(yearCtr = 2016; yearCtr >= 1900; yearCtr--){
			String yer = (String) Integer.toString(yearCtr); 
			String[] yearArray = {yer};
			year.addItem(yer);
		}
		JLabel yearLabel = new JLabel("Year");
		yearLabel.setBounds(173, 32, 350, 40);
		
		//Place of Birth Panel
		placeofBirthPanel = new JPanel();
		addPan.add(placeofBirthPanel);
		placeofBirthPanel.setVisible(true);
		placeofBirthPanel.setLayout(null);
		placeofBirthPanel.setBounds(387,90,277,80);
		placeofBirthPanel.setBorder(BorderFactory.createTitledBorder("PLACE OF BIRTH"));
		placeofBirthPanel.setBackground(Color.white);
		
		JTextField province = new JTextField("",40);
		province.setBounds(10, 20, 125, 20);
		JLabel provinceL = new JLabel("Province");
		provinceL.setBounds(10, 32, 100, 40);
		
		JTextField city = new JTextField("",40);
		city.setBounds(140, 20, 130, 20);
		JLabel cityMuni = new JLabel("City/Municipality");
		cityMuni.setBounds(140, 32, 100, 40);
		JLabel ast6 = new JLabel("*");
		ast6.setFont(new Font("Arial",Font.BOLD,20));
		ast6.setBounds(132, 45, 20,20);
		placeofBirthPanel.add(ast6);
		
		
		//Civil Status Panel
		civilStatusPanel = new JPanel();
		addPan.add(civilStatusPanel);
		civilStatusPanel.setVisible(true);
		civilStatusPanel.setLayout(null);
		civilStatusPanel.setBounds(10,170,140,80);
		civilStatusPanel.setBorder(BorderFactory.createTitledBorder(" CIVIL STATUS"));
		civilStatusPanel.setBackground(Color.white);
		JLabel ast7 = new JLabel("*");
		ast7.setFont(new Font("Arial",Font.BOLD,20));
		ast7.setBounds(3, 2, 20,20);
		civilStatusPanel.add(ast7);
		
		String[] civilStatusItems = {"...","Single","Married","Annulled/Divorce","Widow/er","Legally Separated"};
		JComboBox civilStatus= new JComboBox(civilStatusItems);
		civilStatus.setBounds(10, 20, 120, 20);
	    
		//Name of Spouse Panel
		nameOfSpousePanel = new JPanel();
		addPan.add(nameOfSpousePanel);
		nameOfSpousePanel.setVisible(true);
		nameOfSpousePanel.setLayout(null);
		nameOfSpousePanel.setBounds(150,170,270,80);
		nameOfSpousePanel.setBorder(BorderFactory.createTitledBorder("NAME OF SPOUSE (If Married)"));
		nameOfSpousePanel.setBackground(Color.white);
				
		JTextField fullName = new JTextField("",50);
		fullName.setBounds(10, 22, 250, 20);
		
		//Occupation Panel
		occupationPanel = new JPanel();
		addPan.add(occupationPanel);
		occupationPanel.setVisible(true);
		occupationPanel.setLayout(null);
		occupationPanel.setBounds(420,170,244,80);
		occupationPanel.setBorder(BorderFactory.createTitledBorder(" OCCUPATION/PROFESSION"));
		occupationPanel.setBackground(Color.white);
		JLabel ast8 = new JLabel("*");
		ast8.setFont(new Font("Arial",Font.BOLD,20));
		ast8.setBounds(3, 2, 20,20);
		occupationPanel.add(ast8);
		
		JTextField occupationTF = new JTextField("",20);
		occupationTF.setBounds(10, 23, 225, 20);
		
		//Address Panel
	    addressPanel = new JPanel();
	    addPan.add(addressPanel);
		addressPanel.setVisible(true);
		addressPanel.setLayout(null);
		addressPanel.setBounds(10,250,654,80);
	    addressPanel.setBorder(BorderFactory.createTitledBorder("ADDRESS"));
		addressPanel.setBackground(Color.white);
				
		JTextField provinceTF = new JTextField("",40);
		provinceTF.setBounds(10, 20, 140, 20);
		JLabel provinceLabel = new JLabel("Province");
		provinceLabel.setBounds(10, 32, 140, 40);
				
		JTextField cityTF = new JTextField("",40);
		cityTF.setBounds(160, 20, 140, 20);
		JLabel cityLabel = new JLabel("City/Municipality");
		cityLabel.setBounds(160, 32, 140, 40);
		JLabel ast9 = new JLabel("*");
		ast9.setFont(new Font("Arial",Font.BOLD,20));
		ast9.setBounds(152, 45, 20,20);
		addressPanel.add(ast9);
				
		JTextField barangayTF = new JTextField("",40);
		barangayTF.setBounds(310, 20, 140, 20);
		JLabel barangayLabel = new JLabel("Barangay");
		barangayLabel.setBounds(310, 32, 140, 40);
		JLabel ast10 = new JLabel("*");
		ast10.setFont(new Font("Arial",Font.BOLD,20));
		ast10.setBounds(302, 45, 20,20);
		addressPanel.add(ast10);
		
		JTextField streetTF = new JTextField("",40);
		streetTF.setBounds(460, 20, 183, 20);
		JLabel streetLabel = new JLabel("House No./Street/Subdivision");
		streetLabel.setBounds(460, 32, 183, 40);
		JLabel ast11 = new JLabel("*");
		ast11.setFont(new Font("Arial",Font.BOLD,20));
		ast11.setBounds(452, 45, 20,20);
		addressPanel.add(ast11);
		
		newButton = new JButton("CLEAR");
		newButton.setBounds(280, 357,115,40);
		newButton.setIcon(new ImageIcon("clearBut.png"));
		addButton = new JButton("ADD");
		addButton.setBounds(400, 357,115,40);
		addButton.setIcon(new ImageIcon("addBut.png"));
		cancelButton = new JButton("BACK");
		cancelButton.setBounds(520, 357,115,40);
		cancelButton.setIcon(new ImageIcon("backBut.png"));
		
		newButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				voterID.setText("");
				Lname.setText("");
				Fname.setText("");
				Mname.setText("");
				age.setText("");
				monthChoice.setSelectedIndex(0);
				city.setText("");
				province.setText("");
				civilStatus.setSelectedIndex(0);
				fullName.setText("");
				occupationTF.setText("");
				provinceTF.setText("");
				cityTF.setText("");
				barangayTF.setText("");
				streetTF.setText("");
				voterID.requestFocus();
			}
		});
		
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b) {
	            try
				{
	            	    File allInfo = new File("Voter.txt");
	  					allInfo.createNewFile();
	  					File allInfo1 = new File("Voter's List.txt");
	  					allInfo1.createNewFile();
	  					BufferedWriter out = new BufferedWriter(new FileWriter(allInfo,true));
	  					BufferedWriter out1 = new BufferedWriter(new FileWriter(allInfo1,true));
					    BufferedReader in = new BufferedReader(new FileReader("Voter's List.txt"));
					    String text = "";
					    double count = 0;
	  				
	   if(allInfo.exists() && allInfo1.exists())
					{
	                      while((text = in.readLine()) != null){
	                    	  String[] words = text.split(" ");
	                    	 for(String word : words){
	                        if(word.equals(voterID.getText())){
							    count++;
									}
	                    	      }
	                            }
	                         if(count >= 1)
	                         	{
	                        	 JOptionPane.showMessageDialog(null,"Voter ID already exists","VOTER ID",JOptionPane.ERROR_MESSAGE);
	                        	 voterID.setText("");
	                        	 voterID.requestFocus();
	                         	}
	                         else if(voterID.getText().equals("") || Lname.getText().equals("") || Fname.getText().equals("") || Mname.getText().equals("") || age.getText().equals("") || monthChoice.getSelectedIndex() == 0 || city.getText().equals("") || civilStatus.getSelectedIndex() == 0 || occupationTF.getText().equals("") || cityTF.getText().equals("") || barangayTF.getText().equals("") || streetTF.getText().equals(""))
	                         	{
	                        	 ast1.setForeground(Color.RED); ast5.setForeground(Color.RED); ast9.setForeground(Color.RED);
	                        	 ast2.setForeground(Color.RED); ast6.setForeground(Color.RED); ast10.setForeground(Color.RED);
	                        	 ast3.setForeground(Color.RED); ast7.setForeground(Color.RED); ast11.setForeground(Color.RED);
	                        	 ast4.setForeground(Color.RED); ast8.setForeground(Color.RED); 
	                        	 String buttons[] = {"OK"};
	                        	 int ch = JOptionPane.showOptionDialog(null,"All Fields with (*) are required","ADD VOTER",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
	                        	   if(ch == 0){
	                        		   ast1.setForeground(Color.BLACK); ast5.setForeground(Color.BLACK); ast9.setForeground(Color.BLACK);
	                        		   ast2.setForeground(Color.BLACK); ast6.setForeground(Color.BLACK); ast10.setForeground(Color.BLACK);
	                        		   ast3.setForeground(Color.BLACK); ast7.setForeground(Color.BLACK); ast11.setForeground(Color.BLACK);
	                        		   ast4.setForeground(Color.BLACK); ast8.setForeground(Color.BLACK); 	                        	   }
	                         	}
	                         else if(province.getText().equals("") && fullName.getText().equals("") && provinceTF.getText().equals("")){
	                        	 province.setText("N.A.");
	                        	 fullName.setText("N.A.");
	                        	 provinceTF.setText("N.A.");
	                         }
	                         else if(province.getText().equals("") && fullName.getText().equals("")){
	                        	 province.setText("N.A.");
	                        	 fullName.setText("N.A.");
	                         }
	                         else if(province.getText().equals("") && provinceTF.getText().equals("")){
	                        	 province.setText("N.A.");
	                        	 provinceTF.setText("N.A.");
	                         }
	                         else if(fullName.getText().equals("") && provinceTF.getText().equals("")){
	                        	 fullName.setText("N.A.");
	                        	 provinceTF.setText("N.A.");
	                         }
	                      
	                         else
	                         	{ 
	                        	String gend;
	                        	if(male.getText().equals("Male")){
	                        		gend = "Male";
	                        	}
	                        	else{
	                        		gend = "Female";
	                        	}
								String month;
								if (monthChoice.getSelectedIndex() == 1){
									month = "January";
								}
								else if(monthChoice.getSelectedIndex() == 2){
									month = "February";
								}
							    else if(monthChoice.getSelectedIndex() == 3){
							    	month = "March";
								}
							    else if(monthChoice.getSelectedIndex() == 4){
							    	month = "April";
								}
							    else if(monthChoice.getSelectedIndex() == 5){
							    	month = "May";
								}
							    else if(monthChoice.getSelectedIndex() == 6){
							    	month = "June";
								}
							    else if(monthChoice.getSelectedIndex() == 7){
							    	month = "July";
								}
							    else if(monthChoice.getSelectedIndex() == 8){
							    	month = "August";
								}
							    else if(monthChoice.getSelectedIndex() == 9){
							    	month = "September";
								}
							    else if(monthChoice.getSelectedIndex() == 10){
							    	month = "October";
								}
							    else if(monthChoice.getSelectedIndex() == 11){
							    	month = "November";
								}
							    else{
							    	month = "December";
							    }
								
								String cStatus;
								
								if (civilStatus.getSelectedIndex() == 1){
									cStatus = "Single";
								}
								else if(civilStatus.getSelectedIndex() == 2){
									cStatus = "Married";
								}
							    else if(civilStatus.getSelectedIndex() == 3){
							    	cStatus = "Annulled/Divorce";
								}
							    else if(civilStatus.getSelectedIndex() == 4){
							    	cStatus = "Widow/er";
								}
							    else{
							    	cStatus = "Legally Separated";
								}
								
								//removing whitespaces
								String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos;
								nLname = Lname.getText().replaceAll("\\s", ",");
								nFname = Fname.getText().replaceAll("\\s", ",");
								nMname = Mname.getText().replaceAll("\\s", ",");
								nCity = city.getText().replaceAll("\\s", ",");
								nProv = province.getText().replaceAll("\\s", ",");
								nfullName = fullName.getText().replaceAll("\\s", ",");
								nOccu = occupationTF.getText().replaceAll("\\s", ",");
								nStreet = streetTF.getText().replaceAll("\\s", ",");
								nBara = barangayTF.getText().replaceAll("\\s", ",");
								nCity1 = cityTF.getText().replaceAll("\\s", ",");
								nProv1 = provinceTF.getText().replaceAll("\\s", ",");
								//removing whitespaces		
								
								out.write(voterID.getText()+" "+nLname+" "+nFname+" "+nMname+" "+age.getText()+" "+gend+" "+month+" "+day.getSelectedItem()+" "+year.getSelectedItem()+" "+nProv+" "+nCity+" "+cStatus+" "+nfullName+" "+nOccu+" "+nProv1+" "+nCity1+" "+nBara+" "+nStreet);
								out.append(System.lineSeparator());
								out.flush();
								
								out1.write(voterID.getText()+" "+nLname+" "+nFname+" "+nMname+" "+age.getText()+" "+gend+" "+month+" "+day.getSelectedItem()+" "+year.getSelectedItem()+" "+nProv+" "+nCity+" "+cStatus+" "+nfullName+" "+nOccu+" "+nProv1+" "+nCity1+" "+nBara+" "+nStreet);
								out1.append(System.lineSeparator());
								out1.flush();
	             
						if(allInfo.canWrite() && allInfo.canWrite()){
									out.newLine();
									out1.newLine();
									JOptionPane.showMessageDialog(null,"VOTER SUCCESSFULLY ADDED!\nName: "+Lname.getText()+", "+Fname.getText()+" "+Mname.getText(),"Adding Voter",JOptionPane.INFORMATION_MESSAGE);
									voterID.setText("");
									Lname.setText("");
									Fname.setText("");
									Mname.setText("");
									age.setText("");
									monthChoice.setSelectedIndex(0);
									city.setText("");
									province.setText("");
									civilStatus.setSelectedIndex(0);
									fullName.setText("");
									occupationTF.setText("");
									provinceTF.setText("");
									cityTF.setText("");
									barangayTF.setText("");
									streetTF.setText("");
									voterID.requestFocus();
						     }
						else
						{
							JOptionPane.showMessageDialog(null,"Text is not written in voter.txt","ERROR",JOptionPane.ERROR_MESSAGE);
					    }
					  }
	                   //out.close();
	   	               //in.close(); 
	                }
	                   
	  				    else
						{
	  						JOptionPane.showMessageDialog(null,"File not Found!","ERROR",JOptionPane.ERROR_MESSAGE);
	  				    }
	  					
	  			}
	  			catch(Exception x){
	  			
	  				JOptionPane.showMessageDialog(null,x.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
	  			}
	  		}
		});
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				addVot.setVisible(false);
				addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
				addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
			}
		});
		
		voterIDPanel.add(voterID); namePanel.add(Lname);   namePanel.add(comma1); namePanel.add(Fname);    namePanel.add(Mname);      agePanel.add(age);      
									       namePanel.add(lastName);                       namePanel.add(firstName);namePanel.add(middleName);
		genderPanel.add(male); genderPanel.add(female);      dateofBirthPanel.add(monthChoice); dateofBirthPanel.add(day);      dateofBirthPanel.add(year);      placeofBirthPanel.add(city);     placeofBirthPanel.add(province);
		                                                      dateofBirthPanel.add(monthLabel);  dateofBirthPanel.add(dayLabel); dateofBirthPanel.add(yearLabel); placeofBirthPanel.add(cityMuni); placeofBirthPanel.add(provinceL);
		civilStatusPanel.add(civilStatus); nameOfSpousePanel.add(fullName);     occupationPanel.add(occupationTF);
		addressPanel.add(provinceTF);    addressPanel.add(cityTF);    addressPanel.add(barangayTF);    addressPanel.add(streetTF);
		addressPanel.add(provinceLabel); addressPanel.add(cityLabel); addressPanel.add(barangayLabel); addressPanel.add(streetLabel);
		                                 addVot.add(newButton); addVot.add(addButton); addVot.add(cancelButton);

		JPanel tempPan1 = new JPanel();
		tempPan1.setVisible(true);
		tempPan1.setLayout(null);
		tempPan1.setBackground(Color.white);
		addVot.add(addPan);
		addVot.add(tempPan1);
		addVot.getRootPane().setDefaultButton(addButton);
	}
		public void editingVoter(){
			final JFrame editCan = new JFrame();
			JPanel addPan,candidateIDPanel,namePanel,agePanel,genderPanel;
			JPanel dateofBirthPanel,placeofBirthPanel,civilStatusPanel;
			JPanel nameOfSpousePanel,occupationPanel,addressPanel,positionPanel;
			JButton newButton, searchButton, cancelButton1,updateButton1;
			ButtonGroup gender;
			JRadioButton male, female;
			JTextField Lname,Fname,Mname, age;
			editCan.setUndecorated(true);
			editCan.setSize(680, 486);
			editCan.setVisible(true);
			editCan.setLocation(456,190);
			editCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			editCan.setResizable(false);
		addPan = new JPanel();
		addPan.setVisible(true);
		addPan.setLayout(null);
		addPan.setBounds(5, 5, 671, 430);
		addPan.setBackground(Color.white);
		addPan.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//Candidate ID No. Panel
		candidateIDPanel = new JPanel();
		addPan.add(candidateIDPanel);
		candidateIDPanel.setVisible(true);
		candidateIDPanel.setLayout(null);
		candidateIDPanel.setBounds(10,10,100,80);
		candidateIDPanel.setBorder(BorderFactory.createTitledBorder(" VOTER ID"));
		candidateIDPanel.setBackground(Color.white);
		JLabel ast1 = new JLabel("*");
		ast1.setFont(new Font("Arial",Font.BOLD,20));
		ast1.setBounds(3, 2, 20,20);
		candidateIDPanel.add(ast1);

		JTextField candidateID = new JTextField("",20);
		candidateID.setBounds(10, 28, 80, 20);
	    String can = candidateID.getText();
	    
		//Name Panel
		namePanel = new JPanel();
		addPan.add(namePanel);
		namePanel.setVisible(true);
		namePanel.setLayout(null);
		namePanel.setBounds(110,10,480,80);
		namePanel.setBorder(BorderFactory.createTitledBorder(" NAME"));
		namePanel.setBackground(Color.white);
		JLabel ast2 = new JLabel("*");
		ast2.setFont(new Font("Arial",Font.BOLD,20));
		ast2.setBounds(3, 2, 20,20);
		namePanel.add(ast2);
		
		Lname = new JTextField("",40);
		Lname.setBounds(10, 28, 150, 20);
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(10, 40, 100, 40);
		
		JLabel comma1 = new JLabel(",");
		comma1.setBounds(160, 30,20,20);
		comma1.setFont(new Font("Arial",Font.PLAIN,20));
		
		Fname = new JTextField("",40);
		Fname.setBounds(167, 28, 150, 20);
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(167, 40, 100, 40);
		
		Mname = new JTextField("",40);
		Mname.setBounds(320, 28, 150, 20);
		JLabel middleName = new JLabel("Middle Name");
		middleName.setBounds(330, 40, 100, 40);
		
		//Age Panel
		agePanel = new JPanel();
		addPan.add(agePanel);
		agePanel.setVisible(true);
		agePanel.setLayout(null);
		agePanel.setBounds(590,10,74,80);
		agePanel.setBorder(BorderFactory.createTitledBorder(" AGE"));
		agePanel.setBackground(Color.white);
		JLabel ast3 = new JLabel("*");
		ast3.setFont(new Font("Arial",Font.BOLD,20));
		ast3.setBounds(3, 2, 20,20);
		agePanel.add(ast3);
		
		age = new JTextField("",20);
		age.setBounds(10, 28, 50, 20);

		//Gender Panel
		genderPanel = new JPanel();
		addPan.add(genderPanel);
		genderPanel.setVisible(true);
		genderPanel.setLayout(null);
		genderPanel.setBounds(10,90,144,80);
		genderPanel.setBorder(BorderFactory.createTitledBorder(" GENDER"));
		genderPanel.setBackground(Color.white);
		JLabel ast4 = new JLabel("*");
		ast4.setFont(new Font("Arial",Font.BOLD,20));
		ast4.setBounds(3, 2, 20,20);
		genderPanel.add(ast4);
		
		gender = new ButtonGroup();
		male = new JRadioButton("Male");
		male.setBackground(Color.white);
		female = new JRadioButton("Female");
		female.setBackground(Color.white);
		gender.add(male);
		gender.add(female);
		male.setBounds(5,30,65,20);
		female.setBounds(68,30,70,20);
				
		//Date of Birth Panel
		dateofBirthPanel = new JPanel();
		addPan.add(dateofBirthPanel);
		dateofBirthPanel.setVisible(true);
		dateofBirthPanel.setLayout(null);
		dateofBirthPanel.setBounds(154,90,233,80);
		dateofBirthPanel.setBorder(BorderFactory.createTitledBorder(" DATE OF BIRTH"));
		dateofBirthPanel.setBackground(Color.white);
		JLabel ast5 = new JLabel("*");
		ast5.setFont(new Font("Arial",Font.BOLD,20));
		ast5.setBounds(3, 2, 20,20);
		dateofBirthPanel.add(ast5);
		
		String[] monthNames = {"...","January","February","March","April","May","June","July","August","September","October","November","December"};
		JComboBox monthChoice = new JComboBox(monthNames);
		monthChoice.setBounds(10, 20, 100,20);
		JLabel monthLabel = new JLabel("Month");
		monthLabel.setBounds(10, 32, 350, 40);
		
		JComboBox day = new JComboBox();
		day.setBounds(117, 20, 40, 20);
		int dayCtr = 0;
		for(dayCtr = 1; dayCtr <= 31; dayCtr++){
			String dey = (String) Integer.toString(dayCtr); 
			String[] dayArray = {dey};
			day.addItem(dey);
		}
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setBounds(117, 32, 350, 40);

	    JComboBox year = new JComboBox();
		year.setBounds(165, 20, 55, 20);
		int yearCtr = 0;
		for(yearCtr = 2016; yearCtr >= 1900; yearCtr--){
			String yer = (String) Integer.toString(yearCtr); 
			String[] yearArray = {yer};
			year.addItem(yer);
		}
		JLabel yearLabel = new JLabel("Year");
		yearLabel.setBounds(165, 32, 350, 40);
		
		//Place of Birth Panel
		placeofBirthPanel = new JPanel();
		addPan.add(placeofBirthPanel);
		placeofBirthPanel.setVisible(true);
		placeofBirthPanel.setLayout(null);
		placeofBirthPanel.setBounds(387,90,277,80);
		placeofBirthPanel.setBorder(BorderFactory.createTitledBorder("PLACE OF BIRTH"));
		placeofBirthPanel.setBackground(Color.white);
		
		JTextField province = new JTextField("",40);
		province.setBounds(10, 20, 125, 20);
		JLabel provinceL = new JLabel("Province");
		provinceL.setBounds(10, 32, 100, 40);
		
		JTextField city = new JTextField("",40);
		city.setBounds(140, 20, 130, 20);
		JLabel cityMuni = new JLabel("City/Municipality");
		cityMuni.setBounds(140, 32, 100, 40);
		JLabel ast6 = new JLabel("*");
		ast6.setFont(new Font("Arial",Font.BOLD,20));
		ast6.setBounds(132, 45, 20,20);
		placeofBirthPanel.add(ast6);
		
		
		//Civil Status Panel
		civilStatusPanel = new JPanel();
		addPan.add(civilStatusPanel);
		civilStatusPanel.setVisible(true);
		civilStatusPanel.setLayout(null);
		civilStatusPanel.setBounds(10,170,140,80);
		civilStatusPanel.setBorder(BorderFactory.createTitledBorder(" CIVIL STATUS"));
		civilStatusPanel.setBackground(Color.white);
		JLabel ast7 = new JLabel("*");
		ast7.setFont(new Font("Arial",Font.BOLD,20));
		ast7.setBounds(3, 2, 20,20);
		civilStatusPanel.add(ast7);
		
		String[] civilStatusItems = {"...","Single","Married","Annulled/Divorce","Widow/er","Legally Separated"};
		JComboBox civilStatus= new JComboBox(civilStatusItems);
		civilStatus.setBounds(10, 20, 120, 20);
	    
		//Name of Spouse Panel
		nameOfSpousePanel = new JPanel();
		addPan.add(nameOfSpousePanel);
		nameOfSpousePanel.setVisible(true);
		nameOfSpousePanel.setLayout(null);
		nameOfSpousePanel.setBounds(150,170,270,80);
		nameOfSpousePanel.setBorder(BorderFactory.createTitledBorder("NAME OF SPOUSE (If Married)"));
		nameOfSpousePanel.setBackground(Color.white);
				
		JTextField fullName = new JTextField("",50);
		fullName.setBounds(10, 22, 250, 20);
		
		//Occupation Panel
		occupationPanel = new JPanel();
		addPan.add(occupationPanel);
		occupationPanel.setVisible(true);
		occupationPanel.setLayout(null);
		occupationPanel.setBounds(420,170,244,80);
		occupationPanel.setBorder(BorderFactory.createTitledBorder(" OCCUPATION/PROFESSION"));
		occupationPanel.setBackground(Color.white);
		JLabel ast8 = new JLabel("*");
		ast8.setFont(new Font("Arial",Font.BOLD,20));
		ast8.setBounds(3, 2, 20,20);
		occupationPanel.add(ast8);
		
		JTextField occupationTF = new JTextField("",20);
		occupationTF.setBounds(10, 23, 225, 20);
		
		//Address Panel
	    addressPanel = new JPanel();
	    addPan.add(addressPanel);
		addressPanel.setVisible(true);
		addressPanel.setLayout(null);
		addressPanel.setBounds(10,250,654,80);
	    addressPanel.setBorder(BorderFactory.createTitledBorder("ADDRESS"));
		addressPanel.setBackground(Color.white);
				
		JTextField provinceTF = new JTextField("",40);
		provinceTF.setBounds(10, 20, 140, 20);
		JLabel provinceLabel = new JLabel("Province");
		provinceLabel.setBounds(10, 32, 140, 40);
				
		JTextField cityTF = new JTextField("",40);
		cityTF.setBounds(160, 20, 140, 20);
		JLabel cityLabel = new JLabel("City/Municipality");
		cityLabel.setBounds(160, 32, 140, 40);
		JLabel ast9 = new JLabel("*");
		ast9.setFont(new Font("Arial",Font.BOLD,20));
		ast9.setBounds(152, 45, 20,20);
		addressPanel.add(ast9);
				
		JTextField barangayTF = new JTextField("",40);
		barangayTF.setBounds(310, 20, 140, 20);
		JLabel barangayLabel = new JLabel("Barangay");
		barangayLabel.setBounds(310, 32, 140, 40);
		JLabel ast10 = new JLabel("*");
		ast10.setFont(new Font("Arial",Font.BOLD,20));
		ast10.setBounds(302, 45, 20,20);
		addressPanel.add(ast10);
		
		JTextField streetTF = new JTextField("",40);
		streetTF.setBounds(460, 20, 183, 20);
		JLabel streetLabel = new JLabel("House No./Street/Subdivision");
		streetLabel.setBounds(460, 32, 183, 40);
		JLabel ast11 = new JLabel("*");
		ast11.setFont(new Font("Arial",Font.BOLD,20));
		ast11.setBounds(452, 45, 20,20);
		addressPanel.add(ast11);
		
		newButton = new JButton("CLEAR");
		newButton.setBounds(80, 357,120,40);
		newButton.setIcon(new ImageIcon("clearBut.png"));
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(340, 357,120,40);
		searchButton.setIcon(new ImageIcon("addBut.png"));
		cancelButton1 = new JButton("BACK");
		cancelButton1.setBounds(470, 357,120,40);
		cancelButton1.setIcon(new ImageIcon("backBut.png"));
		updateButton1 = new JButton("UPDATE");
		updateButton1.setBounds(210, 357,120,40);
		updateButton1.setIcon(new ImageIcon("backBut.png"));
		
		Lname.setEditable(false); Fname.setEditable(false); Mname.setEditable(false); age.setEditable(false);
		monthChoice.setEnabled(false); day.setEnabled(false); year.setEnabled(false); city.setEditable(false);
		province.setEditable(false); civilStatus.setEnabled(false); fullName.setEditable(false); occupationTF.setEditable(false);
		provinceTF.setEditable(false); cityTF.setEditable(false); barangayTF.setEditable(false); streetTF.setEditable(false);
		updateButton1.setEnabled(false);
		
		searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a){
					int ctr = 0;
					int ctr1 = 0;
					int count = 0;
				try{
					Scanner in = new Scanner(new FileReader("Voter's List.txt"));
					StringBuilder input = new StringBuilder();
					String tempPos = "";
					String pos = "";
					while(in.hasNext()){
						 String ID = in.next();        
			             String lName = in.next();    
			             String fName = in.next();       
			             String mName = in.next();        
			             String age1 = in.next();   
			             String gender = in.next();
			             String month = in.next();
			             String day1 = in.next();
			             String year1 = in.next();
			             String prov1 = in.next();
			             String city1 = in.next();
			             String cStatus = in.next();
			             String spouse = in.next();
			             String occu = in.next();
			             String prov2 = in.next();
			             String city2 = in.next();
			             String bar = in.next();
			             String strit = in.next();
			       String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age1+" "+gender+" "+month+" "+day1+" "+year1+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit;
			            if(ID.equals(candidateID.getText())){
			            	Lname.setEditable(true); Fname.setEditable(true); Mname.setEditable(true); age.setEditable(true);
			            	monthChoice.setEnabled(true); day.setEnabled(true); year.setEnabled(true); city.setEditable(true);
			            	province.setEditable(true); civilStatus.setEnabled(true); fullName.setEditable(true); occupationTF.setEditable(true);
			            	provinceTF.setEditable(true); cityTF.setEditable(true); barangayTF.setEditable(true); streetTF.setEditable(true);
			             Lname.setText(lName); Fname.setText(fName); Mname.setText(mName); age.setText(age1); 
			             monthChoice.setSelectedItem(month); day.setSelectedItem(day1); year.setSelectedItem(year1); 
			             province.setText(prov1); city.setText(city1); civilStatus.setSelectedItem(cStatus);
			             fullName.setText(spouse); occupationTF.setText(occu); provinceTF.setText(prov2);
			             cityTF.setText(city2); barangayTF.setText(bar); streetTF.setText(strit);
			             updateButton1.setEnabled(true); searchButton.setEnabled(false);
			             count++;
			       	     }
			            else{
			            	count = count;
			            }
				  }
					if(count < 1){
						JOptionPane.showMessageDialog(null,"Candidate not found","Edit Voter",JOptionPane.ERROR_MESSAGE);
						candidateID.setText("");
						candidateID.requestFocus();
					}
			}
				
			catch(Exception e){
				e.getMessage();
			  }
			}
		});
			cancelButton1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent b){
					editCan.setVisible(false);
					addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
					addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
				}
			});
			
			updateButton1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent x){
					int ctr = 0;
					int ctr1 = 0;
					String nLname = "" , nFname = "", nMname = "", nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1 = "";
				try{
					Scanner in = new Scanner(new FileReader("Voter's List.txt"));
					StringBuilder input = new StringBuilder();
					String tempPos = "";
					String pos = "";
					while(in.hasNext()){
						 String ID = in.next();        
			             String lName = in.next();    
			             String fName = in.next();       
			             String mName = in.next();        
			             String age1 = in.next();   
			             String gender = in.next();
			             String month = in.next();
			             String day1 = in.next();
			             String year1 = in.next();
			             String prov1 = in.next();
			             String city1 = in.next();
			             String cStatus = in.next();
			             String spouse = in.next();
			             String occu = in.next();
			             String prov2 = in.next();
			             String city2 = in.next();
			             String bar = in.next();
			             String strit = in.next();
			       String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age1+" "+gender+" "+month+" "+day1+" "+year1+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit;
			             
			     //removing whitespaces
					
					nLname = Lname.getText().replaceAll("\\s", ",");
					nFname = Fname.getText().replaceAll("\\s", ",");
					nMname = Mname.getText().replaceAll("\\s", ",");
					nCity = city.getText().replaceAll("\\s", ",");
					nProv = province.getText().replaceAll("\\s", ",");
					nfullName = fullName.getText().replaceAll("\\s", ",");
					nOccu = occupationTF.getText().replaceAll("\\s", ",");
					nStreet = streetTF.getText().replaceAll("\\s", ",");
					nBara = barangayTF.getText().replaceAll("\\s", ",");
					nCity1 = cityTF.getText().replaceAll("\\s", ",");
					nProv1 = provinceTF.getText().replaceAll("\\s", ",");
					
					String gend;
	            	if(male.isSelected()){
	            		gend = "Male";
	            	}
	            	else{
	            		gend = "Female";
	            	}
	            	
			           if(ID.equals(candidateID.getText()) && (candidateID.getText().equals("") || Lname.getText().equals("") || Fname.getText().equals("") || Mname.getText().equals("") || age.getText().equals("") || monthChoice.getSelectedIndex() == 0 || city.getText().equals("") || civilStatus.getSelectedIndex() == 0 || occupationTF.getText().equals("") || cityTF.getText().equals("") || barangayTF.getText().equals("") || streetTF.getText().equals(""))== false){
			             String newLine = ID+" "+nLname+" "+nFname+" "+nMname+" "+age.getText()+" "+gend+" "+monthChoice.getSelectedItem()+" "+day.getSelectedItem()+" "+year.getSelectedItem()+" "+nProv+" "+nCity+" "+cStatus+" "+nfullName+" "+nOccu+" "+nProv1+" "+nCity1+" "+nBara+" "+nStreet; 
			       		 System.out.println(newLine);
			       		 System.out.println(tempPos);
			       		 input.append(newLine);
			       	     input.append(System.lineSeparator());
			       	     ctr++;
			       	     }
			            else{
			            	input.append(oldLine);
			            	input.append(System.lineSeparator());
			           	 	ast1.setForeground(Color.RED); ast5.setForeground(Color.RED); ast9.setForeground(Color.RED);
                       	    ast2.setForeground(Color.RED); ast6.setForeground(Color.RED); ast10.setForeground(Color.RED);
                       	    ast3.setForeground(Color.RED); ast7.setForeground(Color.RED); ast11.setForeground(Color.RED);
                       	    ast4.setForeground(Color.RED); ast8.setForeground(Color.RED); 
                       	 String buttons[] = {"OK"};
                       	 int ch = JOptionPane.showOptionDialog(null,"All Fields with (*) are required","ADD VOTER",JOptionPane.OK_OPTION,0,null,buttons,buttons[0]);
                       	   if(ch == 0){
                       		   ast1.setForeground(Color.BLACK); ast5.setForeground(Color.BLACK); ast9.setForeground(Color.BLACK);
                       		   ast2.setForeground(Color.BLACK); ast6.setForeground(Color.BLACK); ast10.setForeground(Color.BLACK);
                       		   ast3.setForeground(Color.BLACK); ast7.setForeground(Color.BLACK); ast11.setForeground(Color.BLACK);
                       		   ast4.setForeground(Color.BLACK); ast8.setForeground(Color.BLACK);
                       	   }
			            	//continue;
			            }
					}
					BufferedWriter out = new BufferedWriter(new FileWriter("Voter's List.txt"));
		            out.write(input.toString());
		            out.append(System.lineSeparator());
		            System.out.println("input"+input);
		            System.out.println("out"+out);
		            out.close();
				}
				catch(Exception c){
					c.getMessage();
				}
				if(ctr >= 1){
	            	JOptionPane.showMessageDialog(null,"Candidate information\nsuccessfully edited!","Edit Candidate",JOptionPane.INFORMATION_MESSAGE);
	            	Lname.setText(""); Fname.setText(""); Mname.setText(""); age.setText(""); city.setText("");
	            	province.setText(""); civilStatus.setSelectedItem("..."); fullName.setText(""); occupationTF.setText("");
	            	provinceTF.setText(""); cityTF.setText(""); barangayTF.setText(""); streetTF.setText("");
	            	
	            	Lname.setEditable(false); Fname.setEditable(false); Mname.setEditable(false); age.setEditable(false);
	            	monthChoice.setEnabled(false); day.setEnabled(false); year.setEnabled(false); city.setEditable(false);
	            	province.setEditable(false); civilStatus.setEnabled(false); fullName.setEditable(false); occupationTF.setEditable(false);
	            	provinceTF.setEditable(false); cityTF.setEditable(false); barangayTF.setEditable(false); streetTF.setEditable(false);
	            	
	            	candidateID.setText("");
	            	candidateID.requestFocus();
	            	updateButton1.setEnabled(false); searchButton.setEnabled(true);
	            }
	            
	            else{
	            	ctr = ctr;
	            }
			}
		});
			
			editCan.getRootPane().setDefaultButton(searchButton);
			
			candidateIDPanel.add(candidateID); namePanel.add(Lname);   namePanel.add(comma1); namePanel.add(Fname);    namePanel.add(Mname);      agePanel.add(age);      
										       namePanel.add(lastName);                       namePanel.add(firstName);namePanel.add(middleName);
			genderPanel.add(male); genderPanel.add(female);      dateofBirthPanel.add(monthChoice); dateofBirthPanel.add(day);      dateofBirthPanel.add(year);      
			placeofBirthPanel.add(city);     placeofBirthPanel.add(province);
			dateofBirthPanel.add(monthLabel);  dateofBirthPanel.add(dayLabel); dateofBirthPanel.add(yearLabel); 
			placeofBirthPanel.add(cityMuni); placeofBirthPanel.add(provinceL);
			civilStatusPanel.add(civilStatus); nameOfSpousePanel.add(fullName);     occupationPanel.add(occupationTF);
			addressPanel.add(provinceTF);    addressPanel.add(cityTF);    addressPanel.add(barangayTF);    addressPanel.add(streetTF);
			addressPanel.add(provinceLabel); addressPanel.add(cityLabel); addressPanel.add(barangayLabel); addressPanel.add(streetLabel);
			editCan.add(newButton); editCan.add(searchButton); editCan.add(cancelButton1); editCan.add(updateButton1);

			
			
			JPanel tempPan1 = new JPanel();
			tempPan1.setVisible(true);
			tempPan1.setLayout(null);
			tempPan1.setBackground(Color.white);
			editCan.add(addPan);
			editCan.add(tempPan1);
}		
		public void deletingVoter(){
			final JFrame delVot = new JFrame();
		          JTextField voterID2;
		          JButton searchButton2, cancelButton2;
		          delVot.setUndecorated(true);
		          delVot.setSize(680, 486);
		          delVot.setVisible(true);
		          delVot.setLocation(456,190);
		          delVot.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		          delVot.setResizable(false);
		          delVot.setContentPane(new JLabel(new ImageIcon("delVot.jpg")));
			
		          searchButton2 = new JButton("SEARCH");
			  		searchButton2.setBounds(330, 280,120,40);
			  		searchButton2.setIcon(new ImageIcon("seaBut.png"));
					delVot.add(searchButton2);
					cancelButton2 = new JButton("BACK");
					cancelButton2.setBounds(480, 280,120,40);
					cancelButton2.setIcon(new ImageIcon("backBut.png"));
					delVot.add(cancelButton2);
				
				voterID2 = new JTextField("",20);
				voterID2.setBounds(340, 170, 250, 35);
			
			delVot.add(voterID2);
			searchButton2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent a){
					try{
						Scanner in = new Scanner(new FileReader("Voter.txt"));
						StringBuilder input = new StringBuilder(); 
						String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1 = "";
				        int ctr1 = 0,ctr = 0;
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

				           //putting whitespaces
								nLname = lName.replaceAll(",", " ");
								nFname = fName.replaceAll(",", " ");
								nMname = mName.replaceAll(",", " ");
								nCity = city1.replaceAll(",", " ");
								nProv = prov1.replaceAll(",", " ");
								nfullName = spouse.replaceAll(",", " ");
								nOccu = occu.replaceAll(",", " ");
								nStreet = strit.replaceAll(",", " ");
								nBara = bar.replaceAll(",", " ");
								nCity1 = city2.replaceAll(",", " ");
								nProv1 = prov2.replaceAll(",", " ");
							//putting whitespaces
				       	    if(ID.equals(voterID2.getText())){
				       	    	ctr1++;			            
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
			            
						Scanner in1 = new Scanner(new FileReader("Voter's List.txt"));
						StringBuilder input1 = new StringBuilder(); 
						String nLname1, nFname1, nMname1, nCity2, nProv2, nfullName1, nOccu1, nStreet1, nBara1, nCity3, nProv3 = "";
						while(in1.hasNext()){
							 String ID = in1.next();        
				             String lName = in1.next();    
				             String fName = in1.next();       
				             String mName = in1.next();        
				             String age = in1.next();   
				             String gender = in1.next();
				             String month = in1.next();
				             String day = in1.next();
				             String year = in1.next();
				             String prov1 = in1.next();
				             String city1 = in1.next();
				             String cStatus = in1.next();
				             String spouse = in1.next();
				             String occu = in1.next();
				             String prov2 = in1.next();
				             String city2 = in1.next();
				             String bar = in1.next();
				             String strit = in1.next();
				             String oldLine = ID+" "+lName+" "+fName+" "+mName+" "+age+" "+gender+" "+month+" "+day+" "+year+" "+prov1+" "+city1+" "+cStatus+" "+spouse+" "+occu+" "+prov2+" "+city2+" "+bar+" "+strit;

				           //putting whitespaces
								nLname1 = lName.replaceAll(",", " ");
								nFname1 = fName.replaceAll(",", " ");
								nMname1 = mName.replaceAll(",", " ");
								nCity2 = city1.replaceAll(",", " ");
								nProv2 = prov1.replaceAll(",", " ");
								nfullName1 = spouse.replaceAll(",", " ");
								nOccu1 = occu.replaceAll(",", " ");
								nStreet1 = strit.replaceAll(",", " ");
								nBara1 = bar.replaceAll(",", " ");
								nCity3 = city2.replaceAll(",", " ");
								nProv3 = prov2.replaceAll(",", " ");
							//putting whitespaces
				       	    if(ID.equals(voterID2.getText())){
					        	 JOptionPane.showMessageDialog(null,"VOTER FOUND!","Voter's ID:"+voterID2.getText(),JOptionPane.INFORMATION_MESSAGE);
					        	 JOptionPane.showMessageDialog(null,"Voter's ID:"+ID+"\nName:"+lName+","+fName+" "+mName+"\nAge:"+age+"\nGender:"+gender+"\nBirthday:"+month+" "+day+","+year+"\nBirthplace:\n     Province:"+nProv2+"\n     City:"+nCity2+"\nCivil Status:"+cStatus+"\nSpouse(if married):"+nfullName1+"\nOccupation:"+nOccu1+"\nAddress:\n     Province:"+nProv3+"\n     City:"+nCity3+"\n     Barangay:"+nBara1+"\n     Street:"+nStreet1,"Voter ID:"+voterID2.getText(),JOptionPane.INFORMATION_MESSAGE);
					        	    ctr++;	
					        	}
				            else{
				            	input1.append(oldLine);
				            	input1.append(System.lineSeparator());
				            	continue;
				            }
						}
						BufferedWriter out1 = new BufferedWriter(new FileWriter("Voter's List.txt"));
			            out1.write(input.toString());
			            out1.append(System.lineSeparator());
			            out1.close();
						if((ctr >= 1 || ctr1 >= 1)){
			            	JOptionPane.showMessageDialog(null,"Voter's information successfully deleted!","Delete Voter",JOptionPane.INFORMATION_MESSAGE);
			            	voterID2.setText("");
			            	voterID2.requestFocus();
						}
			            else{
			            	JOptionPane.showMessageDialog(null,"Candidate not found","Delete Voter",JOptionPane.ERROR_MESSAGE);
			            	voterID2.setText("");
			            	voterID2.requestFocus();
			            }
						
					}
					catch(Exception x){
						x.getMessage();
					}
				}
			});
			cancelButton2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent b){
					delVot.setVisible(false);
					addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
					addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
				}
			});
			delVot.getRootPane().setDefaultButton(searchButton2);
		}
		
		public void searchingVoter(){
			final JFrame seaVot = new JFrame();
		          JTextField voterID3;
		          JButton searchButton3, cancelButton3;
            seaVot.setUndecorated(true);
            seaVot.setSize(680, 486);
            seaVot.setVisible(true);
            seaVot.setLocation(456,190);
            seaVot.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        seaVot.setResizable(false);
		    seaVot.setContentPane(new JLabel(new ImageIcon("seaVot.jpg")));
		    
		    searchButton3 = new JButton("SEARCH");
	  		searchButton3.setBounds(330, 280,120,40);
	  		searchButton3.setIcon(new ImageIcon("seaBut.png"));
			seaVot.add(searchButton3);
			cancelButton3 = new JButton("BACK");
			cancelButton3.setBounds(480, 280,120,40);
			cancelButton3.setIcon(new ImageIcon("backBut.png"));
			seaVot.add(cancelButton3);
		
		voterID3 = new JTextField("",20);
		voterID3.setBounds(340, 170, 250, 35);
	
			
			seaVot.add(voterID3);
			
			searchButton3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent b){
					try{
						Scanner in = new Scanner(new FileReader("Voter's List.txt"));
					    int count = 0;
					    String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1;
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
				     	    //putting whitespaces
								nLname = lName.replaceAll(",", " ");
								nFname = fName.replaceAll(",", " ");
								nMname = mName.replaceAll(",", " ");
								nCity = city1.replaceAll(",", " ");
								nProv = prov1.replaceAll(",", " ");
								nfullName = spouse.replaceAll(",", " ");
								nOccu = occu.replaceAll(",", " ");
								nStreet = strit.replaceAll(",", " ");
								nBara = bar.replaceAll(",", " ");
								nCity1 = city2.replaceAll(",", " ");
								nProv1 = prov2.replaceAll(",", " ");
							//putting whitespaces
				          if(ID.equals(voterID3.getText())){
				        	    count++;
				        	    JOptionPane.showMessageDialog(null,"VOTER FOUND!","Voter's ID:"+voterID3.getText(),JOptionPane.INFORMATION_MESSAGE);
				        	    JOptionPane.showMessageDialog(null,"Voter's ID:"+ID+"\nName:"+nLname+","+nFname+" "+nMname+"\nAge:"+age+"\nGender:"+gender+"\nBirthday:"+month+" "+day+","+year+"\nBirthplace:\n     Province:"+nProv+"\n     City:"+nCity+"\nCivil Status:"+cStatus+"\nSpouse(if married):"+nfullName+"\nOccupation:"+nOccu+"\nAddress:\n     Province:"+nProv1+"\n     City:"+nCity1+"\n     Barangay:"+nBara+"\n     Street:"+nStreet,"Voter's ID:"+voterID3.getText(),JOptionPane.INFORMATION_MESSAGE);
				          }
				          else{
				        	  count = count;
							  continue;
				          }
						}
						  if(count == 1){  
								voterID3.setText("");
								voterID3.requestFocus();		         
				          }
				          else{
				        	  JOptionPane.showMessageDialog(null,"Candidate not found","Search Voter",JOptionPane.ERROR_MESSAGE);
								voterID3.setText("");
								voterID3.requestFocus(); 
				          }
						in.close();
					}
					catch(Exception i){
						i.getMessage();
					}
				}
			}); 
			
			cancelButton3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent b){
					seaVot.setVisible(false);
					addCanButton.setEnabled(true); editCanButton.setEnabled(true);  delCanButton.setEnabled(true);  seaCanButton.setEnabled(true);
					addVotButton.setEnabled(true); editVotButton.setEnabled(true);  delVotButton.setEnabled(true);  seaVotButton.setEnabled(true); 
				}
			});
			seaVot.getRootPane().setDefaultButton(searchButton3);
		}
		
public void result(){

	    	JFrame resF = new JFrame("Automated Voting System v.1");
	    	String[] pos = {"...","President","Vice-President","Secretary","Treasurer","Auditor","Public Information Officer"};
	    	JComboBox posName = new JComboBox(pos);
	    	JButton search = new JButton("SEARCH");
	    	search.setIcon(new ImageIcon("seaBut.png"));
	    	resF.setVisible(true);
	    	resF.setSize(490, 200);
	    	resF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    	resF.setLocation(500,270);
	    	resF.setResizable(false);
	    	resF.setContentPane(new JLabel(new ImageIcon("resultSearch.jpg")));
	    	resF.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	    	resF.getRootPane().setDefaultButton(search);
	    	posName.setBounds(195,50,200,30);
	    	search.setBounds(230,120,120,40);
	    	resF.add(search);
	    	resF.add(posName);
	    
	   search.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent d){
			  int ctr = 0;
			    String fileName = ((String) posName.getSelectedItem());
		    	File res = new File(fileName+".txt");
		    	
		    	if(res.exists()){
		    		resFrame();
		    	}
		    	else{
		    		posName.setSelectedIndex(0);
		    		JOptionPane.showMessageDialog(null,"Wrong position name!","Automated Voting System:RESULT",JOptionPane.ERROR_MESSAGE);
		    	}
        }

public void resFrame(){
	       String fileName = (String) posName.getSelectedItem(); 
	       JFrame result = new JFrame("RESULT: "+fileName);
		   result.setVisible(true);
		   result.setSize(800, 400);
		   result.setLayout(null);
		   result.setLocation(285,180);
		   result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		   result.setResizable(false);
		   result.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		   result.setContentPane(new JLabel(new  ImageIcon("resFrame.jpg")));
		   JPanel pan = new JPanel();
		   pan.setLayout(null);
		   pan.setBounds(10, 90, 754, 250);
		   pan.setBackground(Color.WHITE);
		   result.add(pan);
		   JTextArea ta = new JTextArea();
		   ta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.darkGray));
		   ta.setEditable(false);
		   ta.setBounds(10,10,740,250);
		   JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		   sp.setBounds(10, 10, 740, 240);
		   pan.add(sp);
		    	 try{
		    	    Scanner in = new Scanner(new FileReader(fileName+".txt"));
		    	 
		    	    while(in.hasNext()){
						  String ID = in.next();
						  String lname = in.next();
						  String fname = in.next();
						  String mname = in.next();
						  String vote = in.next();
						  String nlname = lname.replaceAll(",", " "); 
						  String nfname = fname.replaceAll(",", " ");
						  String nmname = mname.replaceAll(",", " ");
						  ta.append(ID+"\t\t"+nlname+"\t\t"+nfname+"\t\t"+nmname+"\t\t"+vote);
						  ta.append(System.lineSeparator());
		    	  }
		    	 }
		    	 catch(Exception h){
		    		 h.getMessage();
		    	 }	
		      }
	   });
}

public void allCan(){ 
    JFrame allCan = new JFrame("Candidate's List");
       allCan.setVisible(true);
       allCan.setSize(800, 400);
       allCan.setLayout(null);
       allCan.setLocation(285,180);
       allCan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       allCan.setResizable(false);
       allCan.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
       allCan.setContentPane(new JLabel(new  ImageIcon("allCan.jpg")));
	   JPanel pan = new JPanel();
	   pan.setLayout(null);
	   pan.setBounds(10, 75, 754, 250);
	   pan.setBackground(Color.WHITE);
	   allCan.add(pan);
	   JTextArea ta = new JTextArea();
	   ta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.darkGray));
	   ta.setEditable(false);
	   ta.setBounds(10,10,740,250);
	   JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	   sp.setBounds(10, 10, 740, 240);
	   pan.add(sp);
	   try{
			Scanner in = new Scanner(new FileReader("Candidate.txt"));
		    int count = 0;
		    String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos;
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
	             String posit = in.next();
	             
	     	    //putting whitespaces
					nLname = lName.replaceAll(",", " ");
					nFname = fName.replaceAll(",", " ");
					nMname = mName.replaceAll(",", " ");
					nCity = city1.replaceAll(",", " ");
					nProv = prov1.replaceAll(",", " ");
					nfullName = spouse.replaceAll(",", " ");
					nOccu = occu.replaceAll(",", " ");
					nStreet = strit.replaceAll(",", " ");
					nBara = bar.replaceAll(",", " ");
					nCity1 = city2.replaceAll(",", " ");
					nProv1 = prov2.replaceAll(",", " ");
					nPos = posit.replaceAll(",", " ");
				//putting whitespaces
					  ta.append(ID+"\t"+nLname+"\t"+nFname+"\t"+nMname+"\t"+age+"\t"+gender+"\t"+nOccu+"\t"+nPos);
					  ta.append(System.lineSeparator());
	    	  }
	    	 }
	    	 catch(Exception h){
	    		 h.getMessage();
	    	 }	
}

public void allVot(){ 
    JFrame allVot = new JFrame("Voter's List");
       allVot.setVisible(true);
       allVot.setSize(800, 400);
       allVot.setLayout(null);
       allVot.setLocation(285,180);
       allVot.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       allVot.setResizable(false);
       allVot.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
       allVot.setContentPane(new JLabel(new  ImageIcon("allVot.jpg")));
	   JPanel pan = new JPanel();
	   pan.setLayout(null);
	   pan.setBounds(10, 75, 754, 250);
	   pan.setBackground(Color.WHITE);
	   allVot.add(pan);
	   JTextArea ta = new JTextArea();
	   ta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.darkGray));
	   ta.setEditable(false);
	   ta.setBounds(10,10,740,250);
	   JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	   sp.setBounds(10, 10, 740, 240);
	   pan.add(sp);
	   try{
			Scanner in = new Scanner(new FileReader("Voter's List.txt"));
		    int count = 0;
		    String nLname, nFname, nMname, nCity, nProv, nfullName, nOccu, nStreet, nBara, nCity1, nProv1,nPos;
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
	             
	     	    //putting whitespaces
					nLname = lName.replaceAll(",", " ");
					nFname = fName.replaceAll(",", " ");
					nMname = mName.replaceAll(",", " ");
					nCity = city1.replaceAll(",", " ");
					nProv = prov1.replaceAll(",", " ");
					nfullName = spouse.replaceAll(",", " ");
					nOccu = occu.replaceAll(",", " ");
					nStreet = strit.replaceAll(",", " ");
					nBara = bar.replaceAll(",", " ");
					nCity1 = city2.replaceAll(",", " ");
					nProv1 = prov2.replaceAll(",", " ");
				//putting whitespaces
					  ta.append(ID+"\t"+nLname+"\t"+nFname+"\t"+nMname+"\t"+age+"\t"+gender+"\t\t"+nOccu);
					  ta.append(System.lineSeparator());
	    	  }
	    	 }
	    	 catch(Exception h){
	    		 h.getMessage();
	    	 }	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void menuSelected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void menuDeselected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void menuCanceled(MenuEvent e) {
	// TODO Auto-generated method stub
	
	}
}
 
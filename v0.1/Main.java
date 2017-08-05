import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;





public class Main{
	
	private JFrame frame;
	private JFrame frameStock;
	private JFrame frameComplaints;
	public Stock[] stock=new Stock[10];
	private TextField textFieldCarLicense= new TextField();
	private TextField textFieldCarType= new TextField();
	private TextField textFieldCarManu= new TextField();
	private TextField textFieldCarModel= new TextField();
	private TextArea textAreaProblem= new TextArea();
	private int items[]=new int[10];
	private Checkbox rdbtnBumper = new Checkbox("Bumper");
	private Checkbox rdbtnEngineOil = new Checkbox("Engine Oil");
	private Checkbox rdbtnBrakeOil = new Checkbox("Brake Oil");
	private Checkbox rdbtnBrake = new Checkbox("Brake");
	private Checkbox rdbtnRim = new Checkbox("Rim");
	private Checkbox rdbtnTire = new Checkbox("Tire");
	private Checkbox rdbtnWindow = new Checkbox("Window");
	private Checkbox rdbtnEngine = new Checkbox("Engine");
	private Checkbox rdbtnMusic = new Checkbox("Music System");
	private Checkbox rdbtnSide = new Checkbox("Side Mirror");
	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		
		stock_Initialize();
		frame = new JFrame("Manager");


		frame.setBounds(200, 200, 650, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button btnAddComplaint = new Button("Add Complaint");
		btnAddComplaint.setBounds(50, 400, 190, 25);
		frame.getContentPane().add(btnAddComplaint);
		
		Button btnViewComplaint = new Button("View Complaints");
		btnViewComplaint.setBounds(305, 400, 110, 25);
		frame.getContentPane().add(btnViewComplaint);
		
		Button btnViewStock = new Button("View Stock");
		btnViewStock.setBounds(475, 400, 110, 25);
		frame.getContentPane().add(btnViewStock);
		
		Label lblCarLicensePlate = new Label("Car License Plate Number :");
		lblCarLicensePlate.setBounds(45, 30, 150, 14);
		frame.getContentPane().add(lblCarLicensePlate);
		
		Label lblCarType = new Label("Car Type :");
		lblCarType.setBounds(45, 55, 150, 14);
		frame.getContentPane().add(lblCarType);
		
		Label lblCarManufacturer = new Label("Car Manufacturer :");
		lblCarManufacturer.setBounds(45, 80, 150, 14);
		frame.getContentPane().add(lblCarManufacturer);
		
		Label lblCarModel = new Label("Car Model :");
		lblCarModel.setBounds(45, 105, 150, 14);
		frame.getContentPane().add(lblCarModel);
		
		Label lblProblem = new Label("Problem :");
		lblProblem.setBounds(45, 130, 150, 14);
		frame.getContentPane().add(lblProblem);
		
		Label lblComp = new Label("Select Parts Required :");
		lblComp.setBounds(45, 250, 150, 14);
		frame.getContentPane().add(lblComp);
		
		
		textFieldCarLicense.setBounds(200, 25, 320, 20);
		frame.getContentPane().add(textFieldCarLicense);
		textFieldCarLicense.setColumns(10);
		textFieldCarLicense.setText("Enter Car License");
		textFieldCarLicense.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldCarLicense.setText("");
			}
		});
		
		
		textFieldCarType.setBounds(200, 50, 320, 20);
		frame.getContentPane().add(textFieldCarType);
		textFieldCarType.setColumns(10);
		textFieldCarType.setText("Enter Car Type");
		textFieldCarType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldCarType.setText("");
			}
		});
		
		
		textFieldCarManu.setBounds(200, 75, 320, 20);
		frame.getContentPane().add(textFieldCarManu);
		textFieldCarManu.setColumns(10);
		textFieldCarManu.setText("Enter Car Manufacturer");
		textFieldCarManu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldCarManu.setText("");
			}
		});
		
		
		
		textFieldCarModel.setBounds(200, 100, 320, 20);
		frame.getContentPane().add(textFieldCarModel);
		textFieldCarModel.setColumns(10);
		textFieldCarModel.setText("Enter Car Model");
		textFieldCarModel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldCarModel.setText("");
			}
		});
		
		
		textAreaProblem.setBounds(200, 125, 320, 100);
		frame.getContentPane().add(textAreaProblem);
		textAreaProblem.setColumns(10);
		textAreaProblem.setText("Enter The Problem");
		textAreaProblem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaProblem.setText("");
			}
		});
				
		rdbtnBumper.setBounds(60, 280, 100, 24);
		frame.getContentPane().add(rdbtnBumper);
		
		rdbtnEngineOil.setBounds(160, 280, 100, 24);
		frame.getContentPane().add(rdbtnEngineOil);
		
		rdbtnBrakeOil.setBounds(260, 280, 100, 24);
		frame.getContentPane().add(rdbtnBrakeOil);
		
		rdbtnBrake.setBounds(360, 280, 100, 24);
		frame.getContentPane().add(rdbtnBrake);
		
		rdbtnRim.setBounds(460, 280, 100, 24);
		frame.getContentPane().add(rdbtnRim);
		
		rdbtnTire.setBounds(60, 310, 100, 24);
		frame.getContentPane().add(rdbtnTire);
		
		rdbtnWindow.setBounds(160, 310, 100, 24);
		frame.getContentPane().add(rdbtnWindow);
		
		rdbtnEngine.setBounds(260, 310, 100, 24);
		frame.getContentPane().add(rdbtnEngine);
		
		rdbtnMusic.setBounds(360, 310, 100, 24);
		frame.getContentPane().add(rdbtnMusic);
		
		rdbtnSide.setBounds(460, 310, 100, 24);
		frame.getContentPane().add(rdbtnSide);
		
		btnViewStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameStock = new JFrame("Stock"); 
				frameStock.setBounds(100, 100, 400, 400);
				frameStock.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						frameStock.dispose();
					}
				});
				frameStock.getContentPane().setLayout(null);
				
				Label Head1 = new Label("ITEMS");
				Head1.setBounds(40, 30, 60, 14);
				Head1.setFont(new Font(null,Font.BOLD , 18));
				Label Head2 = new Label("QUANTITY");
				Head2.setBounds(145, 30, 100, 14);
				Head2.setFont(new Font(null,Font.BOLD , 18));
				Label Head3 = new Label("PRICE");
				Head3.setBounds(260, 30, 100, 14);
				Head3.setFont(new Font(null,Font.BOLD , 18));
				
				
				Label Item1 = new Label(stock[0].getPartName());
				Item1.setBounds(45, 55, 100, 14);
				Label Item2 = new Label(stock[1].getPartName());
				Item2.setBounds(45, 80, 100, 14);		
				Label Item3 = new Label(stock[2].getPartName());
				Item3.setBounds(45, 105, 100, 14);
				Label Item4 = new Label(stock[3].getPartName());
				Item4.setBounds(45, 130, 100, 14);
				Label Item5 = new Label(stock[4].getPartName());
				Item5.setBounds(45, 155, 100, 14);
				Label Item6 = new Label(stock[5].getPartName());
				Item6.setBounds(45, 180, 100, 14);
				Label Item7 = new Label(stock[6].getPartName());
				Item7.setBounds(45, 205, 100, 14);
				Label Item8 = new Label(stock[7].getPartName());
				Item8.setBounds(45, 230, 100, 14);
				Label Item9 = new Label(stock[8].getPartName());
				Item9.setBounds(45, 255, 100, 14);
				Label Item10 = new Label(stock[9].getPartName());
				Item10.setBounds(45, 280, 100, 14);
				
				Label Item11 = new Label(""+stock[0].getPartLeft());
				Item11.setBounds(150, 55, 100, 14);
				Label Item12 = new Label(""+stock[1].getPartLeft());
				Item12.setBounds(150, 80, 100, 14);		
				Label Item13 = new Label(""+stock[2].getPartLeft());
				Item13.setBounds(150, 105, 100, 14);
				Label Item14 = new Label(""+stock[3].getPartLeft());
				Item14.setBounds(150, 130, 100, 14);
				Label Item15 = new Label(""+stock[4].getPartLeft());
				Item15.setBounds(150, 155, 100, 14);
				Label Item16 = new Label(""+stock[5].getPartLeft());
				Item16.setBounds(150, 180, 100, 14);
				Label Item17 = new Label(""+stock[6].getPartLeft());
				Item17.setBounds(150, 205, 100, 14);
				Label Item18 = new Label(""+stock[7].getPartLeft());
				Item18.setBounds(150, 230, 100, 14);
				Label Item19 = new Label(""+stock[8].getPartLeft());
				Item19.setBounds(150, 255, 100, 14);
				Label Item20 = new Label(""+stock[9].getPartLeft());
				Item20.setBounds(150, 280, 100, 14);
				
				Label Item21 = new Label(""+stock[0].getPrice());
				Item21.setBounds(265, 55, 100, 14);
				Label Item22 = new Label(""+stock[1].getPrice());
				Item22.setBounds(265, 80, 100, 14);		
				Label Item23 = new Label(""+stock[2].getPrice());
				Item23.setBounds(265, 105, 100, 14);
				Label Item24 = new Label(""+stock[3].getPrice());
				Item24.setBounds(265, 130, 100, 14);
				Label Item25 = new Label(""+stock[4].getPrice());
				Item25.setBounds(265, 155, 100, 14);
				Label Item26 = new Label(""+stock[5].getPrice());
				Item26.setBounds(265, 180, 100, 14);
				Label Item27 = new Label(""+stock[6].getPrice());
				Item27.setBounds(265, 205, 100, 14);
				Label Item28 = new Label(""+stock[7].getPrice());
				Item28.setBounds(265, 230, 100, 14);
				Label Item29 = new Label(""+stock[8].getPrice());
				Item29.setBounds(265, 255, 100, 14);
				Label Item30 = new Label(""+stock[9].getPrice());
				Item30.setBounds(265, 280, 100, 14);
				
				
				frameStock.getContentPane().add(Head1);
				frameStock.getContentPane().add(Head2);
				frameStock.getContentPane().add(Head3);
				frameStock.getContentPane().add(Item1);
				frameStock.getContentPane().add(Item2);
				frameStock.getContentPane().add(Item3);
				frameStock.getContentPane().add(Item4);
				frameStock.getContentPane().add(Item5);
				frameStock.getContentPane().add(Item6);
				frameStock.getContentPane().add(Item7);
				frameStock.getContentPane().add(Item8);
				frameStock.getContentPane().add(Item9);
				frameStock.getContentPane().add(Item10);
				frameStock.getContentPane().add(Item11);
				frameStock.getContentPane().add(Item12);
				frameStock.getContentPane().add(Item13);
				frameStock.getContentPane().add(Item14);
				frameStock.getContentPane().add(Item15);
				frameStock.getContentPane().add(Item16);
				frameStock.getContentPane().add(Item17);
				frameStock.getContentPane().add(Item18);
				frameStock.getContentPane().add(Item19);
				frameStock.getContentPane().add(Item20);
				frameStock.getContentPane().add(Item21);
				frameStock.getContentPane().add(Item22);
				frameStock.getContentPane().add(Item23);
				frameStock.getContentPane().add(Item24);
				frameStock.getContentPane().add(Item25);
				frameStock.getContentPane().add(Item26);
				frameStock.getContentPane().add(Item27);
				frameStock.getContentPane().add(Item28);
				frameStock.getContentPane().add(Item29);
				frameStock.getContentPane().add(Item30);
				frameStock.setVisible(true);
			}
		});
		
		btnAddComplaint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 10; i++) {
					items[i]=-1;
				}
				try
				{
					if((stock[0].getPartLeft()!=0)&&(rdbtnBumper.getState()))
					{	
						items[0]=1;
						stock[0].setPartLeft(stock[0].getPartLeft()-1);
					}
					else if((stock[0].getPartLeft()==0)&&(rdbtnBumper.getState()==true))
						throw new Exception("Item 1 does not have enough stock");
					if(stock[1].getPartLeft()!=0&&rdbtnEngineOil.getState())
					{	
						items[1]=1;
						stock[1].setPartLeft(stock[1].getPartLeft()-1);
					}
					else if((stock[1].getPartLeft()==0)&&(rdbtnEngineOil.getState()==true))
						throw new Exception("Item 2 does not have enough stock");
					if(stock[2].getPartLeft()!=0&&rdbtnBrakeOil.getState())
					{	
						items[2]=1;
						stock[2].setPartLeft(stock[2].getPartLeft()-1);
					}
					else if((stock[2].getPartLeft()==0)&&(rdbtnBrakeOil.getState()==true))
						throw new Exception("Item 3 does not have enough stock");
					if(stock[3].getPartLeft()!=0&&rdbtnBrake.getState())
					{	
						items[3]=1;
						stock[3].setPartLeft(stock[3].getPartLeft()-1);
					}
					else if((stock[3].getPartLeft()==0)&&(rdbtnBrake.getState()==true))
						throw new Exception("Item 4 does not have enough stock");
					if(stock[4].getPartLeft()!=0&&rdbtnRim.getState())
					{	
						items[4]=1;
						stock[4].setPartLeft(stock[4].getPartLeft()-1);
					}
					else if((stock[4].getPartLeft()==0)&&(rdbtnRim.getState()==true))
						throw new Exception("Item 5 does not have enough stock");
					if(stock[5].getPartLeft()!=0&&rdbtnTire.getState())
					{	
						items[5]=1;
						stock[5].setPartLeft(stock[5].getPartLeft()-1);
					}
					else if((stock[5].getPartLeft()==0)&&(rdbtnTire.getState()==true))
						throw new Exception("Item 6 does not have enough stock");
					if(stock[6].getPartLeft()!=0&&rdbtnWindow.getState())
					{	
						items[6]=1;
						stock[6].setPartLeft(stock[6].getPartLeft()-1);
					}
					else if((stock[6].getPartLeft()==0)&&(rdbtnWindow.getState()==true))
						throw new Exception("Item 7 does not have enough stock");
					if(stock[7].getPartLeft()!=0&&rdbtnEngine.getState())
					{	
						items[7]=1;
						stock[7].setPartLeft(stock[7].getPartLeft()-1);
					}
					else if((stock[7].getPartLeft()==0)&&(rdbtnEngine.getState()==true))
						throw new Exception("Item 8 does not have enough stock");
					if(stock[8].getPartLeft()!=0&&rdbtnMusic.getState())
					{	
						items[8]=1;
						stock[8].setPartLeft(stock[8].getPartLeft()-1);
					}
					else if((stock[8].getPartLeft()==0)&&(rdbtnMusic.getState()==true))
						throw new Exception("Item 9 does not have enough stock");
					if(stock[9].getPartLeft()!=0&&rdbtnSide.getState())
					{	
						items[9]=1;
						stock[9].setPartLeft(stock[9].getPartLeft()-1);
					}
					else if((stock[9].getPartLeft()==0)&&(rdbtnSide.getState()==true))
						throw new Exception("Item 10 does not have enough stock");
					
					
					writeData();
					
					textFieldCarLicense.setText("");
					textFieldCarType.setText("");
					textFieldCarManu.setText("");
					textFieldCarModel.setText("");
					textAreaProblem.setText("");
					if(rdbtnBumper.getState())
						rdbtnBumper.setState(false);
					if(rdbtnEngineOil.getState())
						rdbtnEngineOil.setState(false);
					if(rdbtnBrakeOil.getState())
						rdbtnBrakeOil.setState(false);
					if(rdbtnBrake.getState())
						rdbtnBrake.setState(false);
					if(rdbtnRim.getState())
						rdbtnRim.setState(false);
					if(rdbtnTire.getState())
						rdbtnTire.setState(false);
					if(rdbtnWindow.getState())
						rdbtnWindow.setState(false);
					if(rdbtnEngine.getState())
						rdbtnEngine.setState(false);
					if(rdbtnMusic.getState())
						rdbtnMusic.setState(false);
					if(rdbtnSide.getState())
						rdbtnSide.setState(false);
				}
				catch (Exception e1)
				{
					JOptionPane error = new JOptionPane();
					error.showMessageDialog(null, ""+e1.getMessage(), "ALERT", JOptionPane.ERROR_MESSAGE);
					if(stock[0].getPartLeft()!=0&&rdbtnBumper.getState())
					{	
						items[0]=-1;
						stock[0].setPartLeft(stock[0].getPartLeft()+1);
					}
					if(stock[1].getPartLeft()!=0&&rdbtnEngineOil.getState())
					{	
						items[1]=-1;
						stock[1].setPartLeft(stock[1].getPartLeft()+1);
					}
					if(stock[2].getPartLeft()!=0&&rdbtnBrakeOil.getState())
					{	
						items[2]=-1;
						stock[2].setPartLeft(stock[2].getPartLeft()+1);
					}
					if(stock[3].getPartLeft()!=0&&rdbtnBrake.getState())
					{	
						items[3]=-1;
						stock[3].setPartLeft(stock[3].getPartLeft()+1);
					}
					if(stock[4].getPartLeft()!=0&&rdbtnRim.getState())
					{	
						items[4]=-1;
						stock[4].setPartLeft(stock[4].getPartLeft()+1);
					}
					if(stock[5].getPartLeft()!=0&&rdbtnTire.getState())
					{	
						items[5]=-1;
						stock[5].setPartLeft(stock[5].getPartLeft()+1);
					}
					if(stock[6].getPartLeft()!=0&&rdbtnWindow.getState())
					{	
						items[6]=-1;
						stock[6].setPartLeft(stock[6].getPartLeft()+1);
					}
					if(stock[7].getPartLeft()!=0&&rdbtnEngine.getState())
					{	
						items[7]=-1;
						stock[7].setPartLeft(stock[7].getPartLeft()+1);
					}
					if(stock[8].getPartLeft()!=0&&rdbtnMusic.getState())
					{	
						items[8]=-1;
						stock[8].setPartLeft(stock[8].getPartLeft()+1);
					}
					if(stock[9].getPartLeft()!=0&&rdbtnSide.getState())
					{	
						items[9]=-1;
						stock[9].setPartLeft(stock[9].getPartLeft()+1);
					}
				}
			}
		});
		btnViewComplaint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frameComplaints = new JFrame("Complaints"); 
				frameComplaints.setBounds(100, 100, 600, 400);
				frameComplaints.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						frameComplaints.dispose();
					}
				});
				frameComplaints.getContentPane().setLayout(null);
				frameComplaints.setVisible(true);
				try {
					getData();
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} 
			}
		});
	}
	
	private void stock_Initialize(){
		stock[0]=new Stock();
		stock[1]=new Stock();
		stock[2]=new Stock();
		stock[3]=new Stock();
		stock[4]=new Stock();
		stock[5]=new Stock();
		stock[6]=new Stock();
		stock[7]=new Stock();
		stock[8]=new Stock();
		stock[9]=new Stock();
		
		stock[0].setPartName("Bumper");
		stock[0].setPartLeft(20);
		stock[0].setPrice(400);
		stock[1].setPartName("Engine Oil");
		stock[1].setPartLeft(20);
		stock[1].setPrice(400);
		stock[2].setPartName("Brake Oil");
		stock[2].setPartLeft(12);
		stock[2].setPrice(100);
		stock[3].setPartName("Brake");
		stock[3].setPartLeft(12);
		stock[3].setPrice(100);
		stock[4].setPartName("Rim");
		stock[4].setPartLeft(14);
		stock[4].setPrice(100);
		stock[5].setPartName("Tire");
		stock[5].setPartLeft(20);
		stock[5].setPrice(800);
		stock[6].setPartName("Window");
		stock[6].setPartLeft(15);
		stock[6].setPrice(100);
		stock[7].setPartName("Engine");
		stock[7].setPartLeft(15);
		stock[7].setPrice(1000);
		stock[8].setPartName("Music Sytem");
		stock[8].setPartLeft(18);
		stock[8].setPrice(500);
		stock[9].setPartName("Side Mirror");
		stock[9].setPartLeft(10);
		stock[9].setPrice(100);
	}
	
	private Connection getData() throws Exception
	{
		try
		{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/testdb?useSSL=false";
			String username="root";
			String password="root";
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from testing");  
			int y=30;
			while(rs.next())  
			{
				Label carLicense=new Label(rs.getString(1));
				carLicense.setBounds(45, 55+y, 100, 14);
				Label carModel=new Label(rs.getString(2));
				carModel.setBounds(150, 55+y, 100, 14);
				Label carName=new Label(rs.getString(3));
				carName.setBounds(265, 55+y, 100, 14);
				Label carType=new Label(rs.getString(4));
				carType.setBounds(380, 55+y, 100, 14);
				Label carProb=new Label(rs.getString(5));
				carProb.setBounds(520, 55+y, 100, 14);
				frameComplaints.getContentPane().add(carLicense);
				frameComplaints.getContentPane().add(carModel);
				frameComplaints.getContentPane().add(carName);
				frameComplaints.getContentPane().add(carType);
				frameComplaints.getContentPane().add(carProb);
				y=y+20;
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6));  
			}
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	private Connection writeData() throws Exception
	{
		try
		{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/testdb?useSSL=false";
			String username="root";
			String password="root";
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			Statement st = conn.createStatement();
			st.executeUpdate("insert into testing values('"+textFieldCarLicense.getText()+"','"+textFieldCarType.getText()
													+"','"+textFieldCarManu.getText()+"',' "+textFieldCarModel.getText()+"','"+textAreaProblem.getText()+"',0);");  
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}

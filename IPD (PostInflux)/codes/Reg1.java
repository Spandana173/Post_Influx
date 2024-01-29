import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
public class Reg1 implements ActionListener {
	JFrame f=new JFrame("ARASP");
	JLabel L5=new JLabel("<html><u>Bulk Mail Services</u><html>");
	JLabel L1=new JLabel("Email:");
	JLabel L2=new JLabel("Phone: ");
	JLabel L3=new JLabel("Name : ");
	JLabel L4=new JLabel("Branch : ");
	JLabel L10=new JLabel("");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JButton b=new JButton("Register");
	JButton b3=new JButton("<Back");
	private final JButton b5 = new JButton("Smsg");
	private final JButton btnNewButton_1 = new JButton("Dmsg");
	private final JLabel lblNewLabel_2 = new JLabel("<html><u>STUDENTS' REGISTRATION FORM</u><html>");
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg1 window = new Reg1();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Reg1() {
		initialize();
	}
	private void initialize() {
		L10.setHorizontalAlignment(SwingConstants.CENTER);
		L10.setBounds(484,330,690,348);
		L10.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 21));
		L10.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 0, 128), new Color(34, 139, 34)));
		L10.setForeground(new Color(192, 192, 192));
		L5.setBounds(77,195,343,50);
		L5.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 33));
		L5.setForeground(Color.YELLOW);
		L1.setBounds(569,528,200,45);
		L1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		t1.setBounds(781,393,320,30);
		t1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, Color.ORANGE));
		t1.setFont(new Font("Arial", Font.PLAIN, 15));
		L2.setBounds(569,461,200,45);
		L2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		t2.setBounds(781,468,258,30);
		t2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GREEN));
		t2.setFont(new Font("Arial", Font.PLAIN, 15));
		L3.setBounds(569,389,200,39);
	    L3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		t3.setBounds(779,535,343,30);
		t3.setFont(new Font("Arial", Font.PLAIN, 15));
		t3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, Color.ORANGE));
		L4.setBounds(569,596,200,50);
		L4.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 35));
		t4.setBounds(781,606,160,30);
		t4.setFont(new Font("Arial", Font.PLAIN, 15));
		t4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GREEN));
		b.setFont(new Font("Arial", Font.PLAIN, 20));
		b.setBounds(747,692,130,50);
		b.addActionListener(this);
		b3.setFont(new Font("Arial", Font.PLAIN, 20));
		b3.setBounds(77,263,130,50);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 43));
		b3.addActionListener(this);
		f.getContentPane().add(L1);
		f.getContentPane().add(t1);
		f.getContentPane().add(L2);
		f.getContentPane().add(t2);
		f.getContentPane().add(b);
		f.getContentPane().add(b3);
		f.getContentPane().add(L3);
		f.getContentPane().add(t3);
		f.getContentPane().add(L4);
		f.getContentPane().add(L5);
		f.getContentPane().add(t4);
		f.getContentPane().add(L10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(2000,2000);
		f.getContentPane().setLayout(null);
		b5.setBounds(202, 263, 105, 50);
		b5.setFont(new Font("Arial", Font.PLAIN, 20));
		b5.addActionListener(this);
		f.getContentPane().add(b5);
		btnNewButton_1.setBounds(304, 263, 105, 50);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(this);
		f.getContentPane().add(btnNewButton_1);
	    lblNewLabel_2.setBackground(new Color(250, 240, 230));
	    lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(292, 56, 1006, 85);
		f.getContentPane().add(lblNewLabel_2);
		lblNewLabel.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img10.jpg"));
		lblNewLabel.setBounds(202, 29, 80, 116);
		f.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img3.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1563, 835);
		f.getContentPane().add(lblNewLabel_1);
		f.setVisible(true);
		ImageIcon i= new ImageIcon("E:\\IPD (PostInflux)\\images\\img1.jpg");
		f.setIconImage(i.getImage());
	}
	public void actionPerformed(ActionEvent e)
	{  	
		String s1,s2,s3,s4;
		  s1 =t1.getText();
		  s2 =t2.getText();
		  s3 =t3.getText();
		  s4 =t4.getText();
		  if(e.getSource() == b)
		   {    
		      try {
		       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arasp", "root", "1234");//Establishing connection
		       System.out.println("Connected With the database successfully");
		       String q = "insert into register(Name,Phone,Email,Branch)" + "values(?,?,?,?)";
		       PreparedStatement ps = connection.prepareStatement(q);
		       ps.setString(1,(String) s1);
		       ps.setString(2,(String) s2);        
		       ps.setString(3,(String) s3);     
		       ps.setString(4,(String) s4);    
		       ps.execute();
		       connection.close();
		       JOptionPane.showMessageDialog(null,"Data is successfully inserted");
		      } 
		      catch (SQLException e1) 
		      {
		       System.out.println("Error while connecting to the database"+e1);
		      }
		     t1.setText("");
		     t2.setText("");
		     t3.setText("");
		     t4.setText("");
		   }
		  if(e.getSource()==b3){
			f.dispose();
			Entry1 obj1 = new Entry1();
		}		 
		  if(e.getSource()==b5){
				f.dispose();
				Smsg obj1 = new Smsg();
		  }
		  if(e.getSource()==btnNewButton_1){
				f.dispose();
				Dmsg obj1 = new Dmsg();
		  }
		}
 }  





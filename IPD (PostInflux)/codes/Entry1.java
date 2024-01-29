import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
public class Entry1 implements ActionListener{
	JFrame f=new JFrame("ARASP");
	JLabel L1=new JLabel("<html><u>ARASP website</u><html>");
	JLabel L2=new JLabel("-Bulk Mail Services");
	JButton b1=new JButton("Register");
	JButton btnNewButton=new JButton("Smsg");
	JButton btnNewButton_1=new JButton("Dmsg");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry1 window = new Entry1();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Entry1() {
		initialize();
	}
	private void initialize() {
		L1.setBounds(10,188,393,50);
		L1.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 38));
		L1.setForeground(new Color(255, 0, 0));
		L2.setHorizontalAlignment(SwingConstants.CENTER);
		L2.setBounds(942,273,262,33);
		L2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 21));
		L2.setBorder(null);
		L2.setForeground(new Color(192, 192, 192));
		b1.setFont(new Font("Arial", Font.PLAIN, 20));
		b1.setBounds(10,265,130,50);
		b1.addActionListener((ActionListener) this);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(369, 405, 882, 430);
		f.getContentPane().add(lblNewLabel);
		f.getContentPane().add(L1);
		f.getContentPane().add(L2);
		f.getContentPane().add(b1);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(new Color(255, 255, 255));//0x12345  123,50,255
		f.setSize(2000,2000);
		f.getContentPane().setLayout(null);
		JLabel L3 = new JLabel(" ");
		L3.setBounds(312, 341, 917, 494);
		f.getContentPane().add(L3);
        //Image i1 = new ImageIcon(this.getClass().getResource("/img4.png")).getImage();
        //frame.setIconImage(new ImageIcon(Menu.class.getResource("/icon.jpg")).getImage());
		ImageIcon ia= new ImageIcon("E:\\IPD (PostInflux)\\images\\img4.jpg");
		f.setIconImage(ia.getImage());
        lblNewLabel.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img4.png"));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(139, 265, 119, 50);
		btnNewButton.addActionListener((ActionListener)this);
		f.getContentPane().add(btnNewButton);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(257, 265, 130, 50);
		btnNewButton_1.addActionListener((ActionListener)this);
		f.getContentPane().add(btnNewButton_1);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img8.jpg"));
		lblNewLabel_1.setBounds(0, -14, 1540, 186);
		f.getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("***POST INFLUX***");
		lblNewLabel_2.setBackground(new Color(255, 248, 220));
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(529, 201, 574, 82);
		f.getContentPane().add(lblNewLabel_2);
		f.setVisible(true);
		ImageIcon i= new ImageIcon("E:\\IPD (PostInflux)\\images\\img1.jpg");
		f.setIconImage(i.getImage());
	}
	public void actionPerformed(ActionEvent e)
	{  
		if(e.getSource()==b1) {
			f.dispose();
			Reg1 obj2 = new Reg1();
		}
		else if(e.getSource()==btnNewButton) {
			f.dispose();
			Smsg obj3 = new Smsg();
		}
		else if(e.getSource()==btnNewButton_1) {
			f.dispose();
			Dmsg obj4 = new Dmsg();
		}
		
	}
}


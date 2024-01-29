import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class Dmsg implements ActionListener {
    private static ArrayList<String> emailList = new ArrayList<>();
    private static ArrayList<String> messageList = new ArrayList<>();
    JButton btnNewButton_2 = new JButton("Dmsg");
    JButton btnNewButton_1 = new JButton("Register");
    JButton btnNewButton = new JButton("<Back");
    JLabel lblNewLabel_1 = new JLabel("<html><u>Dsmg : </u></html>");
    JLabel lblNewLabel_2 = new JLabel("This Page is to send Different Notice to all the Students at a time.");
    JFrame frame = new JFrame("ARASP");
    JLabel emailLabel = new JLabel("Email:");
    private static JTextField emailField;
    private static JTextArea messageArea;
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dmsg window = new Dmsg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public Dmsg(){
    	initialize();
    	}  
    private void initialize() {
        emailLabel.setBackground(Color.BLUE);
        emailLabel.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 40));
        emailLabel.setSize(127, 50);
        emailLabel.setLocation(748, 261);
        emailField = new JTextField(20);
        emailField.setSize(477, 56);
        emailField.setLocation(915, 255);
        emailField.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.RED));
        emailField.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setSize(183, 50);
        messageLabel.setLocation(735, 373);
        messageLabel.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 40));
        messageArea = new JTextArea(10, 50);
        messageArea.setSize(477, 236);
        messageArea.setLocation(915, 354);
        messageArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 0), Color.RED));
        messageArea.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
        JButton saveButton = new JButton("Save");
        saveButton.setSize(127, 50);
        saveButton.setLocation(1028, 649);
        saveButton.setFont(new Font("Arial", Font.BOLD, 25));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        JButton sendButton = new JButton("Send");
        sendButton.setSize(145, 50);
        sendButton.setLocation(1155, 649);
        sendButton.setFont(new Font("Arial", Font.BOLD, 25));
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmails();
            }
        });
        frame.getContentPane().add(emailLabel);
        frame.getContentPane().add(emailField);
        frame.getContentPane().add(messageLabel);
        frame.getContentPane().add(messageArea);
        frame.getContentPane().add(saveButton);
        frame.getContentPane().add(sendButton);
        frame.setSize(2000,2000);
		frame.getContentPane().setLayout(null);		
		JButton btnNewButton = new JButton("<Back");
		btnNewButton.setBounds(252, 187, 108, 56);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==btnNewButton){
            		frame.dispose();
            		Entry1 obj1 = new Entry1();
            	}    
            }
        });
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(359, 187, 127, 56);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==btnNewButton_1){
            		frame.dispose();
            		Reg1 obj1 = new Reg1();
            	}    
            }
        });
		JButton btnNewButton_2 = new JButton("Smsg");
		btnNewButton_2.setBounds(485, 187, 117, 56);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==btnNewButton_2){
            		frame.dispose();
            		Smsg obj1 = new Smsg();
            	}    
            }
        });
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Elephant", Font.ITALIC, 40));
        lblNewLabel_1.setBackground(Color.ORANGE);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBounds(187, 66, 165, 58);
        frame.getContentPane().add(lblNewLabel_1);        
        lblNewLabel_2.setFont(new Font("Curlz MT", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel_2.setBounds(362, 46, 1081, 96);
        frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel = new JLabel("l");
		lblNewLabel.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img11.1.jpg"));
		lblNewLabel.setBounds(-159, -29, 2146, 896);
		frame.getContentPane().add(lblNewLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		ImageIcon i= new ImageIcon("E:\\IPD (PostInflux)\\images\\img1.jpg");
		frame.setIconImage(i.getImage());
        retrieveData();
    }
    private static void retrieveData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arasp", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Email, Message FROM message");
            while (rs.next()) {
                emailList.add(rs.getString("email"));
                messageList.add(rs.getString("message"));
            	}
            con.close();
        } 
        catch (Exception e) {
        	System.out.println(e);
        }
    }
    private static void saveData() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arasp", "root", "1234");
    		PreparedStatement stmt = con.prepareStatement("INSERT INTO message (Email, Message) VALUES (?,?)");

    		stmt.setString(1, emailField.getText());
    		stmt.setString(2, messageArea.getText());
    		stmt.executeUpdate();
    		con.close();
    		JOptionPane.showMessageDialog(null,"Data is successfully inserted");
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    private static void sendEmails() {
    	final String username = "arasp321@gmail.com";
    	final String password = "tpbzrhnpkzgqodjc";
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", "smtp.gmail.com");
    	props.put("mail.smtp.port", "587");
    	Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(username, password);
    		}
    	});
    try {
        for (int i = 0; i < emailList.size(); i++) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailList.get(i)));
            message.setSubject("Email from MRECW");
            message.setText(messageList.get(i));
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"Message Sent!");
        }
    } catch (Exception e) {
        System.out.println(e);
    	}
    }
	public void actionPerformed(ActionEvent e) {
		
	}
}
    





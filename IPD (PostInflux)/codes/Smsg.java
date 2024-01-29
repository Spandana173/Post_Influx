import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
public class Smsg implements ActionListener {
    public static ArrayList<String> emailList = new ArrayList<>();
    public static JTextArea messageArea;
    JFrame frame = new JFrame("ARASP");
    JButton btnNewButton_2 = new JButton("Dmsg");
    JButton btnNewButton_1 = new JButton("Register");
    JButton btnNewButton = new JButton("<Back");
    JLabel label = new JLabel("Message:");
    JLabel lblNewLabel_1 = new JLabel("<html><u>Smsg : </u></html>");
    JLabel lblNewLabel_2 = new JLabel("This Page is to send Same Notice to all the Students at a time.");
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Smsg window = new Smsg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public Smsg(){
initialize();
}    
private void initialize() {
        label.setBounds(71,310,165,90);
        label.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 40));
        messageArea = new JTextArea(10, 50);
        messageArea.setSize(505, 238);
        messageArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.YELLOW, new Color(255, 0, 0)));
        messageArea.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
        messageArea.setLocation(262, 310);
        JButton sendButton = new JButton("Send");
        sendButton.setBounds(427, 619, 165, 55);
        sendButton.setFont(new Font("Arial", Font.PLAIN, 30));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Elephant", Font.ITALIC, 40));
        lblNewLabel_1.setBackground(Color.ORANGE);
        lblNewLabel_1.setOpaque(true);;
        lblNewLabel_1.setBounds(119, 101, 165, 58);
        frame.getContentPane().add(lblNewLabel_1);
        lblNewLabel_2.setFont(new Font("Curlz MT", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel_2.setBounds(307, 81, 1081, 96);
        frame.getContentPane().add(lblNewLabel_2);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmails();
                messageArea.setText("");
            }
        });	
        frame.getContentPane().add(label);
        frame.getContentPane().add(messageArea);
        frame.getContentPane().add(sendButton);
        frame.setSize(2000,2000);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("<Back");
		btnNewButton.setBounds(57, 211, 115, 55);
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
		btnNewButton_1.setBounds(171, 211, 128, 55);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==btnNewButton_1){
            		frame.dispose();
            		Reg1 obj1 = new Reg1();
            	}    
            }
        });
		JButton btnNewButton_2 = new JButton("Dsmsg");
		btnNewButton_2.setBounds(296, 211, 128, 55);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==btnNewButton_2){
            		frame.dispose();
            		Dmsg obj1 = new Dmsg();
            	}    
            }
        });
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\IPD (PostInflux)\\images\\img12.2.jpg"));
		lblNewLabel.setBounds(0, 0, 1592, 835);
		frame.getContentPane().add(lblNewLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		ImageIcon i= new ImageIcon("E:\\IPD (PostInflux)\\images\\img1.jpg");
		frame.setIconImage(i.getImage());
        retrieveEmails();
   }
    private static void retrieveEmails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arasp", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Email FROM register");
            while (rs.next()) {
                emailList.add(rs.getString("Email"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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
        Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
    try {
        for (String email : emailList) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Email from MRECW");
            message.setText(messageArea.getText());

            Transport.send(message);
            JOptionPane.showMessageDialog(null,"Message Sent!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    	}
    }
    public void actionPerformed(ActionEvent e) {

	}
}

        





        




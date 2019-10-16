package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LogInGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUserNameInput;
	private JPasswordField passwordField;
	public boolean valid = false;
	
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInGUI frame = new LogInGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldUserNameInput = new JTextField();
		textFieldUserNameInput.setBounds(232, 128, 124, 19);
		panel.add(textFieldUserNameInput);
		textFieldUserNameInput.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 178, 124, 19);
		panel.add(passwordField);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Dialog", Font.BOLD, 30));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(113, 28, 192, 52);
		panel.add(lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(113, 130, 101, 15);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(113, 180, 101, 15);
		panel.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MySQLConnection con = new MySQLConnection();
				String s[] = {textFieldUserNameInput.getText(), passwordField.getText()};
				
				boolean valid = con.tryLogIn(s);
				
				if (valid) {
					MainGUI mn;
					try {
						int id = con.getID(s);
						User user = new User(s[0], s[1], Integer.toString(id) , con.getBalance(id));
						mn = new MainGUI(con.getID(s), con.getBalance(id), user);
						mn.go();
					} catch (SQLException e) {
						e.printStackTrace();
					}	
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid User Name or password");
				}
			}
		});
		btnLogIn.setBounds(154, 220, 114, 25);
		panel.add(btnLogIn);
		
	}
}

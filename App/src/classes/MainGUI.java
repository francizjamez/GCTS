package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	public User user;
	//public int id;
	
	private MySQLConnection con = new MySQLConnection();
	//private float balance;
	Inventory inv = new Inventory();
	
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI(User user) throws SQLException {
		
		this.user = user;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 745, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameCosmeticsTrading = new JLabel("Game Cosmetics Trading System");
		lblGameCosmeticsTrading.setBounds(229, 12, 248, 53);
		contentPane.add(lblGameCosmeticsTrading);
		
		JLabel lblId = new JLabel("ID : " + user.getID());
		lblId.setBounds(39, 12, 66, 15);
		contentPane.add(lblId);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 65, 738, 440);
		contentPane.add(panel);
		panel.setBackground(new Color(105, 105, 105));
		panel.setLayout(null);
		
		JPanel panelMarket = new JPanel();
		panelMarket.setBounds(0, 58, 728, 382);
		panel.add(panelMarket);
		panelMarket.setBackground(new Color(25, 25, 112));
		panelMarket.setLayout(null);
		
		JPanel parentPanel = new JPanel();
		parentPanel.setBounds(0, 0, 736, 382);
		panelMarket.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelItems1 = new JPanel();
		parentPanel.add(panelItems1, "name_42394627251892");
		panelItems1.setBackground(new Color(25, 25, 112));
		panelItems1.setLayout(null);
		
		JLabel lblMagusCypher = new JLabel("Magus Cypher");
		lblMagusCypher.setBounds(20, 24, 253, 100);
		panelItems1.add(lblMagusCypher);
		lblMagusCypher.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMagusCypher.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Magus Cypher.jpg")));
		lblMagusCypher.setForeground(new Color(255, 255, 255));
		
		JLabel lblQuantityMG = new JLabel("Quantity :  ");
		lblQuantityMG.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantityMG.setForeground(Color.WHITE);
		lblQuantityMG.setBounds(323, 12, 114, 37);
		panelItems1.add(lblQuantityMG);
		
		JLabel lblRarityMG = new JLabel("Rarity: ");
		lblRarityMG.setForeground(Color.WHITE);
		lblRarityMG.setBackground(Color.BLACK);
		lblRarityMG.setBounds(446, 12, 129, 15);
		panelItems1.add(lblRarityMG);
		
		JLabel lblQualityMG = new JLabel("Quality");
		lblQualityMG.setForeground(Color.WHITE);
		lblQualityMG.setBackground(Color.BLACK);
		lblQualityMG.setBounds(446, 69, 45, 15);
		panelItems1.add(lblQualityMG);
		
		JLabel lblFoA = new JLabel("Feast of Abcession");
		lblFoA.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Feast of Abcession.jpg")));
		lblFoA.setForeground(Color.WHITE);
		lblFoA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFoA.setBounds(20, 143, 287, 101);
		panelItems1.add(lblFoA);
		
		JLabel lblQuantityFoA = new JLabel("Quantity :  ");
		lblQuantityFoA.setForeground(Color.WHITE);
		lblQuantityFoA.setBounds(323, 154, 103, 15);
		panelItems1.add(lblQuantityFoA);
		
		JLabel lblRarityFoA = new JLabel("Rarity: ");
		lblRarityFoA.setForeground(Color.WHITE);
		lblRarityFoA.setBackground(Color.BLACK);
		lblRarityFoA.setBounds(446, 154, 129, 15);
		panelItems1.add(lblRarityFoA);
		
		JLabel lblQualityFoA = new JLabel("Quality");
		lblQualityFoA.setForeground(Color.WHITE);
		lblQualityFoA.setBackground(Color.BLACK);
		lblQualityFoA.setBounds(446, 203, 45, 15);
		panelItems1.add(lblQualityFoA);
		
		JLabel lblGM = new JLabel("Glacial Magnolia");
		lblGM.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Glacial Magnolia.png")));
		lblGM.setForeground(Color.WHITE);
		lblGM.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGM.setBounds(20, 271, 281, 100);
		panelItems1.add(lblGM);
		
		JLabel lblQuantityGM = new JLabel("Quantity :  ");
		lblQuantityGM.setForeground(Color.WHITE);
		lblQuantityGM.setBounds(323, 283, 103, 15);
		panelItems1.add(lblQuantityGM);
		
		JLabel lblRarityGM = new JLabel("Rarity: ");
		lblRarityGM.setForeground(Color.WHITE);
		lblRarityGM.setBackground(Color.BLACK);
		lblRarityGM.setBounds(452, 283, 129, 15);
		panelItems1.add(lblRarityGM);
		
		JLabel lblQualityGM = new JLabel("Quality");
		lblQualityGM.setForeground(Color.WHITE);
		lblQualityGM.setBackground(Color.BLACK);
		lblQualityGM.setBounds(452, 340, 45, 15);
		panelItems1.add(lblQualityGM);
		
		JButton btnTradeFoA = new JButton("Buy");
		btnTradeFoA.setBounds(593, 169, 114, 25);
		panelItems1.add(btnTradeFoA);
		
		JButton btnTradeMG = new JButton("Buy");
		btnTradeMG.setBounds(593, 38, 114, 25);
		panelItems1.add(btnTradeMG);
		
		JButton btnTradeGM = new JButton("Buy");
		btnTradeGM.setBounds(593, 297, 114, 25);
		panelItems1.add(btnTradeGM);
		
		JLabel lblPriceMG = new JLabel("Price : ");
		lblPriceMG.setHorizontalAlignment(SwingConstants.LEFT);
		lblPriceMG.setForeground(Color.WHITE);
		lblPriceMG.setBounds(323, 63, 114, 37);
		panelItems1.add(lblPriceMG);
		
		JLabel lblBalance = new JLabel("Balance: " + user.getBalance());
		lblBalance.setForeground(new Color(255, 255, 255));
		lblBalance.setFont(new Font("Dialog", Font.BOLD, 12));
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setBounds(287, 12, 130, 15);
		panel.add(lblBalance);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.setBounds(182, 30, 114, 25);
		panel.add(btnMarket);
		
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(429, 30, 114, 25);
		panel.add(btnInventory);
		
		
		JComboBox comboBoxMG = new JComboBox();
		comboBoxMG.setBounds(501, 65, 74, 22);
		panelItems1.add(comboBoxMG);
		
		JComboBox comboBoxFoA = new JComboBox();
		comboBoxFoA.setBounds(501, 199, 74, 22);
		panelItems1.add(comboBoxFoA);
		
		JLabel lblPriceFoA = new JLabel("Price : ");
		lblPriceFoA.setHorizontalAlignment(SwingConstants.LEFT);
		lblPriceFoA.setForeground(Color.WHITE);
		lblPriceFoA.setBounds(323, 192, 114, 37);
		panelItems1.add(lblPriceFoA);
		
		JLabel lblPriceGM = new JLabel("Price : ");
		lblPriceGM.setHorizontalAlignment(SwingConstants.LEFT);
		lblPriceGM.setForeground(Color.WHITE);
		lblPriceGM.setBounds(323, 334, 114, 37);
		panelItems1.add(lblPriceGM);
		
		JComboBox comboBoxGM = new JComboBox();
		comboBoxGM.setBounds(501, 336, 74, 22);
		panelItems1.add(comboBoxGM);
		
		JButton tradeButtons[] = {btnTradeMG, btnTradeFoA, btnTradeGM};
		
		Item MG = new Item("Magus Cypher" , lblRarityMG,lblQualityMG, lblQuantityMG, btnTradeMG, lblPriceMG);
		ArrayList<String> MGQualities = con.getAllQualities(MG.getName());
		addQualities(MGQualities, comboBoxMG);
		MG.setQuality(comboBoxMG.getSelectedItem().toString());
		con.setItemInfos(MG);
		inv.addItem(MG);
		
		Item FoA = new Item("Feast of Abcession" , lblRarityFoA,lblQualityFoA, lblQuantityFoA, btnTradeFoA , lblPriceFoA);
		ArrayList<String> FoAQualities = con.getAllQualities(FoA.getName());
		addQualities(FoAQualities, comboBoxFoA);
		FoA.setQuality(comboBoxFoA.getSelectedItem().toString());
		con.setItemInfos(FoA);
		inv.addItem(FoA);
		
		Item GM = new Item("Glacial Magnolia" , lblRarityGM,lblQualityGM, lblQuantityGM, btnTradeGM , lblPriceGM);
		ArrayList<String> GMQualities = con.getAllQualities(GM.getName());
		addQualities(GMQualities, comboBoxGM);
		GM.setQuality(comboBoxGM.getSelectedItem().toString());
		con.setItemInfos(GM);
		inv.addItem(GM);
		
		setMarketInventory();
		
		
		
		
		comboBoxMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					MG.setQuality(comboBoxMG.getSelectedItem().toString());
					con.setItemInfos(MG);
					if(MG.btnTrade.getText().equals("Buy")) {
							setMarketInventory();
					}
					else {
						setUserInventory();
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		comboBoxFoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FoA.setQuality(comboBoxFoA.getSelectedItem().toString());
					con.setItemInfos(FoA);
					if(FoA.btnTrade.getText().equals("Buy")) {
							setMarketInventory();
					}
					else {
						setUserInventory();
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		comboBoxGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GM.setQuality(comboBoxGM.getSelectedItem().toString());
					con.setItemInfos(GM);
					if(GM.btnTrade.getText().equals("Buy")) {
							setMarketInventory();
					}
					else {
						setUserInventory();
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i =0; i < tradeButtons.length; i++) {
					tradeButtons[i].setText("Sell");
					panelItems1.setBackground(Color.BLACK);
					try {
						setUserInventory();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i =0; i < tradeButtons.length; i++) {
					tradeButtons[i].setText("Buy");
					Color c = new Color(25,25,122);
					panelItems1.setBackground(c);
					try {
						setMarketInventory();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});	
		
		btnTradeMG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnTradeMG.getText().equals("Buy")) {
					String qtt = JOptionPane.showInputDialog("Enter How many to buy");
					if(user.getBalance() < MG.getPrice() * convert(qtt)) {
						JOptionPane.showMessageDialog(null,"Insufficient funds");  
					}
					else if(MG.getQuantity() < 1) {
						JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
					}
					else {
						try {
							
							if(MG.getQuantity() < convert(qtt)) {
								JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
							}
							else {
								con.buyItem(MG, convert(qtt), user);
								updateBalance(lblBalance);
								setMarketInventory();
								JOptionPane.showMessageDialog(null, "Traded successfully");
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					}
				}
				else {
					try {
						String qtt = JOptionPane.showInputDialog("Enter How many to sell");
						if(MG.getQuantity() < convert(qtt)) {
							JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
						}
						else {
							con.sellItem(MG, convert(qtt), user);
							updateBalance(lblBalance);
							setUserInventory();
							JOptionPane.showMessageDialog(null, "Traded successfully");
						}
					}
					catch(Exception e){
						
					}
				}
			}
		});
		
		btnTradeFoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (btnTradeFoA.getText().equals("Buy")) {
						String qtt = JOptionPane.showInputDialog("Enter How many to buy");
						if(user.getBalance() < FoA.getPrice() * convert(qtt)) {
							JOptionPane.showMessageDialog(null,"Insufficient funds");  
						}
						else if(FoA.getQuantity() < 1) {
							JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
						}
						else {
							
							
							if(FoA.getQuantity() < convert(qtt)) {
								JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
							}
								
							else {
								con.buyItem(FoA, convert(qtt), user);
								updateBalance(lblBalance);
								setMarketInventory();
								JOptionPane.showMessageDialog(null, "Traded successfully");
							}
						} 								
					}
					else {
						
						String qtt = JOptionPane.showInputDialog("Enter How many to sell");
						if(FoA.getQuantity() < convert(qtt)) {
							JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
						}
						else {
							con.sellItem(FoA, convert(qtt), user);
							updateBalance(lblBalance);
							setUserInventory();
							JOptionPane.showMessageDialog(null, "Traded successfully");
						}
					}
				}catch(Exception exFoA) {
					
				}
			}
		});
		
		btnTradeGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (btnTradeGM.getText().equals("Buy")) {
						String qtt = JOptionPane.showInputDialog("Enter How many to buy");
						if(user.getBalance() < GM.getPrice() * convert(qtt)) {
							JOptionPane.showMessageDialog(null,"Insufficient funds");  
						}
						else if(GM.getQuantity() < 1) {
							JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
						}
						else {
							
							
							if(GM.getQuantity() < convert(qtt) ) {
								JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
							}
								
							else {
								con.buyItem(GM, convert(qtt), user);
								updateBalance(lblBalance);
								setMarketInventory();
								JOptionPane.showMessageDialog(null, "Traded successfully");
							}
						} 								
					}
					else {
						
						String qtt = JOptionPane.showInputDialog("Enter How many to sell");
						if(GM.getQuantity() < convert(qtt)) {
							JOptionPane.showMessageDialog(null,"Insufficient stocks"); 
						}
						else {
							con.sellItem(GM, convert(qtt), user);
							updateBalance(lblBalance);
							setUserInventory();
							JOptionPane.showMessageDialog(null, "Traded successfully");
						}
					}
				}catch(Exception exFoA) {
					
				}
				
			}
		});
	}
	
	private void setUserInventory() throws SQLException {
		con.setInventory(inv.getInventory(), user);
		inv.updateInventory();
	}
	
	private void setMarketInventory() throws SQLException {
		con.setMarket(inv.getInventory());
		inv.updateInventory();
	}
	
	private void updateBalance(JLabel lblBalance) throws SQLException {
		user.setBalance(con.getBalance(user));
		lblBalance.setText("Balance : " + user.getBalance()); 
	}
	
	private int convert(String s) {
		return Integer.parseInt(s);
	}
	
	private void addQualities(ArrayList<String> qualities, JComboBox cb) {
		Iterator i = qualities.iterator();
		while (i.hasNext()) {
			String it = (String) i.next();
			cb.addItem(it);
	    }
	}
}

package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Item{
	
	private JLabel rarity;
	private JLabel qualitylbl;
	private JLabel quantitylbl;
	private JLabel pricelbl;
	public JButton btnTrade;
	
	private String name;
	private String ID;
	private float price;
	private String quality;
	
	private int quantity;
	
	public Item (String name, JLabel rarity, JLabel qualitylbl, JLabel Quantity, JButton Trade, JLabel Price) {
		this.rarity = rarity;
		this.qualitylbl = qualitylbl;
		this.name = name;
		this.quantitylbl = Quantity;
		this.btnTrade = Trade;
		this.pricelbl = Price;
	}
	
	public void setQuantitylbl(int s) {
		this.quantitylbl.setText("Quantity: " + s);
	}
	
	public void setQuality(String s) {
		this.quality = s;
	}
	
	public void setRarity(String s) {
		rarity.setText("Rarity: " + s);
	}
	public void setPricelbl(float price) {
		this.pricelbl.setText("Price: " + price);
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public String getQuality() {
		return this.quality;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public void setID(String s) {
		this.ID = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setQuantity(int s) {
		this.quantity = s;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	
}
package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class MySQLConnection {
	
	public static Connection getConnection() {
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/gcts?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "admin";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successful!");
			return con;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public static boolean tryLogIn(String s[]) {
		
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			
			 ResultSet rs = st.executeQuery("SELECT * FROM GCTS.User;");
			 
			 while (rs.next())
		      {
		        String user_name = rs.getString("Username");
		        String password = rs.getString("Password");
		        
		        if(user_name.equals(s[0]) && password.equals(s[1])) {
		        	return true;
		        }
		      }
			 st.close();
		}
		catch (Exception e){
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		finally {
			System.out.println("read Completed");
		}
		
		return false;
	}
	
	
	public int getID(String s[]) throws SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.User;");
		
		while (rs.next())
	      {
	        String user_name = rs.getString("UserName");
	        String password = rs.getString("Password");
	        int id = rs.getInt("UserID");
	        
	        if(user_name.equals(s[0]) && password.equals(s[1])) {
	        	return id;
	        }
	      }
		st.close();
		return -1;
	}
	
	public Float getBalance(int id) throws SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.User;");
		
		while (rs.next())
	      {
	        int user_id = rs.getInt("UserID");
	        
	        if(user_id == id) {
	        	return rs.getFloat("Balance");
	        }
	      }
		st.close();
		
		return (float) -1;
	}
	
	public void setItemInfos(Item itm) throws SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Item INNER JOIN GCTS.item_rarity on Item.ItemName = item_rarity.ItemName;");
		
		while (rs.next()){
			
			if(itm.getName().equals(rs.getString("ItemName")) && itm.getQuality().equals(rs.getString("Quality"))) {
				String rarity = rs.getString("Rarity");
				itm.setRarity(rarity);
				itm.setID(rs.getString("ItemID"));
			}
	    }
		st.close();
	}
	
	public void setInventory(ArrayList<Item> itm, int id) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Inventory INNER JOIN GCTS.Item on Inventory.ItemID = Item.ItemID;");
		
		while (rs.next()){
			
			if(id == rs.getInt("UserID")) {
				
				Iterator i = itm.iterator();
				
				while (i.hasNext()) {
					
					Item it = (Item) i.next();
					
					if(it.getID().equals(rs.getString("ItemID"))) {
						it.setQuantity (rs.getInt("Quantity"));
						float price =  rs.getFloat("Price");
						it.setPrice(price);
					}
			    }
			}
	    }
		st.close();
	}
	
	public void setMarket(ArrayList<Item> itm) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Market INNER JOIN GCTS.Item on Market.ItemID = Item.ItemID");
		
		while (rs.next()){
			
			Iterator i = itm.iterator();
				
			while (i.hasNext()) {
					
				Item it = (Item) i.next();
						
				if(it.getID().equals(rs.getString("ItemID"))) {
					it.setQuantity(rs.getInt("Quantity"));
					float price =  rs.getFloat("Price");
					it.setPrice(price);
				}
			}
	    }
		
		st.close();
	}
	
	public void buyItem(Item itm, int quantity, int id) throws SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Market INNER JOIN GCTS.Item on market.ItemID = item.ItemID");
		
		while (rs.next()){
			
			if(itm.getID().equals(rs.getString("ItemID"))) {
				
				System.out.println(itm.getID());
				int qtt = rs.getInt("Quantity");
				qtt -= quantity;
				PreparedStatement buy = con.prepareStatement("UPDATE gcts.market SET quantity = " +qtt + " WHERE (`itemID` = " + itm.getID() + ")");
				buy.executeUpdate();
				updateBalance(id, itm.getPrice() * -1 * quantity);
				addUserItem(id, itm, quantity);
			}
	    }
		st.close();
	}
	
	public float updateBalance(int id, float cost) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.User");
		
		while(rs.next()) {
			
			if (id == rs.getInt("UserID")) {
				float balance = rs.getFloat("Balance");
				balance += cost;
				PreparedStatement buy = con.prepareStatement("UPDATE `GCTS`.`User` SET `Balance` = "+ balance + " WHERE (`UserID` = "+ id + ");");
				buy.executeUpdate();
				return balance;
			}
		}
		
		return -1;
	}
	
	public void addUserItem(int id, Item itm, int qtt) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Inventory");
		
		while(rs.next()) {
			
			if(id == rs.getInt("UserID") && itm.getID().equals(rs.getString("ItemID"))) {
				int quantity = rs.getInt("Quantity");
				quantity += qtt;
				PreparedStatement add = con.prepareStatement("UPDATE `GCTS`.`Inventory` SET `quantity` = "+ quantity + " WHERE (`UserID` = "+ id + ") AND (`ItemID` = + " + itm.getID() + ");");
				add.executeUpdate();
			}
			
		}
	}
	
	public void addMarketItem(Item itm, int qtt) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Market");
		System.out.println(itm.getID());
		while(rs.next()) {
			
			if(itm.getID().equals(rs.getString("ItemID"))) {
				int quantity = rs.getInt("Quantity");
				quantity += qtt;
				PreparedStatement add = con.prepareStatement("UPDATE `GCTS`.`Market` SET `quantity` = "+ quantity + " WHERE (`ItemID` = + " + itm.getID() + ");");
				add.executeUpdate();
			}
			
		}
	}
	
	public void sellItem(Item itm, int quantity, int id) throws SQLException {

		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Inventory INNER JOIN GCTS.Item on Inventory.ItemID = item.ItemID");
		
		while (rs.next()){
			
			if(itm.getID().equals(rs.getString("ItemID"))) {
				int qtt = rs.getInt("Quantity");
				qtt -= quantity;
				PreparedStatement buy = con.prepareStatement("UPDATE gcts.Inventory SET quantity = " +qtt + " WHERE (`itemID` = " + itm.getID() + ") and UserID = " +id + "");
				buy.executeUpdate();
				updateBalance(id, itm.getPrice() * quantity);
				addMarketItem(itm, quantity);
			}
	    }
		st.close();
	}
	
	
	public ArrayList<String> getAllQualities(String name) throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		
		ArrayList<String> qualities = new ArrayList<String>();
		
		ResultSet rs = st.executeQuery("SELECT * FROM GCTS.Item");
		while (rs.next()){
			if(name.equals(rs.getString("ItemName"))) {
				qualities.add(rs.getString("Quality"));
			}
	    }
		st.close();
		
		return qualities;
	}
	
	
	
}
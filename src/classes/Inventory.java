package classes;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;


public class Inventory {

	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public void addItem(Item itm) {
		inventory.add(itm);
	}
	
	public void updateInventory() {
		
		Iterator i = inventory.iterator();
		while (i.hasNext()) {
			Item it = (Item) i.next();
			it.setQuantitylbl(it.getQuantity());
			it.setPricelbl(it.getPrice());
	    }
	}
	
	public ArrayList<Item> getInventory(){
		return this.inventory;
	}
}
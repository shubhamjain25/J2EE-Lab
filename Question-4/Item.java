package labPractice4;

import java.util.*;
import javax.swing.*;

public class Item {
	String name, id;
	float price;
	
	static private ArrayList<Item> items = new ArrayList<Item>();
	
	Item retrieveItem(String id) {
		for(Item i:items){
			if(i.id.equals(id)) {return i;}
		}
		
		Item i = new Item();
		i.id = id;
		i.name = JOptionPane.showInputDialog("Enter Product Name").trim();
		i.price = Float.parseFloat(JOptionPane.showInputDialog("Enter Product Price"));
		items.add(i);
		return i;
	}
}

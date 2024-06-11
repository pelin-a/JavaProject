package methods;
import items.Item;
import containers.Container;
import orders.Order;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public abstract class Calculations {
	private List<Item> itemList;
	private List<Order> orderList;
	
	//constructor initializes new empty lists for the order and the containers
	public Calculations() {
		this.itemList= new ArrayList<Item>();
		this.orderList= new ArrayList<Order>(); 
	}	
	
	
	//totalVolume -> calculates the total volume of the items ordered.
	public double totalVolume() {
		double sum=0.0;
		for(int i=0;i<itemList.size();i++) {
			Item item = itemList.get(i);
			double vol=item.getLength()*item.getWidth()*item.getheight();
			sum=sum+vol;	
		}
		return sum;
		
	}
	
	
	// totalWeight-> calculates the total weight of the items
	public double totalWeight() {
		double sum=0;
		for(int i=0;i<itemList.size();i++) {
			Item item=itemList.get(i);
			double weight=item.getWeight();
			sum+=weight;	
		}
		return sum;
		
	}
	
	
	//bestShipping 
	public abstract void bestShipping();
	
	//shippingPrice
	public double shippingPrice() {
		double cost=0;
		for(int i=0;i<orderList.size();i++) {
			Order order=orderList.get(i);
			cost+=order.getCost();
		}
		return cost;	
	}
	
	//addItems-> takes an Item object as a parameter to specify the product and have its information, and the number that is being ordered.
	public void addItem(Item item, int num) {
		for(int i=0;i<num;i++) {
			itemList.add(item); //adds the item to our item list depending on how many times it will be added.
		}
		
	}
	
	//addOrder
	public void addOrder() {
		
		
		
	}
	
	
	//printItem
	
	//printOrder

}

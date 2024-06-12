
//Pelinsu
package methods;
import items.Item;
import orders.Order;
import java.util.ArrayList;
import java.util.List;

public abstract class Calculations {
	private List<Item> itemList;
	private List<Order> orderList;
	private int bestNumSmallBoxes;
	private int bestNumBigBoxes;
	private double maxSmallWeight=500;
	private int smallCost=1000;
	private int bigCost=1800;
	private double totalCost;
	
	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	public int getBestNumSmallBoxes() {
		return bestNumSmallBoxes;
	}


	public void setBestNumSmallBoxes(int bestNumSmallBoxes) {
		this.bestNumSmallBoxes = bestNumSmallBoxes;
	}


	public int getBestNumBigBoxes() {
		return bestNumBigBoxes;
	}


	public void setBestNumBigBoxes(int bestNumBigBoxes) {
		this.bestNumBigBoxes = bestNumBigBoxes;
	}


	public double getMaxSmallWeight() {
		return maxSmallWeight;
	}


	public void setMaxSmallWeight(double maxSmallWeight) {
		this.maxSmallWeight = maxSmallWeight;
	}


	public int getSmallCost() {
		return smallCost;
	}


	public void setSmallCost(int smallCost) {
		this.smallCost = smallCost;
	}


	public int getBigCost() {
		return bigCost;
	}


	public void setBigCost(int bigCost) {
		this.bigCost = bigCost;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	//constructor initializes new empty lists for the order and the containers
	public Calculations() {
		this.itemList= new ArrayList<Item>();
		this.orderList= new ArrayList<Order>();
		
	}	
	
	
	//totalVolume -> calculates the total volume of the items ordered.
	public double totalVolume() {
		double sum=0;
		for(int i=0;i<orderList.size();i++) {
			Order order = orderList.get(i);
			for(int x=0;x<order.getNum();x++) {
				double vol= order.getItem().getItemVolume();
				sum=sum+vol;
			}	
		}
//		System.out.println(sum);
		return sum;
		
	}
	
	
	// totalWeight-> calculates the total weight of the items
	public double totalWeight() {
		double sum=0;
		for(int i=0;i<orderList.size();i++) {
			Order order=orderList.get(i);
			for(int x=0;x<order.getNum();x++) {
				double weight= order.getItem().getWeight();
				sum=sum+weight;
			}	
		}
//		System.out.println(sum);
		return sum;	
	}
	
	
	//bestShipping -> abstract method later method body is given in the BestShipment class
	public abstract void bestShipping();
	
	
	//addItems-> takes an Item object or objects parameter and adds to our itemList. I used one mandatory and also optional parameters here.
	public void addItem(Item item, Item ...items) {
		itemList.add(item); //adds the item to our item list 
		if(items.length>0) {
			for(Item each : items) {
				itemList.add(each);
			}
		}	
	}
	
	//addOrder -> adds a new order to our orderList
	public void addOrder(Item item, int num) {
		Order order=new Order(item,num);
		orderList.add(order);		
	}
	
	//printItem-> prints info of one item
	public void printItem(Item item) {
		item.printItemInfo();	
	}
	// prints all of the items' informations
	public void printAllItems() {
		for(Item item : itemList) {
			item.printItemInfo();
		}
	}
	
	//printOrder-> prints all of the orders in our orderList
	public void printOrder() {
		for(Order order:this.orderList) {
			order.printOrderInfo();	
		}
		
	}

}

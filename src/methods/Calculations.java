package methods;
import items.Item;
import orders.Order;
import java.util.ArrayList;
import java.util.List;

import containers.Container;

public class Calculations {
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
	
	
	//bestShipping 
	public void bestShipping() {
	    double totalVolume = totalVolume(); // Assuming this method exists and calculates the total volume of items
	    double totalWeight = totalWeight(); // Assuming this method exists and calculates the total weight of items

	    Container smallContainer = new Container(6.06, 2.43, 2.59, true); 
	    Container bigContainer = new Container(12.01, 2.43, 2.59, false);
	    
	    double smallVolume = smallContainer.getVolume();
	    double bigVolume = bigContainer.getVolume();

	    // Constants for the container costs and maximum weights
	    double maxSmallWeight = 500; // Max weight for small container in kg
	    double bigCost = 1800; // Cost for big container
	    double smallCostUnder500 = 1000; // Cost for small container if weight <= 500kg
	    double smallCostOver500 = 1200; // Cost for small container if weight > 500kg

	    double minCost = Double.MAX_VALUE;
	    int bestSmallContainers = 0;
	    int bestBigContainers = 0;

	    // Try only small containers
	    int smallContainersNeeded = (int) Math.ceil(totalVolume / smallVolume);
	    double smallContainersCost = smallContainersNeeded * (totalWeight <= 500 ? smallCostUnder500 : smallCostOver500);
	    minCost = smallContainersCost;
	    bestSmallContainers = smallContainersNeeded;

	    // Try only big containers
	    int bigContainersNeeded = (int) Math.ceil(totalVolume / bigVolume);
	    double bigContainersCost = bigContainersNeeded * bigCost;
	    if (bigContainersCost < minCost) {
	        minCost = bigContainersCost;
	        bestBigContainers = bigContainersNeeded;
	        bestSmallContainers = 0;
	    }

	    // Try a combination of big and small containers
	    for (int bigContainers = 0; bigContainers <= Math.ceil(totalVolume / bigVolume); bigContainers++) {
	        double remainingVolume = totalVolume - bigContainers * bigVolume;
	        int smallContainers = Math.max(0, (int) Math.ceil(remainingVolume / smallVolume));

	        // Adjust the total number of containers needed
	        int totalContainers = bigContainers + smallContainers;
	        double totalCost = bigContainers * bigCost + smallContainers * (totalWeight <= 500 ? smallCostUnder500 : smallCostOver500);

	        if (totalCost < minCost) {
	            minCost = totalCost;
	            bestSmallContainers = smallContainers;
	            bestBigContainers = bigContainers;
	        }
	    }

	    // Set the best configuration and print the results
	    setBestNumSmallBoxes(bestSmallContainers);
	    setBestNumBigBoxes(bestBigContainers);
	    setTotalCost(minCost);
	    
	    System.out.println("Optimal Shipping Method:");
	    System.out.println("Big Containers: " + bestBigContainers);
	    System.out.println("Small Containers: " + bestSmallContainers);
	    System.out.println("Total Cost: " + minCost + " Euros");
            
		
//		for(int smallContainers=0;smallContainers<=Math.ceil(totalVolume/smallVolume);smallContainers++){
//			double volumeRemaining= totalVolume - (smallContainers*smallVolume); 
//			double weightRemaining =totalWeight - (smallContainers * maxSmallWeight);
//			int bigContainers = (int) Math.ceil(volumeRemaining / bigVolume);
//			
//			
//			weightRemaining -= bigContainers * (bigVolume / smallVolume) * maxSmallWeight;
//			
////			if (volumeRemaining < 0 || weightRemaining < 0) {
////                continue; // Skip invalid combinations
////            }
//			System.out.println(smallContainers);
//			double cost = bigContainers * bigCost + smallContainers * smallCost;
//			if (smallContainers > 0 && totalWeight - bigContainers * bigVolume / smallVolume * maxSmallWeight > smallContainers * maxSmallWeight) {
//                cost += 200 * smallContainers;
//            }
	 
//            setBestNumSmallBoxes(smallContainers);
//            System.out.println(smallContainers);
//            setBestNumBigBoxes(bigContainers);
//            System.out.println(bigContainers);
//            setTotalCost(cost);
//    			
//		}	
	}
	
	
	//addItems-> takes an Item object as a parameter to specify the product and have its information, and the number that is being ordered.
	public void addItem(Item item) {
		itemList.add(item); //adds the item to our item list depending on how many times it will be added.
		
	}
	
	//addOrder
	public void addOrder(Item item, int num) {
		Order order=new Order(item,num);
		orderList.add(order);
//		for(int i=0;i<orderList.size();i++) {
//			System.out.print(orderList.get(i).getItem().getName());
//			System.out.println(orderList.get(i).getNum());
//		}
		
	}
	
	
	//printItem
	
	//printOrder

}

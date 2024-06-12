
//Pelinsu
package methods;
import java.util.Scanner;
import items.Item;
public class Test{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item laptop = new Item("Laptop", 0.60, 0.50, 0.50, 6.5);
        Item mouse = new Item("Mouse", 0.30, 0.30, 0.20, 0.2);
        Item desktop = new Item("Desktop", 1.00, 1.50, 0.50, 20);
        Item lcdScreen = new Item("LCD Screen", 1.20, 1.40, 0.80, 2.6);
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the number of Laptops:");
			int numLaptops = scanner.nextInt();
			System.out.println("Enter the number of Mice:");
			int numMice = scanner.nextInt();
			System.out.println("Enter the number of Desktops:");
			int numDesktops = scanner.nextInt();
			System.out.println("Enter the number of LCD Screens:");
			int numLcdScreens = scanner.nextInt();
			
			BestShipment calc = new BestShipment();
			  calc.addItem(laptop,mouse,desktop,lcdScreen);
			  calc.addOrder(laptop,numLaptops);
			  calc.addOrder(mouse,numMice); 
			  calc.addOrder(desktop,numDesktops); 
			  calc.addOrder(lcdScreen,numLcdScreens); 
			  calc.bestShipping();
			  
			  System.out.println("Best Shipping Method:");
			    System.out.println("Big Containers: " + calc.getBestNumBigBoxes());
			    System.out.println("Small Containers: " + calc.getBestNumSmallBoxes());
			    System.out.println("Total Cost: " + calc.getTotalCost() + " Euros");
		}
	

	}

}

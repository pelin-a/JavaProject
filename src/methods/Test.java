package methods;
import java.util.Scanner;
import methods.Calculations;
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
			
			Calculations calc = new Calculations();
			
      calc.addOrder(laptop,numLaptops);
      
      calc.addOrder(mouse,numMice);
      calc.addOrder(desktop,numDesktops);
      calc.addOrder(lcdScreen,numLcdScreens);
      calc.bestShipping();
			System.out.println(calc.getBestNumBigBoxes());
			System.out.println(calc.getBestNumSmallBoxes());
		}
	

	}

}

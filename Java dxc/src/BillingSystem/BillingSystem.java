package BillingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BillingSystem {
	
	private String name;
	private int serialNo;
	private int quantity;
	private ArrayList<Integer> qty = new ArrayList<Integer>();
	private ArrayList<String> itemName = new ArrayList<String>();
	private ArrayList<Double> amount = new ArrayList<Double>();
	private Scanner sc = new Scanner(System.in);
	private double cost;
	private double subTotal;
	private double tax;
	private double tip;
	private double grandTotal;
	
	
	public static void main(String[] args) {
		
		BillingSystem bill = new BillingSystem();
		bill.getUserDetails();
		bill.orderFromMenu();
		bill.calculateTaxAndTip();
		bill.showReceipt();
		
	}
	
	//Print receipt for customer
	private void showReceipt() {
		System.out.println("__________________________________");
		System.out.println("       Receipt for "+name);
		System.out.println("__________________________________");
		System.out.println("QTY        Item Name        Amount");
		System.out.println("__________________________________");
		for(int i=0;i<qty.size();i++) {
			System.out.println(qty.get(i)+"         "+fixedLengthString(itemName.get(i))+"          "+String.format("%.2f", amount.get(i)));
		}
		System.out.println("__________________________________");
		System.out.println();
		System.out.println("            Subtotal          "+String.format("%.2f", subTotal));
		System.out.println("      	 Tax (6.75%)          "+String.format("%.2f", tax));
		System.out.println("      	   Tip (10%)          "+String.format("%.2f", tip));
		System.out.println("         Grand Total        $ "+String.format("%.2f", grandTotal));
		System.out.println("__________________________________");
		System.out.println();
		System.out.println("Please go to the counter to pay.");
	}
	
	//format item name spacing and hence the row
	private String fixedLengthString(String string) {
	    return String.format("%1$"+10+ "s", string);
	}
	
	private void calculateTaxAndTip() {
		tax = subTotal * 0.0675;
		tip = (subTotal + tax)* 0.1;
		grandTotal = subTotal + tax + tip; 
	}
	
	//The whole process of ordering
	private void orderFromMenu() {
		boolean moreOrder = true;
		boolean invalid = true;
		
		while(moreOrder) {
			displayMenu();
			selectChoice();
			selectQuantity();
			tallySubtotal();
			String ans1 = invalidInput();
			if(ans1.equals("y")) {
				continue;
			}else if(ans1.equals("n")) {
				moreOrder = false;
			}else {
				while(invalid) {
					System.out.println("Invalid input, please try again.");
					String ans2 = invalidInput();
					if(ans2.equals("y")) {
						invalid = false;
					}else if(ans2.equals("n")) {
						moreOrder = false;
					}else{
						continue;
					}
				}
			}
		}
	}
	
	private String invalidInput() {
		System.out.println("Do you want to order more food? [y/n]");
		String ans = sc.next();
		return ans;
	}
	
	//Calculate the cost and subtotal after every order and adds them to an Arraylist
	private void tallySubtotal() {

		switch(serialNo) {
			case 1:
				cost = 2*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Coffee");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 2:
				cost = 2*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Tea");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 3:
				cost = 1*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Water");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 4:
				cost = 8*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Burger");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 5:
				cost = 5*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Bread");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 6:
				cost = 6*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Fried Rice");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 7:
				cost = 3*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Soup");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
			case 8:
				cost = 6*quantity;
				subTotal += cost;
				qty.add(quantity);
				itemName.add("Pasta");
				amount.add(cost);
				System.out.println("Cost: $"+String.format("%.2f", cost)+", "+"Subtotal: $"+String.format("%.2f", subTotal));
				break;
		}
	}
	
	//Select valid item choice from menu
	private void selectChoice() {	
		while(true) {
			System.out.println("Select the item of your choice (1-8)");
			serialNo = sc.nextInt();
			if(serialNo<9 && serialNo>0) {
				break;
			}else {
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}	
	}
	
	//Select valid quantity
	private void selectQuantity() {
		while(true) {
			System.out.println("Enter quantity");
			quantity = sc.nextInt();
			if(quantity<100 && quantity>0) {
				break;
			}else {
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}
	}
	
	//Display menu for viewing
	private void displayMenu() {
		System.out.println("__________________________________");
		System.out.println("               Menu               ");
		System.out.println("__________________________________");
		System.out.println("SINo      Item Name      ItemPrice");
		System.out.println("__________________________________");
		System.out.println(" 1         Coffee         $2      ");
		System.out.println(" 2         Tea            $2      ");
		System.out.println(" 3         Water          $1      ");
		System.out.println(" 4         Burger         $8      ");
		System.out.println(" 5         Bread          $5      ");
		System.out.println(" 6         Fried Rice     $6      ");
		System.out.println(" 7         Soup           $3      ");
		System.out.println(" 8         Pasta          $6      ");
		System.out.println("__________________________________");
		System.out.println();
	}
	
	private void getUserDetails() {
		System.out.println("Enter name");
		name = sc.nextLine();
	}
	
}

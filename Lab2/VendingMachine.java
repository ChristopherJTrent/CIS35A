public class VendingMachine2 {
	public static void main(String[] args) {
		//Initialization
		java.util.Scanner input = new java.util.Scanner(System.in);
		boolean exit = false;
		int chipQuantity = 3;
		int cookieQuantity = 5;
		int candyQuantity = 8;
		int total = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		//End Initialization
		//User Input
		do {
			System.out.println("\nPlease Insert your change");
			System.out.print("Quarters: ");
			quarters = input.nextInt();
			System.out.print("Dimes: ");
			dimes = input.nextInt();
			System.out.print("Nickels: ");
			nickels = input.nextInt();
			total += ((quarters * 25) + (dimes * 10) + (nickels * 5)); //grab
			System.out.printf("Vending Machine \nCredit: $%4.2f \nSelect an option by inputting its number: \n1) Potato Chips $1.25, %d left\n2) Cookies $0.85 %d left \n3) Candy $0.95 %d left\n0) Leave without buying anything \n",
				total / 100.0, chipQuantity,cookieQuantity,candyQuantity);
			int in = input.nextInt();
			//End User Input
			//Business Logic
			int price = 0;
			String selection = "";
			switch(in) {
				case 0: exit=true;
					break;
				case 1: 
					price = 125;
					selection = "Chips";
					break;
				case 2: 
					price = 85;
					selection = "Cookies";
					break;
				case 3: 
					price = 95;
					selection = "Candy";
					break;
				default:
					System.out.printf("There is no item with number %d, please make a different selection.", in);			
			}
			if(!exit){
				if(price <= total){
					switch(in){
						case 1: 
							if(chipQuantity > 0){
								chipQuantity--;
								total -= price;
								System.out.printf("Here are your chips. You have $%.2f remaining.", total/100f);
								break;
							} else {
								System.out.println("That item is sold out. please select another.");
								break;
							}
						case 2:
							if(cookieQuantity > 0){
								cookieQuantity--;
								total -= price;
								System.out.printf("Here are your cookies. You have $%.2f remaining.", total/100f);
								break;
							}else {
								System.out.println("That item is sold out. please select another.");
								break;
							}
						case 3:
							if (candyQuantity > 0) {
								candyQuantity--;
								total -= price;
								System.out.printf("Here's your candy. You have $%.2f remaining.",total/100f);
								break;
							} else {
								System.out.println("That item is sold out, please select another.");
								break;
							}
						default:
							System.out.println("Unexpected error state reached.");
							break;
					}
				} else {
					System.out.printf("You have insufficient funds to purchase %s, please select a different item. You have %.2f credit.", selection, total/100f);
				}
			} else {
				if (total > 0){
					System.out.printf("Have a nice day, your change is %.2f\n",total/100f);
				} else {
					System.out.println("Have a nice day.");
				}
			}
		} while (!exit); //flag value.
	input.close();
	}
}
//End Business Logic

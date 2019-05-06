public class VendingMachine2 {
	static final int[] prices = { 125, 85, 95 }; // all internal values are in integer cents, to avoid rounding errors
	static final String[] items = { "Potato Chips", "Cookies", "Candy" };
	static final int[] coins = { 25, 10, 5 };
	static int[] quantities = { 3, 5, 8 };
	static int total = 0;
	public static int getMoney(){	
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("\nPlease Insert your change");
		System.out.print("Quarters: ");
		int quarters = input.nextInt();
		System.out.print("Dimes: ");
		int dimes = input.nextInt();
		System.out.print("Nickels: ");
		int nickels = input.nextInt();
		input.close();
		return (quarters * coins[0]) + (dimes * coins[1]) + (nickels * coins[2]);		
	}
	public static boolean doDispense(int index){
		if(quantities[index] == 0){ //Check if the item is sold out.
			System.out.println("That item is sold out, please select a different item.");
		}
		else if (prices[index] == total) { //check if exact change was given
			System.out.printf("Here's your %s!\nYou paid with exact change.\n ", items[in]);
			total = 0;
			quantities[index]--;
		} else if (prices[index] < total) { //otherwise, check if sufficient payment was given.
			total -= prices[index];
			System.out.printf("Here's your %s!\nYou have %.2f remaining\n", items[in], total / 100.0);
			quantities[index]--;
		} else { //if neither, insufficient payment was supplied, inform the user.
			System.out.println(
					"You have insufficient credit to buy this item, please insert more coins, or choose a less expensive item.");
		}
	}
	public static boolean validateSelection(int index) {
		if (in == 999){
			quantities[0] = 1;
			quantities[1] = 2;
			quantities[2] = 3;
			System.out.println("Testing values loaded, quantities set to 1, 2, and 3.");
			return true;
		} else if (index > 3){  //Highest Item number is 3, all higher input can be discarded as invalid.
			System.out.printf("There is no item with that number. You have %.2f remaining\n", total/100.0); //lossy float display only occurs in human-readable settings.
			return false;
		} else {
			return true;
		}
	}
	public static void main(String[] args) {
	//Initialization
	boolean exit = false;
	//End Initialization
	//User Input
	do {
		total += getMoney()
			System.out.printf("Vending Machine \nCredit: $%4.2f \nSelect an option by inputting its number: \n1) Potato Chips $1.25, %d left\n2) Cookies $0.85 %d left \n3) Candy $0.95 %d left\n0) Leave without buying anything \n", total / 100.0, quantities[0],quantities[1],quantities[2]);
			int in = input.nextInt();
			//End User Input
			//Business Logic
			if (in == 0) {
				exit = true;
			} else if validateInput(--in) {
				doDispense(in);
			}
	} while (!exit); //flag value.
	}
}
//End Business Logic

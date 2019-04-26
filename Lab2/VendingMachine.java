public class VendingMachine {
	public static void main(String[] args) {
		//Initialization
		java.util.Scanner input = new java.util.Scanner(System.in);
		boolean exit = false;
		int[] quantities = { 3, 5, 8 };
		int total = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		final int[] prices = { 125, 85, 95 }; // all internal values are in integer cents, to avoid rounding errors
		final String[] items = { "Potato Chips", "Cookies", "Candy" };
		final int[] coins = { 25, 10, 5 };
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
		total += ((quarters * coins[0]) + (dimes * coins[1]) + (nickels * coins[2])); //grab
			System.out.printf(
					"Vending Machine \nCredit: $%4.2f \nSelect an option by inputting its number: \n1) Potato Chips $1.25, %d left\n2) Cookies $0.85 %d left \n3) Candy $0.95 %d left\n0) Leave without buying anything \n",
					total / 100.0, quantities[0],quantities[1],quantities[2]);
			int in = input.nextInt();
			//End User Input
			//Business Logic
			if (in == 0) {
				exit = true;
			} else if (in == 999){
				quantities[0] = 1;
				quantities[1] = 2;
				quantities[2] = 3;
				System.out.println("Testing values loaded, quantities set to 1, 2, and 3.");
			} else if (in > 3){  //Highest Item number is 3, all higher input can be discarded as invalid.
				System.out.printf("There is no item with that number. You have %.2f remaining\n", total/100.0); //lossy float display only occurs in human-readable settings.
			}else {
				in--;
				if(quantities[in] == 0){ //Check if the item is sold out.
					System.out.println("That item is sold out, please select a different item.");
				}
				else if (prices[in] == total) { //check if exact change was given
					System.out.printf("Here's your %s!\nYou paid with exact change.\n ", items[in]);
					total = 0;
					quantities[in]--;
				} else if (prices[in] < total) { //otherwise, check if sufficient payment was given.
					total -= prices[in];
					System.out.printf("Here's your %s!\nYou have %.2f remaining\n", items[in], total / 100.0);
					quantities[in]--;
				} else { //if neither, insufficient payment was supplied, inform the user.
					System.out.println(
							"You have insufficient credit to buy this item, please insert more coins, or choose a less expensive item.");
				}
			}
		} while (!exit); //flag value.
	}
}
//End Business Logic

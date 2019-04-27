public class SumDigits {
	public static void main(String[] args) {
<<<<<<< HEAD
		//prep code
		java.util.Scanner s = new java.util.Scanner(System.in); //Define a Scanner
		//business logic
		while(true) {
			//I/O
			System.out.println("Input a number between 1 and " + Integer.MAX_VALUE + " or 0 to exit"); //prompt the user
			int input = s.nextInt(); //grab their input
			//Manual Termination
			if(input == 0) break; //Exit if 0.
			//Integer to IntArray
			int length = Math.abs((int)(Math.log10(input)+1)); //find the number of digits, log base 10 gives 1 less than that.
			int[] out = new int[length]; //Dynamically Allocate an integer array.
			for(int i = 0; i<length; i++){ //Loop across that array
				out[i] = input%10; //set each index to the value of that digit.
				input /= 10; //Remove the ith digit from the array.
			}
			//IntArray to Sum
			int answer = 0;
			for(int i : out) { //Enhanced for loop across the array.
				answer += i;
			}
			//output
			System.out.println("The sum of those digits is " + answer); //output the answer to the console.
		}
		//resource management
		s.close(); //Prevent resource leaks.
=======
		java.util.Scanner userInput = new java.util.Scanner(System.in);
		while(true){
			System.out.println("Input a positive number to get the sum of its digits. Input 0 to exit, or 1 to run the test values.");
			try{
				int input = userInput.nextInt();
				if(input == 0) {
					break;
				} 
				else if (input == 1) {
					test();
					break;
				} else {
					System.out.println("The sum of the digits of "+input+" is: "+ sumDigits(getDigits(input)));
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Looks like the value you put in is outside of what this program can handle, please remember that it has to be a number between 0 and " + Integer.MAX_VALUE);
				System.err.println("Unrecoverable error, invalid user input. Exiting...");
				break;
			}
		}
>>>>>>> prep to pull
	}
}

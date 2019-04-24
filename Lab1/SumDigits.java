import java.util.ArrayList;

public class SumDigits {
	public static void main(String[] args) {
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
	}
}

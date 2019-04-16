import java.util.ArrayList;

public class SumDigits {
	public static int[] getDigits(int in) {		
		int length = (int)(Math.log10(in)+1); //(Log base 10 of input) + 1 gives the total number of digits in a number.
		int[] out = new int[length+1]; //Define an array that can comfortably hold the digits of the number.
		for(int i = 0; i<length; i++){ //loop across the number's digits.
			out[i] = in%10; //Extract the Ith digit
			in /= 10; //and remove it.
		}
		return out; //return the int array of digits.

	}
	public static int sumDigits(int[] in) {
		int answer=0;
		for(int i : in){ //enhanced for loop. "for int i in in, do"
			answer+=i; //add i to the answer.
		}
		return answer; // pass it back.
	}
	public static void test(){
		System.out.println("12345: " + sumDigits(getDigits(12345))); //test 1 through 5
		System.out.println("98765: " + sumDigits(getDigits(98765))); //test 9 through 5
		System.out.println("2468: " + sumDigits(getDigits(2468))); //all single digit even numbers
		System.out.println("13579: " + sumDigits(getDigits(13579))); //all single digit odd numbers
		System.out.println(Integer.MAX_VALUE +": " + sumDigits(getDigits(Integer.MAX_VALUE))); //2^31-1
	}
	public static void main(String[] args) {
		test(); //run the test method.
	}
}

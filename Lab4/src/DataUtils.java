import java.util.ArrayList;

public class DataUtils {
	public static int Sum(int... input) { // int ... is a JDK 1.5 construct, variable arguments. this method can take any
		// number of integer args.
		int value = 0;
		for (int i : input) {
			value += i;
		}
		return value;
	}
	public static double getDatasetTotalPay(ArrayList<Employee> empls) {
		double output = 0.0;
		for(Employee e : empls) {
			output += e.calculateWeeklyPay();
		}
		return output;
	}
}

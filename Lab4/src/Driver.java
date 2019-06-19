import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Employee> userData = new ArrayList<Employee>();
		Scanner s = new Scanner(System.in);
		System.out.println("Do you wish to run test code? (yes or no)");
		boolean debugmode = s.nextLine().toLowerCase().equals("yes");
		if (debugmode)
			new Test().runUnitTests();
		else {
			boolean continueFlag = true;
			while (continueFlag) {
				int emplType = 0;
				while (true) {
					System.out.println(
							"Is the employee: \n 1: Salaried \n 2:Hourly \n or \n 3: Commissioned \n or do you wish to \n 4: exit and print payroll");
					if (s.hasNextInt()) {
						int input = s.nextInt();
						if (input > 0 && input < 5) {
							if (input == 4) {
								continueFlag = false;
								break;
							}
							emplType = input;
							break;
						}
					}
				}
				if (!continueFlag)
					break;
				System.out.println("What is the employee's Full name? (first last)");
				String fn = s.nextLine();
				String ln = s.nextLine();
				double rate = 0.0;
				while (true) {
					System.out.println("What is the employee's "
							+ ((emplType == 1) ? "Salary" : (emplType == 2) ? "Weekly Hours Worked" : "Weekly Sales") + "? "
							+ "(In the format xxxx.xx)");
					if (s.hasNextDouble()) {
						rate = s.nextDouble();
						break;
					}
				}
				boolean bonus = false;
				if (emplType == 1) {
					while (true) {
						System.out.println("Has the employee earned a bonus this week? (yes/no)");
						if (s.hasNextLine()) {
							String in = s.nextLine();
							if (in.toLowerCase().equals("yes") || in.toLowerCase().equals("no")) {
								bonus = in.toLowerCase().equals("yes") ? true : false;
								break;
							}
						}
					}
				}
				switch (emplType) {
				case 1:
					userData.add(new Employee(new Salaried(bonus, rate), ln, fn));
					break;
				case 2:
					userData.add(new Employee(new Hourly(rate), ln, fn));
					break;
				case 3:
					userData.add(new Employee(new Commissioned(rate), ln, fn));
					break;
				default:
					continue;
				}
			}
			System.out.println(new TextUtils().getFormattedOutput(userData, DataUtils.getDatasetTotalPay(userData)));
		}
	}
}
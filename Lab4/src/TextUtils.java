import java.util.ArrayList;

public class TextUtils {
	private static final int nameWidthDefault = 4; // width of the word name
	private static final int SalariedWidthDefault = 8; // width of the word salaried
	private static final int HourlywidthDefault = 6; // width of the word hourly
	private static final int CommissionedWidthDefault = 12; // width of the word commissioned
	int nameWidth = nameWidthDefault;
	int salarywidth = SalariedWidthDefault;
	int hourlywidth = HourlywidthDefault;
	int commissionwidth = CommissionedWidthDefault;
	boolean widthSafe = false;

	private enum valueTypes {
		name, salary, hourly, commission
	}

	private void checkFieldWidth(ArrayList<Employee> employees) {
		for (Employee e : employees) {
			switch (e.getPayGrade().getType().replace(" *", "")) {
			case "Salaried":
				if (e.getPayGrade().Rate > (10 ^ salarywidth + 1)) {
					salarywidth = (int) Math.floor(Math.log(e.getPayGrade().Rate)) + 2;
					break;
				} else
					break;
			case "Hourly":
				if (e.getPayGrade().calculateWeeklyPay() > (10 ^ hourlywidth + 1)) {
					hourlywidth = (int) Math.floor(Math.log(e.calculateWeeklyPay()));
					break;
				} else
					break;
			case "Commissioned":
				if (e.calculateWeeklyPay() > (10 ^ commissionwidth + 1)) {
					commissionwidth = (int) Math.floor(Math.log(e.calculateWeeklyPay()));
					break;
				} else
					break;
			}
			if ((e.getFamilyName() + " " + e.getGivenName()).length()+1 > nameWidth) {
				nameWidth = (e.getFamilyName() + " " + e.getGivenName()).length();
			}

		}
		this.widthSafe = true;
	}

	private int getPadding(String text, valueTypes type) {
		switch (type) {
		case name:
			return nameWidth - text.length();
		case salary:
			return salarywidth - text.length();
		case hourly:
			return hourlywidth - text.length();
		case commission:
			return commissionwidth - text.length();
		default:
			return 0;
		}
	}

	public String getFormattedOutput(ArrayList<Employee> input, double total) {
		String output = "";
		if (!this.widthSafe) {
			checkFieldWidth(input);
		}
		output+="Name";
		output+=getDynamicPadding("Name", valueTypes.name);
		output+="|";
		output+="Hourly";
		output+=getDynamicPadding("Hourly", valueTypes.hourly);
		output+="|";
		output+="Salaried";
		output+=getDynamicPadding("Salaried", valueTypes.salary);
		output+="|";
		output+="Commissioned";
		output+=getDynamicPadding("Commissioned", valueTypes.commission);
		output+="\n";
		output+=getFullWidthSeparator();
		output+='\n';
		for (Employee e : input) {
			//System.out.println(output.length());
			output+=getFormattedEmployeeData(e);
		}
		output+=DataUtils.getDatasetTotalPay(input) + '\n';
		if (output.contains("*")) {
			output+="\n * denotes a 10% bonus.";
		}
		return output;
	}

	private String getFullWidthSeparator() {
		return getFullWidthSeparator('=');
	}

	private String getFullWidthSeparator(char input) {
		String output = "";
		int length = DataUtils.Sum(nameWidth, salarywidth, hourlywidth, commissionwidth, 6);
		//System.out.println(length);
		for (int i = 0; i++ < length; output+=input) {}
		output+="\n";
		return output;
	}

	private String getDynamicPadding(String text, valueTypes type) {
		return getDynamicPadding(text, type, ' ');
	}
	private String getDynamicPadding(String text, valueTypes type, char filler) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i++ <= getPadding(text, type); sb.append(filler))
			;
		return sb.toString();
	}
	private String getDynamicPadding(valueTypes type) {
		return getDynamicPadding("", type);
	}

	private String getFormattedEmployeeData(Employee e) {
		String output = "";
		output+=e.getFullName();
		output+=getDynamicPadding(e.getFullName(), valueTypes.name);
		output+="|";
		if (e.getPayGrade() instanceof Hourly) {
			output+="$" + e.calculateWeeklyPay() + getDynamicPadding(e.calculateWeeklyPay() + "", valueTypes.hourly);
		} else {
			output+=getDynamicPadding(valueTypes.hourly);
		}
		output+="|";
		if (e.getPayGrade() instanceof Salaried) {
			output+="$" + e.calculateWeeklyPay() + (e.getPayGrade().getType().contains("*")?"*":"")+getDynamicPadding(e.calculateWeeklyPay() + "", valueTypes.salary);
		} else {
			output+=getDynamicPadding(valueTypes.salary);
		}
		output+="|";
		if (e.getPayGrade() instanceof Commissioned) {
			output+="$" + e.calculateWeeklyPay()
					+ getDynamicPadding(e.calculateWeeklyPay() + "", valueTypes.commission);
		} else {
			output+=getDynamicPadding(valueTypes.commission);
		}
		output+='\n'+getFullWidthSeparator('-');
		return output;
	}
}

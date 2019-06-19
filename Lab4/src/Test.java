import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public void runUnitTests() {
		ArrayList<ArrayList<Employee>> TestDataSet = new ArrayList<ArrayList<Employee>>();
		ArrayList<Employee> InnerDataset1 = new ArrayList<Employee>();
		ArrayList<Employee> InnerDataset2 = new ArrayList<Employee>();
		ArrayList<Employee> InnerDataset3 = new ArrayList<Employee>();
		ArrayList<Employee> InnerDataset4 = new ArrayList<Employee>();
		ArrayList<Employee> InnerDataset5 = new ArrayList<Employee>();
		Employee[] good = new Employee[] { new Employee(new Salaried(false, 1000.00), "Test", "Johnathan"),
				new Employee(new Salaried(true, 1000.00), "Dali", "Salvador"),
				new Employee(new Hourly(60f), "Chuu", "Cydney"), new Employee(new Hourly(30f), "Bui", "Don"),
				new Employee(new Commissioned(100000.00), "Jones", "Jacob"),
				new Employee(new Commissioned(50000.00), "Sune", "Kit"), };
		InnerDataset2.addAll(Arrays.asList(good));
		InnerDataset3.add(new Employee(new Salaried(false, 100.00), null, "Cher"));
		InnerDataset4.add(new Employee(new Salaried(false, 100.00), null, null));
		InnerDataset5.add(new Employee(null, "Volunteer", "Joseph"));
		TestDataSet.add(InnerDataset1);
		TestDataSet.add(InnerDataset2);
		TestDataSet.add(InnerDataset3);
		TestDataSet.add(InnerDataset4);
		TestDataSet.add(InnerDataset5);
		try {
			for (ArrayList<Employee> dataset : TestDataSet) {
				System.out.println("Testing dataset at address " + dataset);
				System.out.println(new TextUtils().getFormattedOutput(dataset, DataUtils.getDatasetTotalPay(dataset)));
			}
		} catch (NullPointerException e) {
			System.out.println("Dataset contained null compensation");
		}
	}
}

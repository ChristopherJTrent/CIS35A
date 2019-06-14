public class Employee {
	private Compensation payGrade; //I really just want to put { get; set } here. I miss C#.
	private String familyName;
	private String givenName;
	public Employee(Copmensation payGrade, String familyName, String givenName){
		this.payGrade = payGrade;
		this.familyName = familyName;
		this.givenName = givenName;
	}
	public double calculateWeeklyPay(){
		return this.payGrade.calculateWeeklyPay();
	}
	public Compensation getPayGrade(){
		return this.payGrade;
	}
	public String getFamilyName(){
		return this.familyName;
	}
	public String getGivenName(){
		return this.givenName;
	}
}

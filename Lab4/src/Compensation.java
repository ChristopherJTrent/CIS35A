public abstract class Compensation {
	protected double Rate;
	public abstract double calculateWeeklyPay();
	public abstract String getType();
	public double getRate(){
		return this.Rate;
	}
}

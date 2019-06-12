public class Commissioned extends Compensation {
	private double CommissionPercentage;
	private double SalesMade;
	public double calculateWeeklyPay(){
		return this.SalesMade/this.CommissionPercentage;
	}
}

public class Commissioned extends Compensation {
	private double CommissionPercentage;
	private double SalesMade;
	public Commissioned(){
		this.CommissionPercentage = 0.2;
		this.SalesMade=0.0;
	}
	public Commissioned(double SalesMade){
		this.SalesMade = SalesMade;
	}
	public double calculateWeeklyPay(){
		return this.SalesMade*this.CommissionPercentage;
	}
}

public class Commissioned extends Compensation {
	private double CommissionPercentage;
	private double SalesMade;
<<<<<<< HEAD
	public double calculateWeeklyPay(){
		return this.SalesMade/this.CommissionPercentage;
=======
	public Commissioned(){
		this.CommissionPercentage = 0.2;
		this.SalesMade=0.0;
	}
	public Commissioned(double SalesMade){
		this.SalesMade = SalesMade;
	}
	public double calculateWeeklyPay(){
		return this.SalesMade*this.CommissionPercentage;
>>>>>>> d50bd766d4adc73ca4ffa061168607caa4f7c9e0
	}
}

public class Commissioned extends Compensation {
	private double CommissionPercentage;
	private double SalesMade;
	public double calculateWeeklyPay(){
		return Math.round((this.SalesMade/this.CommissionPercentage)*100)/100;
	}
	public Commissioned(){
		this.CommissionPercentage = 20.0;
		this.SalesMade=0.0;
	}
	public Commissioned(double SalesMade){
		this.SalesMade = SalesMade;
		this.CommissionPercentage = 20.0;
	}	
	public Commissioned(double CommissionPercentage, double salesMade){
		this.SalesMade = salesMade;
		this.CommissionPercentage = CommissionPercentage;
	}
	@Override
	public String getType() {
		return "Commissioned";
	}
}

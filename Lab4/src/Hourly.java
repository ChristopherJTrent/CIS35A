public class Hourly extends Compensation {
	private double HoursWorked;
	private double OvertimeMultiplier;
	public double calculateWeeklyPay(){
		return (this.HoursWorked > 40) ?
       	  	  this.HoursWorked * super.Rate
		  : (40 * super.Rate)
		  + (
			  this.HoursWorked 
			  - 40
		    )
		  * super.Rate
		  * this.OvertimeMultiplier;
	}
}

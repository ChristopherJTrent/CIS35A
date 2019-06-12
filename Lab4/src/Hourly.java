public class Hourly extends Compensation {
	private double HoursWorked;
<<<<<<< HEAD
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
=======
	private double overtimeMultiplier=2.0;
	public Hourly(){
		super();
		HoursWorked = 0;
	}
	public Hourly(double hours){
		super();
		HoursWorked = hours;
	}
	public double calculateWeeklyPay(){
		return this.HoursWorked>40?
			(40.0*super.getRate())
				+(super.getRate()
					*(this.HoursWorked-40)
					*this.overtimeMultiplier)
			:this.HoursWorked
				*super.getRate();
	}
	public double getHoursWorked(){
		return this.HoursWorked;
	}
	public double getOvertimeMultiplier(){
		return this.overtimeMultiplier;
>>>>>>> d50bd766d4adc73ca4ffa061168607caa4f7c9e0
	}
}

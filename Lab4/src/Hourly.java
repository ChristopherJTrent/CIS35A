public class Hourly extends Compensation {
	private double HoursWorked;
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
	}
}

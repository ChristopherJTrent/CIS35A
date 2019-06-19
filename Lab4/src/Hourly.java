public class Hourly extends Compensation {
	private double HoursWorked;
	private double overtimeMultiplier=2.0;
	public Hourly(){
		super();
		HoursWorked = 0;
	}
	public Hourly(double hours){
		this.Rate=15.0;
		HoursWorked = hours;
	}
	@Override
	public double calculateWeeklyPay(){
		return Math.round((this.HoursWorked>40?
			(40.0*super.getRate())
				+(super.getRate()
					*(this.HoursWorked-40)
					*this.overtimeMultiplier)
			:this.HoursWorked
				*super.getRate())*100)/100;
	}
	public double getHoursWorked(){
		return this.HoursWorked;
	}
	public double getOvertimeMultiplier(){
		return this.overtimeMultiplier;
	}
	@Override
	public String getType() {
		return "Hourly";
	}
}

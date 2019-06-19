public class Salaried extends Compensation {
	private boolean BonusWeek = false;
	
	public Salaried(boolean bonus) {
		this.BonusWeek = bonus;
	}
	public Salaried(boolean bonus, double rate) {
		this.Rate = rate;
		this.BonusWeek = bonus;
	}
	public double calculateWeeklyPay() {
		return Math.round((this.Rate * (BonusWeek?1.1:1.0)*100))/100;
	}
	@Override
	public String getType() {
		return (BonusWeek)?"Salaried *":"Salaried";
	}

}

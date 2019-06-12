public class Salaried extends Compensation {
	private boolean BonusWeek = false;
	public double calculateWeeklyPay() {
		return super.getRate() * BonusWeek?1.1:1.0;
	}
}

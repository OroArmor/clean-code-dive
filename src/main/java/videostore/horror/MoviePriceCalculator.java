package videostore.horror;

public class MoviePriceCalculator {

	public static double calculateRegularMoviePrice(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2) {
			thisAmount += (daysRented - 2) * 1.5;
		}
		return thisAmount;
	}

	public static double calculateNewReleaseMoivePrice(int daysRented) {
		return daysRented * 3;
	}

	public static double calculateChildrensMoviePrice(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3) {
			thisAmount += (daysRented - 3) * 1.5;
		}
		return thisAmount;
	}
}

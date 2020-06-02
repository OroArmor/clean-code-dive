package videostore.horror;

import java.util.function.Function;

public enum MovieType {
	CHILDRENS(MoviePriceCalculator::calculateChildrensMoviePrice),
	REGULAR(MoviePriceCalculator::calculateRegularMoviePrice),
	NEW_RELEASE(MoviePriceCalculator::calculateNewReleaseMoivePrice);

	private Function<Integer, Double> priceCalculation;

	private MovieType(Function<Integer, Double> priceCalculation) {
		this.priceCalculation = priceCalculation;
	}

	public double calculatePrice(int daysRented) {
		return priceCalculation.apply(daysRented);
	}

}
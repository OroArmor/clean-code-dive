package videostore.horror;

public class Rental {
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented) {
		if (daysRented <= 0) {
			throw new IllegalArgumentException("Negative days rented");
		}

		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int addFrequentRenterPoints() {
		int frequentRenterPoints = 1;
		if (getMovie().getType() == MovieType.NEW_RELEASE && getDaysRented() >= 2) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

	public double calculateRentalPrice() {
		return movie.getType().calculatePrice(daysRented);
	}

}
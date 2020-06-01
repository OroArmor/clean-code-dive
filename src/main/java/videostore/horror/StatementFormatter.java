package videostore.horror;

import java.util.List;
import static java.util.stream.Collectors.joining;

public class StatementFormatter {
	public String createOrderStatment(List<Rental> rentals, String name) {
		return formatHeader(name) + formatBody(rentals) + formatFooter(rentals);
	}

	private String formatBody(List<Rental> rentals) {
		return rentals.stream().map(this::formatBodyLine).collect(joining());
	}

	private String formatFooter(List<Rental> rentals) {
		return "Amount owed is " + rentals.stream().mapToDouble(Rental::calculateRentalPrice).sum() + "\n"
				+ "You earned " + rentals.stream().mapToInt(Rental::addFrequentRenterPoints).sum()
				+ " frequent renter points";
	}

	private String formatBodyLine(Rental rental) {
		return "\t" + rental.getMovie().getTitle() + "\t" + rental.calculateRentalPrice() + "\n";
	}

	private String formatHeader(String name) {
		return "Rental Record for " + name + "\n";
	}
}
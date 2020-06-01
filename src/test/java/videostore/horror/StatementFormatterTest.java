package videostore.horror;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import videostore.horror.Movie.MovieType;

public class StatementFormatterTest {

	@Test
	public void characterizationTest() {
		List<Rental> rentals = List.of(new Rental(new Movie("Star Wars", MovieType.NEW_RELEASE), 6),
				new Rental(new Movie("Sofia", MovieType.CHILDRENS), 7),
				new Rental(new Movie("Inception", MovieType.REGULAR), 5));

		String expected = "Rental Record for John Doe\n" + "	Star Wars	18.0\n" + "	Sofia	7.5\n"
				+ "	Inception	6.5\n" + "Amount owed is 32.0\n" + "You earned 4 frequent renter points";

		assertEquals(expected, new StatementFormatter().createOrderStatment(rentals, "John Doe"));
	}
}

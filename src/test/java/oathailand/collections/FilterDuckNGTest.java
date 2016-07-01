package oathailand.collections;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import thjug.trainging.Duck;

public class FilterDuckNGTest {

	@Test
	public void testGreaterThan() {
		final List<Duck> ducks = Arrays.asList(
				new Duck("Donald Duck", 54), new Duck("Stewed Duck", 18), new Duck("Mickey Mouse", 32), new Duck("Yo", 24));

		final FilterDuck filterDuck = new FilterDuck();
		final List<Duck> actuals = filterDuck.greaterThan(ducks, 30);

		actuals.forEach(d -> {
			assert d.age > 30 : "Age should be greater than 30";
		});

	}

}

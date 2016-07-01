package oathailand.collections;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;
import thjug.trainging.Duck;

public class ReduceDuckNGTest {

	@Test
	public void testSumAges() {		
		final List<Duck> ducks = Arrays.asList(
			new Duck("Donald Duck", 54)
			, new Duck("Stewed Duck", 18)
			, new Duck("Mickey Mouse", 32)
			, new Duck("Yo", 24));	
		
		final ReduceDuck reduceDuck = new ReduceDuck();
		
		assert reduceDuck.sumAges(ducks) == 128 
				: "Total of Ages should be 128";
	}
	
}

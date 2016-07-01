package oathailand.collections;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import thjug.trainging.Duck;

@Slf4j
public class ReduceDuck {

	public int sumAges(final List<Duck> ducks) {
		final int sumAge = ducks.stream()
				.map(d -> d.age)
				.reduce(0, (a, b) -> a + b);
		
		log.info("Total Age: ", sumAge);
		
		return sumAge;
	}

}

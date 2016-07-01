package oathailand.collections;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import thjug.trainging.Duck;

/**
 *
 * @author pasoktummarungsri
 */
@Slf4j
public class FilterDuck {

	public List<Duck> greaterThan(final List<Duck> ducks, final int i) {
		return ducks.parallelStream()
				.filter(d -> d.age > i)
				.collect(Collectors.toList());
	}
	
}

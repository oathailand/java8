package thjug.trainging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@AllArgsConstructor
public class Duck {

	public final String name;
	public final int age;

	public static void main(final String[] args) {
		final List<String> listString1 = Arrays.asList(
				"1 Donald, 14", "Trump, 38", "Obamo, 12", "Captain, 230", "Batman, 44");

		final List<String> listString2 = Arrays.asList(
				"2 Donald, 14", "Trump, 38", "Obamo, 12", "Captain, 230", "Batman, 44");

		final List<String> listString3 = Arrays.asList(
				"3 Donald, 14", "Trump, 38", "Obamo, 12", "Captain, 230", "Batman, 44");

		final List<List<String>> listListString = Arrays.asList(
				listString1, listString2, listString3);

		final List<Duck> ducks = listListString.parallelStream()
			.flatMap(list -> {
				log.info("flatMap {}", list.get(0));
				return list.parallelStream();
			})
			.map(str -> {
				log.info("map {}", str);
				final String[] s = str.split(",");
				return new Duck(s[0], Integer.parseInt(s[1].trim()));
			})
			.sorted((x, y) -> y.age - x.age)
			.collect(Collectors.toList());
		
		//ducks.forEach(d -> log.info("{}", d));
		
		final Optional<Duck> duck = ducks.parallelStream()
				.filter(d -> d.age > 1000)
				.findAny();
		
		duck.ifPresent(d -> log.info("Duck {}", d));
		if (!duck.isPresent()) {
			log.warn("No Data!");
		}
	}

	public static void main4(final String[] args) {
		final List<String> listString = Arrays.asList(
				"Donald, 14", "Trump, 38", "Obamo, 12", "Captain, 230", "Batman, 44");

		final List<Duck> ducks = listString.parallelStream()
				.map(str -> {
					final String[] s = str.split(",");
					return new Duck(s[0], Integer.parseInt(s[1].trim()));
				})
				.collect(Collectors.toList());

		ducks.forEach(d -> log.info("{}", d));
	}

	public static void main2(final String[] args) {
		final List<Duck> list = new LinkedList<>();
		list.add(new Duck("Donald Duck", 54));
		list.add(new Duck("Stewed Duck", 18));
		list.add(new Duck("Mickey Mouse", 32));
		list.add(new Duck("Yo", 24));

		for (final Duck d : list) {
			log.info("{}", d);
		}
		log.info("====");

		Collections.sort(list,
				(x, y) -> x.name.compareTo(y.name));

		for (final Duck d : list) {
			log.info("{}", d);
		}
		log.info("====");

		Collections.sort(list,
				(x, y) -> y.age - x.age);

		for (final Duck d : list) {
			log.info("{}", d);
		}
		log.info("====");

		list.stream().forEach(d -> log.info("{}", d));
		log.info("====");
	}

	public static void main3(final String[] args) {
		final List<Duck> list = new LinkedList<>();
		list.add(new Duck("Donald Duck", 54));
		list.add(new Duck("Stewed Duck", 18));
		list.add(new Duck("Mickey Mouse", 32));
		list.add(new Duck("Yo", 24));
		list.add(new Duck("Donald Duck 1", 54));
		list.add(new Duck("Stewed Duck 1", 18));
		list.add(new Duck("Mickey Mouse 1", 32));
		list.add(new Duck("Yo 1", 24));
		list.add(new Duck("Donald Duck 2", 54));
		list.add(new Duck("Stewed Duck 2", 18));
		list.add(new Duck("Mickey Mouse 2", 32));
		list.add(new Duck("Yo", 24));
		list.add(new Duck("Donald Duck 3", 54));
		list.add(new Duck("Stewed Duck 3", 18));
		list.add(new Duck("Mickey Mouse 3", 32));
		list.add(new Duck("Yo 3", 24));

		list.stream()
				.forEach(d -> log.info("{}", d));
		log.info("====");

//		list.parallelStream()
//				.forEach(d -> log.info("{}", d));
//		log.info("====");
//		list.stream()
//			.filter(d -> d.age > 32)
//			.forEach(d -> log.info("{}", d));
//		log.info("====");
//		for (final Duck d : list) {
//			if (d.age > 32) {
//				log.info("{}", d);
//			}
//		}
		list.parallelStream()
				.filter(d -> d.age > 30)
				.forEach(d -> log.info("{}", d));
		log.info("====");

		final List<Duck> filterList = list.parallelStream()
				.filter(d -> d.age > 30)
				.collect(Collectors.toList());

		filterList.forEach(d -> log.info("{}", d));
		log.info("====");
	}
}

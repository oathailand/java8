package thjug.trainging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class People {
	private String firstname;
	private String lastname;
	private int age;
	private String citizen;	
	
	public static void main(String[] args) {
		final People p = new People();
		p.setFirstname("Peerapat");
		p.setLastname("Asok.");
		p.setAge(1);
		p.setCitizen("Thai");
		log.info("P1: {}", p);
		
		final People p2 = new People(
				"Charnsilp",
				"C",
				2,
				"Thai");
		log.info("P2: {}", p2);
		
		log.trace("Trace");
		log.debug("Debug");
		log.info("Information");
		log.warn("Warning");
		log.error("Error");
	}
	
}

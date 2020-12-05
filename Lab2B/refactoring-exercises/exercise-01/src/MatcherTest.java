import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MatcherTest {
	Matcher matcher;
	@BeforeEach
	public void before(){
		int[] expected = new int[] { 10, 50, 30, 98 };
		int clipLimit = 100;
		int delta = 5;
		int[] actual = new int[] { 12, 55, 25, 110 };

		matcher = new Matcher(expected, actual, clipLimit, delta);
	}
	@Test
	public void testMatch() {

		assertTrue(matcher.match());

		matcher.actual = new int[] { 10, 60, 30, 98 };
		assertFalse(matcher.match());

		matcher.actual = new int[] { 10, 50, 30 };
		assertFalse(matcher.match());
	}
}

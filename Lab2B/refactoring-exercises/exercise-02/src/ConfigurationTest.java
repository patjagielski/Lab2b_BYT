import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigurationTest{
	Configuration configuration;
	@Before
	public void before(){
		int interval = 10;
		int duration = 100;
		int departure = 200;

		configuration = new Configuration(interval, duration, departure);
	}
	@Test
	public void testGoodInput() {

		assertEquals(configuration.getInterval(), 10);
		assertEquals(configuration.getDuration(), 100);
		assertEquals(configuration.getDeparture(), 200);
	}
	@Test
	public void testNegativeValues() {
		configuration.setDeparture(-200);
		configuration.setDuration(-100);
		configuration.setInterval(-10);

		try{
			configuration.load();
			fail("should not be able to use negative values");
		} catch (ConfigurationException e) {

			assertTrue(true);
		}

	}
	@Test
	public void testInvalidDuration() {
		configuration.setDeparture(199);
		configuration.setDuration(99);
		configuration.setInterval(10);

		try{
			configuration.load();
			fail("one of these values are invalid and should not be able to be processed");
		} catch (ConfigurationException e) {

			assertTrue(true);
		}
	}


}

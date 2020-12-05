// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class PersonClientsTest {
	/**
	 * Each test case should test one method/functionality
	 * So we will create 4 test cases for Person
	 */
	Person person = new Person("Jagielski", "Patrik", "TimothyTomTOm");

	@Test
	public void testPrintPerson() throws IOException {
		StringWriter out = new StringWriter();
		person.printPerson(out);
		assertEquals("Patrik TimothyTomTOm Jagielski", out.toString());
	}
	@Test
	public void testFormatPerson(){
		String name = person.formatPerson();
		assertEquals("Jagielski, Patrik TimothyTomTOm", name);
	}
	@Test
	public void testDisplay() throws IOException {
		StringWriter out = new StringWriter();
		person.display(out);
		assertEquals("Jagielski, Patrik TimothyTomTOm", out.toString());
	}
	@Test
	public void testToString(){
		String name = person.toString();
		assertEquals("Jagielski, Patrik TimothyTomTOm", name);
	}
}

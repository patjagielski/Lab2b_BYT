import java.io.IOException;
import java.io.Writer;

public class Person {
	public String last;

	public String first;

	public String middle;

	/**
	 * Bad smell: Lazy Class
	 * we use too many classes and they can be reduced down this singular class
	 * each function does a similar functionality, however in case the client wants all these different formats
	 * then we should reduce the number of methods
	 */
	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}

	public void printPerson(Writer out) throws IOException {
		out.write(this.first);
		out.write(" ");
		if (this.middle != null) {
			out.write(this.middle);
			out.write(" ");
		}
		out.write(this.last);

	}
	public String formatPerson() {
		String result = this.last + ", " + this.first;
		if (this.middle != null)
			result += " " + this.middle;
		return result;
	}
	public void display(Writer out) throws IOException {
		out.write(this.last);
		out.write(", ");
		out.write(this.first);
		if (this.middle != null) {
			out.write(" ");
			out.write(this.middle);
		}
	}
	public  String toString() {
		return this.last + ", " + this.first
				+ ((this.middle == null) ? "" : " " + this.middle);
	}
}
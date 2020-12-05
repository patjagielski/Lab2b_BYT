public class Matcher {

	public int[] expected;
	public int[] actual;
	public int clipLimit;
	public int delta;

	public Matcher(int[] _expected, int[] _actual, int _clipLimit, int _delta) {
		this.expected = _expected;
		this.actual = _actual;
		this.clipLimit = _clipLimit;
		this.delta = _delta;
	}

	/**
	 * Bad smell: Long Parameters List, Primitive Obsession
	 * Will create object that takes these properties
	 */

	public boolean match() {
	//there are two for loops that can be reduced to one
		// Clip "too-large" values
		for (int i = 0; i < this.actual.length; i++) {
			if (this.actual[i] > this.clipLimit) {
				this.actual[i] = this.clipLimit;
			}
			if (Math.abs(this.expected[i] - this.actual[i]) > this.delta) {
				return false;
			}
			// Check for length differences
		}
		return this.actual.length == this.expected.length;


	}
}
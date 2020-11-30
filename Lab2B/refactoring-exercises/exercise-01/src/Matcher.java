public class Matcher {
	//idk why this constructor is here?
//	public Matcher() {
//	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
	//there are two for loops that can be reduced to one
		// Clip "too-large" values
		for (int i = 0; i < actual.length; i++) {
			if (actual[i] > clipLimit) {
				actual[i] = clipLimit;
			}
			if (Math.abs(expected[i] - actual[i]) > delta) {
				return false;
			}
			// Check for length differences
			if (actual.length != expected.length) {
				return false;
			}
		}
		return true;

		// Check that each entry within expected +/- delta
//		for (int i = 0; i < actual.length; i++)
//			if (Math.abs(expected[i] - actual[i]) > delta)
//				return false;

	}
}
public class CsvWriter {
	private static char NEWLINE = '\n';
	private static String COMMA = ",";
	private static char SLASH = '\"';
	private static String DOUBLESLASH = "\"\"";



	private StringBuilder toReturn;
	public CsvWriter() {
		toReturn = new StringBuilder();
	}

	/**
	 * Bad Smell: Message chain would be my guess
	 * Originally where ever I had the toReturn call was a system.out.println call
	 * each method returns something rather than manipulating some variable
	 */
	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++) {
			writeLine(lines[i]);
		}
		System.out.println(toReturn);
	}

	private StringBuilder writeLine(String[] fields) {
		if (fields.length == 0)
			return toReturn.append(NEWLINE);
		else {
			 writeField(fields[0]);

			for (int i = 1; i < fields.length; i++) {
				toReturn.append(COMMA);
				writeField(fields[i]);
			}
			return toReturn.append(NEWLINE);
		}

	}

	private StringBuilder writeField(String field) {
		if (field.indexOf(COMMA) != -1 || field.indexOf(SLASH) != -1)
			return writeQuoted(field);
		else
			return toReturn.append(field);

	}

	private StringBuilder writeQuoted(String field) {
		toReturn.append(SLASH);
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == SLASH)
				toReturn.append(DOUBLESLASH);
			else
				toReturn.append(c);
		}
		return toReturn.append(SLASH);
	}


}
public class Expression {

	private char op;

	private int left;

	private int right;

	private int constant;

	/**
	 * Bad smell: Switch Statements
	 * since it is a small switch statements we break them out to explicit methods
	 * having Expression object that takes other Expression objects can become confusing and isn't really good practice
	 *I don't know which bad smell this would fit under, but we are overcomplicating the object, maybe Speculative Generality, Maybe Middle man?
	 */

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, int left, int right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		switch (op) {
		case 'c':
			return constant;
		case '+':
			return add();
		case '-':
			return subtract();
		case '*':
			return multiply();
		case '/':
			return divide();
		default:
			throw new IllegalStateException();
		}
	}

	private int divide() {
		return left/ right;
	}

	private int multiply() {
		return left * right;
	}

	private int subtract() {
		return left - right;
	}

	private int add() {
		return left + right;
	}
}

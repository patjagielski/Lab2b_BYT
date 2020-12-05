import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {

	@Test
	public void testConstant() {
		Expression e = new Expression(-43);
		assertEquals(e.evaluate(), -43);
	}
	@Test
	public void testAddition() {
		Expression e = new Expression('+', 100, -100);
		assertEquals(e.evaluate(), 0);
	}
	@Test
	public void testSubtraction() {
		Expression e = new Expression('-', 100, -100);
		assertEquals(e.evaluate(), 200);
	}
	@Test
	public void testMultiplication() {
		Expression e = new Expression('*', 100, -100);
		assertEquals(e.evaluate(), -10000);
	}
	@Test
	public void testDivision() {
		Expression e = new Expression('/', 100, -100);
		assertEquals(e.evaluate(), -1);
	}
	@Test
	public void testComplexExpression() {
		// 1+2-3*4/5
		Expression e1 = new Expression('+', 1, 2);
		Expression e2 = new Expression('*', 3, 4);
		Expression e3 = new Expression('/', e2.evaluate(), 5);
		Expression e = new Expression('-', e1.evaluate(), e3.evaluate());
		assertEquals(e.evaluate(), 1);
	}

}

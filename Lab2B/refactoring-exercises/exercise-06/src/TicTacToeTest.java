import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {
	TicTacToe game;

	/**
	 * I explain this more below, but at the bottom we are creating a test method that other test methods use which is bad
	 * We are creating redundant test methods as well
	 */
	@Test
	public void testDefaultMove() {
		TicTacToe game = new TicTacToe("XOXOX-OXO");
		assertEquals(5, game.suggestMove('X'));

		game = new TicTacToe("XOXOXOOX-");
		assertEquals(8, game.suggestMove('O'));

		game = new TicTacToe("---------");
		assertEquals(0, game.suggestMove('X'));

		game = new TicTacToe("XXXXXXXXX");
		assertEquals(-1, game.suggestMove('X'));
	}
	@Test
	public void testFindWinningMove() {
		TicTacToe game = new TicTacToe("XO-XX-OO-");
		assertEquals(5, game.suggestMove('X'));
		assertEquals(8, game.suggestMove('O'));
	}
	@Test
	public void testWinConditions() {
		game = new TicTacToe("---XXX---");
		assertEquals('X',game.winner());

		game = new TicTacToe("XXX------");
		assertEquals('X', game.winner());

		game = new TicTacToe("------XXX");
		assertEquals('X', game.winner());

		game = new TicTacToe("X--X--X--");
		assertEquals('X', game.winner());

		game = new TicTacToe("-X--X--X-");
		assertEquals('X', game.winner());

		game = new TicTacToe("--X--X--X");
		assertEquals('X', game.winner());

		game = new TicTacToe("X---X---X");
		assertEquals('X', game.winner());

		game = new TicTacToe("--X-X-X--");
		assertEquals('X', game.winner());

		game = new TicTacToe("---------");
		assertEquals('-', game.winner());

		game = new TicTacToe("XXOOOXXOO");
		assertEquals('-', game.winner());

/**
 * there is no reason to check same cases for O seperately due to the code never specifically checking for X or O
 * it simply checks the winner of the inputed char, making it redundant to test for O specifically
 * ie. I can use Q or Y as a test variable and it'll work fine
 * as proven below
 */
		game = new TicTacToe("---YYY---");
		assertEquals('Y',game.winner());


	}
	/**
	 * should not create test methods which rely on test methods
	 * because then we have to create another test method checking if this test method is doing its job correctly,
	 * which creates a mess
	 */
//	@Test
//	private void assertWinner(String s, char w) {
//		TicTacToe game = new TicTacToe(s);
//		assertEquals(w, game.winner());
//	}
}
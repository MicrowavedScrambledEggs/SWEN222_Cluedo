/**
 *
 */
package tests;
import static org.junit.Assert.*;
import game.Board;
import game.Card;
import game.Coordinate;
import game.Game;
import game.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
/**
 * @author Vicki
 *
 */
public class GameTests {
	@Test
	public void test1_createBoard() {
		Board b = new Board();
	}

	@Test
	public void test2_getMoves(){
		Board b = new Board();
		Map<Coordinate, String> moves = b.possibleMoves(new Coordinate(5,8), 6);
		for(Coordinate coord : moves.keySet()){
			System.out.printf("%s : %s\n", coord.toString(), moves.get(coord));
		}
	}

	@Test
	public void test3_getMoves2(){
		Board b = new Board();
		Map<Coordinate, String> moves = b.possibleMoves(new Coordinate(9,0), 4);
		for(Coordinate coord : moves.keySet()){
			System.out.printf("%s : %s\n", coord.toString(), moves.get(coord));
		}
	}

	@Test
	public void test4_getMoves3(){
		Board b = new Board();
		Map<Coordinate, String> moves = b.possibleMoves(new Coordinate(4, 6), 1);
		Map<Coordinate, String> expected = new HashMap<Coordinate, String>();
		assertEquals("Enter the study", moves.get(new Coordinate(4,5)));
		String distanceTo = moves.get(new Coordinate(4,7));
		assertTrue(distanceTo.contains("6 steps away from ball room"));
		assertTrue(distanceTo.contains("10 steps away from dining room"));
		assertTrue(distanceTo.contains("22 steps away from library"));
		assertTrue(distanceTo.contains("19 steps away from conservatory"));
		assertTrue(distanceTo.contains("18 steps away from lounge"));
		assertTrue(distanceTo.contains("18 steps away from hall"));
		assertTrue(distanceTo.contains("16 steps away from billiard room"));
	}

	// ========= helper methods! =============

	private List<Card> fillHand(List<Card> list, Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			list.add(cards[i]);
		}
		return list;
	}
}

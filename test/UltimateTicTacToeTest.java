import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.ultimateTictactoe.IUltimateTicTacToe;
import tictactoe.backend.ultimateTictactoe.UltimateTicTacToe;
import tictactoe.frontend.ultimateTictactoe.UltimateConsole;

import static org.junit.Assert.*;

public class UltimateTicTacToeTest {
    private IUltimateTicTacToe ticTacToe;

    @Before
    public void init() {
        ticTacToe = new UltimateTicTacToe();
    }

    @Test
    public void createUltimate() {
        ticTacToe.createUltimate();
        assertNotNull(ticTacToe.getLocalBoard());
    }

    @Test
    public void markOneMove() {
        ticTacToe.createUltimate();
        assertTrue(ticTacToe.markMove(2, 1, 5));
    }

    @Test
    public void checkTicTacToeX() {

        ticTacToe.createUltimate();
        //---------------- Board 1
        // x
        ticTacToe.markMove(2, 1, 1);
        // o
        ticTacToe.markMove(0, 2, 1);
        // x
        ticTacToe.markMove(1, 1, 1);
        // o
        ticTacToe.markMove(1, 2, 1);
        // x
        ticTacToe.markMove(0, 1, 1);
        //------------------ Board 2
        // o
        ticTacToe.markMove(0, 2, 4);
        // x
        ticTacToe.markMove(1, 1, 4);
        // o
        ticTacToe.markMove(1, 2, 4);
        // x
        ticTacToe.markMove(0, 1, 4);
        // o
        ticTacToe.markMove(0, 0, 4);
        // x
        ticTacToe.markMove(2, 1, 4);
        //------------------ Board 3
        // o
        ticTacToe.markMove(1, 0, 7);
        // x
        ticTacToe.markMove(2, 0, 7);
        // o
        ticTacToe.markMove(1, 2, 7);
        // x
        ticTacToe.markMove(1, 1, 7);
        // o
        ticTacToe.markMove(2, 2, 7);
        // x
        ticTacToe.markMove(0, 2, 7);
        assertTrue(ticTacToe.checkTicTacToe());

    }

    @Test
    public void checkTicTacToeO() {

        ticTacToe.createUltimate();
        //---------------- Board 1
        // x
        ticTacToe.markMove(0, 0, 2);
        // o
        ticTacToe.markMove(1, 1, 2);
        // x
        ticTacToe.markMove(1, 2, 2);
        // o
        ticTacToe.markMove(2, 0, 2);
        // x
        ticTacToe.markMove(0, 1, 2);
        // o
        ticTacToe.markMove(0, 2, 2);
        //------------------ Board 2
        // x
        ticTacToe.markMove(1, 0, 5);
        // o
        ticTacToe.markMove(2, 2, 5);
        // x
        ticTacToe.markMove(0, 1, 5);
        // o
        ticTacToe.markMove(1, 1, 5);
        // x
        ticTacToe.markMove(2, 1, 5);
        // o
        ticTacToe.markMove(0, 0, 5);
        // x
        ticTacToe.markMove(2, 1, 5);
        //------------------ Board 3
        // o
        ticTacToe.markMove(1, 0, 8);
        // x
        ticTacToe.markMove(2, 0, 8);
        // o
        ticTacToe.markMove(1, 2, 8);
        // x
        ticTacToe.markMove(1, 1, 8);
        // o
        ticTacToe.markMove(2, 2, 8);
        // x
        ticTacToe.markMove(0, 2, 8);
        assertTrue(ticTacToe.checkTicTacToe());
    }

    @Test
    public void winnerX() {
        ticTacToe.createUltimate();
        //---------------- Board 1
        ticTacToe.markMove(2, 1, 1);
        ticTacToe.markMove(0, 2, 1);
        ticTacToe.markMove(1, 1, 1);
        ticTacToe.markMove(1, 2, 1);
        ticTacToe.markMove(0, 1, 1);
        //------------------ Board 2
        ticTacToe.markMove(0, 2, 4);
        ticTacToe.markMove(1, 1, 4);
        ticTacToe.markMove(1, 2, 4);
        ticTacToe.markMove(0, 1, 4);
        ticTacToe.markMove(0, 0, 4);
        ticTacToe.markMove(2, 1, 4);
        //------------------ Board 3
        ticTacToe.markMove(1, 0, 7);
        ticTacToe.markMove(2, 0, 7);
        ticTacToe.markMove(1, 2, 7);
        ticTacToe.markMove(1, 1, 7);
        ticTacToe.markMove(2, 2, 7);
        ticTacToe.markMove(0, 2, 7);
        assertEquals('X', ticTacToe.winner());
    }

    @Test
    public void winnerO() {
        ticTacToe.createUltimate();
        //---------------- Board 1
        ticTacToe.markMove(0, 0, 2);
        ticTacToe.markMove(1, 1, 2);
        ticTacToe.markMove(1, 2, 2);
        ticTacToe.markMove(2, 0, 2);
        ticTacToe.markMove(0, 1, 2);
        ticTacToe.markMove(0, 2, 2);
        //------------------ Board 2
        ticTacToe.markMove(1, 0, 5);
        ticTacToe.markMove(2, 2, 5);
        ticTacToe.markMove(0, 1, 5);
        ticTacToe.markMove(1, 1, 5);
        ticTacToe.markMove(2, 1, 5);
        ticTacToe.markMove(0, 0, 5);
        ticTacToe.markMove(2, 1, 5);
        //------------------ Board 3
        ticTacToe.markMove(1, 0, 8);
        ticTacToe.markMove(2, 0, 8);
        ticTacToe.markMove(1, 2, 8);
        ticTacToe.markMove(0, 1, 8);
        ticTacToe.markMove(1, 1, 8);
        ticTacToe.markMove(0, 2, 8);
        assertEquals('O', ticTacToe.winner());
    }

    @Test
    public void drawIsTrue() {
        ticTacToe.markMove(0, 0, 0);
        ticTacToe.markMove(0, 2, 0);
        ticTacToe.markMove(1, 1, 0);
        ticTacToe.markMove(2, 0, 0);
        ticTacToe.markMove(2, 2, 0);
        ticTacToe.markMove(0, 0, 1);
        ticTacToe.markMove(0, 2, 1);
        ticTacToe.markMove(1, 1, 1);
        ticTacToe.markMove(2, 0, 1);
        ticTacToe.markMove(2, 2, 1);
        ticTacToe.markMove(0, 0, 2);
        ticTacToe.markMove(0, 2, 2);
        ticTacToe.markMove(1, 1, 2);
        ticTacToe.markMove(2, 0, 2);
        ticTacToe.markMove(2, 2, 2);
        ticTacToe.markMove(1, 0, 3);
        ticTacToe.markMove(0, 0, 3);
        ticTacToe.markMove(0, 2, 3);
        ticTacToe.markMove(1, 1, 3);
        ticTacToe.markMove(2, 0, 3);
        ticTacToe.markMove(2, 2, 3);
        ticTacToe.markMove(0, 0, 4);
        ticTacToe.markMove(0, 2, 4);
        ticTacToe.markMove(1, 1, 4);
        ticTacToe.markMove(2, 0, 4);
        ticTacToe.markMove(2, 2, 4);
        ticTacToe.markMove(0, 0, 5);
        ticTacToe.markMove(0, 2, 5);
        ticTacToe.markMove(1, 1, 5);
        ticTacToe.markMove(2, 0, 5);
        ticTacToe.markMove(2, 2, 5);
        ticTacToe.markMove(0, 0, 6);
        ticTacToe.markMove(0, 2, 6);
        ticTacToe.markMove(1, 1, 6);
        ticTacToe.markMove(2, 0, 6);
        ticTacToe.markMove(2, 2, 6);
        ticTacToe.markMove(0, 0, 7);
        ticTacToe.markMove(0, 2, 7);
        ticTacToe.markMove(1, 1, 7);
        ticTacToe.markMove(2, 0, 7);
        ticTacToe.markMove(2, 2, 7);
        ticTacToe.markMove(0, 0, 8);
        ticTacToe.markMove(0, 2, 8);
        ticTacToe.markMove(1, 1, 8);
        ticTacToe.markMove(2, 0, 8);
        ticTacToe.markMove(2, 2, 8);
        ticTacToe.getLocalBoard();
        assertTrue(ticTacToe.draw());

    }

    @Test
    public void drawIsFalse() {
        UltimateTicTacToe ultimateTicTacToe = new UltimateTicTacToe();

        ultimateTicTacToe.markMove(0, 0, 0);
        ultimateTicTacToe.markMove(0, 2, 0);
        ultimateTicTacToe.markMove(1, 1, 0);
        ultimateTicTacToe.markMove(2, 0, 0);
        ultimateTicTacToe.markMove(2, 2, 0);
        ultimateTicTacToe.markMove(0, 0, 1);
        ultimateTicTacToe.markMove(0, 2, 1);
        ultimateTicTacToe.markMove(1, 1, 1);
        ultimateTicTacToe.markMove(2, 0, 1);
        ultimateTicTacToe.markMove(2, 2, 1);
        ultimateTicTacToe.markMove(0, 0, 2);
        ultimateTicTacToe.markMove(0, 2, 2);
        ultimateTicTacToe.markMove(1, 1, 2);
        ultimateTicTacToe.markMove(2, 0, 2);
        ultimateTicTacToe.markMove(2, 2, 2);
        ultimateTicTacToe.markMove(1, 0, 3);
        ultimateTicTacToe.markMove(0, 0, 3);
        ultimateTicTacToe.markMove(0, 2, 3);
        ultimateTicTacToe.markMove(1, 1, 3);
        ultimateTicTacToe.markMove(2, 0, 3);
        ultimateTicTacToe.markMove(2, 2, 3);
        ultimateTicTacToe.markMove(0, 0, 4);
        ultimateTicTacToe.markMove(0, 2, 4);
        ultimateTicTacToe.markMove(1, 1, 4);
        ultimateTicTacToe.markMove(2, 0, 4);
        ultimateTicTacToe.markMove(2, 2, 4);
        ultimateTicTacToe.markMove(0, 0, 5);
        ultimateTicTacToe.markMove(0, 2, 5);
        ultimateTicTacToe.markMove(1, 1, 5);
        ultimateTicTacToe.markMove(2, 0, 5);
        ultimateTicTacToe.markMove(2, 2, 5);
        ultimateTicTacToe.markMove(0, 0, 6);
        ultimateTicTacToe.markMove(0, 2, 6);
        ultimateTicTacToe.markMove(1, 1, 6);
        ultimateTicTacToe.markMove(2, 0, 6);
        ultimateTicTacToe.markMove(2, 2, 6);
        ultimateTicTacToe.markMove(0, 0, 7);
        ultimateTicTacToe.markMove(0, 2, 7);
        ultimateTicTacToe.markMove(1, 1, 7);
        ultimateTicTacToe.markMove(2, 0, 7);
        ultimateTicTacToe.markMove(2, 2, 7);
        ultimateTicTacToe.markMove(0, 0, 8);
        ultimateTicTacToe.markMove(0, 2, 8);
        ultimateTicTacToe.markMove(1, 1, 8);
        ultimateTicTacToe.markMove(2, 0, 8);
        ultimateTicTacToe.markMove(2, 2, 8);
        assertFalse(ticTacToe.draw());
    }
}
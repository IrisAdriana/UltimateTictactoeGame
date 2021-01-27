import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.tictactoe.ITicTacToe;
import tictactoe.backend.tictactoe.TicTacToe;

public class TicTacToeTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createBoard() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        Assert.assertNotNull(ticTacToe.getBoard());
    }

    @Test
    public void markMoveXValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        boolean status = ticTacToe.markMove(1, 1);
        Assert.assertTrue(status);
    }

    @Test
    public void markMoveOValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        boolean status = ticTacToe.markMove(1, 1);
        Assert.assertTrue(status);
    }

    @Test
    public void markMoveXRemarkNotValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(2, 2);
        boolean status = ticTacToe.markMove(2, 2);
        Assert.assertFalse(status);
    }

    @Test
    public void markMoveORemarkNotValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(1, 2);
        boolean status = ticTacToe.markMove(1, 2);
        Assert.assertFalse(status);
    }

    @Test
    public void markMoveXLimitRowAndColumnNotValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        boolean status = ticTacToe.markMove(5, 3);
        Assert.assertFalse(status);
    }

    @Test
    public void checkTicTacToeRowValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 1);
        ticTacToe.markMove(1, 2);
        boolean thereAreTicTacToe = ticTacToe.checkTicTacToe();
        Assert.assertTrue(thereAreTicTacToe);
    }

    @Test
    public void checkTicTacToeColumnValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(2, 1);
        boolean thereAreTicTacToe = ticTacToe.checkTicTacToe();
        Assert.assertTrue(thereAreTicTacToe);
    }

    @Test
    public void checkTicTacToeDiagonalValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(2, 0);
        boolean thereAreTicTacToe = ticTacToe.checkTicTacToe();
        Assert.assertTrue(thereAreTicTacToe);
    }

    @Test
    public void checkTicTacToeNotValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(1, 2);
        boolean thereAreTicTacToe = ticTacToe.checkTicTacToe();
        Assert.assertFalse(thereAreTicTacToe);
    }

    @Test
    public void winnerXRow() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(2, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 2);
        ticTacToe.checkTicTacToe();
        char winner = ticTacToe.winner();
        Assert.assertEquals('X', winner);
    }

    @Test
    public void winnerXColumn() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(2, 2);
        ticTacToe.checkTicTacToe();
        char winner = ticTacToe.winner();
        Assert.assertEquals('O', winner);
    }

    @Test
    public void winnerXDiagonal() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(2, 2);
        ticTacToe.checkTicTacToe();
        char winner = ticTacToe.winner();
        Assert.assertEquals('X', winner);
    }

    @Test
    public void drawValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(0, 2);
        ticTacToe.markMove(1, 0);
        ticTacToe.markMove(1, 2);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(2, 2);
        ticTacToe.markMove(2, 1);
        boolean isDraw = ticTacToe.draw();
        Assert.assertTrue(isDraw);
    }

    @Test
    public void drawNotValid() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(2, 0);
        ticTacToe.markMove(2, 2);
        ticTacToe.checkTicTacToe();
        boolean isDraw = ticTacToe.draw();
        Assert.assertFalse(isDraw);
    }

    @Test
    public void getBoardEmpty() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        char[][] board1 = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
        char[][] board2 = ticTacToe.getBoard();
        Assert.assertArrayEquals(board1, board2);
    }

    @Test
    public void getBoardHalfFull() {
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0, 0);
        ticTacToe.markMove(2, 1);
        ticTacToe.markMove(0, 1);
        ticTacToe.markMove(1, 1);
        ticTacToe.markMove(0, 2);
        char[][] board1 = {{'X', 'X', 'X'}, {'\0', 'O', '\0'}, {'\0', 'O', '\0'}};
        char[][] board2 = ticTacToe.getBoard();
        Assert.assertArrayEquals(board1, board2);
    }

    @Test
    public void getBoard() {
        ITicTacToe ticTacToe = new TicTacToe();
        char[][] board1 = { {'\0', '\0', '\0'},
                            {'\0', '\0', '\0'},
                            {'\0', '\0', '\0'}};
        char[][] board2 = ticTacToe.getBoard();
        Assert.assertArrayEquals(board1, board2);

    }

    /*@Test
    public void getBoardFull(){
        ITicTacToe ticTacToe = new TicTacToe();
        ticTacToe.create();
        ticTacToe.markMove(0,0);
        ticTacToe.markMove(0,1);
        ticTacToe.markMove(0,2);
        ticTacToe.markMove(1,0);
        ticTacToe.markMove(1,2);
        ticTacToe.markMove(1,1);
        ticTacToe.markMove(2,0);
        ticTacToe.markMove(2,2);
        ticTacToe.markMove(2,1);
        char[][] board1 = {{'X','O','X'},{'O','O','X'},{'X','X','O'}};
        char[][] board2 = ticTacToe.getBoard();
        Assert.assertArrayEquals(board1, board2);
    }*/

}
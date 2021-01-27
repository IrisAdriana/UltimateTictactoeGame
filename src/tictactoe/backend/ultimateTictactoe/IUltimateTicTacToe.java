package tictactoe.backend.ultimateTictactoe;

import java.util.List;

public interface IUltimateTicTacToe {

    void createUltimate();

    List<char[][]> getLocalBoard();

    boolean markMove(int row, int column, int numberBoard);

    boolean checkTicTacToe();

    char winner();

    boolean draw();

    boolean enableTicTacToe(int numberBoard);
}

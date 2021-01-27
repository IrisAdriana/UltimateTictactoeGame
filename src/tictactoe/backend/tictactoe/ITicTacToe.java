package tictactoe.backend.tictactoe;

import tictactoe.backend.IObservable;

public interface ITicTacToe extends IObservable {

    void create();

    boolean markMove(int row, int column);

    boolean checkTicTacToe();

    char winner();

    boolean draw();

    char[][] getBoard();
}

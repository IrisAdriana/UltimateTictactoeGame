package tictactoe.backend.ultimateTictactoe;

import tictactoe.backend.*;
import tictactoe.backend.tictactoe.ITicTacToe;
import tictactoe.backend.tictactoe.TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class UltimateTicTacToe extends TicTacToe implements IUltimateTicTacToe {

    private char[][] globalBoard;
    private List<ITicTacToe> localBoard;
    private IConvert convert;
    private ITicTacToe localTicTacToe;
    private int SIZE;
    private int numberMove;
    private IPlayer player;
    private List<Boolean> enableLocalTicTacToe;
    private char winner;
    private boolean validCell;


    public UltimateTicTacToe() {
        SIZE = 3;
        globalBoard = new char[SIZE][SIZE];
        localBoard = new ArrayList<>();
        convert = new Convert(SIZE);
        player = new Player();
        enableLocalTicTacToe = new ArrayList<>();
        this.createUltimate();
    }

    public void createUltimate() {
        winner = '\0';
        numberMove = 0;
        for (int i = 0; i < 9; i++) {
            localBoard.add(new TicTacToe(player));
            enableLocalTicTacToe.add(true);
        }
    }

    public List<char[][]> getLocalBoard() {
        ArrayList<char[][]> board = new ArrayList<>();
        for (ITicTacToe localTicTacToe : localBoard) {
            if (localTicTacToe.checkTicTacToe()) {
                board.add(fillBoard(localTicTacToe));
            } else {
                board.add(localTicTacToe.getBoard());
            }
        }
        return board;
    }

    public boolean markMove(int row, int column, int numberBoard) {
        boolean mark = false;
        ITicTacToe localTicTacToe = localBoard.get(numberBoard);
        if (enableTicTacToe(numberBoard)) {
            if (localTicTacToe.markMove(row, column)) {
                markMoveGlobal(convert.row(numberBoard + 1), convert.column(numberBoard + 1), numberBoard);
                mark = true;
            }
        }
        return mark;
    }

    private void markMoveGlobal(int row, int column, int numberBoard) {
        localTicTacToe = localBoard.get(numberBoard);
        if (!checkTicTacToe() && localTicTacToe.checkTicTacToe()) {
            globalBoard[row][column] = localTicTacToe.winner();
            changeEnableLocalBoard(numberBoard);
            numberMove++;
        }
    }

    public boolean checkTicTacToe() {
        return rowWinner() || columnWinner() || diagonalWinner();
    }

    private boolean checkRowCol(char firstCell, char secondCell, char thirdCell) {
        if (firstCell == 'X' && secondCell == 'X' && thirdCell == 'X') {
            return true;
        } else {
            return firstCell == 'O' && secondCell == 'O' && thirdCell == 'O';
        }
    }

    private boolean rowWinner() {
        for (char[] row : globalBoard) {
            if (checkRowCol(row[0], row[1], row[2])) {
                validCell = true;
            }
        }
        return validCell;
    }

    private boolean columnWinner() {
        for (int column = 0; column < globalBoard.length; column++) {
            if (checkRowCol(globalBoard[0][column],
                    globalBoard[1][column],
                    globalBoard[2][column])) {
                validCell = true;
            }
        }
        return validCell;
    }

    private boolean diagonalWinner() {
        return ((checkRowCol(globalBoard[0][0], globalBoard[1][1], globalBoard[2][2]))
                || (checkRowCol(globalBoard[0][2], globalBoard[1][1], globalBoard[2][0])));
    }

    public char winner() {
        if (checkTicTacToe()) {
            player.changePlayer();
            winner = 'X';
        } else winner = 'O';
        return winner;
    }

    public boolean draw() {
        boolean is = false;
        if (fullBoard() && winner == '\0') {
            is = true;
        }
        return is;
    }

    private boolean fullBoard() {
        boolean full = false;
        if (9 == numberMove) {
            full = true;
        }
        return full;
    }

    private void changeEnableLocalBoard(int numberBoard) {
        enableLocalTicTacToe.set(numberBoard, false);
    }

    public boolean enableTicTacToe(int numberBoard) {
        return enableLocalTicTacToe.get(numberBoard);
    }

    private char[][] fillBoard(ITicTacToe board) {
        char[][] fillBoard = new char[SIZE][SIZE];
        char piece = board.winner();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                fillBoard[i][j] = piece;
            }
        }
        return fillBoard;
    }
}

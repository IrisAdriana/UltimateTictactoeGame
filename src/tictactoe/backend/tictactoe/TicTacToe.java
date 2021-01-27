package tictactoe.backend.tictactoe;

import tictactoe.backend.IPlayer;
import tictactoe.backend.Player;
import tictactoe.controller.MyEvent;
import tictactoe.frontend.tictactoe.ITicTacToeUI;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements ITicTacToe {
    private final char[][] board;
    private final int SIZE;
    private final List<ITicTacToeUI> support;
    private int numberMove;
    private char turn;
    private char winner;
    private IPlayer player;

    public TicTacToe() {
        SIZE = 3;
        board = new char[SIZE][SIZE];
        player = new Player();
        support = new ArrayList<>();
        create();
    }

    public TicTacToe(IPlayer player) {
        SIZE = 3;
        board = new char[SIZE][SIZE];
        this.player = player;
        support = new ArrayList<>();
        create();
    }

    @Override
    public void create() {
        numberMove = 0;
        turn = player.getPlayer();
        winner = '\0';
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '\0';
            }
        }
        notifyListener(new MyEvent(this, "create", false, true));
    }

    @Override
    public boolean markMove(int row, int column) {
        boolean mark = false;
        if (!checkTicTacToe()) {
            if (checkLimits(row) && checkLimits(column)) {
                if (markBox(row, column)) {
                    mark = true;
                    numberMove++;
                    player.changePlayer();
                    notifyListener(new MyEvent(this, "markMove", false, true));
                }
            }
        }
        return mark;
    }

    @Override
    public boolean checkTicTacToe() {
        boolean thereIs = false;
        if (numberMove >= 0) {
            if (rowWinner() || columnWinner() || diagonalWinner()) {
                thereIs = true;
                notifyListener(new MyEvent(this, "winner", false, true));
            }
        }
        return thereIs;
    }

    @Override
    public char winner() {
        return winner;
    }

    @Override
    public boolean draw() {
        boolean is = false;
        if (finish() && winner == '\0') {
            is = true;
        }
        return is;
    }

    @Override
    public char[][] getBoard() {
        char[][] boardShape = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, boardShape[i], 0, SIZE);
        }
        return boardShape;
    }

    private boolean checkLimits(int value) {
        boolean check = false;
        int limitMin = 0;
        int limitMax = 3;
        if (value >= limitMin && value < limitMax) {
            check = true;
        }
        return check;
    }

    private boolean markBox(int row, int column) {
        boolean mark = false;
        if (checkBox(row, column)) {
            board[row][column] = player.getPlayer();
            mark = true;
        }
        return mark;
    }

    private boolean checkBox(int row, int column) {
        boolean status = false;
        if ('\0' == board[row][column]) {
            status = true;
        }
        return status;
    }

    private boolean rowWinner() {
        boolean earner = false;
        int counterX;
        int counterO;
        for (int i = 0; i < SIZE; i++) {
            counterX = 0;
            counterO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'X') {
                    counterX++;
                }
                if (board[i][j] == 'O') {
                    counterO++;
                }
            }
            if (counterX == 3 || counterO == 3) {
                getWinner(counterX, counterO);
                earner = true;
            }
        }
        return earner;
    }

    private boolean columnWinner() {
        boolean earner = false;
        int counterX;
        int counterO;
        for (int i = 0; i < SIZE; i++) {
            counterX = 0;
            counterO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == 'X') {
                    counterX++;
                }
                if (board[j][i] == 'O') {
                    counterO++;
                }
            }
            if (counterX == 3 || counterO == 3) {
                getWinner(counterX, counterO);
                earner = true;
            }
        }
        return earner;
    }

    private boolean diagonalWinner() {
        boolean earner = false;
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'X') {
                counterX++;
            }
            if (board[i][i] == 'O') {
                counterO++;
            }
        }
        if (counterX == 3 || counterO == 3) {
            getWinner(counterX, counterO);
            earner = true;
        }
        counterX = 0;
        counterO = 0;
        for (int i = 2; i >= 0; i--) {
            if (board[i][2 - i] == 'X') {
                counterX++;
            }
            if (board[i][2 - i] == 'O') {
                counterO++;
            }
        }
        if (counterX == 3 || counterO == 3) {
            getWinner(counterX, counterO);
            earner = true;
        }
        return earner;
    }

    private void getWinner(int counterX, int counterO) {
        if (counterX == 3) {
            winner = 'X';
        }
        if (counterO == 3) {
            winner = 'O';
        }
    }

    private boolean finish() {
        boolean full = false;
        int numberBox = SIZE * SIZE;
        if (numberBox == numberMove) {
            full = true;
        }
        return full;
    }

    private void notifyListener(MyEvent event) {
        for (ITicTacToeUI ui : support) {
            ui.update(event);
        }
    }

    @Override
    public void addListener(ITicTacToeUI tictactoeUI) {
        support.add(tictactoeUI);
    }
}

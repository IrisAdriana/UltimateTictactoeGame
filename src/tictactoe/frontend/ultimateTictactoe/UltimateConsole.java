package tictactoe.frontend.ultimateTictactoe;

import tictactoe.backend.*;
import tictactoe.backend.ultimateTictactoe.IUltimateTicTacToe;
import tictactoe.helper.*;

import java.util.List;

public class UltimateConsole {

    private IUltimateTicTacToe ultimateTicTacToe;
    private IHelper helper;
    private IColor color;
    private IMessage message;
    private IPlayer player;
    private IConvert convert;
    private int numberBoard;
    private int number;
    private char piece;

    public UltimateConsole(IUltimateTicTacToe ultimateTicTacToe) {
        this.ultimateTicTacToe = ultimateTicTacToe;
        helper = new Helper();
        message = new Message();
        color = new Color();
        convert = new Convert(3);
        piece = 'X';
        player = new Player();
    }

    public void run() {
        message.titleMessage();
        play();
    }

    private void play() {
        message.startMessage();
        showBoardGame();
        System.out.println();
        message.boardNumberMessage();
        numberBoard = helper.enterNumber(11, "board");
        while (true) {
            movePlayer();
            player.changePlayer();
            showBoardGame();
            checkStatusGame();
            checkBoard();
        }
    }

    private void movePlayer() {
        System.out.println(color.yellow() + "\n---> Board: " + numberBoard + color.reset());
        System.out.print("- enter the play number " + player.getPlayer() + " : ");
        number = helper.enterNumber(11, "play number");
        if (number == 10) {
            ultimateTicTacToe.createUltimate();
        } else {
            if (number == 11) {
                System.out.println(message.finishGameMessage());
                System.exit(0);
            } else {
                if (!ultimateTicTacToe.markMove(convert.row(number), convert.column(number), numberBoard - 1)) {
                    System.out.println(color.red() +
                            "***play not valid, box already checked" + color.reset());
                    movePlayer();
                }
            }
        }
    }

    private void checkStatusGame() {
        if (ultimateTicTacToe.checkTicTacToe()) {
            char winner = ultimateTicTacToe.winner();
            System.out.println(message.winnerMessage(winner) + "\n");
            message.subMenuMessage();
        } else {
            if (ultimateTicTacToe.draw()) {
                System.out.println(message.drawMessage() + "\n");
                message.subMenuMessage();
            }
        }
    }

    private void checkBoard() {
        numberBoard = number;
        if (!ultimateTicTacToe.enableTicTacToe(numberBoard - 1)) {
            message.boardNumberMessage();
            numberBoard = helper.enterNumber(11, "board");
        }
    }

    public void showBoardGame() {

        List<char[][]> globalBoard = ultimateTicTacToe.getLocalBoard();
        showBoardGameLocal(globalBoard.get(0), globalBoard.get(1), globalBoard.get(2));
        System.out.println(color.yellow() + "===================================================" +
                color.reset());
        showBoardGameLocal(globalBoard.get(3), globalBoard.get(4), globalBoard.get(5));
        System.out.println(color.yellow() + "===================================================" +
                color.reset());
        showBoardGameLocal(globalBoard.get(6), globalBoard.get(7), globalBoard.get(8));
    }

    private void showBoardGameLocal(char[][] localBoard1, char[][] localBoard2, char[][] localBoard3) {
        for (int row = 0; row < localBoard1.length; row++) {
            print(row, localBoard1);
            System.out.print(color.yellow() + " # " + color.reset());
            print(row, localBoard2);
            System.out.print(color.yellow() + " # " + color.reset());
            print(row, localBoard3);
            System.out.println();
        }
    }

    private void print(int index, char[][] board) {
        char[] chars = board[index];
        for (int j = 0; j < board.length; j++) {
            char box = chars[j];
            if (box == 'X') {
                System.out.print(color.purple() + "[ " + box + " ]" + color.reset());
            } else {
                if (box == 'O') {
                    System.out.print(color.cyan() + "[ " + box + " ]" + color.reset());
                } else {
                    System.out.print("[   ]");
                }
            }
        }
    }
}

package tictactoe.frontend.tictactoe;

import tictactoe.backend.*;
import tictactoe.backend.tictactoe.ITicTacToe;
import tictactoe.controller.MyEvent;
import tictactoe.frontend.tictactoe.ITicTacToeUI;
import tictactoe.helper.*;

public class Console implements ITicTacToeUI {
    private final ITicTacToe game;
    private final IHelper helper;
    private final IColor color;
    private final IConvert convert;
    private final IMessage message;
    private final IPlayer player;
    private String piece;

    public Console(ITicTacToe game) {
        this.game = game;
        this.game.addListener(this);
        helper = new Helper();
        color = new Color();
        convert = new Convert(3);
        message = new Message();
        player = new Player();
        piece = "X";
    }

    @Override
    public void run() {
        setLabelsGameInit();
        play();
    }

    @Override
    public void update(MyEvent event) {
        if (event.getPropertyName().equals("markMove")) {
            player.changePlayer();
            showBoardGame();
            checkStatusGame();
        }
        if (event.getPropertyName().equals("create")) {
            setLabelsMessagesOptionsInit();
        }
    }

    private void play() {
        setLabelsMessagesOptionsInit();
        while (true) {
            movePlayer();
        }
    }

    private void setLabelsGameInit() {
        System.out.println();
        message.titleMessage();
    }

    private void setLabelsMessagesOptionsInit() {
        piece = "X";
        System.out.println(color.blue() + "\n\nChoose a number from 1 to 9 for play" + color.reset());
        System.out.println(color.green() + "> Press 10 new game \n> Press 11 to the exit game" + color.reset());
        showBoardGame();
        System.out.print("- enter the play number " + piece + " : ");
    }

    private void movePlayer() {
        int number = helper.enterNumber(11, "play number");
        if (number == 10) {
            game.create();
        } else {
            if (number == 11) {
                System.out.println(message.finishGameMessage());
                System.exit(0);
            } else {
                if (!game.markMove(convert.row(number), convert.column(number))) {
                    System.out.println(color.red() + "***play not valid, box already checked" + color.reset());
                    System.out.print("- re-enter the play number: ");
                    movePlayer();
                }
            }
        }
    }

    private void checkStatusGame() {
        if (game.checkTicTacToe()) {
            char winner = game.winner();
            System.out.println(message.winnerMessage(winner) + "\n");
            message.subMenuMessage();
        } else {
            if (game.draw()) {
                System.out.println(message.drawMessage() + "\n");
                message.subMenuMessage();
            } else {
                System.out.print("- enter the play number " + piece + " : ");
            }
        }
    }

    private void showBoardGame() {
        char[][] boardPlay = game.getBoard();
        System.out.println();
        for (int i = 0; i < boardPlay.length; i++) {
            char[] chars = boardPlay[i];
            for (int j = 0; j < boardPlay.length; j++) {
                char box = chars[j];
                if (box == 'X') {
                    System.out.print("[ " + color.purple() + box + color.reset() + " ]");
                } else {
                    if (box == 'O') {
                        System.out.print("[ " + color.cyan() + box + color.reset() + " ]");
                    } else {
                        System.out.print("[   ]");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

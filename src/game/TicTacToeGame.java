package game;

import tictactoe.backend.tictactoe.ITicTacToe;
import tictactoe.backend.tictactoe.TicTacToe;
import tictactoe.frontend.tictactoe.Console;
import tictactoe.frontend.tictactoe.GUI;
import tictactoe.frontend.tictactoe.ITicTacToeUI;

public class TicTacToeGame implements IGame {

    private final ITicTacToeUI console;
    private final ITicTacToeUI gui;

    public TicTacToeGame() {
        ITicTacToe ticTacToe = new TicTacToe();
        console = new Console(ticTacToe);
        gui = new GUI(ticTacToe);
    }

    public void run() {
        gui.run();
        console.run();
    }

}

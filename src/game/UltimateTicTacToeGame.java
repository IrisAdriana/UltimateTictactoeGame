package game;

import tictactoe.backend.ultimateTictactoe.IUltimateTicTacToe;
import tictactoe.backend.ultimateTictactoe.UltimateTicTacToe;
import tictactoe.frontend.ultimateTictactoe.UltimateConsole;

public class UltimateTicTacToeGame implements IGame {

    private final UltimateConsole console;

    public UltimateTicTacToeGame() {
        IUltimateTicTacToe ultimateTicTacToe = new UltimateTicTacToe();
        console = new UltimateConsole(ultimateTicTacToe);
    }

    public void run() {
        console.run();
    }
}

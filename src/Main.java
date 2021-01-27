
import game.IGame;
import game.TicTacToeGame;
import game.UltimateTicTacToeGame;

public class Main {

    public static void main(String[] args) {
        IGame ultimateTicTacToe = new UltimateTicTacToeGame();
        IGame ticTacToe = new TicTacToeGame();


//descomentar para jugar tictactoe normal
        ticTacToe.run();

//descomentar para jugar tictactoe ultimate por consola
//        ultimateTicTacToe.run();
    }
}

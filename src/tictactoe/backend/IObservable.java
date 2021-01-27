package tictactoe.backend;

import tictactoe.frontend.tictactoe.ITicTacToeUI;

public interface IObservable{
    void addListener(ITicTacToeUI iTicTacToeUI);
}

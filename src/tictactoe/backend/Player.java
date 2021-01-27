package tictactoe.backend;

public class Player implements IPlayer{
    private char player;

    public Player() {
        player = 'X';
    }

    public char getPlayer() {
        return player;
    }

    public void changePlayer() {
        if (player == 'X') player = 'O';
        else player = 'X';
    }
}

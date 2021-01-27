import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.IPlayer;
import tictactoe.backend.Player;

import static org.junit.Assert.*;

public class PlayerTest {
    private IPlayer player;

    @Before
    public void init() {
        player = new Player();
    }

    @Test
    public void getPlayerX() {
        char playerX = player.getPlayer();
        assertEquals('X', playerX);
    }

    @Test
    public void getPlayerO() {
        player.changePlayer();
        char playerO = player.getPlayer();
        assertEquals('O', playerO);
    }
}
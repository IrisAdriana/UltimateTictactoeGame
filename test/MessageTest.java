import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.helper.Message;

public class MessageTest {
    private Message message;

    @Before
    public void init() {
        message = new Message();
    }

    @Test
    public void messageDrawGameValid() {
        String draw = message.drawMessage();
        Assert.assertEquals("It's a Draw ", draw);
    }

    @Test
    public void messageFinishGameValid() {
        String finish = message.finishGameMessage();
        Assert.assertEquals("Thanks for Play!!! ", finish);
    }


    @Test
    public void messageWinnerGameValid() {
        String winner = message.winnerMessage('X');
        Assert.assertEquals("The winner is X, Congratulations!!!!!!!", winner);
    }

}
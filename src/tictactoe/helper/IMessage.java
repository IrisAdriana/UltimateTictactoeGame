package tictactoe.helper;

public interface IMessage {
    void startMessage();

    void titleMessage();

    void subMenuMessage();

    String winnerMessage(char winner);

    String drawMessage();

    String finishGameMessage();

    void boardNumberMessage();
}

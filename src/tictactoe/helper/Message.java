package tictactoe.helper;

public class Message implements IMessage {
    private IColor color;

    public Message() {
        color = new Color();
    }

    public void startMessage() {
        System.out.println(color.blue() + "\n\nChoose a number from 1 to 9 for play" +
                color.reset());
        System.out.println(color.green() + "> Press 10 new game \n> Press 11 to the exit game\n" +
                color.reset());
    }

    public void titleMessage() {
        System.out.println();
        System.out.println(color.yellow() +
                "\n -----------  TIC TAC TOE 1.0 ----------- \n" +
                color.reset());
    }

    public void subMenuMessage() {
        System.out.println(color.green() + "> Press 10 new game \n> Press 11 to the exit game" +
                color.reset() + "\n");
        System.out.print("- enter the option: ");
    }

    public String winnerMessage(char winner) {
        return "The winner is " + winner + ", Congratulations!!!!!!!";
    }

    public String drawMessage() {
        return "It's a Draw ";
    }

    public String finishGameMessage() {
        return "Thanks for Play!!! ";
    }

    public void boardNumberMessage() {
        System.out.print(color.yellow() + " ----> enter the board number: " + color.reset());
    }
}

package tictactoe.backend;

public class Convert implements IConvert{

    private int parameter;

    public Convert(int parameter) {
        this.parameter = parameter;
    }

    public int row(int number){
        return (number - 1) / parameter;
    }

    public int column(int number){
        return (number - 1) % parameter;
    }
}

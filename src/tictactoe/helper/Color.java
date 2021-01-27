package tictactoe.helper;

public class Color implements IColor{

    public String red(){ return "\033[31m"; }

    public String green(){ return "\033[32m"; }

    public String yellow(){ return "\033[33m"; }

    public String blue(){ return "\033[34m"; }

    public String purple(){ return "\033[35m"; }

    public String cyan(){ return "\033[36m"; }

    public String reset(){ return "\u001B[0m"; }

}

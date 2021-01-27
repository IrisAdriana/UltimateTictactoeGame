package tictactoe.frontend;

import tictactoe.controller.MyEvent;

public interface IObserver{
    void update(MyEvent evt);
}

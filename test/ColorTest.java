import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.helper.Color;

public class ColorTest {
    private Color color;

    @Before
    public void init() {
        color = new Color();
    }

    @Test
    public void colorRedValid() {
        String red = color.red();
        Assert.assertEquals("\033[31m", red);
    }

    @Test
    public void colorGreenValid() {
        String green = color.green();
        Assert.assertEquals("\033[32m", green);
    }

    @Test
    public void colorYellowValid() {
        String yellow = color.yellow();
        Assert.assertEquals("\033[33m", yellow);
    }

    @Test
    public void colorBlueValid() {
        String blue = color.blue();
        Assert.assertEquals("\033[34m", blue);
    }

    @Test
    public void colorPurpleValid() {
        String purple = color.purple();
        Assert.assertEquals("\033[35m", purple);
    }

    @Test
    public void colorCyanValid() {
        String cyan = color.cyan();
        Assert.assertEquals("\033[36m", cyan);
    }

    @Test
    public void resetColorValid() {
        String reset = color.reset();
        Assert.assertEquals("\u001B[0m", reset);
    }

}
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tictactoe.helper.Helper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class HelperTest {
    private Helper helper;

    @Before
    public void init() {
        helper = new Helper();
    }

    @Test
    public void enterNumberValid() {
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int number = helper.enterNumber(9, "number play");
        Assert.assertEquals(7, number);
    }

    @Test
    public void enterNumberNotValid() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input = "2";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int number = helper.enterNumber(2, "number play");
        Assert.assertEquals(2, number);
    }
}
import org.junit.Before;
import org.junit.Test;
import tictactoe.backend.Convert;
import tictactoe.backend.IConvert;

import static org.junit.Assert.*;

public class ConvertTest {
    private IConvert convert;

    @Before
    public void init() {
        int parameter = 3;
        convert = new Convert(parameter);
    }

    @Test
    public void row() {
        int row = convert.row(5);
        assertEquals(row, 1);
    }

    @Test
    public void column() {
        int column = convert.column(9);
        assertEquals(column, 2);
    }
}
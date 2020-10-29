package utils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class ParseTest {

    private ParseValue parseValue = new ParseValue();

    @Test
    public void parseValueCheckValue() {

        assertEquals(parseValue.CheckPostive(0), false);
        assertEquals(parseValue.CheckPostive(100), true);
        assertEquals(parseValue.CheckPostive(-100), false);

        assertEquals(parseValue.plus100(100), 200);
        assertEquals(parseValue.plus100(-100), 0);

        //assertEquals(parseValue.GetSin(30), 100);

    }

}

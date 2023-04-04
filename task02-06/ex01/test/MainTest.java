package ex01;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testInit() {
        Сount count = new Сount();
        count.init(4);
        Visual result = count.getResult();
        assertEquals(4, result.getDecimalNumber());
        assertEquals(0, result.getTetradsCount());
    }

    @Test
    public void testSaveAndRestore() throws Exception {
        Сount calc = new Сount();
        calc.init(4);
        calc.save();

        Сount calc2 = new Сount();
        calc2.restore();

        assertEquals(calc.getResult().getDecimalNumber(), calc2.getResult().getDecimalNumber());
        assertEquals(calc.getResult().getTetradsCount(), calc2.getResult().getTetradsCount());
    }
    @Test
    public void testSetValuesAndGetters() {
        Visual item = new Visual();
        item.setValues(4, 4);

        assertEquals(4, item.getDecimalNumber());
        assertEquals(4, item.getTetradsCount());
    }

    @Test
    public void testToString() {
        Visual item = new Visual(4, 3);

        String expectedString = "Decimal number = 4, Tetrads count = 3";
        assertEquals(expectedString, item.toString());
    }

}
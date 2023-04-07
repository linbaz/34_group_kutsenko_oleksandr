package ex03;

import ex01.Visual;
import ex02.ViewResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class MainTest {

    private ViewResult viewResult;
    private ArrayList<Visual> items;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        viewResult = new ViewResult(3);
        items = viewResult.getItems();
    }

    @Test
    public void testCalc() {
        Map<String, Integer> expected = Map.of("tetradsCount", 1);
        Assert.assertEquals(expected, viewResult.calc(11));
    }

    @Test
    public void testInit() {
        viewResult.init(1.0);
        Assert.assertEquals(0.0, items.get(0).getDecimalNumber(), DELTA);
        Assert.assertEquals(1, items.get(0).getTetradsCount());
        Assert.assertEquals(1.0, items.get(1).getDecimalNumber(), DELTA);
        Assert.assertEquals(1, items.get(1).getTetradsCount());
        Assert.assertEquals(2.0, items.get(2).getDecimalNumber(), DELTA);
        Assert.assertEquals(1, items.get(2).getTetradsCount());
    }

    @Test
    public void testViewInit() {
        viewResult.viewInit();
        Assert.assertEquals(3, items.size());
    }

}
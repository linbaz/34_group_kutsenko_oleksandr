package ex02;

import ex01.Visual;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;


public class MainTest {
    private ViewResult view;

    public MainTest() {
        view = new ViewResult();
    }

    @Before
    public void setUp() {
        view = new ViewResult();
    }

    @Test
    public void testGetItems() {
        ArrayList<Visual> items = view.getItems();
        assertNotNull(items);
        assertEquals(ViewResult.DEFAULT_NUM, items.size());
    }

    @Test
    public void testCalc() {
        Map<String, Integer> result = view.calc(10.0);
        assertNotNull(result);
        assertTrue(result.containsKey("tetradsCount"));
        assertEquals(1, (int) result.get("tetradsCount"));
    }

    @Test
    public void testInit() {
        view.init(1.0);
        ArrayList<Visual> items = view.getItems();
        assertNotNull(items);
        assertEquals(ViewResult.DEFAULT_NUM, items.size());
        int expectedDecimalNumber = 0;
        for (Visual item : items) {
            assertEquals(expectedDecimalNumber, item.getDecimalNumber());
            expectedDecimalNumber++;
        }
    }

    @Test
    public void testViewSaveAndRestore() throws Exception {
        view.init(1.0);
        view.viewSave();
        ArrayList<Visual> itemsBeforeRestore = view.getItems();
        view.viewRestore();
        ArrayList<Visual> itemsAfterRestore = view.getItems();
        assertNotNull(itemsBeforeRestore);
        assertNotNull(itemsAfterRestore);
        assertEquals(itemsBeforeRestore.size(), itemsAfterRestore.size());
        for (int i = 0; i < itemsBeforeRestore.size(); i++) {
            Visual itemBeforeRestore = itemsBeforeRestore.get(i);
            Visual itemAfterRestore = itemsAfterRestore.get(i);
            assertEquals(itemBeforeRestore.getDecimalNumber(), itemAfterRestore.getDecimalNumber());
            assertEquals(itemBeforeRestore.getTetradsCount(), itemAfterRestore.getTetradsCount());
        }
    }

    @Test
    public void testViewShow() {
        view.init(1.0);
        view.viewShow();
        // manually verify output
    }
}
package ex04;


import ex01.Visual;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import ex02.ViewResult;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;
import java.util.Optional;



public class MainTest {

    private ViewResult viewResult;
    private String fileName = "items.bin";

    @BeforeEach
    public void setUp() {
        viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
    }

    @Test
    public void testGetItems() {
        ArrayList<Visual> items = viewResult.getItems();
        assertNotNull(items);
        assertEquals(10, items.size());
    }

    @Test
    public void testCalc() {
        double decimalNumber = 27.0;
        int expectedTetradsCount = 2;
        Map<String, Integer> result = viewResult.calc(decimalNumber);
        assertNotNull(result);
        assertEquals(Optional.of(expectedTetradsCount), result.get("tetradsCount"));
    }

    @Test
    public void testViewInit() {
        viewResult.viewInit();
        ArrayList<Visual> items = viewResult.getItems();
        assertNotNull(items);
        assertEquals(10, items.size());
    }

    @Test
    public void testViewSaveAndRestore() {
        final String fileName = "items.bin";
        ViewResult viewResult1 = new ViewResult(5) {
            @Override
            public void viewSave() throws IOException {

            }
        };

        try {
            viewResult1.viewSave(fileName);
            File file = new File(fileName);
            assertTrue(file.exists());

            viewResult1.getItems().clear();
            viewResult1.viewRestore(fileName);
            ArrayList<Visual> items1 = viewResult1.getItems();
            assertNotNull(items1);
            assertEquals(5, items1.size());

            ViewResult viewResult2 = new ViewResult(10) {
                @Override
                public void viewSave() throws IOException {

                }
            };
            viewResult2.viewRestore(fileName);
            ArrayList<Visual> items2 = viewResult2.getItems();
            assertNotNull(items2);
            assertEquals(5, items2.size());

        } catch (IOException | ClassNotFoundException e) {
            fail("An exception was thrown: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Clean up the file
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
package ex05;

import static org.junit.Assert.*;
import org.junit.Test;
import ex02.ViewResult;
import ex02.Visual;

import java.io.IOException;

public class MainTest {
    @Test
    public void testAvgCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        Visual firstItem = new Visual(2, 2);
        Visual secondItem = new Visual(4, 4);
        Visual thirdItem = new Visual(6, 6);
        viewResult.getItems().add(firstItem);
        viewResult.getItems().add(secondItem);
        viewResult.getItems().add(thirdItem);
        AvgCommand avgCommand = new AvgCommand(viewResult);
        avgCommand.execute();
        double expectedAvg = 0.9230769230769231;
        double actualAvg = avgCommand.getResult();
        double delta = 0.001;
        assertEquals(expectedAvg, actualAvg, delta);
    }

    @Test
    public void testMaxCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        Visual firstItem = new Visual(2, 2);
        Visual secondItem = new Visual(4, 4);
        Visual thirdItem = new Visual(6, 6);
        viewResult.getItems().add(firstItem);
        viewResult.getItems().add(secondItem);
        viewResult.getItems().add(thirdItem);
        MaxCommand maxCommand = new MaxCommand(viewResult);
        maxCommand.execute();
        int expectedMax = 12;
        int actualMax = maxCommand.getResult();
        assertEquals(expectedMax, actualMax);
    }

    @Test
    public void testMinMaxCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        Visual firstItem = new Visual(2, 2);
        Visual secondItem = new Visual(4, 4);
        Visual thirdItem = new Visual(-6, 6);
        Visual fourthItem = new Visual(-8, 8);
        Visual fifthItem = new Visual(-10, 10);
        viewResult.getItems().add(firstItem);
        viewResult.getItems().add(secondItem);
        viewResult.getItems().add(thirdItem);
        viewResult.getItems().add(fourthItem);
        viewResult.getItems().add(fifthItem);
        MinMaxCommand minMaxCommand = new MinMaxCommand(viewResult);
        minMaxCommand.execute();
        int expectedMin = 0;
        int actualMin = minMaxCommand.getResultMin();
        assertEquals(expectedMin, actualMin);
        int expectedMax = -1;
        int actualMax = minMaxCommand.getResultMax();
        assertEquals(expectedMax, actualMax);
    }
}

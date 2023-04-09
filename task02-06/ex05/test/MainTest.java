package ex05;

import static org.junit.Assert.*;
import org.junit.Test;
import ex02.ViewResult;
import ex02.Item2d;

import java.io.IOException;

public class MainTest {
    @Test
    public void testAvgCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        Item2d firstItem = new Item2d(2, 2);
        Item2d secondItem = new Item2d(4, 4);
        Item2d thirdItem = new Item2d(6, 6);
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
        Item2d firstItem = new Item2d(2, 2);
        Item2d secondItem = new Item2d(4, 4);
        Item2d thirdItem = new Item2d(6, 6);
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
        Item2d firstItem = new Item2d(2, 2);
        Item2d secondItem = new Item2d(4, 4);
        Item2d thirdItem = new Item2d(-6, 6);
        Item2d fourthItem = new Item2d(-8, 8);
        Item2d fifthItem = new Item2d(-10, 10);
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

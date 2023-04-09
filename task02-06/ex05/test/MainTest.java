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
        viewResult.getItems().add(new Item2d(2, 2));
        viewResult.getItems().add(new Item2d(4, 4));
        viewResult.getItems().add(new Item2d(6, 6));
        AvgCommand avgCommand = new AvgCommand(viewResult);
        avgCommand.execute();
        assertEquals(0.9230769230769231, avgCommand.getResult(), 0.001);
    }

    @Test
    public void testMaxCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        viewResult.getItems().add(new Item2d(2, 2));
        viewResult.getItems().add(new Item2d(4, 4));
        viewResult.getItems().add(new Item2d(6, 6));
        MaxCommand maxCommand = new MaxCommand(viewResult);
        maxCommand.execute();
        assertEquals(12, maxCommand.getResult());
    }

    @Test
    public void testMinMaxCommand() {
        ViewResult viewResult = new ViewResult() {
            @Override
            public void viewSave() throws IOException {

            }
        };
        viewResult.getItems().add(new Item2d(2, 2));
        viewResult.getItems().add(new Item2d(4, 4));
        viewResult.getItems().add(new Item2d(-6, 6));
        viewResult.getItems().add(new Item2d(-8, 8));
        viewResult.getItems().add(new Item2d(-10, 10));
        MinMaxCommand minMaxCommand = new MinMaxCommand(viewResult);
        minMaxCommand.execute();
        assertEquals(0, minMaxCommand.getResultMin());
        assertEquals(-1, minMaxCommand.getResultMax());
    }
}




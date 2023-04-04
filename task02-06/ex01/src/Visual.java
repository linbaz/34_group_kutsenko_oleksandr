package ex01;

import java.io.Serializable;
/** Хранит исходные данные и результат вычислений.
 * @author xone
 * @version 1.0
 */
public class Visual implements Serializable {
    private int decimalNumber;
    private int tetradsCount;
    public Visual() {
        decimalNumber = 0;
        tetradsCount = 0;
    }

    public Visual(int decimalNumber, int tetradsCount) {
        this.decimalNumber = decimalNumber;
        this.tetradsCount = tetradsCount;
    }

    public int setDecimalNumber(int decimalNumber) {
        return this.decimalNumber = decimalNumber;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public int setTetradsCount(int tetradsCount) {
        return this.tetradsCount = tetradsCount;
    }

    public int getTetradsCount() {
        return tetradsCount;
    }

    public Visual setValues(int decimalNumber, int tetradsCount) {
        this.decimalNumber = decimalNumber;
        this.tetradsCount = tetradsCount;
        return this;
    }

    @Override
    public String toString() {
        return "Decimal number = " + decimalNumber + ", Tetrads count = " + tetradsCount;
    }
}
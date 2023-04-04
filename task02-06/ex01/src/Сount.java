package ex01;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** Содержит реализацию методов для вычисления и отображения результатов.
 * @author xone
 * @version 1.0
 */
public class Сount {
    /** Имя файла, используемое при сериализации. */
    private static final String FNAME = "ex01.Item2d.bin";
    /** Сохраняет результат вычислений. Объект класса {@linkplain Visual} */
    private Visual result;
    /** Инициализирует {@linkplain Сount#result} */
    public Сount() {
        result = new Visual();
    }
    /** Установить значение {@linkplain Сount#result}
     * @param result - новое значение ссылки на объект {@linkplain Visual}
     */
    public void setResult(Visual result) {
        this.result = result;
    }
    /** Получить значение {@linkplain Сount#result}
     * @return текущее значение ссылки на объект {@linkplain Visual}
     */
    public Visual getResult() {
        return result;
    }
    /**
     * Вычисляет значение функции.
     *
     * @param decimalNumber - аргумент вычисляемой функции.
     * @return результат вычисления функции.
     */
    private Visual count(double decimalNumber) {
        String binaryDigits = Integer.toBinaryString((int) decimalNumber);
        int tetradsCount = 0;
        tetradsCount = binaryDigits.length() / 4;
        return new Visual((int) decimalNumber, tetradsCount);
    }
    /** Вычисляет значение функции и сохраняет
     * результат в объекте {@linkplain Сount#result}
     * @param decimalNumber - аргумент вычисляемой функции.
     */
    public void init(double decimalNumber) {
        setResult(count(decimalNumber));
    }
    /** Выводит результат вычислений. */
    public void show() {
        System.out.println(result);
    }
    /** Сохраняет {@linkplain Сount#result} в файле {@linkplain Сount#FNAME}
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    /** Восстанавливает {@linkplain Сount#result} из файла {@linkplain Сount#FNAME}
     * @throws Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Visual)is.readObject();
        is.close();
    }
}


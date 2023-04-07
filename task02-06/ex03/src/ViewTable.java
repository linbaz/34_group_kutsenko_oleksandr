package ex03;

import ex01.Visual;
import ex02.ViewResult;

import java.util.Formatter;
/** ConcreteProduct
 * (шаблон проектирования
 * Factory Method)<br>
 * Вывод в виде таблицы
 * @author xone
 * @version 1.0
 * @see ViewResult
 */
public class ViewTable extends ViewResult {
    /** Определяет ширину таблицы по умолчанию */
    private static final int DEFAULT_WIDTH = 20;
    /** Текущая ширина таблицы */
    private int width;
    /** Устанавливает {@linkplain ViewTable#width width}
     * значением {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }
    /** Устанавливает {@linkplain ViewTable#width} значением <b>width</b><br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult() ViewResult()}
     * @param width определяет ширину таблицы
     */
    public ViewTable(int width) {
        this.width = width;
    }
    /** Устанавливает {@linkplain ViewTable#width} значением <b>width</b><br>
     * Вызывается конструктор суперкласса {@linkplain ViewResult#ViewResult(int n) ViewResult(int
    n)}
     * @param width определяет ширину таблицы
     * @param n количество элементов коллекции; передаётся суперконструктору
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }
    /** Устанавливает поле {@linkplain ViewTable#width} значением <b>width</b>
     * @param width новая ширина таблицы
     * @return заданная параметром <b>width</b> ширина таблицы
     */
    public int setWidth(int width) {
        return this.width = width;
    }
    /** Возвращает значение поля {@linkplain ViewTable#width}
     * @return текущая ширина таблицы
     */
    public int getWidth() {
        return width;
    }
    /** Выводит вертикальный разделитель шириной {@linkplain ViewTable#width} символов */
    private void outLine() {
        for(int i = width; i > 0; i--) {
            Object System = null;
        }
    }
    /** Вызывает {@linkplain ViewTable#outLine()}; завершает вывод разделителем строки */
    private void outLineLn() {
        outLine();
        System.out.println();
    }
    /** Выводит заголовок таблицы шириной {@linkplain ViewTable#width} символов */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Decimal Number ", "Tetrads Count ");
    }
    /** Выводит тело таблицы шириной {@linkplain ViewTable#width} символов */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        for(Visual item : getItems()) {
            System.out.printf(fmt.toString(), item.getDecimalNumber(), item.getTetradsCount());
        }
    }
    /** Перегрузка метода суперкласса;
     * устанавливает поле {@linkplain ViewTable#width} значением <b>width</b><br>
     * Для объекта {@linkplain ViewTable} вызывает метод {@linkplain ViewTable#init(double
            stepX)}
     * @param width новая ширина таблицы.
     * @param stepDecimalNumber передается методу <b>init(double)</b>
     */
    public final void init(int width, double stepDecimalNumber) { // method overloading
        this.width = width;
        init(stepDecimalNumber);
    }
    /** Переопределение (замещение, overriding) метода суперкласса;
     * выводит информационное сообщение и вызывает метод суперкласса
     * {@linkplain ViewResult#init(double stepX) init(double stepX)}<br>
     * {@inheritDoc}
     */
    @Override
    public void init(double stepDecimalNumber) { // method overriding
        System.out.print("Initialization... ");
        super.init(stepDecimalNumber);
        System.out.println("done. ");
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewBody() {
        outBody();
    }
    /** Вывод элемента таблицы<br>{@inheritDoc} */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}

package ex04;

import ex01.Visual;
import ex01.Visual;

/** Команда
 * Change item;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ChangeItemCommand implements Command {
    /** Обрабатываемый объект; шаблон Command */
    private Visual item;
    /** Параметр команды; шаблон Command */
    private double offset;
    /** Устанавливаент поле {@linkplain ChangeItemCommand#item}
     * @param item значение для {@linkplain ChangeItemCommand#item}
     * @return новое значение {@linkplain ChangeItemCommand#item}
     */
    public Visual setItem(Visual item) {
        return this.item = item;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#item}
     * @return значение {@linkplain ChangeItemCommand#item}
     */
    public Visual getItem() {
        return item;
    }
    /** Устанавливаент поле {@linkplain ChangeItemCommand#offset}
     * @param offset значение для {@linkplain ChangeItemCommand#offset}
     * @return новое значение {@linkplain ChangeItemCommand#offset}
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#offset}
     * @return значение {@linkplain ChangeItemCommand#offset}
     */
    public double getOffset() {
        return offset;
    }
    @Override
    public void execute() {
        item.setTetradsCount((int) (item.getDecimalNumber() * offset));
    }
}
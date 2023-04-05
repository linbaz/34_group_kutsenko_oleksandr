package ex02;
import java.io.IOException;
import java.util.Map;

/** Product
 * (шаблон проектирования
 * Factory Method)<br>
 * Интерфейс "фабрикуемых"
 * объектов<br>
 * Объявляет методы
 * отображения объектов
 * @author xone
 * @version 1.0
 */
public interface View {
    /**
     * Отображает заголовок
     */
    void viewHeader();

    /**
     * Отображает основную часть
     */
    void viewBody();

    /**
     * Отображает окончание
     */
    void viewFooter();

    /**
     * Отображает объект целиком
     */
    void viewShow();

    /**
     * Выполняет инициализацию
     */
    void viewInit();

    /**
     * Сохраняет данные для последующего восстановления
     */
    void viewSave() throws IOException;

    /**
     * Восстанавливает ранее сохранённые данные
     */
    void viewRestore() throws Exception;

    Map<String, Integer> calc(double v);
}
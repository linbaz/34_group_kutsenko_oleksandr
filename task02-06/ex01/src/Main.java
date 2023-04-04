package ex01;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/** Содержит реализацию статического метода main().
 * @author xone
 * @version 1.0
 * @see Main#main
 */
public class Main {
    /** Объект класса {@linkplain Сount}.
     */
    private Сount count = new Сount();
    /** Отображает меню. */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    count.show();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    count.init(Math.random() * 99.0);
                    count.show();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        count.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    count.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        count.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    count.show();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }
    /** Вычисляется значение функции для различных аргументов.
     * Результаты вычислений выводятся на экран.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
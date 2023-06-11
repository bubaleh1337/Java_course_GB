package sem2;

import java.util.Scanner;

/*
 * Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
 */
public class task1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите 1-ю строку: ");
    String s = scanner.nextLine();
    System.out.println("Введите 2-ю строку: ");
    String s2 = scanner.nextLine();
    scanner.close();

    if (s.contains(s2)) {
      System.out.println("Совпадения найдены.");
    } else {
      System.out.println("Совпадений нет.");
    }
  }
}

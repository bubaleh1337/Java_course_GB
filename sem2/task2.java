package sem2;

import java.util.Scanner;

/*
 * Напишите программу, чтобы проверить, являются ли две 
 * данные строки вращением друг друга (вхождение в обратном порядке).
 */
public class task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите 1-ю строку: ");
    // StringBuilder s1 = new StringBuilder(scanner.nextLine());
    String s1 = scanner.nextLine();
    System.out.println("Введите 2-ю строку: ");
    StringBuilder s2 = new StringBuilder(scanner.nextLine());
    // String s2 = scanner.nextLine();
    scanner.close();

    System.out.println(s1.equals((s2.reverse().toString())));
  }
}

package sem1.hw1;
/*
  1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
  2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
  3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
  4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

  Пункты реализовать в методе main
  *Пункты реализовать в разных методах

  int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task1 {
  public static void main(String[] args) {
    int i = getRandomNumber();
    int n = getBit(i);
    List<Integer> m1 = findMultiples(n, i, Short.MAX_VALUE);
    List<Integer> m2 = findNonMultiples(n, Short.MIN_VALUE, i);

    System.out.println("Random number: " + i);
    System.out.println("Most significant bit: " + n);
    System.out.println("Multiples of n in the range [i, Short.MAX_VALUE]: ");
    printArray(m1);
    System.out.println("Non-multiples of n in the range [Short.MIN_VALUE, i]: ");
    printArray(m2);
  }

  public static int getRandomNumber() {
    return new Random().nextInt(2000);
  }

  public static int getBit(int number) {
    int msb = 0;
    while (number > 0) {
      number = number >> 1;
      msb++;
    }
    return msb;
  }

  public static List<Integer> findMultiples(int num, int start, int end) {
    List<Integer> multiples = new ArrayList<>();

    for (int i = start; i <= end; i++) {
      if (i % num  == 0) {
        multiples.add(i);
      }
    }

    return multiples;
  }

  public static List<Integer> findNonMultiples(int num, int start, int end) {
    List<Integer> nonMultiples = new ArrayList<>();

    for (int i = start; i <= end; i++) {
      if (i % num != 0) {
        nonMultiples.add(i);
      }
    }

    return nonMultiples;
  }

  public static void printArray(List<Integer> list) {
    for (int num : list) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}

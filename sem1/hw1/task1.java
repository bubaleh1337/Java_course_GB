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

import java.util.Random;

public class task1 {
  public static void main(String[] args) {
    int i = getRandomNumber();
    int n = getBit(i);
    int[] m1 = findMultiples(n, i, Short.MAX_VALUE);
    int[] m2 = findNonMultiples(n, Short.MIN_VALUE, i);

    System.out.println("Random number: " + i);
    System.out.println("Most significant bit: " + n);
    System.out.println("Multiples of n in the range [i, Short.MAX_VALUE]:");
    printArray(m1);
    System.out.println("Non-multiples of n in the range [Short.MIN_VALUE, i]:");
    printArray(m2);
  }

  public static int getRandomNumber() {
    Random rand = new Random();
    return rand.nextInt(2001);
  }

  public static int getBit(int number) {
    int msb = 0;
    while (number > 0) {
      number = number >> 1;
      msb++;
    }
    return msb;
  }

  public static int[] findMultiples(int num, int start, int end) {
    int[] multiples = new int[(end - start) / num + 1];
    int index = 0;

    for (int i = start; i <= end; i++) {
      if (i % num == 0) {
        multiples[index] = i;
        index++;
      }
    }

    return multiples;
  }

  public static int[] findNonMultiples(int num, int start, int end) {
    int[] nonMultiples = new int[Math.abs(start - end) / num + 1];
    int index = 0;

    for (int i = start; i <= end; i++) {
      if (i % num != 0) {
        nonMultiples[index] = i;
        index++;
      }
    }

    return nonMultiples;
  }

  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}

package sem1.hw1;
/*
  1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
  2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
  3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE 
  сохранить в массив m1
  4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE 
  до i и сохранить в массив m2

  Пункты реализовать в методе main
  *Пункты реализовать в разных методах

  int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */


import java.util.Random;

public class task1 {
  public static void main(String[] args) {
    int i = getRandomNumber(2000);
    System.out.println("\nRandom number: " + i);

    int n = getBit(i);
    System.out.println("Most significant bit: " + n);

    int[] m1 = findMultiples(n, i, Short.MAX_VALUE);
    System.out.println("\nMultiples of n in the range [i, Short.MAX_VALUE]: " + m1.length);
    printArray(m1);

    int[] m2 = findNonMultiples(n, i, Short.MIN_VALUE);
    System.out.println("Non-multiples of n in the range [Short.MIN_VALUE, i]: " + m2.length);
    printArray(m2);
  }

  public static int getRandomNumber(int num) {
    return new Random().nextInt(num);
  }

  public static int getBit(int number) {
    int max_bit = 0;
    while (number > 0) {
      number = number >> 1;
      max_bit++;
    }
    return max_bit;
  }

  public static int[] findMultiples(int bit, int num, int max) {
    int index = 0;
    int[] m1 = new int[(max - num) / bit];

    for (int i = num; i < max; i++) {
      if (i % bit == 0) {
        m1[index] = i;
        index++;
      }
    }
    return m1;
  }

  public static int[] findNonMultiples(int bit, int num, int min) {
    int index = 0;
    int[] m2 = new int[(Math.abs(min) - num) / bit];

    for (int i = num; i > min; i--) {
      try {
        if (bit % i != 0) {
        m2[index] = i;
        index++;
      }
      } catch (Exception e) {
        
      }
      
    }

    // int[] nonMultiples = new int[Math.abs(start - end) / num + 1];
    // int index = 0;

    // for (int i = start; i <= end; i++) {
    // if (i % num != 0) {
    // nonMultiples[index] = i;
    // index++;
    // }
    // }
    return m2;
  }

  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}

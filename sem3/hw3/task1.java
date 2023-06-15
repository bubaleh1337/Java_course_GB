package sem3.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;

/*
Пусть дан произвольный список целых чисел.

1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение 
 */
public class task1 {
  public static void main(String[] args) {
    ArrayList<Integer> list = getList();
    System.out.println("\nПроизвольный список целых чисел: " + list);
    System.out.println("\n1) Удаление чётных чисел: " + remove(list));
    System.out.println("2) Нахождение минимального значения: " + Collections.min(list));
    System.out.println("3) Нахождение максимального значения: " + Collections.max(list));
    System.out.println("4) Нахождение среднего значения: " + average(list));
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new Random().nextInt(15));
    }
    return list;
  }
  
  public static ArrayList<Integer> remove(ArrayList<Integer> list) {
    Iterator<Integer> it = list.iterator();

    while (it.hasNext()) {
      if (it.next() % 2 == 0) {
        it.remove();
      }
    }
    return list;
  }

  static double average(ArrayList<Integer> list) {

    double sum = 0;

    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }

    return sum / list.size();
  }
}

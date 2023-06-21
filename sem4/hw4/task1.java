package sem4.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
1. Организовать вводи и хранение данных пользователей. ФИО возраст и пол
2. вывод в формате Фамилия И.О. возраст пол
3. добавить возможность выхода или вывода списка отсортированного по возрасту!)
4. *реализовать сортировку по возрасту с использованием индексов
5. *реализовать сортировку по возрасту и полу с использованием индексов
 */
public class task1 {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    ArrayList<ArrayList<String>> majorList = new ArrayList<>();
    
    while (true) {
      ArrayList<String> listInput = getList();
      if (listInput == null) {
        break;
      }
      majorList.add(listInput);
    }
    print(majorList);
    // System.out.println(majorList);
    System.out.println("-----------------------------------");

    boolean inGame = false;
    while (!inGame) {
      System.out.print(
          "\n\nНажмите 1 для просмотра списка \nНажмите 2 для сортировки по возрасту \nНажмите 3 для сортировки по женскому полу и возрасту \nНажмите 4 сортировки по мужскому полу и возрасту \nНажмите 0 для выхода \nВаш выбор: \n\n");
      int choose = scanner.nextInt();
      try {
        switch (choose) {
          case 1:
            majorList.forEach(System.out::println);
          case 2:
            sortedByAge(majorList).forEach(System.out::println);
          case 3:
            sortedBySex(majorList, "f").forEach(System.out::println);
          case 4:
            sortedBySex(majorList, "m").forEach(System.out::println);
          default:
            inGame = true;
        }
      } catch (Exception e) {
      }

    }
  }

  public static void addParametr(int count) {
    switch (count) {
      case 0:
        System.out.println("Введите имя: ");
        break;
      case 1:
        System.out.println("Введите пол: ");
        break;
      case 2:
        System.out.println("Введите возраст: ");
        break;
      default:
        System.out.println("Что-то не так, попробуйте ещё раз.");
        break;
    }
  }

  public static ArrayList<String> getList() {
    ArrayList<String> listInput = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      addParametr(i);
      String word = scanner.nextLine();
      if (word.equals("q")) {
        return null;
      }
      if (i == 0) {
        String[] tmp = word.split(" ");
        listInput.add(tmp[0]);
        listInput.add(tmp[1]);
        listInput.add(tmp[2]);
      } else {
        listInput.add(word);
      }
    }
    return listInput;
  }

  public static void print(ArrayList<ArrayList<String>> lst) {
    for (ArrayList<String> i : lst) {
      System.out
          .println(i.get(0) + " " + i.get(1).charAt(0) 
          + "." + i.get(2).charAt(0) + ". " + i.get(3) 
          + " " + i.get(4));
    }
  }

  public static ArrayList<String> sortedByAge(ArrayList<ArrayList<String>> majorList) {
    ArrayList<String> sorted = new ArrayList<>();
    int[] age = new int[majorList.size()];
    for (int i = 0; i < majorList.size(); i++) {
      String[] line = majorList.get(i).toString().split(" ");
      age[i] = (Integer.parseInt(line[2]));
      
    }    
    int[] sortedAge = Arrays.stream(age).sorted().toArray();
    for (int k : sortedAge) {
      for (int j = 0; j < age.length; j++) {
        if (k == age[j]) {
          sorted.add(majorList.get(j).toString());
        }
      }
    }
    return sorted;
  }
  
  public static ArrayList<String> sortedBySex(ArrayList<ArrayList<String>> majorList, String sex) {
    ArrayList<ArrayList<String>> sorted = new ArrayList<>();
    for (int i = 0; i < majorList.size(); i++) {
      if (majorList.get(i).toString().endsWith(sex)) {
        sorted.add(majorList.get(i));
      }
    }
    return sortedByAge(sorted);
  }
}

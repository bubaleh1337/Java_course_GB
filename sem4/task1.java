package sem4;

import java.util.ArrayList;
import java.util.Scanner;

/*
 1. Организовать ввод и хранение данных пользователей. 
 ФИО возраст и пол
 2. вывод в формате Фамилия И.О. возраст пол

 3. Добавить возможность выхода или вывода списка отсортированного по возрасту!)
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
          .println(i.get(0) + " " + i.get(1).charAt(0) + ". " + i.get(2).charAt(0) + ". " + i.get(3) + " " + i.get(4));
    }
  }
}

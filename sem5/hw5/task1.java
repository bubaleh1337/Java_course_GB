package sem5.hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре 
будут повторяющиеся имена с разными телефонами, 
их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.
*/
public class task1 {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    while (true) {
      // Ввод данных
      String name = prompt("Введите имя: ");
      String number_phone = prompt("Введите номер: ");
      if (name.equals("") || number_phone.equals(""))
        break;

      // Проверяем, есть ли уже такое имя в телефонной книге
      phoneBook = checkPB(phoneBook, name, number_phone);
    }
    // Сортировка по убыванию числа телефонов
    ArrayList<Map.Entry<String, ArrayList<String>>> entries = sortPB(phoneBook);

    // Вывод результатов
    printPB(entries);
  }

  public static String prompt(String msg) {
    System.out.println(msg);
    String word = scanner.nextLine();
    return word;
  }

  public static HashMap<String, ArrayList<String>> checkPB(HashMap<String, ArrayList<String>> phoneBook,
      String name, String number_phone) {
    if (phoneBook.containsKey(name)) {
      ArrayList<String> phones = phoneBook.get(name);
      phones.add(number_phone);
      phoneBook.put(name, phones);
    } else {
      ArrayList<String> phones = new ArrayList<>();
      phones.add(number_phone);
      phoneBook.put(name, phones);
    }
    return phoneBook;
  }

  public static ArrayList<Map.Entry<String, ArrayList<String>>> sortPB(HashMap<String, ArrayList<String>> phoneBook) {
    ArrayList<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<String, ArrayList<String>>>() {
      @Override
      public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
        return o2.getValue().size() - o1.getValue().size();
      }
    });
    return entries;
  }

  public static void printPB(ArrayList<Map.Entry<String, ArrayList<String>>> entries) {
    System.out.println("Результат:");
    for (Map.Entry<String, ArrayList<String>> entry : entries) {
      System.out.println(entry.getKey() + ": " + entry.getValue().toString());
    }
  }
}

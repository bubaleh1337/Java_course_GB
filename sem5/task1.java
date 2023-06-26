package sem5;

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

    Map<String, String> pb = new HashMap<>();

    while (true) {
      String human = prompt("Введите имя: ");
      String number_phone = prompt("Введите номер: ");
      if (human.equals("") || number_phone.equals("")) break;

      pb = phonebook(human, number_phone);
      System.out.println("-".repeat(15));

      if (quit(human) == true || quit(number_phone) == true) {
        for (var item : pb.entrySet()) {
          
          System.out.printf("%s: %s\n", item.getKey(), item.getValue());
        }
        break;
      }
    }
  }

  public static String prompt(String msg) {
    System.out.println(msg);
    String word = scanner.nextLine();
    return word;
  }

  public static boolean quit(String word) {
    if (word.equals("q")) return true;
    else return false;
  }
  public static Map<String, String> phonebook(String human, String number_phone) {
    Map<String, String> pb = new HashMap<>();
    if (pb.containsKey(human)) {
      pb.put(human, number_phone);
    } else {
      pb.put(human, number_phone);
    }
    return pb;
  }
}

package sem2.hw2;

import java.util.ArrayList;
/*
Дана строка "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя 
StringBuilder. Данные для фильтрации приведены ниже
 в виде строки.
Если значение null, то параметр не должен попадать 
в строку.
Параметры для фильтрации: {"name":"Ivanov", 
"country":"Russia", "city":"Moscow", "age":"null"}
В итоге должно получится select * from students 
where name=Ivanov, country=Russia, city=Moscow

Дополнительные задания

Дана строка (можно сохранить в файл и читать 
из файла)
[{"фамилия":"Иванов","оценка":"5",
"предмет":"Математика"},{"фамилия":"Петрова",
"оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, 
используя StringBuilder, создаст строки вида: 
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

*Сравнить время выполнения замены символа "а" на "А" 
любой строки содержащей >1000 символов 
средствами String и StringBuilder.
 */
import java.util.Scanner;

public class task1 {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String head = "select * from students where ";
    StringBuilder sb = new StringBuilder(head);
    StringBuilder words = new StringBuilder("name: , country: , city: , age: ");

    System.out.println(getSB(sb, words));

  }

  public static void prompt(StringBuilder sb, StringBuilder lst) {
    sb.append(lst.toString());
    System.out.println(sb);
  }

  public static void addParametr(int count) {
    switch (count) {
      case 0:
        System.out.println("Enter a name: ");
        break;
      case 1:
        System.out.println("Enter a country: ");
        break;
      case 2:
        System.out.println("Enter a city: ");
        break;
      case 3:
        System.out.println("Enter a age: ");
        break;
      default:
        System.out.println("Something wrong. Try again.");
        break;
    }
  }

  public static StringBuilder getSB(StringBuilder sb, StringBuilder words) {

    for (int i = 0; i < 4; i++) {
      addParametr(i);
      String word = scanner.nextLine();
      sb.append(word + " ");
    }
    return sb;
  }
}

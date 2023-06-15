package sem2.hw2;

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
  public static void main(String[] args) {
    String head = "select * from students where ";
    StringBuilder sb = new StringBuilder(head);
    String words = "name: , country: , city: , age: ";
    for (int i = 0; i < words.length(); i++) {
      prompt(i, words.substring(i).toString(), sb);
    }
  }

  public static StringBuilder prompt(int count, String words, StringBuilder sb) {
    Scanner scanner = new Scanner(System.in);
    addParametr(count, words, sb);
    String word = scanner.nextLine();
    sb.append(word);
    scanner.close();
    return sb;
  }

  public static void addParametr(int count, String words, StringBuilder sb) {
    switch (count) {
      case 0:
        System.out.println("Enter a name: ");
        sb.append(words.charAt(0));
        break;
      case 1:
        System.out.println("Enter a country: ");
        sb.append(words.charAt(1));
        break;
      case 2:
        System.out.println("Enter a city: ");
        sb.append(words.charAt(2));
        break;
      case 3:
        System.out.println("Enter a age: ");
        sb.append(words.charAt(3));
        break;
      default:
        System.out.println("Something wrong. Try again.");
        break;
    }
  }
}

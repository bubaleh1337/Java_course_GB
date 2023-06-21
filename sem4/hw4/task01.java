package sem4.hw4;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. Организовать вводи и хранение данных пользователей. ФИО возраст и пол
2. вывод в формате Фамилия И.О. возраст пол
3. добавить возможность выхода или вывода списка отсортированного по возрасту!)
4. *реализовать сортировку по возрасту с использованием индексов
5. *реализовать сортировку по возрасту и полу с использованием индексов
*/
public class task01 {
  enum SortBy {
    NONE, AGE, AGE_AND_GENDER;
  };

  public static void main(String[] args) {
    ArrayList<String> lastNames = new ArrayList<>();
    ArrayList<String> firstNames = new ArrayList<>();
    ArrayList<String> surNames = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>();
    ArrayList<String> genders = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Если захотите выйти, введите 'exit'.\nЧтобы показать весь созданный список и сортировку введите 'show'.\n");
    String[] inputFieldNames = new String[] { "ФИО", "Пол (1. Мужской, 2. Женский)", "Возраст" };
    String[] inputFields = new String[inputFieldNames.length];

    boolean input = true;
    boolean add;

    while (input) {
      add = true;

      for (int i = 0; i < inputFields.length; i++) {
        // проверяем ввод пустой строки
        do {
          inputFields[i] = inputData(scanner, inputFieldNames[i]).strip();
        } while (inputFields[i].length() == 0);

        // выход
        if (inputFields[i].equals("exit")) {
          input = false;
          add = false;
          break;
        }
        // вывод
        if (inputFields[i].equals("show")) {
          add = false;
          System.out.println("Без сортировки:");
          showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.NONE);
          System.out.println("-----------------");
          System.out.println("Сортировка по возрасту:");
          showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.AGE);
          System.out.println("-----------------");
          System.out.println("Сортировка по возрасту и полу:");
          showPersons(lastNames, firstNames, surNames, ages, genders, SortBy.AGE_AND_GENDER);
          break;
        }
      }
      // Добалвение
      if (add) {
        String[] fullnameArr = inputFields[0].split(" ");

        lastNames.add(fullnameArr[0]);
        // Ловим ошибки, если пользвоатель ввел не все данные в ФИО.
        // если что-то пустое вводим пустую строку.
        try {
          firstNames.add(fullnameArr[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
          firstNames.add("");
        }
        try {
          surNames.add(fullnameArr[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
          surNames.add("");
        }
        // Вводим в поле пол цифру 1 или 2. чтобы не ошибиться в вводе данных.
        // Если человек ввел дургие данные. вставляем пустую строку.
        switch (inputFields[1]) {
          case "1":
            genders.add("мужской");
            break;
          case "2":
            genders.add("женский");
            break;
          default:
            genders.add("");
            break;
        }

        ages.add(getDigit(inputFields[2]));
      }
    }
    scanner.close();
  }

  // Показываем списко не отсортиованный
  public static void showPersons(ArrayList<String> lastNames, ArrayList<String> firstNames,
      ArrayList<String> surNames,
      ArrayList<Integer> ages, ArrayList<String> genders, SortBy sortBy) {

    int[] indexes = getDefaultIndexes(ages.size());
    switch (sortBy) {
      case AGE:
        indexes = getSortAgesIndexes(ages);
        break;
      case AGE_AND_GENDER:
        indexes = getSortAGIndexes(ages, genders);
        break;
      case NONE:
        break;
    }
    for (int index : indexes) {
      System.out.println(lastNames.get(index)
          + ((firstNames.get(index).length() > 0) ? (" " + firstNames.get(index).charAt(0) + ".") : "")
          + ((surNames.get(index).length() > 0) ? (surNames.get(index).charAt(0) + ". ") : " ")
          + ages.get(index) + " " + genders.get(index));
    }
  }

  // Ввод данных с запросом 'text'
  public static String inputData(Scanner scanner, String text) {
    System.out.print(text + ": ");
    return scanner.nextLine();
  }

  // Построение индекса по умолчанию
  private static int[] getDefaultIndexes(int count) {
    int[] indexes = new int[count];
    for (int i = 0; i < count; i++) {
      indexes[i] = i;
    }
    return indexes;
  }

  // Сортируем индексы по возрасту
  private static int[] getSortAGIndexes(ArrayList<Integer> ages, ArrayList<String> genders) {
    int[] indexes = getDefaultIndexes(ages.size());

    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < indexes.length - 1; i++) {
        // либо по полу, если они разные и не в том порядке
        // либо по возрасту, если пол один
        if ((genders.get(indexes[i]).toLowerCase().equals("женский")
            && genders.get(indexes[i + 1]).toLowerCase().equals("мужской"))
            || ((genders.get(indexes[i]).equals(genders.get(indexes[i + 1])))
                && (ages.get(indexes[i]) > ages.get(indexes[i + 1])))) {
          isSorted = false;
          int tmp = indexes[i];
          indexes[i] = indexes[i + 1];
          indexes[i + 1] = tmp;
        }
      }
    }

    return indexes;
  }

  // Сортируем индексы по возрасту и полу
  private static int[] getSortAgesIndexes(ArrayList<Integer> ages) {
    int[] indexes = getDefaultIndexes(ages.size());

    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < indexes.length - 1; i++) {
        if (ages.get(indexes[i]) > ages.get(indexes[i + 1])) {
          isSorted = false;
          int tmp = indexes[i];
          indexes[i] = indexes[i + 1];
          indexes[i + 1] = tmp;
        }
      }
    }

    return indexes;
  }

  // Переводим возраст из строки в цифру. Если введены не корректные данные
  // возвращаем 0
  private static int getDigit(String str) throws NumberFormatException {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}

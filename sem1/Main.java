package sem1;

// Вывести все простые числа от 1 до 1000
public class Main {
  public static void main(String[] args) {
    for (int number = 2; number <= 1000; number++) {
      for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
          System.out.print(number + " ");
        }
      }
    }
  }
}

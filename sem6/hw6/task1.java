package sem6.hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Map;

/*
Разработать программу, имитирующую поведение коллекции HashSet. 
В программе содать метод add добавляющий элемент, метод toString 
возвращающий строку с элементами множества и метод позволяющий 
читать элементы по индексу.
*Реализовать все методы из семинара.
Формат данных Integer.
 */
public class task1 {
  public static void main(String[] args) {
    SetImitation setImitation = new SetImitation();
    System.out.println(setImitation.add(9));
    System.out.println(setImitation.add(9));
    System.out.println(setImitation.add(4));
    System.out.println(setImitation.add(3));
    System.out.println(setImitation.add(1));
    System.out.println(setImitation.delete(9));
    System.out.println(setImitation.delete(9));
    System.out.println(setImitation.size());
    System.out.println(setImitation.isEmpty());
    System.out.println(setImitation.contains(9));
    System.out.println(setImitation.contains(4));

    for (int i = 0; i < 10; i++) {
      setImitation.add(new Random().nextInt(1000));
    }
    Iterator<Integer> iterator = setImitation.iterator();
    while (iterator.hasNext()) {
      int i = iterator.next();
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println(setImitation.getElementByIndex(3));
    // System.out.println(setImitation.getElementByIndex(20));
    System.out.println(setImitation.toStr());
  }
}

class SetImitation<E> { // E == var
  private HashMap<E, Object> map = new HashMap<>();

  private static final Object OBJECT = new Object(); // const

  public boolean add(E num) {
    return map.put(num, OBJECT) == null;
  }

  public boolean delete(E num) {
    return map.remove(num, OBJECT);
  }

  public int size() {
    return map.size();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public boolean contains(Object num) {
    return map.containsKey(num);
  }

  public Iterator<E> iterator() {
    return map.keySet().iterator();
  }

  public E getElementByIndex(int index) {
    E[] mapArray = (E[]) map.keySet().toArray();
    return mapArray[index];
  }

  public String toStr() {
    return String.valueOf(map.keySet());
  }
}

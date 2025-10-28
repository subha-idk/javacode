package JAVA8;

import java.util.ArrayList;
import java.util.Iterator;

public class Lect1 {
  public static void main(String[] args) {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(0);
    l.add(5);
    l.add(10);
    l.add(15);
    l.add(20);
    l.add(25);

    // iterable is the playlist where all the song are listed
    // iterator who play the loop
    // list implement iterable - > iterable has one function iterator so i can get it
    Iterator<Integer> it = l.iterator();

    // iterator has mainly two class one is hasnext and next
    while(it.hasNext()){
      System.out.println(it.next());
    }
  }
}

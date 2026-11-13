package Study_Brod.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBase {

    static void printList( ArrayList<Item> items){
        for(Item i: items){
            System.out.println(i);

        }
    }

    public static void main(String[] args) {
        ArrayList <Item> items = new ArrayList<>();
        items.add(new Item("Potato", 100, 0.33));
        items.add(new Item("White monster", 1000000, 1.65));
        items.add(new Item("White Mango", 10000, 1.55));
        items.add(new Item("Steak", 1000, 10));

//        printList(items);
//
//        Collections.sort(items);
//
//        printList(items);

        Collections.shuffle(items);
        printList(items);

        items.sort(BY_PRICE);
        printList(items);
    }

    public static final Comparator<Item> BY_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price, o2.price);
        }
    };


    public static final Comparator<Item> BY_TOTAL_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price * o1.quantity, o2.price * o2.quantity);
        }
    };

    static class Item implements Comparable<Item>{
        String name;
        int quantity;
        double price;

        public Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }

//        @Override
//        public int compareTo(Item o) {
//            return this.quantity - o.quantity;
//        }

//        @Override
//        public int compareTo(Item o) {
//           return (int) (this.price - o.price);
//            return Double.compare(this.price, o.price);
//        }

        @Override
        public int compareTo(Item o) {
            return this.name.compareTo(o.name);
       }
    }
}

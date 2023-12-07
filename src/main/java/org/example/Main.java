package org.example;

import org.example.sem3.Task2;

public class Main {
    public static void main(String[] args) {
        Task2<Integer> numbers = new Task2<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        numbers.remove(2);

        System.out.println(numbers.getItemsSize());
        System.out.println(numbers);
        System.out.println("****************************");

        Task2.BogdanIterator iterator = numbers.getIterator();


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
package org.example;

import org.example.sem3.ArraysComparator;
import org.example.sem3.Calculator;
import org.example.sem3.Pair;
import org.example.sem3.Task2;

public class Main {
    public static void main(String[] args) {
//        Task2<Integer> numbers = new Task2<>();
//
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//
//        numbers.remove(2);
//
//        System.out.println(numbers.getItemsSize());
//        System.out.println(numbers);
//        System.out.println("****************************");
//
//        Task2.BogdanIterator iterator = numbers.getIterator();
//
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        System.out.println(Calculator.sum(10,10f));
//        System.out.println(Calculator.divide(10,10.0));
//        System.out.println(Calculator.multiply(10L,10));
//        System.out.println(Calculator.subtract(10L,10f));
//        System.out.println(Calculator.divide(10L,0));

        Pair<Integer,String> pair = new Pair<>(10,"ten");
        System.out.println(pair);


        Object first = new Object();
        Object second = new Object();
        Pair<Object,Object> pair2 = new Pair<>(first,second);
        System.out.println(pair2);



        String[] strs = {"a","b","c"};
        String[] strs2 = {"a","b","c"};
        String[] strs3 = {"a","b","c","d"};
        Integer[] ints = {1,2,3,4};
        Integer[] ints2 = {1,2,3,4,5};
        Integer[] ints3 = {1,2,3,4};

        System.out.println(ArraysComparator.compareArrays(strs,strs2));
        System.out.println(ArraysComparator.compareArrays(strs,strs3));
        System.out.println(ArraysComparator.compareArrays(ints,ints3));
        System.out.println(ArraysComparator.compareArrays(ints3,ints2));
        System.out.println(ArraysComparator.compareArrays(strs,ints));




    }
}
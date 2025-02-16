package org.assignment1.java1117features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VarJava10 {
    public static void main(String[] args) {
        // Using 'var' to infer the type of a primitive variable
        var number = 10;
        System.out.println("Number: " + number);

        // Using 'var' with a List
        var list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List elements:");
        for (var item : list) {
            System.out.println(item);
        }

        // Using 'var' with a Set
        var set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println("Set elements:");
        for (var element : set) {
            System.out.println(element);
        }

        // Using 'var' with a Map
        var map = new HashMap<Integer, String>();
        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");

        System.out.println("Map entries:");
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

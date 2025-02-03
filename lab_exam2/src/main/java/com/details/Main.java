package com.details;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Example Map
        Map<String, Integer> map = new HashMap<>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

        // Map using Stream
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        //Records Where Key Contains "raj"
        map.entrySet().stream()
                .filter(entry -> entry.getKey().contains("raj"))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Map Sorted by Key
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Map Sorted by Value
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Map Reverse Sorted by Key
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Student Map
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student(109, "raj", 95), 95);
        studentMap.put(new Student(61, "keta", 78), 78);
        studentMap.put(new Student(11, "gunika", 98), 98);
        studentMap.put(new Student(19, "keshav", 97), 97);

        //Sorted by Student Name
        studentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName)))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //Sorted by Student ID
        studentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Student::getId)))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

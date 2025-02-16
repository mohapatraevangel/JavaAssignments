package org.assignment1.java1117features;

public class PatternMAtching_instanceOF {
    public static void main(String[] args) {
        Object name="hello";
        if(name instanceof String){
            System.out.println("name is string");
        }
        else{
            System.out.println("name is not string");
        }
    }
}

package org.assignment1.java9features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A{
    void foo(){
        System.out.println("foo of class A");
    }
}
class B extends  A{
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {
        List<A> list=new ArrayList<>(Arrays.asList(new A(), new B(), new A(), new B(),new A(),new B()));
        list.forEach(A::foo);
    }
}
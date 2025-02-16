package org.assignment1.java9features;



import java.util.InputMismatchException;
import java.util.Scanner;

class DoSideWork implements AutoCloseable{
    public DoSideWork(){
        System.out.println("crt of DoSideWork");
    }
    void doSideWork(){
        System.out.println("doing side work");
    }
    @Override
    public void close() throws Exception {
        System.out.println("closing side work");
    }
}
class Work implements AutoCloseable{
    public Work(){
        System.out.println("ctr of work");
    }
    void doWork(){
        System.out.println("doing main work");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close ");
    }
}
public class B_TryWithResourceImprovement {
    public static void main(String[] args) {
        try(DoSideWork rs1 = new DoSideWork(); Work rs2 = new Work()) {
            rs1.doSideWork();;
            rs2.doWork();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
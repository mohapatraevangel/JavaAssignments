package org.assignment1.java9features;

 interface Shape {


    default double calculateArea() {
        double dimension = getDimension();
        return calculate(dimension);
    }


    default double calculatePerimeter() {
        double dimension = getDimension();
        return calculate(dimension) * 2;
    }


    private double calculate(double dimension) {
        return dimension * dimension;
    }


    double getDimension();
}

class Square implements Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getDimension() {
        return side;
    }
}

class A_PrivateMethodInsideInterface {
    public static void main(String[] args) {
        Square square = new Square(4.0);

        // Call default methods to calculate area and perimeter
        System.out.println("Area of Square: " + square.calculateArea());
        System.out.println("Perimeter of Square: " + square.calculatePerimeter());
    }
}

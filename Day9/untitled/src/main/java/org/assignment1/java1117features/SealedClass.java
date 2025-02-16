package org.assignment1.java1117features;

// Sealed class declaration
sealed class Shape permits Circle, Rectangle {
    // Show dimensions for Circle
    public String showDimensions(double radius) {
        return "Radius: " + radius;
    }

    // Show dimensions for Rectangle
    public String showDimensions(double length, double width) {
        return "Length: " + length + ", Width: " + width;
    }
}

// Circle class extends Shape
final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    // Override showDimensions for Circle
    @Override
    public String showDimensions(double radius) {
        return "Circle - " + super.showDimensions(radius);
    }
}

// Rectangle class extends Shape
final class Rectangle extends Shape {
    private final double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    // Override showDimensions for Rectangle
    @Override
    public String showDimensions(double length, double width) {
        return "Rectangle - " + super.showDimensions(length, width);
    }
}

// Main class for testing the program
public class E_SealedClass {
    public static void main(String[] args) {
        // Create instances of Circle and Rectangle
        Shape circle = new Circle(5.0);  // Circle with radius 5.0
        Shape rectangle = new Rectangle(4.0, 6.0);  // Rectangle with length 4.0 and width 6.0

        // Show dimensions
        System.out.println(circle.showDimensions(5.0));  // Calling showDimensions for Circle
        System.out.println(rectangle.showDimensions(4.0, 6.0));  // Calling showDimensions for Rectangle

        // Show area of both shapes
        System.out.println("Area of the circle: " + ((Circle) circle).area());
        System.out.println("Area of the rectangle: " + ((Rectangle) rectangle).area());
    }
}

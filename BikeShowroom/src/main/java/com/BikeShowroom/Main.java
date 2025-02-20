package com.BikeShowroom;

import Exceptions.ShortageException;

public class Main {
    public static void main(String[] args) {
        BikeShowroom showroom = new BikeShowroom(100); // 100 bikes available in showroom

        try {
            // Trying to order 120 bikes
            showroom.orderBikes(120);
        } catch (ShortageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
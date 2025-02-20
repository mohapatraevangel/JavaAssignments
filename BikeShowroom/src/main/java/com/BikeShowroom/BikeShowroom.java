package com.BikeShowroom;

import Exceptions.ShortageException;

public class BikeShowroom {
    private int availableBikes;

    public BikeShowroom(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    public void orderBikes(int bikesToOrder) throws ShortageException {
        if (bikesToOrder > availableBikes) {
            throw new ShortageException("Not enough bikes available! Only " + availableBikes + " bikes left.");
        } else {
            availableBikes -= bikesToOrder;
            System.out.println(bikesToOrder + " bikes ordered successfully.");
        }
    }
}

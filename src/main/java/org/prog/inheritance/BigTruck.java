package org.prog.inheritance;

public class BigTruck extends Truck {

    public void pickCargo() {
        System.out.println("pick cargo");
    }

    @Override
    public void turnLeft() {
        System.out.println("Big Truck Turns Left");
    }
}

package org.prog.inheritance;

public class BigDemoCar extends DemoCar {

    public BigDemoCar() {
        super("carColor");
    }

    public void dragAnotherCar() {
        System.out.println("dragging car");
    }
}

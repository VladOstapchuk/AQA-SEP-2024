package org.prog.inheritance;

public class DemoCar {
    public String color;
    public int milage;

    public DemoCar(String carColor) {
        color = carColor;
    }

    public void turnLeft() {
        System.out.println("Turning Left");
    }

    public void goTo(String destination) {
        goTo(destination, "current location");
    }

    public void goTo(String destination, String startingFrom) {
        goTo(destination, startingFrom, "nowhere");
    }

    public void goTo(String destination, String startingFrom, String passingThrough) {
        goTo(destination, startingFrom, passingThrough, "no passengers");
    }

    public void goTo(String destination, String startingFrom, String passingThrough, String withPassengers) {
        System.out.println("Driving from " + startingFrom + " to " + destination +
                " passing through " + passingThrough + " with " + withPassengers);
    }

    //this is car1
    @Override
    public boolean equals(Object o) {
        if (o instanceof DemoCar) {
            DemoCar demoCarToCompare = (DemoCar) o;
            if (this.color == null && demoCarToCompare.color == null) {
                return true;
            }
            if (this.color != null &&
                    this.color.equals(demoCarToCompare.color)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}

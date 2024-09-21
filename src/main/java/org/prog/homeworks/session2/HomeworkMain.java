package org.prog.homeworks.session2;

public class HomeworkMain {

    public static void main(String[] args) {

        Airplane Jet1ofthePresident = new Airplane("President of the USA", 1);
        Airplane superJet101 = new Airplane();
        Airplane superJet2 = new Airplane("TransGalaticTrips", 1001);
        Airplane superJet3 = new Airplane("TransGalaticTrips", 1002);
        Airplane reserveJet = new Airplane("TransGalaticTrips", 1001);

        Jet1ofthePresident.flyTo("Washington DC", "Camp Devis");
        superJet101.flyTo("New York", "Tokio");

        System.out.println(superJet2.equals(reserveJet));


    }
}

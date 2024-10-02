package org.prog.homeworks.session4;

import java.util.*;

//TODO: create Map which will allow you to track car owners and cars they own
//TODO: At least one car must be owned by two owners
//TODO: print owners that share cars
public class MapsHomework {

    public static void main(String[] args) {

        //made Set for output only unique value of users
        Set<NewCarOwner> CarOwnersSet = new HashSet<>();

        //create users for cars
        NewCarOwner user1 = new NewCarOwner("Alex", "Alexenko", "380890010101");
        NewCarOwner user2 = new NewCarOwner("Bob", "Marley", "380892220202");
        NewCarOwner user3 = new NewCarOwner("Tom", "Yung", "380893330303");
        NewCarOwner user4 = new NewCarOwner("Agent", "Smith", "380894440404");

        //create cars with all parameters
        Car car1 = new Car("Pontiak", "Yellow", 505, user1);
        Car car2 = new Car("Ford", "Red", 001, user2);
        Car car3 = new Car("Zaporozhets", "Black", 665, user3);
        Car car4 = new Car("Ferrari", "Silver", 100, user4);
        Car car5 = new Car("KRAZ", "Totanium", 4800, user3);

        //Map for all cars with users
        Map<Car, NewCarOwner> CarsAndOwnersData = new HashMap<>();
        CarsAndOwnersData.put(car1, user1);
        CarsAndOwnersData.put(car2, user2);
        CarsAndOwnersData.put(car3, user3);
        CarsAndOwnersData.put(car4, user2);
        CarsAndOwnersData.put(car5, user3);

        //search users who share car and put this users into Set
        for (NewCarOwner newCarOwner : CarsAndOwnersData.values()) {
            if (Collections.frequency(CarsAndOwnersData.values(), newCarOwner) > 1)
                CarOwnersSet.add(newCarOwner);
        }

        System.out.println(CarOwnersSet);

    }
}

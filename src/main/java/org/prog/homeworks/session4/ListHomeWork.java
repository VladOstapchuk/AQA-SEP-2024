package org.prog.homeworks.session4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO: Create list of 1000 cars
//TODO: Pain each car RANDOMLY in one for following colors: red, green, blue
//TODO: put cars in separate lists based on their colors
//TODO: print size of each list
public class ListHomeWork {

    public static void main(String[] args) {
        List<Car> redCars = new ArrayList<>();
        List<Car> greenCars = new ArrayList<>();
        List<Car> blueCars = new ArrayList<>();

        List<Car> CarsList1 = CarFactory(1000);
        for (Car car : CarsList1) {
            if (car.getColor().equals("RED")) {
                redCars.add(car);
            } else if (car.getColor().equals("GREEN")) {
                greenCars.add(car);
            } else blueCars.add(car);
        }

        System.out.println("Red cars from Factory: " + redCars.size());
        System.out.println("Green cars from Factory: " + greenCars.size());
        System.out.println("Blue cars from Factory: " + blueCars.size());
    }

    //this method put in List Car with all randomly entered parameters
    public static List<Car> CarFactory(int Quantity) {
        List<Car> carsFromFactory = new ArrayList<>();
        for (int i = 0; i < Quantity; i++) {
            Random random = new Random();
            CarColors[] colors = CarColors.values();
            CarBrands[] brands = CarBrands.values();
            CarModels[] models = CarModels.values();
            carsFromFactory.add(new Car(brands[random.nextInt(brands.length)].toString(),
                    colors[random.nextInt(colors.length)].toString(),
                    models[random.nextInt(models.length)].getModelNumber()));
        }
        return carsFromFactory;
    }
}




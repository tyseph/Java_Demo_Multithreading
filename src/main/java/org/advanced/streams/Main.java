package org.advanced.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Car {
    String name;
    String type;
    String model;
    Integer price;

    public Car(String name, String type, String model, Integer price) {
        this.name = name;
        this.type = type;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }
}

public class Main {


    public static void main(String[] args) {

        List<Car> cars = List.of(
                new Car("Suzuki", "Old", "Basic", 90000),
                new Car("BMW", "New", "Top", 35400),
                new Car("Audi", "New", "Medium", 9300),
                new Car("Ferrari", "Old", "Basic", 8000),
                new Car("Lamborghini", "Old", "Top", 190000)
        );

        List<Car> oldCars = cars.stream().filter((o) -> Objects.equals(o.getType(), "Old")).toList();
        System.out.println(oldCars);


    }
}

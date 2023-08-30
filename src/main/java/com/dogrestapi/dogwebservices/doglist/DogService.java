package com.dogrestapi.dogwebservices.dogList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class DogService {
    private static List<Dog> dogs = new ArrayList<>();

    private static int dogCount = 0;

    static {
        dogs.add(new Dog(++dogCount, "Yohannes", "Sassy", 10, "Brown", "Chiwawa"));
        dogs.add(new Dog(++dogCount, "Yohannes", "Bobby", 8, "White", "Normal"));
        dogs.add(new Dog(++dogCount, "Yohannes", "Terfie", 11, "White and Brown", "Normal"));
        dogs.add(new Dog(++dogCount, "Yohannes", "Blue", 5, "Black and White", "Husky"));
    }

    public Dog addDog(String name, int age, String color, String breed) {
        Dog dog = new Dog(++dogCount, "Yohannes", name, age, color, breed);
        dogs.add(dog);
        return dog;
    }

    public List<Dog> findByBreed(String breed) {
        Predicate<? super Dog> predicate = dog -> dog.getBreed().equalsIgnoreCase(breed);
        return dogs.stream().filter(predicate).toList();
    }

    public List<Dog> findByUsername(String username) {
        Predicate<? super Dog> predicate = dog -> dog.getUsername().equalsIgnoreCase(username);
        return dogs.stream().filter(predicate).toList();
    }

    public void deleteById(int id) {
        Predicate<? super Dog> predicate = dog -> dog.getId() == id;
        dogs.removeIf(predicate);
    }

    public Dog findById(int id) {
        Predicate<? super Dog> predicate = dog -> dog.getId() == id;
        Dog dog = dogs.stream().filter(predicate).findFirst().get();
        return dog;
    }

    public void updateDog(Dog dog) {
        deleteById(dog.getId());
        dogs.add(dog);
    }
}

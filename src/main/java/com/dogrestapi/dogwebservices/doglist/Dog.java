package com.dogrestapi.dogwebservices.doglist;

public class Dog {
    private String username;
    private int id;
    private String name;
    private int age;
    private String color;
    private String breed;

    public Dog() {
    }

    public Dog(int id, String username, String name, int age, String color, String breed) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + ", color=" + color + ", breed=" + breed + "]";
    }

}

package ru.netology.entity;

public class User {
    private final int AGE_OF_ADULTHOOD = 18;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }

    public boolean isAdult() {
        return age >= AGE_OF_ADULTHOOD;
    }
}

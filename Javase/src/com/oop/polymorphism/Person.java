package com.oop.polymorphism;

public class Person {
    public void feed(Pet p){
        p.feed();
    }
    public void play(Pet p) {
        p.play();
    }

    public static void main(String[] args) {
        Person p = new Person();
        Pet pet1 = new Dog();
        Pet pet2 = new Cat();
        Pet pet3 = new Penguin();
        p.feed(pet1);
        p.feed(pet2);
        p.feed(pet3);
        p.play(pet1);
        p.play(pet2);
        p.play(pet3);


    }
}

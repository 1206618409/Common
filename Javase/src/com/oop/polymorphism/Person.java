package com.oop.polymorphism;

import org.w3c.dom.ls.LSOutput;

public class Person {
    public void feed(Pet p){
        p.feed();
    }

    public static void main(String[] args) {
        Person p = new Person();
        Pet pet1 = new Dog();
        Pet pet2 = new Cat();
        p.feed(pet1);
        p.feed(pet2);
    }
}

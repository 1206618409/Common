package com.oop.polymorphism;

/**
 * 多态
 * 多态:对应同一个指令（调用同一个名称的方法），不同的对象给予不同的反应（不同的方法实现）
 *
         * 规范:
         * 1、必须要有继承关系
         * 2、子类方法必须重写父类的方法
         * 3、父类引用指向子类对象
 */
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

package com.oop.extend.ccc;

public class TestMotoVegycle {
    public static void main(String[] args) {
        Car c = new Car(1,"宝马","1");
        System.out.println("租金是："+c.CalcRemt(5));
        Bus b = new Bus(2,"金龙",20);
        System.out.println("租金是："+b.CalcRemt(5));


    }
}

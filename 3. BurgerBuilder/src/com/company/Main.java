package com.company;

public class Main {
    public static void main(String[] args) {
        //Creates a BurgerHandler with initial number of burgers
        BurgerHandler burgerHandler = new BurgerHandler(0);

        //Creates and starts a thread for producer and consumer classes
        new Thread(new BurgerProducer(burgerHandler)).start();
        new Thread(new BurgerConsumer(burgerHandler)).start();
    }
}
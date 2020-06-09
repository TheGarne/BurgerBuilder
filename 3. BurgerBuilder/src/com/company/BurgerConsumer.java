package com.company;

public class BurgerConsumer implements Runnable {
    private BurgerHandler burgerHandler;

    public BurgerConsumer(BurgerHandler burgerHandler){
        this.burgerHandler = burgerHandler;
    }

    //Required whenever a class needs to be executed by a thread
    @Override
    public void run() {
        int burgerCount = 0;
        while (true) {
            //Takes a burger if possible
            burgerCount = burgerHandler.takeOne();
            System.out.println(Thread.currentThread().getName() + " (Consumer: " + burgerCount + ")");

            //Creates a random time for thread to sleep
            int pause = (int) (Math.random() * 2000);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
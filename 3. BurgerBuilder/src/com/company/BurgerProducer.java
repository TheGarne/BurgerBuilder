package com.company;

public class BurgerProducer implements Runnable {
    private BurgerHandler burgerHandler;

    public BurgerProducer(BurgerHandler burgerHandler){
        this.burgerHandler = burgerHandler;
    }

    //Required whenever a class needs to be executed by a thread
    @Override
    public void run() {
        int burgerCount = 0;
        while (true) {
            //Creates a new burger if possible
            burgerCount = burgerHandler.addOne();
            System.out.println(Thread.currentThread().getName() + " (Producer: " + burgerCount + ")");

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
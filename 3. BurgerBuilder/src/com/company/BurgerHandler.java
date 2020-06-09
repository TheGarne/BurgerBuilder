package com.company;

public class BurgerHandler {
    //Maximum number of burgers is put to 8
    private int numberOfBurgers;
    private final int MAX = 8;

    public BurgerHandler(int startvalue){
        numberOfBurgers = startvalue;
    }

    //Synchonized = only 1 thread can access this method at a given time
    public synchronized int addOne(){
        try {
            //If the max number of burgers is reached the thread waits until notified
            while(numberOfBurgers >= MAX){
                wait();
            }

            //Adds a burger and notifies all threads
            numberOfBurgers++;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfBurgers;
    }

    //Synchonized = only 1 thread can access this method at a given time
    public synchronized int takeOne(){
        try {
            //If there is no burger available the thread waits until notified
            while (numberOfBurgers == 0) {
                wait();
            }

            //Removes a burger and notifies all threads
            numberOfBurgers--;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfBurgers;
    }
}
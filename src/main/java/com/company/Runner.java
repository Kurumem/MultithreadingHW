package com.company;

import java.util.Random;

public class Runner extends Thread {
    public String name;
    public String runnerNames;
    private long count;
    Random random = new Random();
    Runner other = null;


    public Runner(String name) {
        this.name = name;
    }

    public Runner(String runnerNames,Runner other){
        this.runnerNames = runnerNames;
        this.other = other;
    }

    public void run(){
        try {
            long maxCount = 10;
            if (other == null) {
                while (count < maxCount) {
                    ++count;
                    try{
                        Thread.sleep(random.nextInt(100));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(name + " пробежал(а) " + count + " м ");
                    Thread.yield();
                }
            }
            else{
                other.join();
                while (count<maxCount){
                    ++count;
                    try{
                        Thread.sleep(random.nextInt(100));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(runnerNames + " пробежал(а) " + count + " м ");
                    Thread.yield();
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

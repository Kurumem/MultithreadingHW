package com.company;

import java.util.ArrayList;

public class Relay {
    String name;
    public Team team1;
    public Team team2;
    ArrayList<String> runnerNamesFirst = new ArrayList<>();
    ArrayList<String> runnerNamesSecond = new ArrayList<>();




    public Relay(String[] teamNames, String[][] runnerNames) {


        for (int i = 0; i < 4; i++) {
            runnerNamesFirst.add(runnerNames[0][i]);
        }

        for (int i = 0; i < 4; i++) {
            runnerNamesSecond.add(runnerNames[1][i]);
        }

        team1 = new Team(teamNames[0],runnerNamesFirst);
        team2 = new Team(teamNames[1],runnerNamesSecond);
        System.out.println(" Команда №1: " + teamNames[0] + " - " + runnerNamesFirst);
        System.out.println(" Команда №2: " + teamNames[1] + " - " + runnerNamesSecond);
    }

    public void run() {


        Runner r1_1 = new Runner(team1.getRunnerNames(0));
        Runner r1_2 = new Runner(team1.getRunnerNames(1),r1_1);
        Runner r1_3 = new Runner(team1.getRunnerNames(2),r1_2);
        Runner r1_4 = new Runner(team1.getRunnerNames(3),r1_3);
        r1_1.start();
        r1_2.start();
        r1_3.start();
        r1_4.start();
        Runner r2_1 = new Runner(team2.getRunnerNames(0));
        Runner r2_2 = new Runner(team2.getRunnerNames(1),r2_1);
        Runner r2_3 = new Runner(team2.getRunnerNames(2),r2_2);
        Runner r2_4 = new Runner(team2.getRunnerNames(3),r2_3);

        r2_1.start();
        r2_2.start();
        r2_3.start();
        r2_4.start();

        while (r1_4.isAlive() || r2_4.isAlive()){
            if (r2_4.isAlive()){
                name = team1.getTeamName();
                try {
                    r2_4.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            else {
                name = team2.getTeamName();
                try {
                    r1_4.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
        System.out.println("Победила команда: " + name);


    }


}






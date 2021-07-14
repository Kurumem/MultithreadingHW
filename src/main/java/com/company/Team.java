package com.company;

import java.util.ArrayList;

public class Team extends Thread {
    public String teamName;
    public ArrayList<String> runnersNames;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, ArrayList<String> runnersNames){
        this.teamName = teamName;
        this.runnersNames = runnersNames;
    }
    public String getRunnerNames(int i){
        return runnersNames.get(i);
    }
}

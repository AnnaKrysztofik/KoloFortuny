package main.models;

import main.viewModels.UserViewModel;

public class Player {

    private String name;
    private int points;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public UserViewModel buildViewModel()
    {
        return new UserViewModel(this.name, this.points);
    }
}


package main.viewModels;

public class UserViewModel {

    private String userName;
    private int points;

    public UserViewModel(String userName, int points) {
        this.userName = userName;
        this.points = points;
    }

    public String getUserName() {
        return userName;
    }

    public int getPoints() {
        return points;
    }
}

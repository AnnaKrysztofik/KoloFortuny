package viewModels;

public class UserViewModel {

    private String userName;
    private int stanKonta;

    public UserViewModel(String userName, int stanKonta) {
        this.userName = userName;
        this.stanKonta = stanKonta;
    }

    public String getUserName() {
        return userName;
    }

    public int getStanKonta() {
        return stanKonta;
    }
}

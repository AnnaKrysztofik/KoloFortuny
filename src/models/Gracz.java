package models;

import viewModels.UserViewModel;

public class Gracz {

    private String imie;
    private int stanKonta;

    public Gracz(String imie, int stanKonta) {
        this.imie = imie;
        this.stanKonta = stanKonta;
    }

    public String getImie() {
        return imie;
    }

    public int getstanKonta() {
        return stanKonta;
    }

    public void dodajstanKonta(int stanKonta) {
        this.stanKonta += stanKonta;
    }

    public void setstanKonta(int stanKonta) {
        this.stanKonta = stanKonta;
    }

    public UserViewModel buildViewModel()
    {
        return new UserViewModel(this.imie, this.stanKonta);
    }
}


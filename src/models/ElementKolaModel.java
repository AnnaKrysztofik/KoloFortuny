package models;

import viewModels.ElementKolaViewModel;

import java.util.Arrays;
import java.util.List;

public class ElementKolaModel {
    private boolean isBankrut;
    private boolean isStop;
    private int value;
    private String nazwa;

    public ElementKolaModel(boolean isBankrut, boolean isStop, int value, String nazwa) {
        this.isBankrut = isBankrut;
        this.isStop = isStop;
        this.value = value;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getValue() {
        return value;
    }

    public boolean getIsStop(){return isStop;}

    public boolean getIsBankrut(){return isBankrut;}

    public ElementKolaViewModel buildViewModel()
    {
        return new ElementKolaViewModel(this.getNazwa());
    }

}
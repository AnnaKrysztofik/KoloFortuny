package main.models;

import main.viewModels.WheelElementViewModel;

public class WheelModel {
    private boolean isBankrupt;
    private boolean isStop;
    private int value;
    private String name;

    public WheelModel(boolean isBankrupt, boolean isStop, int value, String name) {
        this.isBankrupt = isBankrupt;
        this.isStop = isStop;
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean getIsStop(){return isStop;}

    public boolean getIsBankrupt(){return isBankrupt;}

    public WheelElementViewModel buildViewModel()
    {

        return new WheelElementViewModel(this.getName());
    }

}
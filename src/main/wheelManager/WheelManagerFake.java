package main.wheelManager;

import main.models.WheelModel;

import java.util.List;

public class WheelManagerFake implements WheelManagerInterface {

    private List<WheelModel> wheelModel;
    private int idx;

    @Override
    public WheelModel spinTheWheelOfFortune() {

        return wheelModel.get(idx++);
    }

    public void setWheelModel(List<WheelModel> wheelModel) {

        this.wheelModel = wheelModel;
    }
}

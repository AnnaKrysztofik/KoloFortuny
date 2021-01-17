package main.wheelManager;

import main.models.WheelModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WheelManager implements WheelManagerInterface {

    public WheelManager() {

    }

    private static final List<WheelModel> WHEEL = Arrays.asList(
            new WheelModel(true, false, 0, "******** BANKRUT **************"),
            new WheelModel(false, true, 0, "******* STOP ****************"),
            new WheelModel(false, false, 100, "+100"),
            new WheelModel(false, false, 200, "+200"),
            new WheelModel(false, false, 100, "+100"),
            new WheelModel(false, false, 200, "+200"),
            new WheelModel(false, false, 300, "+300"),
            new WheelModel(false, false, 400, "+400"),
            new WheelModel(false, false, 500, "+500"));



    @Override
    public WheelModel spinTheWheelOfFortune() {

        Random random = new Random();
        int index = random.nextInt(WHEEL.size());
        String name = WHEEL.get(index).getName();
        System.out.println(name);
        return WHEEL.get(index);
    }



}


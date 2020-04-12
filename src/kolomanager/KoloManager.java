package kolomanager;

import models.ElementKolaModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KoloManager implements KoloManagerInterface {

    public KoloManager() {

    }

    private static final List<ElementKolaModel> KOLO = Arrays.asList(
            new ElementKolaModel(true, false, 0, "******** BANKRUT **************"),
            new ElementKolaModel(false, true, 0, "******* STOP ****************"),
            new ElementKolaModel(false, false, 100, "+100"),
            new ElementKolaModel(false, false, 200, "+200"),
            new ElementKolaModel(false, false, 100, "+100"),
            new ElementKolaModel(false, false, 200, "+200"),
            new ElementKolaModel(false, false, 300, "+300"),
            new ElementKolaModel(false, false, 400, "+400"),
            new ElementKolaModel(false, false, 500, "+500"));

    @Override
    public ElementKolaModel zakrecKolem() {

        Random random = new Random();
        int indeks = random.nextInt(KOLO.size());
        String nazwa = KOLO.get(indeks).getNazwa();
        System.out.println(nazwa);
        return KOLO.get(indeks);
    }
}


package providers;

import models.HasloModel;

public class HasloProviderFake implements HasloProviderInterface {

    @Override
    public HasloModel generujHaslo() {
        return new HasloModel("Zdanie", "ALA MA KOTA");
    }
}

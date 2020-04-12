package kolomanager;

import models.ElementKolaModel;

import java.util.List;

public class KoloManagerFake implements KoloManagerInterface {

    private List<ElementKolaModel> elementKolaModel;
    private int idx;

    @Override
    public ElementKolaModel zakrecKolem() {
        return elementKolaModel.get(idx++);
    }

    public void setElementKolaModel(List<ElementKolaModel> elementKolaModel) {
        this.elementKolaModel = elementKolaModel;
    }
}

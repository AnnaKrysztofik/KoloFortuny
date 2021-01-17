package main.providers;

import main.models.PhraseModel;

public class PhraseProviderFake extends PhraseProvider implements PhraseProviderInterface {

    @Override
    public PhraseModel generatePhrase() {
        return new PhraseModel("Zdanie", "ALA MA KOTA");
    }


}

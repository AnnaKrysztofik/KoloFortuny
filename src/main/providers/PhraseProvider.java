package main.providers;

import main.models.PhraseModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PhraseProvider implements PhraseProviderInterface {
    private List<PhraseModel> databaseOfPhrase = Arrays.asList(
            new PhraseModel("PRZYSŁOWIE", "Gdzie dwóch się biję tam trzeci korzysta"),
            new PhraseModel("PRZYSŁOWIE", "Kto daje i odbiera ten się w piekle poniewiera"),
            new PhraseModel("PRZYSŁOWIE", "Kto się czubi ten się lubi"),
            new PhraseModel("PRZYSŁOWIE", "Mowa jest srebrem a milczenie złotem"),
            new PhraseModel("PRZYSŁOWIE", "Szukać igły w stogu siana"),
            new PhraseModel("PRZYSŁOWIE", "Gdy dwóch sie bije, trzeci korzysta"),

            new PhraseModel("POWIEDZENIE", "Ściany mają uszy"),
            new PhraseModel("POWIEDZENIE", "Apetyt rośnie w miarę jedzenia"),
            new PhraseModel("POWIEDZENIE", "Atak jest najlepszą obroną"),
            new PhraseModel("POWIEDZENIE", "Tonący brzytwy się chwyta"),
            new PhraseModel("POWIEDZENIE", "Każdy kij ma dwa końce"),
            new PhraseModel("POWIEDZENIE", "Atak jest najlepszą obroną"),
            new PhraseModel("POWIEDZENIE", "Nadzieja umiera ostatnia"),
            new PhraseModel("POWIEDZENIE", "Ręka rękę myje"),
            new PhraseModel("POWIEDZENIE", "Burza mózgów"),
            new PhraseModel("POWIEDZENIE", "Przechodzić samego siebie"),
            new PhraseModel("POWIEDZENIE", "Raz kozie śmierć"),
            new PhraseModel("POWIEDZENIE", "Nie wywołuj wilka z lasu"),
            new PhraseModel("POWIEDZENIE", "Głowa Pusta jak kapusta"),

            new PhraseModel("TYTUŁ FILMU", "LOT NAD KUKUŁCZYM GNIAZDEM"),
            new PhraseModel("TYTUŁ FILMU", "LEON ZAWODOWIEC"),
            new PhraseModel("TYTUŁ FILMU", "CHŁOPIEC W PASIASTEJ PIŻAMIE"),
            new PhraseModel("TYTUŁ FILMU", "GWIEZDNE WOJNY"),
            new PhraseModel("TYTUŁ FILMU", "MROCZNY RYCERZ"),
            new PhraseModel("TYTUŁ FILMU", "BĘKARTY WOJNY"),
            new PhraseModel("TYTUŁ FILMU", "WRÓG U BRAM"),
            new PhraseModel("TYTUŁ FILMU", "JAK WYSTRESOWAĆ SMOKA"),
            new PhraseModel("TYTUŁ FILMU", "CHŁOPAKI NIE PŁACZA"),
            new PhraseModel("TYTUŁ FILMU", "PIRACI Z KARAIBÓW"),
            new PhraseModel("TYTUŁ FILMU", "DZIEWCZYNA Z TATUAŻEM"),
            new PhraseModel("TYTUŁ FILMU", "CZARNY ŁĄBĘDŹ"),
            new PhraseModel("TYTUŁ FILMU", "OSTATNI SAMURAJ"),
            new PhraseModel("TYTUŁ FILMU", "CUDOWNE DZIECKO"),
            new PhraseModel("TYTUŁ FILMU", "WICHRY NAMIĘTNOŚCI"),
            new PhraseModel("TYTUŁ FILMU", "NÓŻ W WODZIE"),
            new PhraseModel("TYTUŁ FILMU", "SZKLANA PUŁAPKA"),
            new PhraseModel("TYTUŁ FILMU", "SZKOŁA UCZUĆ"),
            new PhraseModel("TYTUŁ FILMU", "ZIEMIA OBIECANA"),
            new PhraseModel("TYTUŁ FILMU", "ZAKOCHANY KUNDEL"),
            new PhraseModel("TYTUŁ FILMU", "MIASTO GRZECHU"),
            new PhraseModel("TYTUŁ FILMU", "MŁODZI GNIEWNI"),
            new PhraseModel("TYTUŁ FILMU", "W SAMO POŁUDNIE"),
            new PhraseModel("TYTUŁ FILMU", "GORĄCZKA ZŁOTA"));

    @Override
    public PhraseModel generatePhrase() {
        Random random = new Random();
        int index = random.nextInt(databaseOfPhrase.size());
        PhraseModel phrase = databaseOfPhrase.get(index);
        return new PhraseModel(phrase.getCategory(), phrase.getPhrase().toUpperCase());
    }
}

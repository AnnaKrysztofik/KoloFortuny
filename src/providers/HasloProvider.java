package providers;

import models.HasloModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HasloProvider implements HasloProviderInterface {
    private List<HasloModel> bazaHaseł = Arrays.asList(
            new HasloModel("PRZYSŁOWIE", "Gdzie dwóch się biję tam trzeci korzysta"),
            new HasloModel("PRZYSŁOWIE", "Kto daje i odbiera ten się w piekle poniewiera"),
            new HasloModel("PRZYSŁOWIE", "Kto się czubi ten się lubi"),
            new HasloModel("PRZYSŁOWIE", "Mowa jest srebrem a milczenie złotem"),
            new HasloModel("PRZYSŁOWIE", "Szukać igły w stogu siana"),
            new HasloModel("PRZYSŁOWIE", "Gdy dwóch sie bije, trzeci korzysta"),

            new HasloModel("POWIEDZENIE", "Ściany mają uszy"),
            new HasloModel("POWIEDZENIE", "Apetyt rośnie w miarę jedzenia"),
            new HasloModel("POWIEDZENIE", "Atak jest najlepszą obroną"),
            new HasloModel("POWIEDZENIE", "Tonący brzytwy się chwyta"),
            new HasloModel("POWIEDZENIE", "Każdy kij ma dwa końce"),
            new HasloModel("POWIEDZENIE", "Atak jest najlepszą obroną"),
            new HasloModel("POWIEDZENIE", "Nadzieja umiera ostatnia"),
            new HasloModel("POWIEDZENIE", "Ręka rękę myje"),
            new HasloModel("POWIEDZENIE", "Burza mózgów"),
            new HasloModel("POWIEDZENIE", "Przechodzić samego siebie"),
            new HasloModel("POWIEDZENIE", "Raz kozie śmierć"),
            new HasloModel("POWIEDZENIE", "Nie wywołuj wilka z lasu"),
            new HasloModel("POWIEDZENIE", "Głowa Pusta jak kapusta"),

            new HasloModel("TYTUŁ FILMU", "LOT NAD KUKUŁCZYM GNIAZDEM"),
            new HasloModel("TYTUŁ FILMU", "LEON ZAWODOWIEC"),
            new HasloModel("TYTUŁ FILMU", "CHŁOPIEC W PASIASTEJ PIŻAMIE"),
            new HasloModel("TYTUŁ FILMU", "GWIEZDNE WOJNY"),
            new HasloModel("TYTUŁ FILMU", "MROCZNY RYCERZ"),
            new HasloModel("TYTUŁ FILMU", "BĘKARTY WOJNY"),
            new HasloModel("TYTUŁ FILMU", "WRÓG U BRAM"),
            new HasloModel("TYTUŁ FILMU", "JAK WYSTRESOWAĆ SMOKA"),
            new HasloModel("TYTUŁ FILMU", "CHŁOPAKI NIE PŁACZA"),
            new HasloModel("TYTUŁ FILMU", "PIRACI Z KARAIBÓW"),
            new HasloModel("TYTUŁ FILMU", "DZIEWCZYNA Z TATUAŻEM"),
            new HasloModel("TYTUŁ FILMU", "CZARNY ŁĄBĘDŹ"),
            new HasloModel("TYTUŁ FILMU", "OSTATNI SAMURAJ"),
            new HasloModel("TYTUŁ FILMU", "CUDOWNE DZIECKO"),
            new HasloModel("TYTUŁ FILMU", "WICHRY NAMIĘTNOŚCI"),
            new HasloModel("TYTUŁ FILMU", "NÓŻ W WODZIE"),
            new HasloModel("TYTUŁ FILMU", "SZKLANA PUŁAPKA"),
            new HasloModel("TYTUŁ FILMU", "SZKOŁA UCZUĆ"),
            new HasloModel("TYTUŁ FILMU", "ZIEMIA OBIECANA"),
            new HasloModel("TYTUŁ FILMU", "ZAKOCHANY KUNDEL"),
            new HasloModel("TYTUŁ FILMU", "MIASTO GRZECHU"),
            new HasloModel("TYTUŁ FILMU", "MŁODZI GNIEWNI"),
            new HasloModel("TYTUŁ FILMU", "W SAMO POŁUDNIE"),
            new HasloModel("TYTUŁ FILMU", "GORĄCZKA ZŁOTA"));

    @Override
    public HasloModel generujHaslo() {
        Random random = new Random();
        int indeks = random.nextInt(bazaHaseł.size());
        HasloModel haslo = bazaHaseł.get(indeks);
        return new HasloModel(haslo.getKategoria(), haslo.getHaslo().toUpperCase());
    }
}

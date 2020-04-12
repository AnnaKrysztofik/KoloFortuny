package viewModels;

/*
    Opisuje plansze z haslem i kategoria
 */
public class HasloViewModel {

    //Haslo w postaci np. A_A _A ___A
    private String haslo;
    private String kategoria;

    public HasloViewModel(String haslo, String kategoria) {
        this.haslo = haslo;
        this.kategoria = kategoria;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getKategoria() {
        return kategoria;
    }
}
